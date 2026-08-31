import re
import time
import API

from Eremite.utils.items import GetMyItem, GetLockpicks, MoveItemToContainer
from Eremite.utils.sorting import QuickSort
from Eremite.utils.misc import WeightCheck, GetItemLock
from Eremite.RecycleWeight import do_keys

LOCK_PATTERN = re.compile(r'.*(?<=>)([^<]+)(?= lock).*')

lockables = [
    0x0E7C,  # Grey EW
    0x09AB,  # Gray NS
    0x0E41,  # Gray/Gold NS
    0x0E40,  # Gray/Gold EW
    0x0E43,  # Wood/Gold NS
    0x0E42,  # Wood/Gold EW
    0x0E3E,  # Med Wood Crate WE
    0x09A9,  # Small Wood Crate NS
    0x0E3C,  # Big Wood Crate (Square)
    0x0E7F,  # Keg
    0x0E77,  # Barrel
]

color_map = {
    "bronze": 444,
    "shadow Iron": 999,
    "agapite": 46,
    "blaze": 39,
    "gold": 53,
    "valorite": 91,
    "verite": 61,
    "toxic": 69,
    "ice": 88,
    "platinum": 2442,
}


def GetDistanceToPlayer(API: API, entity):
    if not entity:
        return 999
    ex = getattr(entity, 'X', API.Player.X)
    ey = getattr(entity, 'Y', API.Player.Y)
    return getattr(entity, 'Distance', max(abs(ex - API.Player.X), abs(ey - API.Player.Y)))


def EnsureContainerOpen(API: API, container, timeout_per_try=1.2, max_retries=3):
    """
    Opens container and waits for contents packet from server.
    If the chest was trapped, the first UseObject triggers the trap without opening the box.
    This function will retry UseObject up to max_retries until items are received.
    """
    if not container:
        return []

    container_serial = getattr(container, 'Serial', container)

    for attempt in range(max_retries):
        API.UseObject(container_serial)
        start = time.time()
        while time.time() - start < timeout_per_try and not API.StopRequested:
            items = API.ItemsInContainer(container_serial, recursive=False)
            if items is not None and len(items) > 0:
                return items
            API.Pause(0.2)

    return API.ItemsInContainer(container_serial, recursive=False) or []


def FindLockables(API: API):
    ground_items = API.GetItemsOnGround(distance=15) or []
    chests = [
        chest for chest in ground_items
        if getattr(chest, 'IsContainer', False)
        and not getattr(chest, 'IsCorpse', False)
        and (getattr(chest, 'Graphic', getattr(chest, 'ItemID', None)) in lockables)
    ]
    chests = [chest for chest in chests if not isLockedDown(API, chest)]
    chests = [chest for chest in chests if HasLoot(API, chest)]
    near = [chest for chest in chests if GetDistanceToPlayer(API, chest) <= 1]
    return near[0] if near else None


def isLockedDown(API: API, chest):
    if not chest:
        return False
    chest_serial = getattr(chest, 'Serial', chest)
    props = API.ItemNameAndProps(chest_serial, True) or ""
    return "locked down" in props.lower()


def HasLoot(API: API, chest):
    if not chest:
        return False
    chest_serial = getattr(chest, 'Serial', chest)
    props = API.ItemNameAndProps(chest_serial, True) or ""
    props_lower = props.lower()

    for line in props_lower.splitlines():
        if 'lock' in line:
            match = LOCK_PATTERN.match(line)
            if match:
                level = match.group(1).strip()
                color = color_map.get(level, 0) or 0
                API.HeadMsg(f"-=({level})=-", chest_serial, color)
                return True
        if 'items' in line:
            count_str = line.split(' items')[0].strip()
            if '/' in count_str:
                count_str = count_str.split('/')[0].strip()
            try:
                count = int(count_str)
                if count > 0:
                    API.HeadMsg(f"-=({count} Items)=-", chest_serial, 69)
                    return True
            except ValueError:
                pass
    return False


def isLocked(API: API, chest):
    if not chest:
        return False
    chest_serial = getattr(chest, 'Serial', chest)
    props = API.ItemNameAndProps(chest_serial, True) or ""
    return "lock" in props.lower()


def DoLockPick(API: API, box):
    lockpicks = GetLockpicks(API, best=True)
    if not lockpicks:
        API.SysMsg("No Lockpicks!", 33)
        API.Pause(1.0)
        return False

    lockpick_serial = getattr(lockpicks, 'Serial', lockpicks)
    box_serial = getattr(box, 'Serial', box)

    API.UseObject(lockpick_serial)
    if not API.WaitForTarget(timeout=0.6):
        API.UseObject(lockpick_serial)
        API.WaitForTarget(timeout=0.6)

    API.Target(box_serial)
    API.Pause(4.1)
    return True


def DisposeBox(API: API, box):
    if not box:
        return

    box_serial = getattr(box, 'Serial', box)
    items = API.ItemsInContainer(box_serial, recursive=False) or []
    if items:
        API.SysMsg(f"Dispose failed: has {len(items)} items remaining", 33)
        return

    recyclebag = GetMyItem(API, "recyclebag")
    recyclebag_serial = getattr(recyclebag, 'Serial', recyclebag) if recyclebag else None

    on_ground = getattr(box, 'OnGround', False) or (getattr(box, 'RootContainer', None) is None)

    if on_ground:
        # Remove Chest on treasure boxes via context menu
        API.ContextMenu(box_serial, 0)
        if API.WaitForGump(0xc8fd1ea7, delay=1.0):
            API.ReplyGump(1, 0xc8fd1ea7)
    else:
        box_name = (getattr(box, 'Name', '') or "").lower()
        props = (API.ItemNameAndProps(box_serial, True) or "").lower()
        graphic = getattr(box, 'Graphic', 0)
        color = getattr(box, 'Color', getattr(box, 'Hue', 0))

        should_recycle = False
        if box_name == "bag of reagents":
            should_recycle = True
        elif any(p in props for p in ["paragon", "from a swamp", "from a shipwreck"]):
            should_recycle = True
        elif graphic in [0x0E76, 0x0E75] and color == 0:  # Juka bags - Undyed
            should_recycle = True

        if should_recycle and recyclebag_serial:
            API.Pause(0.6)
            MoveItemToContainer(API, box_serial, recyclebag_serial)


