from Eremite.utils.items import GetMyItem, AppraiseWeapon, AppraiseJewelry, AppraiseArmor, MoveItemToContainer
from Eremite.utils.sorting import QuickSort, trashJunk
from Eremite.utils.barding import InstrumentStocker
from Eremite.utils.misc import GetItemLock

WEAP_KEEP_THRESHOLD = 350

def isBlessed(API: API, item):
    """Checks if an item is blessed or insured."""
    if not item:
        return False
    item_serial = getattr(item, 'Serial', item)
    props = API.ItemNameAndProps(item_serial, True) or ""
    props_lower = props.lower()
    for prop in props_lower.splitlines():
        if "insured" in prop or "blessed" in prop:
            return True
    return False

def appraise_weapons(API: API):
    weapons_ids = API.GetSharedVar("weapons") or []
    trash_weapons_ids = API.GetSharedVar("trash_weapons") or []
    lootBag = API.GetSharedVar("LootBag")
    recycleBag = GetMyItem(API, "recyclebag")
    if not all([weapons_ids, trash_weapons_ids, lootBag, recycleBag]):
        API.SysMsg("Missing information!  Check appraise_weapons function.")
        return

    pack_items = API.ItemsInContainer(API.Player.Backpack, recursive=False) or []
    weapons = [w for w in pack_items if w.Graphic in weapons_ids and not isBlessed(API, w)]
    trash_weapons = [w for w in pack_items if w.Graphic in trash_weapons_ids and not isBlessed(API, w)]

    if weapons:
        API.SysMsg("* Analyzing Weapons...", 88)
        for item in weapons:
            val = AppraiseWeapon(API, item)
            item_name = getattr(item, 'Name', '') or "Weapon"
            if val >= WEAP_KEEP_THRESHOLD and lootBag:
                API.SysMsg(f"{val}: {item_name}", 99)
                MoveItemToContainer(API, item.Serial, lootBag)
                API.IgnoreObject(item.Serial)
                API.Pause(0.6)

    # Trash4Tokens Weapons
    if trash_weapons:
        API.SysMsg("* Analyzing Trash Weapons...", 88)
        for item in trash_weapons:
            val = AppraiseWeapon(API, item)
            item_name = (getattr(item, 'Name', '') or "Weapon").lower()
            if val >= WEAP_KEEP_THRESHOLD:
                API.SysMsg(f"{val}: {item_name}", 99)
                MoveItemToContainer(API, item.Serial, lootBag)
                API.IgnoreObject(item.Serial)
                API.Pause(0.6)
            elif "gargoyle" not in item_name:
                MoveItemToContainer(API, item.Serial, recycleBag)
                API.Pause(0.6)

jewelry_name_exclusions = ["sabrix's eye"]

def appraise_jewelry(API: API):
    jewelry_ids = API.GetSharedVar('jewelry') or []
    lootBag = API.GetSharedVar("LootBag")
    recycleBag = GetMyItem(API, 'recyclebag')
    if not all([jewelry_ids, lootBag, recycleBag]):
        API.SysMsg("Missing information!  Check appraise_jewelry function.")
        return

    pack_items = API.ItemsInContainer(API.Player.Backpack, recursive=False) or []
    jewelry = [j for j in pack_items if j and j.Graphic in jewelry_ids and not isBlessed(API, j)]

    if jewelry:
        API.SysMsg("* Analyzing Jewelry...", 88)
        API.Pause(0.6)
        for item in jewelry:
            item_name = (getattr(item, 'Name', '') or "").lower()
            if any(ex in item_name for ex in jewelry_name_exclusions):
                continue
            is_keep = AppraiseJewelry(API, item)
            dest = lootBag if is_keep else getattr(recycleBag, 'Serial', recycleBag)
            if dest:
                MoveItemToContainer(API, item.Serial, dest)
                API.Pause(0.6)

