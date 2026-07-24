import re
from System import Int32
from collections import OrderedDict

# =============== Item Getters ===============

def GetSmithHammer():
    # See if we have this already saved:
    hammer = Misc.ReadSharedValue("smithing_hammer")
    hid = Misc.ReadSharedValue('smith_hammer_id')
    if hammer and not isinstance(hammer, int) and Items.FindBySerial(hammer.Serial) and hammer.ItemID == hid:
        return hammer
    # Find a smithing hammer in pack:
    hammer = Items.FindByID(hid, 0, Player.Backpack.Serial, 1)
    if hammer and Items.FindBySerial(hammer.Serial):
        Misc.SetSharedValue("smithing_hammer", hammer)
        return hammer

    # If not hard coded or found, prompt for hammer:
    hammer = Target.PromptTarget("Select smithing hammer." , 34)
    if hammer and hammer != -1:
        Misc.SetSharedValue("smithing_hammer", hammer)
        return hammer
    return None
    
def GetCarpHammer():
    hammer = Misc.ReadSharedValue("carpenter_hammer")
    hid = Misc.ReadSharedValue('carpenter_hammer_id')
    if hammer and not isinstance(hammer, int) and Items.FindBySerial(hammer.Serial) and hammer.ItemID == hid:
        return hammer
    hammer = Items.FindByID(hid, 0, Player.Backpack.Serial, 1)
    if hammer and Items.FindBySerial(hammer.Serial):
        Misc.SetSharedValue("carpenter_hammer", hammer)
        return hammer
    hammer = Target.PromptTarget("Select carpenter hammer." , 34)
    if hammer and hammer != -1:
        Misc.SetSharedValue("carpenter_hammer", hammer)
        return hammer
    return None
    
def GetSkinningKnife():
    knife = Misc.ReadSharedValue('skinning_knife')
    kid = Misc.ReadSharedValue('butchers_war_cleaver_id')
    if knife and not isinstance(knife, int) and Items.FindBySerial(knife.Serial) and knife.ItemID == kid:
        return knife
    knife = Items.FindByID(kid, -1, Player.Backpack.Serial, 1)
    if knife:
        return knife
    Misc.SendMessage("No Butcher's War Cleaver Found! You should buy one to auto-cut leather to pack!", 33)
    knife = Target.PromptTarget("Select a skinning knife.", 34)
    if knife and knife != -1:
        Misc.SetSharedValue("skinning_knife", knife)
        return knife
    return None
    
def GetRecycleBag():
    rbag = Misc.ReadSharedValue("recyclebag")
    try:
        if rbag and Items.FindBySerial(rbag.Serial):
            return rbag
    except:
        pass
    rbag = Items.FindByID(0x09B2 ,0x0495, Player.Backpack.Serial, 0)
    if not rbag:
        rbag = Target.PromptTarget("Select Recycle Bag", 0x0495)
    if rbag and rbag != -1:
        Misc.SetSharedValue("recyclebag", rbag)
        return rbag
    return None
        
        
def GetFletchingTools():
    fletch = Misc.ReadSharedValue("fletching_tools")
    fid = Misc.ReadSharedValue('fletching_tools_id')
    if fletch and not isinstance(fletch, int) and Items.FindBySerial(fletch.Serial) and fletch.ItemID == fid:
        return fletch
    fletch = Items.FindByID(fid, 0, Player.Backpack.Serial, 1)
    if not fletch:
        fletch = Target.PromptTarget("Select fletching tools.",34)
    if fletch and fletch != -1:
        Misc.SetSharedValue("fletching_tools", fletch)
        return fletch
    return None
        
def GetScissors():
    scissors = Misc.ReadSharedValue("scissors")
    sid = Misc.ReadSharedValue('scissors_id')
    if scissors and not isinstance(scissors, int) and Items.FindBySerial(scissors.Serial) and scissors.ItemID == sid:
        return scissors
    scissors = Items.FindByID(sid, 0, Player.Backpack.Serial, 1)
    if not scissors:
        scissors = Target.PromptTarget("Select scissors.",34)
    if scissors and scissors != -1:
        Misc.SetSharedValue("scissors", scissors)
        return scissors
    return None

def getSewingKit():
    sewingkit = Misc.ReadSharedValue("sewingkit")
    if sewingkit and not isinstance(sewingkit, int) and Items.FindBySerial(sewingkit.Serial):
        return sewingkit
    sewingkit = Items.FindByID(0x0F9D, 0, Player.Backpack.Serial, 1)
    if not sewingkit:
        sewingkit = Target.PromptTarget("Select sewing kit.", 34)
    if sewingkit and sewingkit != -1:
        Misc.SetSharedValue('sewingkit', sewingkit)
        return sewingkit
    return None

