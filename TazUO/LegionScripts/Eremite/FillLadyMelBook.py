import random
import API

from Eremite.utils.items import GetMyItem, GetPeerlessBag, MoveItemToContainer

MEL_START_STONE_SERIAL = 0x40866623
QUEST_GUMP_ID = 0xC563D169
STALE_GUMP_ID = 0xFD84F341

def GetDistanceToSerial(API: API, serial: int) -> int:
    if not getattr(API, 'Player', None):
        return 999
    item = API.FindItem(serial)
    if not item:
        return 999
    ix = getattr(item, 'X', 0)
    iy = getattr(item, 'Y', 0)
    return getattr(item, 'Distance', max(abs(ix - API.Player.X), abs(iy - API.Player.Y)))


def getQuestItems(API: API):
    bp_serial = getattr(API.Player.Backpack, 'Serial', None) if (API.Player and API.Player.Backpack) else None
    if not bp_serial:
        return [], [], [], [], [], False

    toadstools = API.FindTypeAll(0x1125, hue=0x0877, container=bp_serial) or []
    foulfungi = API.FindTypeAll(0x26B7, hue=0x0801, container=bp_serial) or []
    stifftwigs = API.FindTypeAll(0x1B9C, hue=0x08AD, container=bp_serial) or []
    petritwigs = API.FindTypeAll(0x1B9D, hue=0x0482, container=bp_serial) or []
    fossiltwigs = API.FindTypeAll(0x1B9C, hue=0x0850, container=bp_serial) or []

    has_all_five = all([
        len(toadstools) > 0,
        len(foulfungi) > 0,
        len(stifftwigs) > 0,
        len(petritwigs) > 0,
        len(fossiltwigs) > 0
    ])
    return toadstools, foulfungi, stifftwigs, petritwigs, fossiltwigs, has_all_five


def MelTicketCount(API: API):
    bp_serial = getattr(API.Player.Backpack, 'Serial', None) if (API.Player and API.Player.Backpack) else None
    if not bp_serial:
        return
    ticks = API.FindTypeAll(0x14EF, hue=0, container=bp_serial) or []
    mel_ticks = []
    for tick in ticks:
        props = (API.ItemNameAndProps(tick.Serial, True) or "").lower()
        if "melisande" in props:
            mel_ticks.append(tick)
    API.SysMsg(f"Mel Tickets: {len(mel_ticks)}", 88)


def ClearStaleGumps(API: API):
    while API.HasGump(STALE_GUMP_ID) and not API.StopRequested:
        API.ReplyGump(3, STALE_GUMP_ID)
        API.Pause(0.2)


def FillLadyMelBook(API: API):
    while not API.StopRequested:
        bp_serial = getattr(API.Player.Backpack, 'Serial', None) if (API.Player and API.Player.Backpack) else None
        if not bp_serial:
            return False

        melbook = API.FindType(0x0E3B, hue=0x01F4, container=bp_serial)
        toadstools, foulfungi, stifftwigs, petritwigs, fossiltwigs, has_all_five = getQuestItems(API)

        API.SysMsg(f"{len(toadstools)} : Deadly Toadstools : Ground", 77)
        API.SysMsg(f"{len(foulfungi)} : Foul Fungi      : Moss Maiden", 77)
        API.SysMsg(f"{len(stifftwigs)} : Stiffened Twigs  : TreeFellow", 77)
        API.SysMsg(f"{len(petritwigs)} : Petrified Twigs  : Reaper", 77)
        API.SysMsg(f"{len(fossiltwigs)} : Fossilized Twigs  : Changeling", 77)

        dist_to_stone = GetDistanceToSerial(API, MEL_START_STONE_SERIAL)
        if dist_to_stone > 10:
            API.HeadMsg("Too Far", API.Player.Serial, 44)
            API.SysMsg("More than 10 tiles from start stone - move to the quest area.", 44)
            return False

        if not has_all_five:
            API.HeadMsg("Missing Items", API.Player.Serial, 44)
            return False

        if not melbook:
            API.Pathfind(6455, 834, wait=True)
            while not API.StopRequested:
                API.Msg("fight lady mel")
                for _ in range(6):
                    API.Pause(1.0)
                    melbook = API.FindType(0x0E3B, hue=0x01F4, container=bp_serial)
                    if melbook:
                        break
                if melbook:
                    break

        if not API.HasGump(QUEST_GUMP_ID):
            API.UseObject(melbook.Serial)
            API.WaitForGump(QUEST_GUMP_ID, 1.0)

        API.CancelTarget()

        for qitem in [foulfungi[0], stifftwigs[0], petritwigs[0], toadstools[0], fossiltwigs[0]]:
            if not API.HasTarget("any"):
                API.ReplyGump(700, QUEST_GUMP_ID)
                API.WaitForTarget(timeout=1.0)
            API.Target(qitem.Serial)
            API.WaitForTarget(timeout=1.0)

        API.CloseGump(QUEST_GUMP_ID)
        API.CancelTarget()

        API.Pathfind(6450, 840, wait=True)
        API.Pause(0.6)

        while API.FindType(0x0E3B, hue=0x01F4, container=bp_serial) and not API.StopRequested:
            API.Msg("ready")
            for _ in range(6):
                melbook = API.FindType(0x0E3B, hue=0x01F4, container=bp_serial)
                if not melbook:
                    break
                API.Pause(1.0)