def appraise_armor(API: API):
    armor_ids = API.GetSharedVar('armors') or []
    lootBag = API.GetSharedVar("LootBag")

    if not all([armor_ids, lootBag]):
        API.SysMsg("Missing information!  Check appraise_armor function.")
        return

    pack_items = API.ItemsInContainer(API.Player.Backpack, recursive=False) or []
    armor = [a for a in pack_items if a.Graphic in armor_ids and not isBlessed(API, a)]

    if armor:
        API.SysMsg("* Analyzing Armors...", 88)
        API.Pause(0.6)
        for item in armor:
            if AppraiseArmor(API, item):
                MoveItemToContainer(API, item.Serial, lootBag)
                API.Pause(0.6)

def trashUnsmeltables(API: API):
    recycleBag = GetMyItem(API, "recyclebag")
    if not recycleBag:
        return
    to_trash = []

    pack_items = API.ItemsInContainer(API.Player.Backpack, recursive=False) or []
    tribal_spears = [i for i in pack_items if i and getattr(i, 'Graphic', 0) == 0x0F62 and getattr(i, 'Hue', 0) == 0x0345 and 'tribal' in getattr(i, 'Name', '').lower()]
    to_trash.extend(tribal_spears)

    poh = [0x1410, 0x1411, 0x1412, 0x1413, 0x1414, 0x1415]
    plate_of_honor = [i for i in pack_items if i and getattr(i, 'Graphic', 0) in poh and "plate of honor" in API.ItemNameAndProps(i, True).lower() and getattr(i, 'Hue', 42) == 0]
    to_trash.extend(plate_of_honor)

    if to_trash:
        for item in to_trash:
            MoveItemToContainer(API, item, recycleBag)
            API.Pause(0.6)

def smelt_items(API: API, container=None):
    if not container:
        backpack = getattr(API.Player, 'Backpack', None)
        backpack_serial = getattr(backpack, 'Serial', None) if backpack else None
        container = backpack_serial
    if not container:
        return
    smith_hammer = GetMyItem(API, "smithhammer")
    if not smith_hammer:
        return
    if API.HasTarget():
        API.CancelTarget()
    trashUnsmeltables(API)
    smeltables = API.GetSharedVar("smeltables") or []

    pack_items = API.ItemsInContainer(container, recursive=False) or []
    to_smelt = [s for s in pack_items if s.Graphic in smeltables and not isBlessed(API, s)]

    if to_smelt:
        API.SysMsg(f"* Smelting {len(to_smelt)} items...", 88)
        while not API.HasGump(949095101) and not API.HasGump(0x38920abd) and not API.StopRequested:
            API.UseObject(smith_hammer)
            API.WaitForGump(949095101, 600)
            API.Pause(0.6)

        gump_id = 949095101 if API.HasGump(949095101) else 0x38920abd
        API.ReplyGump(14, gump_id)
        API.WaitForTarget(timeout=1.5)

        for item in to_smelt:
            if not API.HasTarget("any"):
                API.ReplyGump(14, gump_id)
                API.WaitForTarget(timeout=1.5)
            API.Target(item.Serial)
            API.WaitForGump(gump_id, 1500)
            API.ReplyGump(14, gump_id)
            API.WaitForTarget(timeout=1.5)

        if API.HasTarget():
            API.CancelTarget()
        API.Pause(0.6)

    if API.HasGump(0x38920abd):
        API.CloseGump(0x38920abd)
    if API.HasGump(949095101):
        API.CloseGump(949095101)