key_colors = {
    "metal": 0x0014,
    "spell": 0x0021,
    "wood": 0x0058,
    "tailor": 0x0045
}
def GetKeys(type: str):
    if type not in key_colors.keys():
         Misc.SendMessage(f"Invalid Choice: {type} - Must be one of: {key_colors.keys()}" , 33)
         return None
    keys = Misc.ReadSharedValue(f"keys_{type}")
    if keys and Items.FindBySerial(keys.Serial):
        return keys
    keys = Items.FindByID(Misc.ReadSharedValue("keys_id") , key_colors[type], Player.Backpack.Serial, 1)
    if not keys:
        keys = Target.PromptTarget("Select keys ({type}):", 34)
    if keys and keys != -1 and keys.Color == key_colors[type] and keys.ItemID == Misc.ReadSharedValue("keys_id"):
        Misc.SetSharedValue(f"keys_{type}", keys)
        return keys
    return None

def GetToolHouse():
    thouse = Misc.ReadSharedValue("tool_house")
    if thouse and Items.FindBySerial(thouse.Serial):
        return thouse
    thouse = Items.FindByID(Misc.ReadSharedValue('toolhouse_id'), 0x0045, Player.Backpack.Serial,1)        
    if not thouse:
        thouse = Target.PromptTarget("Select Tool House.", 34)
    if thouse and thouse != -1 and thouse.Color == 0x0045 and thouse.ItemID == Misc.ReadSharedValue('toolhouse_id'):
        Misc.SetSharedValue("tool_house", thouse)
        return thouse
    return None

def GetRunicToolHouse():
    thouse = Misc.ReadSharedValue("runic_tool_house")
    if thouse and Items.FindBySerial(thouse.Serial):
        return thouse
    thouse = Items.FindByID(Misc.ReadSharedValue('toolhouse_id'), 0x0058, Player.Backpack.Serial,1)        
    if not thouse:
        thouse = Target.PromptTarget("Select Tool House.", 34)
    if thouse and thouse != -1 and thouse.Color == 0x0058 and thouse.ItemID == Misc.ReadSharedValue('toolhouse_id'):
        Misc.SetSharedValue("runic_tool_house", thouse)
        return thouse
    return None
    
def GetGemPouch():
    pouch = Misc.ReadSharedValue('gem_pouch')
    if pouch and Items.FindBySerial(pouch.Serial):
        return pouch
    pouch = Items.FindByID(0x0E79, 0x0875, Player.Backpack.Serial, 1)
    if not pouch:
        Target.PromptTarget("Select gem pouch.", 34)
    if pouch and pouch != -1:
        Misc.SetSharedValue("gem_pouch", pouch)
        return pouch
    return None

pickTypes = {
    "Iron": 10,
    "Dull Copper": 20,
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
    "Platinum": 140
}
    
def GetLockpicks(level=None, best=False, worst=False):
    """Find lockpicks - optionally provide the specific level (platinum, etc) or best to find highest grade"""
    picks = Items.FindAllByID(0x14FC, -1, Player.Backpack.Serial, 1)
    
    if not picks:
        return None
    
    if not any([level, best, worst]):
        return picks[0]
    
    pick = None
    _ = [Items.WaitForProps(p, 1000) for p in picks]
    if level:
        pick = [p for p in picks if level.lower() in str(p.Properties).lower()]
        

    if any([best, worst]):
        map = OrderedDict(sorted(pickTypes.items(), key=lambda item: item[1], reverse=best))
        map = [k for k in map]
        for m in map:
            for pick in picks:
                mat = f"material: {m.lower()}"
                if mat in str(pick.Properties).lower():
                    return pick
                
    return pick or None
    
    
# Item Comparator

def parse_resist_line(line):
    tokens = re.findall(r'(?<=>|\s)(\d+|--)(?=%)?', line)
    if len(tokens) != 5:
        print(f"Failed to parse resist line: {line}")
        return 0

    total = 0
    for token in tokens:
        if token == '--':
            continue
        else:
            num_match = re.search(r'\d+', token)
            total += int(num_match.group()) if num_match else 0
    return total