def DragGemsToPouch(API: API, box, gempouch):
    gems = API.GetSharedVar('gems') or []
    if not gems or not gempouch:
        return True

    box_serial = getattr(box, 'Serial', box)
    gempouch_serial = getattr(gempouch, 'Serial', gempouch)

    items = API.ItemsInContainer(box_serial, recursive=False) or []
    gs = [i for i in items if getattr(i, 'Graphic', 0) in gems]
    while gs and not API.StopRequested:
        for g in gs:
            MoveItemToContainer(API, g.Serial, gempouch_serial)
            API.Pause(0.6)
        items = API.ItemsInContainer(box_serial, recursive=False) or []
        gs = [i for i in items if getattr(i, 'Graphic', 0) in gems]
    return True


def DragGoldToBoH(API: API, box, boh):
    if not boh:
        return True
    start_gold = getattr(API.Player, 'Gold', 0)
    box_serial = getattr(box, 'Serial', box)
    boh_serial = getattr(boh, 'Serial', boh)

    items = API.ItemsInContainer(box_serial, recursive=False) or []
    gold = [i for i in items if getattr(i, 'Graphic', 0) == 0x0EED]
    while gold and not API.StopRequested:
        for g in gold:
            MoveItemToContainer(API, g.Serial, boh_serial)
            API.Pause(0.6)
        items = API.ItemsInContainer(box_serial, recursive=False) or []
        gold = [i for i in items if getattr(i, 'Graphic', 0) == 0x0EED]

    gained = getattr(API.Player, 'Gold', 0) - start_gold
    if gained > 0:
        API.HeadMsg(f"+{gained}", API.Player.Serial, 55)
    return True


def lootScrolls(API: API, bag, scrollbag, spell_scrolls):
    if not spell_scrolls or not scrollbag:
        return True

    bag_serial = getattr(bag, 'Serial', bag)
    scrollbag_serial = getattr(scrollbag, 'Serial', scrollbag)

    items = API.ItemsInContainer(bag_serial, recursive=False) or []
    scrolls = [i for i in items if getattr(i, 'Graphic', 0) in spell_scrolls]
    while scrolls and not API.StopRequested:
        for scroll in scrolls:
            MoveItemToContainer(API, scroll.Serial, scrollbag_serial)
            API.Pause(0.6)
        items = API.ItemsInContainer(bag_serial, recursive=False) or []
        scrolls = [i for i in items if getattr(i, 'Graphic', 0) in spell_scrolls]
    return True


def DragLootToBackpack(API: API, box):
    box_serial = getattr(box, 'Serial', box)
    items = API.ItemsInContainer(box_serial, recursive=False) or []
    while items and not API.StopRequested:
        for loot in items:
            if not WeightCheck(API):
                API.HeadMsg("High Weight", API.Player.Serial, 33)
                return
            MoveItemToContainer(API, loot.Serial, API.Player.Backpack.Serial)
            API.Pause(0.6)
        items = API.ItemsInContainer(box_serial, recursive=False) or []
    return True


def main(API: API):
    holdingbag = API.GetSharedVar("BagOfHolding")
    scrollbag = API.GetSharedVar("ScrollBoH")
    spell_scrolls = API.GetSharedVar("spell_scrolls") or []
    gempouch = GetMyItem(API, "gempouch")

    API.CancelTarget()
    target = FindLockables(API)
    if not target:
        API.SysMsg("Loot what?", 91)
        target_serial = API.RequestTarget(timeout=10.0)
        target = API.FindItem(target_serial) if target_serial else None

    if not target:
        return

    GetItemLock(API, __file__, wait=False, takeover=True)

    target_serial = getattr(target, 'Serial', target)
    if getattr(target, 'OnGround', False) and GetDistanceToPlayer(API, target) > 1:
        API.HeadMsg("Too far.", target_serial, 66)
        return

    API.HeadMsg("V", target_serial, 69)
    while isLocked(API, target) and not API.StopRequested:
        DoLockPick(API, target)

    # Open container and set off trap if present; retries UseObject until contents are received
    EnsureContainerOpen(API, target_serial, timeout_per_try=1.2, max_retries=3)
    API.Pause(0.4)
    API.ClearMoveQueue()

    if holdingbag:
        DragGoldToBoH(API, target, holdingbag)

    root_container = getattr(target, 'RootContainer', None)
    if root_container == API.Player.Serial:
        do_keys(API, 'gempouch', container=target)
        do_keys(API, 'spellkeys', container=target)
    elif gempouch:
        DragGemsToPouch(API, target, gempouch)

    if scrollbag:
        lootScrolls(API, target, scrollbag, spell_scrolls)

    DragLootToBackpack(API, target)
    DisposeBox(API, target)
    QuickSort(API, scrolls=False)


if __name__ in ("__main__", "<module>"):
    main(API)
