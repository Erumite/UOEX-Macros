import re
from collections import OrderedDict

toollist = {
    "smithhammer": {"graphic": 0x13E4, "hue": 0},
    "fletchingtools": {"graphic": 0x1022, "hue": 0},
    "carpentersaw": {"graphic": 0x1034, "hue": 0},
    "shovel": {"graphic": 0x0F39, "hue": 0},
    "scissors": {"graphic": 0x0F9F, "hue": 0},
    "sewingkit": {"graphic": 0x0F9D, "hue": 0},
    "skinningknife": {"graphic": 0x2D2F, "hue": None},
    "lockpicks": {"graphic": 0x14FC, "hue": None},
    "spellkeys": {"graphic": 0x176B, "hue": 33},
    "metalkeys": {"graphic": 0x176B, "hue": 20},
    "woodkeys": {"graphic": 0x176B, "hue": 88},
    "tailorkeys": {"graphic": 0x176B, "hue": 69},
    "toolhouse": {"graphic": 0x22C4, "hue": 69},
    "runictoolhouse": {"graphic": 0x22C4, "hue": 88},
    "recyclebag": {"graphic": 0x09B2, "hue": 1173},
    "gempouch": {"graphic": 0x0E79, "hue": 2165},
    "mobileforge": {"graphic": 0x0E32, "hue": 1161},
}

pickTypes = {
    "Iron": 0,
    "Dull Copper": 10,
    "Shadow Iron": 30,
    "Copper": 40,
    "Bronze": 50,
    "Gold": 60,
    "Agapite": 70,
    "Verite": 80,
    "Valorite": 90,
    "Blaze": 100,
    "Ice": 110,
    "Toxic": 120,
    "Electrum": 130,
    "Platinum": 140,
}


def GetMyItem(API: API, item: str):
    if item not in toollist.keys():
        API.SysMsg(f"No Item Getter for: {item}")
        return None

    backpack_serial = getattr(API.Player.Backpack, 'Serial', None) if (API.Player and API.Player.Backpack) else None
    if not backpack_serial:
        return None

    found = API.GetSharedVar(item)
    found_serial = getattr(found, 'Serial', found)

    if found_serial:
        item_obj = API.FindItem(found_serial)
        if item_obj and getattr(item_obj, 'RootContainer', None) == getattr(API.Player, 'Serial', None):
            return item_obj

    hue = toollist[item]["hue"]
    if hue is not None and hue != 0:
        found = API.FindType(graphic=toollist[item]["graphic"], container=backpack_serial, hue=hue)
    else:
        found = API.FindType(graphic=toollist[item]["graphic"], container=backpack_serial)

    if found:
        API.SetSharedVar(item, found)
        return found

    API.SysMsg(f"Could not find {item} in backpack.")
    return None


def GetLockpicks(API: API, level=None, best=False, worst=False):
    """Find lockpicks - optionally provide specific level (platinum, etc.) or best/worst to find grade."""
    backpack_serial = getattr(API.Player.Backpack, 'Serial', None) if (API.Player and API.Player.Backpack) else None
    if not backpack_serial:
        return None

    picks = API.FindTypeAll(graphic=0x14FC, container=backpack_serial) or []
    if not picks:
        return None

    if not any([level, best, worst]):
        return picks[0]

    if level:
        for p in picks:
            props = (API.ItemNameAndProps(p.Serial, True) or "").lower()
            if level.lower() in props:
                return p

    if any([best, worst]):
        ordered_map = OrderedDict(sorted(pickTypes.items(), key=lambda item: item[1], reverse=bool(best)))
        for mat in ordered_map.keys():
            search_str = f"material: {mat.lower()}"
            for p in picks:
                props = (API.ItemNameAndProps(p.Serial, True) or "").lower()
                if search_str in props or mat.lower() in props:
                    return p

    return picks[0] if picks else None

def GetPeerlessBag(API: API):
    pouches = API.FindTypeAll(0x0E79, container=getattr(API.Player.Backpack, 'Serial', None)) or []
    _ = [API.ItemNameAndProps(p.Serial, True) for p in pouches]
    pouches = [p for p in pouches if "peerless" in str(API.ItemNameAndProps(p.Serial, True)).lower()]
    return pouches[0] if len(pouches) > 0 else None