def AppraiseWeaponFiltered(weapon, verbose=False, relevant_props = None):
    if not weapon:
        return
    Items.WaitForProps(weapon, 1000)
        
    point_map = Misc.ReadSharedValue("weapon_point_map")
    relevant_props = relevant_props or list(point_map.keys())
    name_map = Misc.ReadSharedValue("weapon_name_map")
    
    pattern = re.compile(r'^(.+?)\s+(\d+)\s*%?$', re.IGNORECASE)
    skip_keywords = [
        "durability", "requirement", "weapon damage", "speed:", "handed",
        "range", "skill", "quiver", "~", "blessed", "binds to", "insured",
        "slayer", "balron damnation", "spell channeling", "faster casting"
    ]
    props = weapon.Properties
    found_props = {}
    total = 0
    
    for prop in props:
        prop = str(prop).strip()

        if not prop:
            if verbose:
                print(f"Blank: {prop}")
            continue
        if any(skip in prop.lower() for skip in skip_keywords):
            if verbose:
                print(f"Skip: {prop}")
            continue
        if weapon.Name.lower().strip() in prop.lower():
            if verbose:
                print(f"SkipName: {prop}")
            continue
        
        if prop.lower().startswith("resistances:"):
            total += parse_resist_line(prop)
            points = total * 5
            if verbose:
                print(f"Resistances: +{total} ({points})")
            found_props["Resistances"] = total
            continue

        match = pattern.match(prop)
        if match:
            name_raw = match.group(1).strip().lower()
            value = int(match.group(2))
            canonical = name_map.get(name_raw)
            found_props[canonical] = value
        else:
            Misc.SendMessage(f"Failed to match prop: {prop}", 33)
    
    for prop_name, value in found_props.items():
        if prop_name is None or prop_name not in relevant_props:
            continue
        else:
            ref = point_map[prop_name]
            if ref is None:
                continue
            points_per = ref["points"]
            contribution = points_per * value
            total += contribution
        
        if verbose:
            print(f"{prop_name}: {value}x{points_per}={contribution}")
        
    return total
    
def AppraiseWeapon(weapon, verbose=False, summary=False):
    Items.WaitForProps(weapon, 600)
    relevant_weapon_props = Misc.ReadSharedValue("relevant_weapon_props")
    relevant_armor_props = Misc.ReadSharedValue("relevant_armor_props")
    weapon_value = AppraiseWeaponFiltered(weapon, verbose=verbose, relevant_props = relevant_weapon_props)
    armor_value = AppraiseWeaponFiltered(weapon, verbose=verbose, relevant_props = relevant_armor_props)
    if summary:
        total_value = AppraiseWeaponFiltered(weapon, verbose=verbose)
        Misc.SendMessage(f"Armor Value: {armor_value}", 88)
        Misc.SendMessage(f"Weapon Value: {weapon_value}", 88)
        Misc.SendMessage(f"Total Value: {total_value}", 88)
    return max(weapon_value, armor_value)
    
jewelry_keep_rules = {
    "strength bonus": 8,
    "dexterity bonus": 8,
    "intelligence bonus": 8,
    "lower reagent cost": 19,
    "animal taming": 12,
    "animal lore": 8,
    "spell damage increase": 17,
}
    
def AppraiseJewelry(item):
    Items.WaitForProps(item, 1000)
    props = item.Properties
    pattern = re.compile(r'^([\w\s]+\w)\s\+?(\d+)%?', re.IGNORECASE)
    for prop in props:
        match = pattern.match(str(prop))
        if match:
            prop_name = match.group(1)
            if prop_name in jewelry_keep_rules and int(match.group(2)) >= jewelry_keep_rules[prop_name]:
                return True
    return False

    
armor_keep_rules = {
    "lower reagent cost": 19,
}
    
def AppraiseArmor(item): # -> Bool
    Items.WaitForProps(item, 1000)
    pattern = re.compile(r'^([\w\s]+\w)\s\+?(\d+)%?', re.IGNORECASE)
    for prop in item.Properties:
        match = pattern.match(str(prop))
        if match:
            prop_name = match.group(1)
            if prop_name in armor_keep_rules and int(match.group(2)) >= armor_keep_rules[prop_name]:
                return True
    return False
    
# Utility

def RepairCheck():
    layers = ["RightHand", "LeftHand", "Shoes", "Pants", "Shirt", "Head", "Gloves",
              "Ring", "Neck", "Waist", "InnerTorso", "Bracelet", "MiddleTorso", "Earrings",
              "Arms", "Cloak", "OuterTorso", "OuterLegs", "InnerLegs"]
    headmsgcolor = 999
    for layer in layers:
        item = Player.GetItemOnLayer(layer)
        if not item:
            continue
        
        Items.WaitForProps(item, 500)
            
        has_dura = False
        for prop in item.Properties:
            if has_dura:
                continue
            if 'durability' in str(prop).lower():
               has_dura=True

        if not has_dura:
            continue
            
        color = None
        if item.Durability < 5:
            color = 33
            headmsgcolor = min(color, headmsgcolor)
        elif item.Durability < 10:
            color = 45
            headmsgcolor = min(color, headmsgcolor)
        elif item.Durability < 15:
            color = 55
            headmsgcolor = min(color, headmsgcolor)
        if color:
            Misc.SendMessage(f"Repair {layer}: ({item.Durability})", color)

    if headmsgcolor < 999:
        Player.HeadMessage(headmsgcolor,"REPAIR!")