def SortMelItems(API: API):
    pouch = GetPeerlessBag(API)
    pouch_serial = getattr(pouch, 'Serial', None) if pouch else None
    if not pouch_serial:
        API.SysMsg("No Peerless Pouch Found!", 33)
        return False

    trash_bag = GetMyItem(API, "recyclebag")
    trash_serial = getattr(trash_bag, 'Serial', trash_bag) if trash_bag else None

    toadstools, foulfungi, stifftwigs, petritwigs, fossiltwigs, _ = getQuestItems(API)
    keep_max = min(len(foulfungi), len(fossiltwigs)) + 5

    for qitem in [toadstools, foulfungi, stifftwigs, petritwigs, fossiltwigs]:
        in_pouch = [q for q in qitem if q.Container == pouch.Serial]
        in_pack = [q for q in qitem if q.Container != pouch.Serial]
        kept = len(in_pouch)
        for item in in_pack:
            if kept < keep_max:
                MoveItemToContainer(API, item.Serial, pouch_serial, x=random.randint(44, 100), y=100)
                kept += 1
            elif trash_serial and item.Container != trash_serial:
                MoveItemToContainer(API, item.Serial, trash_serial)
            API.Pause(0.6)

    mel_tickets = API.FindTypeAll(0x14EF, hue=0, container=API.Player.Backpack.Serial) or []
    mel_tickets = [m for m in mel_tickets if m.Container != pouch.Serial and 'lady melisande master ticket' in API.ItemNameAndProps(m, True).lower()]
    for tick in mel_tickets:
        props = (API.ItemNameAndProps(tick.Serial, True) or "").lower()
        if "melisande master ticket" in props:
            MoveItemToContainer(API, tick.Serial, pouch_serial, x=random.randint(44, 100), y=65)
            API.Pause(0.6)


def TrashMelItems(API: API):
    toadstools, foulfungi, stifftwigs, petritwigs, fossiltwigs, has_all_five = getQuestItems(API)
    trash_bag = GetMyItem(API, "recyclebag")
    trash_serial = getattr(trash_bag, 'Serial', trash_bag) if trash_bag else None
    if not trash_serial:
        return

    for qitems in [toadstools, foulfungi, stifftwigs, petritwigs, fossiltwigs]:
        qitems = [i for i in qitems if getattr(i, 'Container', None) != trash_serial]
        for item in qitems:
            MoveItemToContainer(API, item.Serial, trash_serial)
            API.Pause(0.6)


def TrashMelJunk(API: API):
    trash_bag = GetMyItem(API, "recyclebag")
    trash_serial = getattr(trash_bag, 'Serial', trash_bag) if trash_bag else None
    bp_serial = getattr(API.Player.Backpack, 'Serial', None) if (API.Player and API.Player.Backpack) else None
    if not bp_serial:
        return

    # Eternally corrupt trees
    trees = API.FindTypeAll(0x20FA, container=bp_serial) or []
    for tree in trees:
        props = (API.ItemNameAndProps(tree.Serial, True) or "").lower()
        if "eternally corrupt tree" in props and trash_serial:
            MoveItemToContainer(API, tree.Serial, trash_serial)
            API.Pause(0.6)

    # Recipe scrolls
    recipes = API.FindTypeAll(0x2831, hue=0, container=bp_serial) or []
    for recipe in recipes:
        props = (API.ItemNameAndProps(recipe.Serial, True) or "").lower()
        if "recipe scroll" not in props:
            continue
        API.InJournal("already know this recipe", clearMatches=True)
        API.UseObject(recipe.Serial)
        API.Pause(0.6)
        if API.InJournal("already know this recipe", clearMatches=True) and trash_serial:
            MoveItemToContainer(API, recipe.Serial, trash_serial)
            API.Pause(0.6)


def main(API: API):
    if not getattr(API, 'Player', None) or not getattr(API.Player, 'Backpack', None):
        return

    FillLadyMelBook(API)
    MelTicketCount(API)
    ClearStaleGumps(API)

    if API.GetMap() == 0: # Felucca
        SortMelItems(API)
    else:
        TrashMelItems(API)

    TrashMelJunk(API)


if __name__ in ("__main__", "<module>"):
    main(API)