def fletch_items(API: API, container=None):
    if not container:
        backpack = getattr(API.Player, 'Backpack', None)
        backpack_serial = getattr(backpack, 'Serial', None) if backpack else None
        container = backpack_serial
    if not container:
        return
    
    fletching_tools = GetMyItem(API, "fletchingtools")
    if not fletching_tools:
        return
    if API.HasTarget():
        API.CancelTarget()
    fletchables = API.GetSharedVar("fletchables") or []

    pack_items = API.ItemsInContainer(container, recursive=False) or []
    to_chop = [c for c in pack_items if c.Graphic in fletchables and not isBlessed(API, c)]

    if to_chop:
        API.SysMsg(f"* Fletching {len(to_chop)} items...", 88)
        while not API.HasGump(949095101) and not API.StopRequested:
            API.UseObject(fletching_tools)
            API.WaitForGump(949095101, 1500)
            API.Pause(0.6)

        API.ReplyGump(14, 949095101)
        API.WaitForTarget(timeout=1.5)

        for item in to_chop:
            if not API.HasTarget("any"):
                API.ReplyGump(14, 949095101)
                API.WaitForTarget(timeout=1.5)
            API.Target(item.Serial)
            API.WaitForGump(949095101, 1500)
            API.ReplyGump(14, 949095101)
            API.WaitForTarget(timeout=1.5)

        if API.HasTarget():
            API.CancelTarget()
        API.Pause(0.6)

    if API.HasGump(949095101):
        API.CloseGump(949095101)

def chop_items(API: API, container=None):
    if not container:
        backpack = getattr(API.Player, 'Backpack', None)
        backpack_serial = getattr(backpack, 'Serial', None) if backpack else None
        container = backpack_serial
    if not container:
        return
    carpenter_saw = GetMyItem(API, "carpentersaw")
    if not carpenter_saw:
        return
    if API.HasTarget():
        API.CancelTarget()
    choppables = API.GetSharedVar("choppables") or []

    pack_items = API.ItemsInContainer(container, recursive=False) or []
    to_chop = [c for c in pack_items if c.Graphic in choppables and not isBlessed(API, c)]

    if to_chop:
        API.SysMsg(f"* Chopping {len(to_chop)} items...", 88)
        while not API.HasGump(949095101) and not API.HasGump(0x38920abd) and not API.StopRequested:
            API.UseObject(carpenter_saw)
            API.WaitForGump(949095101, 1000)
            API.Pause(0.6)

        gump_id = 949095101 if API.HasGump(949095101) else 0x38920abd
        API.ReplyGump(14, gump_id)
        API.WaitForTarget(timeout=1.5)

        for item in to_chop:
            if not API.HasTarget("any"):
                API.ReplyGump(14, gump_id)
                API.WaitForTarget(timeout=1.5)
            API.Target(item.Serial)
            API.WaitForGump(gump_id, 1000)
            API.ReplyGump(14, gump_id)
            API.WaitForTarget(timeout=1.5)

        if API.HasTarget():
            API.CancelTarget()
        API.Pause(0.6)

    if API.HasGump(0x38920abd):
        API.CloseGump(0x38920abd)
    if API.HasGump(949095101):
        API.CloseGump(949095101)

def trashUnscissorables(API: API):
    recycleBag = GetMyItem(API, "recyclebag")
    if not recycleBag:
        return

    lasp = [0x13CB, 0x13CC, 0x13CD, 0x13C6]  # Leather Set
    pack_items = API.ItemsInContainer(API.Player.Backpack, recursive=False) or []
    unsciss = [u for u in pack_items if u.Graphic in lasp and not isBlessed(API, u)]

    if unsciss:
        API.Pause(0.6)
        for item in unsciss:
            props = API.ItemNameAndProps(item.Serial, True) or ""
            props_lower = props.lower()
            name_lower = (getattr(item, 'Name', '') or "").lower()

            trash = "leather" in name_lower and "part of an armor set" in props_lower
            trash = trash or "greymist armor" in props_lower
            trash = trash or "death's essence" in props_lower

            if trash:
                MoveItemToContainer(API, item.Serial, recycleBag)
                API.Pause(0.6)

def scissorItem(API: API, scissors, item):
    if API.HasTarget("any"):
        API.Target(item.Serial)
    else:
        while not API.HasTarget("any") and not API.StopRequested:
            API.UseObject(scissors)
            API.WaitForTarget(timeout=0.3)
        API.Target(item.Serial)