def FindTypesInContainer(API: API, graphics=None, container = None, hue: int = None, recursive: bool=False):
    if not container and getattr(API.Player, "Backpack", None) and getattr(API.Player.Backpack, "Serial", None):
        container = API.Player.Backpack.Serial
    if not container:
        return []
    graphics = graphics if isinstance(graphics, list) else [graphics]
    items = API.ItemsInContainer(container, recursive=recursive) or []
    items = [i for i in items if getattr(i, 'Graphic', None) in graphics]
    if hue:
        items = [i for i in items if getattr(i, 'Hue', None) == hue]
    return items

# =============== Item Utils ===============
def MoveItemToContainer(API: API, item, container, amt: int = 0, x: int = 65535, y: int = 65535, max_retries: int = 2):
    """Wrapper that mimics API.MoveItem() but ensures that it actually moves in case of lag, saves, etc."""
    container_serial = getattr(container, 'Serial', container) or None
    item_serial = getattr(item, 'Serial', item) or None
    if not container_serial or not item_serial:
        return False

    curr = API.FindItem(item_serial)
    if not curr or getattr(curr, 'Container', None) == container_serial:
        return True

    for _ in range(max_retries):
        API.MoveItem(item_serial, container_serial, x=x, y=y, amt=amt)
        for _ in range(12):
            API.Pause(0.05)
            curr = API.FindItem(item_serial)
            if not curr or getattr(curr, 'Container', None) == container_serial:
                return True

    curr = API.FindItem(item_serial)
    return not curr or getattr(curr, 'Container', None) == container_serial

# =============== Item Appraisals ===============
jewelry_keep_rules = {
    "strength bonus": 8,
    "dexterity bonus": 8,
    "intelligence bonus": 8,
    "lower reagent cost": 19,
    "animal taming": 12,
    "animal lore": 8,
    "spell damage increase": 17,
}

armor_keep_rules = {
    "lower reagent cost": 19,
}


def AppraiseJewelry(API, item):
    if not item:
        return False
    item_serial = getattr(item, 'Serial', item)
    props = API.ItemNameAndProps(item_serial, True) or ""
    pattern = re.compile(r'^([\w\s]+\w)\s\+?(\d+)%?', re.IGNORECASE)
    for line in props.splitlines():
        match = pattern.match(line.strip())
        if match:
            prop_name = match.group(1).lower()
            val = int(match.group(2))
            if prop_name in jewelry_keep_rules and val >= jewelry_keep_rules[prop_name]:
                return True
    return False


def AppraiseArmor(API, item):
    if not item:
        return False
    item_serial = getattr(item, 'Serial', item)
    props = API.ItemNameAndProps(item_serial, True) or ""
    pattern = re.compile(r'^([\w\s]+\w)\s\+?(\d+)%?', re.IGNORECASE)
    for line in props.splitlines():
        match = pattern.match(line.strip())
        if match:
            prop_name = match.group(1).lower()
            val = int(match.group(2))
            if prop_name in armor_keep_rules and val >= armor_keep_rules[prop_name]:
                return True
    return False


# =============== Weapon Appraisals ===============
def AppraiseWeaponFiltered(API, weapon, verbose=False, relevant_props=None):
    if not weapon:
        return 0
    weapon_serial = getattr(weapon, 'Serial', weapon)
    props_str = API.ItemNameAndProps(weapon_serial, True) or ""

    point_map = API.GetSharedVar("weapon_point_map") or {}
    relevant_props = relevant_props or list(point_map.keys())
    name_map = API.GetSharedVar("weapon_name_map") or {}

    pattern = re.compile(r'^(.+?)\s+(\d+)\s*%?$', re.IGNORECASE)
    skip_keywords = [
        "durability", "requirement", "weapon damage", "speed:", "handed",
        "range", "skill", "quiver", "~", "blessed", "binds to", "insured",
        "slayer", "balron damnation", "spell channeling", "faster casting"
    ]

    found_props = {}
    total = 0

    for prop in props_str.splitlines():
        prop = prop.strip()
        if not prop or any(skip in prop.lower() for skip in skip_keywords):
            continue

        match = pattern.match(prop)
        if match:
            name_raw = match.group(1).strip().lower()
            value = int(match.group(2))
            canonical = name_map.get(name_raw, name_raw)
            found_props[canonical] = value

    for prop_name, value in found_props.items():
        if prop_name not in relevant_props or prop_name not in point_map:
            continue
        ref = point_map[prop_name]
        if not ref:
            continue
        points_per = ref.get("points", 0) if isinstance(ref, dict) else 0
        total += points_per * value

    return total