def scissor_items(API: API, container=None):
    if not container:
        backpack = getattr(API.Player, 'Backpack', None)
        backpack_serial = getattr(backpack, 'Serial', None) if backpack else None
        container = backpack_serial
    if not container:
        return
    scissors = GetMyItem(API, "scissors")
    if not scissors:
        return
    if API.HasTarget():
        API.CancelTarget()
    trashUnscissorables(API)

    scissorables = API.GetSharedVar("scissorables") or []

    pack_items = API.ItemsInContainer(container, recursive=False) or []
    to_cut = [s for s in pack_items if s.Graphic in scissorables and not isBlessed(API, s)]

    if to_cut:
        API.SysMsg(f"* Scissoring {len(to_cut)} items...", 88)
        API.UseObject(scissors)
        API.WaitForTarget(timeout=0.6)
        for item in to_cut:
            scissorItem(API, scissors, item)
        if API.HasTarget():
            API.CancelTarget()
        API.Pause(0.6)

# ================= Resource Keys ==================

resource_keys = {
    "spellkeys": {"shared_var": "key_reagents", "gump_id": 247257139, "reply_val": 60030},
    "woodkeys": {"shared_var": "wooditems", "gump_id": 173511501, "reply_val": 60023},
    "tailorkeys": {"shared_var": "cloths", "gump_id": 1106836505, "reply_val": 60029},
    "metalkeys": {"shared_var": "ingots", "gump_id": 4213074123, "reply_val": 60015},
    "toolhouse": {"shared_var": "tools", "gump_id": 1513449091, "reply_val": 60030},
    "runictoolhouse": {"shared_var": "tools", "gump_id": 810195827, "reply_val": 999},
    "gempouch": {"shared_var": "gems", "gump_id": 309845371, "reply_val": 30},
}

def do_keys(API: API, key_type: str, shared_var: str = None, gump_id: int = None, reply_val: int = None, container = None):
    if not container:
        backpack = getattr(API.Player, 'Backpack', None)
        backpack_serial = getattr(backpack, 'Serial', None) if backpack else None
        container = backpack_serial
    if not container:
        return
    shared_var = shared_var or resource_keys.get(key_type, {}).get('shared_var', None)
    gump_id = gump_id or resource_keys.get(key_type, {}).get('gump_id', None)
    reply_val = reply_val or resource_keys.get(key_type, {}).get('reply_val', None)
    if not all([shared_var, gump_id, reply_val]) or key_type not in resource_keys.keys():
        API.SysMsg(f"Bad do_keys config for {key_type}.")
        return
    
    keys = GetMyItem(API=API, item=key_type)
    if not keys:
        API.SysMsg(f"Couldn't find keys: {key_type}", 55)
        return
    key_items = API.GetSharedVar(shared_var)
    if not key_items:
        API.SysMsg(f"Couldn't find key items: {key_type} ({shared_var})", 55)
        return

    if API.HasTarget():
        API.CancelTarget()

    pack_items = API.ItemsInContainer(container, recursive=False) or []
    to_add = [i for i in pack_items if i and i.Graphic in key_items]

    # Extra Logic based on individual key types:
    if key_type == "spellkeys":
        spring_waters = [i for i in pack_items if i and getattr(i, 'Graphic', 0) == 0x0E24 and getattr(i, 'Hue', 0) == 0x047f]
        to_add.extend(spring_waters)
    elif key_type == "toolhouse":
        garg_ids = [0x0F45, 0x0E86, 0x13F6]
        garg_tools = [g for g in pack_items if g and "gargoyle" in getattr(g, 'Name', '').lower() and getattr(g, 'Hue', 0) == 0x0973 and getattr(g, "Graphic", 0) in garg_ids]
        to_add.extend(garg_tools)
    elif key_type == "runictoolhouse":
        to_add = [t for t in to_add if getattr(t, "Hue", 0) != 0]

    if to_add:
        API.SysMsg(f"* Adding {len(to_add)} items to {key_type}...", 88)
        while not API.HasGump(gump_id) and not API.StopRequested:
            API.UseObject(keys)
            API.WaitForGump(gump_id)
            API.Pause(0.6)
        API.ReplyGump(reply_val, gump_id)
        API.WaitForTarget(timeout=1.0)
        for item in to_add:
            if not API.HasTarget("any"):
                API.ReplyGump(reply_val, gump_id)
                API.WaitForTarget(timeout=1.0)
            API.Target(item)
            API.WaitForTarget(timeout=1.0)
        if API.HasTarget():
            API.CancelTarget()
        API.Pause(0.6)
    if API.HasGump(gump_id):
        API.CloseGump(gump_id)

# ================= Edge ==================

def do_edge_cases(API: API):
    lootBag = API.GetSharedVar("LootBag")
    recycleBag = GetMyItem(API, "recyclebag")
    scrollBag = API.GetSharedVar("ScrollBoH")

    if API.HasTarget():
        API.CancelTarget()
    # Nunchaku
    pack_items = API.ItemsInContainer(API.Player.Backpack) or []

    nunchakus = [i for i in pack_items if i and getattr(i, 'Graphic', 0) == 0x27AE]
    for item in nunchakus:
        name = getattr(item, 'Name', '') or ""
        dest = lootBag if "dragon" in name.lower() and lootBag else recycleBag
        if dest:
            API.Pause(0.6)
            MoveItemToContainer(API, item, dest)

    # Butchers Knives
    knives = [i for i in pack_items if i and getattr(i, 'Graphic', 0) == 0x13F6]
    for item in knives:
        props = API.ItemNameAndProps(item, True) or ""
        if "gargoyle" in props.lower():
            continue
        val = AppraiseWeapon(API, item)
        dest = lootBag if val >= WEAP_KEEP_THRESHOLD and lootBag else recycleBag
        if dest:
            API.Pause(0.6)
            MoveItemToContainer(API, item, dest)

    # Harps
    harps = [i for i in pack_items if i and getattr(i, 'Graphic', 0) == 0x0EB2]
    for item in harps:
        if recycleBag:
            API.Pause(0.6)
            MoveItemToContainer(API, item, recycleBag)

    # Juka Lord Bows
    bows = [i for i in pack_items if i and getattr(i, 'Graphic', 0) == 0x13B2 and getattr(i, 'Hue', 42) == 0]
    for item in bows:
        props = API.ItemNameAndProps(item, True) or ""
        if "80 str, 80 dex" in props.lower() and recycleBag:
            MoveItemToContainer(API, item, recycleBag)

    # Normal ointments to LootBoH / ScrollBoH
    if scrollBag:
        ointments = [i for i in pack_items if i and getattr(i, 'Graphic', 0) == 0x0E24 and getattr(i, 'Hue', 42) == 0]
        for oint in ointments:
            API.Pause(0.6)
            MoveItemToContainer(API, oint, scrollBag)

peerless_loot = {
    0x318B: "diseased bark",
    0x3183: "blight",
    0x3184: "corruption",
    0x3185: "scourge",
    0x3186: "putrefaction",
    0x3187: "taint",
    0x3188: "muculent",
    0x318D: "eye of the travesty",
}