def AppraiseWeapon(API, weapon, verbose=False, summary=False):
    relevant_weapon_props = API.GetSharedVar("relevant_weapon_props")
    relevant_armor_props = API.GetSharedVar("relevant_armor_props")
    weapon_value = AppraiseWeaponFiltered(API, weapon, verbose=verbose, relevant_props=relevant_weapon_props)
    armor_value = AppraiseWeaponFiltered(API, weapon, verbose=verbose, relevant_props=relevant_armor_props)
    if summary:
        total_value = AppraiseWeaponFiltered(API, weapon, verbose=verbose)
        API.SysMsg(f"Armor Value: {armor_value}", 88)
        API.SysMsg(f"Weapon Value: {weapon_value}", 88)
        API.SysMsg(f"Total Value: {total_value}", 88)
    return max(weapon_value, armor_value)


# =============== Repair Check ===============
def RepairCheck(API):
    '''
    Checks durability of equipped items across standard layers and alerts player if repair is needed.
    '''
    layers = [
        "OneHanded", "TwoHanded", "Shoes", "Pants", "Shirt", "Helmet", "Gloves", "Ring",
        "Talisman", "Necklace", "Hair", "Waist", "Torso", "Bracelet", "Tunic", "Earrings",
        "Arms", "Cloak", "Robe", "Skirt", "Legs"
    ]
    headmsgcolor = 999

    for layer in layers:
        item = API.FindLayer(layer)
        if not item:
            continue

        props = API.ItemNameAndProps(item.Serial, True) or ""
        if 'durability' not in props.lower():
            continue

        match = re.search(r'durability\s+(\d+)', props, re.IGNORECASE)
        if not match:
            continue

        durability = int(match.group(1))

        color = None
        if durability < 5:
            color = 33
            headmsgcolor = min(color, headmsgcolor)
        elif durability < 10:
            color = 45
            headmsgcolor = min(color, headmsgcolor)
        elif durability < 15:
            color = 55
            headmsgcolor = min(color, headmsgcolor)

        if color:
            API.SysMsg(f"Repair {layer}: ({durability})", color)

    if headmsgcolor < 999:
        API.HeadMsg("REPAIR!", API.Player.Serial, headmsgcolor)


# =============== Misc Item Users ===============
def UseOres(API):
    mobileforge = GetMyItem(API, "mobileforge")
    if not mobileforge:
        return
    backpack_serial = getattr(API.Player.Backpack, 'Serial', None) if (API.Player and API.Player.Backpack) else None
    if not backpack_serial:
        return
    mobileforge_serial = getattr(mobileforge, 'Serial', mobileforge)
    ores = API.FindTypeAll(0x19B9, container=backpack_serial) or []
    for ore in ores:
        while API.FindItem(ore.Serial) and not API.StopRequested:
            API.UseObject(ore.Serial)
            if API.WaitForTarget(timeout=0.6):
                API.Target(mobileforge_serial)
            API.Pause(0.6)


def UseGroundOres(API):
    mobileforge = GetMyItem(API, "mobileforge")
    if not mobileforge:
        return
    mobileforge_serial = getattr(mobileforge, 'Serial', mobileforge)
    ores = API.GetItemsOnGround(distance=1, graphic=0x19B9) or []
    for ore in ores:
        while API.FindItem(ore.Serial) and not API.StopRequested:
            API.UseObject(ore.Serial)
            if API.WaitForTarget(timeout=0.6):
                API.Target(mobileforge_serial)
            API.Pause(0.6)