def sortPeerlessLoot(API: API):
    lootBag = API.GetSharedVar("LootBag")
    bagOfHolding = API.GetSharedVar("BagOfHolding")
    peerless_storage = 0x47A61E5D

    peer_ids = list(peerless_loot.keys())

    pack_items = API.ItemsInContainer(API.Player.Backpack) or []
    items = [i for i in pack_items if i and getattr(i, 'Graphic', 0) in peer_ids]

    if items:
        API.SysMsg(f"* Sorting {len(items)} peerless items...", 88)
    
    for item in items:
        props = API.ItemNameAndProps(item, True) or ""
        target_name = peerless_loot.get(getattr(item, 'Graphic', None))
        if target_name and target_name in props.lower() and lootBag:
            MoveItemToContainer(API, item.Serial, lootBag)
            API.Pause(0.6)

    ps = API.FindItem(peerless_storage)
    if ps and getattr(ps, 'Distance', 42) <= 2:
        pack_items = API.ItemsInContainer(lootBag, recursive=False) or []
        items = [i for i in pack_items if getattr(i, 'Graphic', 0) in peer_ids]
        for item in items:
            props = API.ItemNameAndProps(item, True) or ""
            target_name = peerless_loot.get(getattr(item, 'Graphic', None))
            if target_name and target_name in props.lower():
                MoveItemToContainer(API, item.Serial, peerless_storage)
                API.Pause(0.6)



    # Elven Notes
    notes = [i for i in pack_items if i and getattr(i, 'Graphic', 0) == 0x0E39 and getattr(i, 'Hue', 0) == 0x0A43]
    for note in notes:
        props = API.ItemNameAndProps(note, True) or ""
        if "elven note" in props.lower() and bagOfHolding:
            MoveItemToContainer(API, note.Serial, bagOfHolding)
            API.Pause(0.6)

def BoDsToBook(API: API):
    craftbodbook = 0x416E4DC9
    craftcol = [0x044e, 0x0058, 0x0483, 0x0030]
    tamerbodbook = 0x45292696
    tamercol = [0x01ca]

    pack_items = API.ItemsInContainer(API.Player.Backpack) or []
    bods = [i for i in pack_items if i and getattr(i, 'Graphic', 0) == 0x2258]

    for bod in bods:
        bod_color = getattr(bod, 'Hue', 0)
        if bod_color in craftcol and API.FindItem(craftbodbook):
            MoveItemToContainer(API, bod.Serial, craftbodbook)
            API.Pause(0.6)
        elif bod_color in tamercol and API.FindItem(tamerbodbook):
            MoveItemToContainer(API, bod.Serial, tamerbodbook)
            API.Pause(0.6)

def main():
    GetItemLock(API, __file__, wait=True, takeover=False)
    API.ClearMoveQueue()
    API.ClearIgnoreList()

    if not getattr(API, 'Player', None) or not getattr(API.Player, 'Backpack', None):
        API.SysMsg("RecycleWeight: Player or Backpack not available.", 33)
        return

    # Ensure shared values are populated from _eremite.py if not already set
    if not API.GetSharedVar("gem_pouch") or not API.GetSharedVar("smeltables"):
        API.PlayScript("Eremite/_eremite.py")

    if not getattr(API, 'Player', None) or not getattr(API.Player, 'Backpack', None):
        API.SysMsg("RecycleWeight: Player or Backpack not available.", 33)
        return

    backpack_serial = API.Player.Backpack.Serial
    toolBag = API.GetSharedVar("ToolBag")
    boh = API.GetSharedVar("BagOfHolding")

    # Fast weight-lowering tasks
    for key in ["spellkeys", "gempouch"]:
        do_keys(API=API, key_type=key)

    QuickSort(API=API, leather=False, scrolls=False)

    # Appraisal
    appraise_jewelry(API)
    appraise_weapons(API)
    appraise_armor(API)

    # Smelting / Fletching / Chopping / Scissoring
    bags_to_process = [backpack_serial]
    if toolBag:
        bags_to_process.append(toolBag)

    for bag in bags_to_process:
        smelt_items(API, container=bag)
        fletch_items(API, container=bag)
        chop_items(API, container=bag)
        scissor_items(API, container=bag)

    # Key Stocking
    
    for key in resource_keys.keys():
        do_keys(API=API, key_type=key)

    # Final Cleanup
    do_keys(API=API, key_type='spellkeys')
    do_keys(API=API, key_type='tailorkeys', container=boh)
    do_keys(API=API, key_type='tailorkeys', container=toolBag)
    trashJunk(API)
    do_edge_cases(API)
    QuickSort(API=API)
    sortPeerlessLoot(API=API)
    BoDsToBook(API)
    InstrumentStocker(API=API)

    API.SysMsg("Job's Done...", 69)
    API.CancelTarget()

if __name__ in ("__main__", "<module>"):
    main()
