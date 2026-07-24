from Scripts.Eremite.utils.items import GetSmithHammer,GetCarpHammer, GetFletchingTools, GetScissors, GetRecycleBag, GetKeys, GetToolHouse, GetGemPouch, GetRunicToolHouse
from Eremite.utils.items import AppraiseWeapon, AppraiseJewelry, AppraiseArmor
from Eremite.utils.sorting import QuickSort, trashJunk
from Eremite.utils.barding import InstrumentStocker

smith_hammer = GetSmithHammer()
carpenter_hammer = GetCarpHammer()
fletching_tools = GetFletchingTools()
scissors = GetScissors()
gem_pouch = GetGemPouch()

WEAP_KEEP_THRESHOLD = 350

# Stop crafting macro that breaks this. 
if Misc.ScriptStatus('CraftPicksToSell.py'):
    Misc.ScriptStop('CraftPicksToSell.py')

# Crappy hack of a fix for the startup delay problem.
if not Misc.ReadSharedValue('gem_pouch'):
    Misc.ScriptRun("_eremite.py")

# Containers
lootBag = Misc.ReadSharedValue("LootBag")
toolBag = Items.FindBySerial(Misc.ReadSharedValue("ToolBag"))
scrollBag = Misc.ReadSharedValue("ScrollBoH")
bagOfHolding = Misc.ReadSharedValue("BagOfHolding")
recycleBag = GetRecycleBag()
backpack = Player.Backpack

# Keys:
wood_keys = GetKeys("wood")
spell_keys = GetKeys("spell")
metal_keys = GetKeys("metal")
tailor_keys = GetKeys("tailor")
tool_house = GetToolHouse()
runic_tool_house = GetRunicToolHouse()

# Key Item Lists
wood_key_items = Misc.ReadSharedValue("wooditems")
metal_key_items = [0x1BF2] # just ingots, lol
tailor_key_items = Misc.ReadSharedValue("cloths")
spell_key_items = Misc.ReadSharedValue("KeyReagents")
tool_house_items = Misc.ReadSharedValue("tools")
gems = Misc.ReadSharedValue('gems')
jewelry = Misc.ReadSharedValue('jewelry')


# Various Item ID Lists
weapons = Misc.ReadSharedValue("weapons")
armors = Misc.ReadSharedValue("armors")
trash_weapons = Misc.ReadSharedValue("trash_weapons")
smeltables = Misc.ReadSharedValue("smeltables")
fletchables = Misc.ReadSharedValue("fletchables")
scissorables = Misc.ReadSharedValue("scissorables")
choppables = Misc.ReadSharedValue("choppables")

busy_text = "You must wait to perform another action."

def isBlessed(item):
    props = item.Properties
    if "insured" in str(props).lower() or "blessed" in str(props).lower():
        print(f"Blessed: {item}")
        return True
    return False
    
def appraise_weapons(pack):
    # Smeltable Weapons
    items = Items.FindAllByID(weapons, -1, pack.Serial, 0)
    items = [item for item in items if not isBlessed(item)]
    if len(items) > 0: 
        Misc.SendMessage("* Analyzing Weapons...", 88)
    for item in items:
        value = AppraiseWeapon(item)
        if value >= WEAP_KEEP_THRESHOLD:
            Misc.SendMessage(f"{value}: {item.Name}", 99)
            Items.Move(item,lootBag,-1)
            Misc.IgnoreObject(item)
            Misc.Pause(600)
    # Trash4Tokens Weapons
    items = Items.FindAllByID(trash_weapons, -1, pack.Serial, 0)
    items = [item for item in items if not isBlessed(item)]
    if len(items) > 0: 
        Misc.SendMessage("* Analyzing Trash Weapons...", 88)
    for item in items:
        value = AppraiseWeapon(item)
        if value >= WEAP_KEEP_THRESHOLD:
            Misc.SendMessage(f"{value}: {item.Name}", 99)
            Items.Move(item,lootBag,-1)
            Misc.IgnoreObject(item)
            Misc.Pause(600)
        elif not "gargoyle" in item.Name.lower():
            Items.Move(item,recycleBag,-1)
            Misc.Pause(600)    

jewelry_name_exclusions = ["sabrix's eye"]
def appraise_jewelry(pack):
    items = Items.FindAllByID(jewelry, -1, pack.Serial, 0)
    if len(items) > 0: 
        Misc.SendMessage("* Analyzing Jewelry...", 88)
        Misc.Pause(600)
    for item in items:
        if any ([item.Name.lower() in n for n in jewelry_name_exclusions]):
            continue
        dest = lootBag if AppraiseJewelry(item) else recycleBag
        Items.Move(item,dest,-1)
        Misc.Pause(600)
        
def appraise_armor(pack):
    items = Items.FindAllByID(armors, -1, pack.Serial, 0)
    if len(items) > 0: 
        Misc.SendMessage("* Analyzing Armors...", 88)
        Misc.Pause(600)
    for item in items:
        if AppraiseArmor(item):
            Items.Move(item, lootBag,-1)
            Misc.Pause(600)
        
def trashUnsmeltables(pack):
    to_trash = []
    # Tribal spears can't be smelted
    for item in Items.FindAllByID(0x0F62,0x0345,pack.Serial,0):
        if not item.Properties:
            Items.WaitForProps(item, 600)
        if "tribal" in item.Name.lower():
            to_trash.append(item)
    # Plate of Honor gear can't be recycled.
    poh = [0x1410, 0x1411, 0x1412, 0x1413, 0x1414, 0x1415]
    for item in Items.FindAllByID(poh, 0, pack.Serial, 0):
        if not item.Properties:
            Items.WaitForProps(item, 600)
        if "plate of honor" in item.Name.lower():
            to_trash.append(item)
    if to_trash:
        Misc.Pause(600)
        for item in to_trash:
            Misc.Pause(600)
            Items.Move(item,recycleBag,-1)
            
def smelt_items(pack):
    Target.Cancel()
    trashUnsmeltables(pack)
    items = Items.FindAllByID(smeltables, -1, pack.Serial, 0, True)
    items = [item for item in items if not isBlessed(item)]
    if len(items) > 0:
        Misc.SendMessage(f"* Smelting {len(items)} items...", 88)
        while not Gumps.HasGump(949095101):
            Items.UseItem(smith_hammer)
            Gumps.WaitForGump(949095101, 600)
        Gumps.SendAction(0x38920abd,14)
        Target.WaitForTarget(1500)
        for item in items:
            if not Target.HasTarget():
                Gumps.SendAction(0x38920abd,14)
                Target.WaitForTarget(1500)
            Target.TargetExecute(item)
            Gumps.WaitForGump(949095101, 1500)
            Gumps.SendAction(0x38920abd,14)
            Target.WaitForTarget(1500)
        Target.Cancel()
        Misc.Pause(600)
    while Gumps.HasGump(0x38920abd):
        Gumps.CloseGump(0x38920abd)
    
def fletch_items(pack):
    Target.Cancel()
    items = Items.FindAllByID(fletchables, -1, pack.Serial, 0, True)
    items = [item for item in items if not isBlessed(item)]
    if len(items) > 0:
        Misc.SendMessage(f"* Fletching {len(items)} items...", 88)
        while not Gumps.HasGump(949095101):
            Items.UseItem(fletching_tools)
            Gumps.WaitForGump(949095101,1500)
        Gumps.SendAction(0x38920abd,14)
        Target.WaitForTarget(1500)
        for item in items:
            if not Target.HasTarget():
                Gumps.SendAction(0x38920abd,14)
                Target.WaitForTarget(1500)
            Target.TargetExecute(item)
            Gumps.WaitForGump(949095101,1500)
            Gumps.SendAction(0x38920abd,14)
            Target.WaitForTarget(1500)
        Target.Cancel()
        Misc.Pause(600)
    while Gumps.HasGump(949095101):
        Gumps.CloseGump(949095101)

def chop_items(pack):
    Target.Cancel()
    items = Items.FindAllByID(choppables, -1, pack.Serial, 0, True)
    items = [item for item in items if not isBlessed(item)]
    if len(items) > 0:
        Misc.SendMessage(f"* Chopping {len(items)} items...", 88)
        while not Gumps.HasGump(949095101):
            Items.UseItem(carpenter_hammer)
            Gumps.WaitForGump(949095101, 1000)
        Gumps.SendAction(0x38920abd, 14)
        Target.WaitForTarget(1500)
        for item in items:
            if not Target.HasTarget():
                Gumps.SendAction(0x38920abd,14)
                Target.WaitForTarget(1500)
            Target.TargetExecute(item)
            Gumps.WaitForGump(949095101, 1000)
            Gumps.SendAction(0x38920abd, 14)
            Target.WaitForTarget(1500)
        Target.Cancel()
        Misc.Pause(600)
    while Gumps.HasGump(0x38920abd):
        Gumps.CloseGump(0x38920abd)

def trashUnscissorables(pack):
    # Leather Armor Set Pieces, Death's Embrace & Leather Set pieces.
    lasp = [0x13CB, 0x13CC, 0x13CD, 0x13C6]
    unsciss = Items.FindAllByID(lasp, 0, pack.Serial, 0)
    if unsciss:
        Misc.Pause(600)
    for item in unsciss:
        if not item.Properties:
            Items.WaitForProps(item, 600)
        trash = False
        trash = "leather" in item.Name.lower() and "part of an armor set" in str(item.Properties).lower()
        trash = trash or "greymist armor" in item.Name.lower()
        trash = trash or "death's essence" in item.Name.lower()
        if trash:
            Items.Move(item,recycleBag,-1)
            Misc.Pause(600)
        
def scissorItem(i):
    if Target.HasTarget():
        Target.TargetExecute(i)
    else:
        while not Target.HasTarget():
            Items.UseItem(scissors)
            Target.WaitForTarget(100)
        Target.TargetExecute(i)

def scissor_items(pack):
    Target.Cancel()
    trashUnscissorables(pack)
    items = Items.FindAllByID(scissorables, -1, pack.Serial, 0, True)
    items = [item for item in items if not isBlessed(item)]
    if len(items) > 0:
        Misc.SendMessage(f"* Scissoring {len(items)} items...", 88)
        Items.UseItem(scissors)
        Target.WaitForTarget(600)
        for item in items:
            scissorItem(item)
        Target.Cancel()
        Misc.Pause(600)

# Resource Keys
def do_spell_keys(pack):
    Target.Cancel()
    items = Items.FindAllByID(spell_key_items, -1, pack.Serial, 0)
    # Spring waters share ID with other non-keyable items.
    spring_waters = Items.FindAllByID(0x0E24, 0x047f, pack.Serial, 0)
    items += spring_waters
    if len(items) > 0:
        Misc.SendMessage(f"* Adding {len(items)} reagents to spell keys...", 88)
        while not Gumps.HasGump(247257139):
            Items.UseItem(spell_keys)
            Gumps.WaitForGump(247257139, 1000)
        Gumps.SendAction(0xebcd833,60030)
        Target.WaitForTarget(1000)
        for item in items:
            if not Target.HasTarget():
                Gumps.SendAction(0xebcd833,60030)
                Target.WaitForTarget(1000)
            Target.TargetExecute(item)
            Target.WaitForTarget(1000)
        Target.Cancel()
        Misc.Pause(600)
    while Gumps.HasGump(0xebcd833):
        Gumps.CloseGump(0xebcd833)

def do_wood_keys(pack):
    Target.Cancel()
    items = Items.FindAllByID(wood_key_items, -1, pack.Serial, 0)
    if len(items) > 0:
        Misc.SendMessage(f"* Adding {len(items)} wood to wood keys...", 88)
        while not Gumps.HasGump(173511501):
            Items.UseItem(wood_keys)
            Gumps.WaitForGump(173511501,1000)
        Gumps.SendAction(0xa57934d,60023)
        Target.WaitForTarget(1000)
        for item in items:
            if not Target.HasTarget():
                Gumps.SendAction(0xa57934d,60030)
                Target.WaitForTarget(1000)
            Target.TargetExecute(item)
            Target.WaitForTarget(1000)
        Target.Cancel()
        Misc.Pause(600)
    while Gumps.HasGump(0xa57934d):
        Gumps.CloseGump(0xa57934d)

def do_tailor_keys(pack):
    Target.Cancel()
    items = Items.FindAllByID(tailor_key_items, -1, pack.Serial, 1)
    items = [i for i in items if "thrasher" not in i.Name.lower()]
    if len(items) > 0:
        Misc.SendMessage(f"* Adding {len(items)} cloth to tailor keys...", 88)
        while not Gumps.HasGump(1106836505):
            Items.UseItem(tailor_keys)
            Gumps.WaitForGump(1106836505, 1000)
        Gumps.SendAction(0x41f8fc19, 60029)
        Target.WaitForTarget(1000)
        for item in items:
            if not Target.HasTarget():
                Gumps.SendAction(1106836505,60030)
                Target.WaitForTarget(1000)
            Target.TargetExecute(item)
            Target.WaitForTarget(1000)
        Target.Cancel()
        Misc.Pause(600)
    while Gumps.HasGump(1106836505):
        Gumps.CloseGump(1106836505)
        
def do_metal_keys(pack):
    Target.Cancel()
    items = Items.FindAllByID(metal_key_items, -1, pack.Serial, 0)
    if len(items) > 0:
        Misc.SendMessage(f"* Adding {len(items)} ingots to metal keys...", 88)
        while not Gumps.HasGump(4213074123):
            Items.UseItem(metal_keys)
            Gumps.WaitForGump(4213074123, 1000)
        Gumps.SendAction(4213074123,60015)
        Target.WaitForTarget(1000)
        for item in items:
            if not Target.HasTarget():
                Gumps.SendAction(4213074123,60030)
                Target.WaitForTarget(1000)
            Target.TargetExecute(item)
            Target.WaitForTarget(1000)
        Target.Cancel()
        Misc.Pause(600)
    while Gumps.HasGump(4213074123):
        Gumps.CloseGump(4213074123)
        
def do_tool_house(pack):
    Target.Cancel()
    items = Items.FindAllByID(tool_house_items, -1, pack.Serial, 0)
    # Gargoyle Tools share ItemIDs with some weapons, etc:
    garg_axes = Items.FindAllByID(0x0F45, 0x0973, pack.Serial, 0)
    garg_axes = [axe for axe in garg_axes if "Gargoyle" in axe.Name]
    items += garg_axes
    garg_picks = Items.FindAllByID(0x0E86,0x0973,pack.Serial,0)
    garg_picks = [pick for pick in garg_picks if "gargoyle" in pick.Name]
    items += garg_picks
    garg_knives = Items.FindAllByID(0x13F6,0x0973,pack.Serial,0)
    garg_knives = [k for k in garg_knives if "Gargoyle" in k.Name]
    items += garg_knives
    
    if len(items) > 0:
        Misc.SendMessage(f"* Adding {len(items)} tools to tool house...", 88)
        while not Gumps.HasGump(1513449091):
            Items.UseItem(tool_house)
            Gumps.WaitForGump(1513449091,1000)
        Gumps.SendAction(0x5a356683, 60030)
        Target.WaitForTarget(1000)
        for item in items:
            if not Target.HasTarget():
                Gumps.SendAction(0x5a356683,60030)
                Target.WaitForTarget(1000)
            Target.TargetExecute(item)
            Target.WaitForTarget(1000)
        Target.Cancel()
        Misc.Pause(600)
    while Gumps.HasGump(0x5a356683):
        Gumps.CloseGump(0x5a356683)
        
def do_runic_tool_house(pack):
    Target.Cancel()
    items = Items.FindAllByID(tool_house_items, -1, pack.Serial, 0)
    items = [item for item in items if item.Color != 0]
    if len(items) > 0:
        Misc.SendMessage(f"* Adding {len(items)} runic tools to runic tool house...", 88)
        while not Gumps.HasGump(810195827):
            Items.UseItem(runic_tool_house)
            Gumps.WaitForGump(810195827,1000)
        Gumps.SendAction(810195827, 999)
        Target.WaitForTarget(1000)
        for item in items:
            if not Target.HasTarget():
                Gumps.SendAction(810195827,999)
                Target.WaitForTarget(1000)
            Target.TargetExecute(item)
            Target.WaitForTarget(1000)
        Target.Cancel()
        Misc.Pause(600)
    while Gumps.HasGump(810195827):
        Gumps.CloseGump(810195827)
        
        
def do_gem_pouch(pack):
    Target.Cancel()
    items = Items.FindAllByID(gems, -1, pack.Serial, 0)
    if len(items) > 0:
        Misc.SendMessage(f"* Adding {len(items)} gems to gem pouch...", 88)
        while not Gumps.HasGump(309845371):
            Items.UseItem(gem_pouch)
            Gumps.WaitForGump(309845371,1000)
        Gumps.SendAction(0x1277dd7b, 30)
        Target.WaitForTarget(1000)
        for item in items:
            if not Target.HasTarget():
                Gumps.SendAction(0x1277dd7b,60030)
                Target.WaitForTarget(1000)
            Target.TargetExecute(item)
            Target.WaitForTarget(1000)
        Target.Cancel()
    while Gumps.HasGump(0x1277dd7b):
        Gumps.CloseGump(0x1277dd7b)
        

def do_edge_cases(pack):
    Target.Cancel()
    # Trash most nunchaku unless Dragon Nunchaku
    items = Items.FindAllByID(0x27AE,-1 , pack.Serial , 0)
    for item in items:
        dest = lootBag if "Dragon" in item.Name else recycleBag
        Misc.Pause(600)
        Items.Move(item,dest,-1)
    # Butchers' Knife - may be garg knife.
    items = Items.FindAllByID([0x13F6],-1,pack.Serial,0)
    for item in items:
        if "gargoyle" in str(item.Properties).lower():
           continue
        elif AppraiseWeapon(item) >= WEAP_KEEP_THRESHOLD:
            Misc.Pause(600)
            Items.Move(item,lootBag,-1)
        else:
            Misc.Pause(600)
            Items.Move(item,recycleBag,-1)
    # Harps - colored ones are special relics
    items = Items.FindAllByID([0x0EB2],0,pack.Serial,0)
    for item in items:
        Misc.Pause(600)
        Items.Move(item,recycleBag,-1)
    #Juka Lord Bows
    for item in Items.FindAllByID(0x13B2,0,pack.Serial,0):
        if "80 str, 80 dex" in str(item.Properties).lower():
            Items.Move(item,recycleBag,-1)
    # Move normal ointments to LootBoH
    for oint in Items.FindAllByID(0x0E24, 0, pack.Serial, 0):
        Misc.Pause(600)
        Items.Move(oint, scrollBag, -1)

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
def sortPeerlessLoot(pack):
    peerless_storage = Items.FindBySerial(0x47A61E5D) # Storage for peerless items @ house.
    peer_ids = list(peerless_loot.keys())
    for item in Items.FindAllByID(peer_ids, -1, pack.Serial, 0):
        Items.WaitForProps(item,600) # claimall fails to update the names.
        if peerless_loot[item.ItemID] in item.Name.lower():
            Items.Move(item, lootBag, -1)
            Misc.Pause(600)
    if peerless_storage and Player.DistanceTo(peerless_storage) < 2:
        for item in Items.FindAllByID(peer_ids, -1, lootBag, 0):
            Items.Move(item, peerless_storage, -1)
    for note in Items.FindAllByID(0x0E39, 0x0a43, pack.Serial, 0): # Elven Notes
        Items.WaitForProps(note, 600)
        if "elven note" in note.Name.lower():
            Items.Move(note, bagOfHolding, -1)
            Misc.Pause(600)
            
def BoDsToBook(pack):
    craftbodbook = 0x416E4DC9 # Hard-Coded
    craftcol = [0x044e,0x0058,0x0483,0x0030]
    tamerbodbook = 0x45292696 # Hard-Coded
    tamercol = [0x01ca]
    for bod in Items.FindAllByID(0x2258, -1, pack.Serial, 0):
        if bod.Color in craftcol:
            Items.Move(bod, craftbodbook, -1)
    for bod in Items.FindAllByID(0x2258, -1, pack.Serial, 0):
        if bod.Color in tamercol:
            Items.Move(bod, tamerbodbook, -1)

def main():
    from Eremite.utils.misc import GetItemLock
    GetItemLock(__file__, wait=True, takeover=False)
    Misc.ClearDragQueue()
    # Gear that passes appraisal will be added to ignore.
    Misc.ClearIgnore()
    # These can finish quickly to lower weight.
    do_spell_keys(backpack)
    do_gem_pouch(backpack)
    QuickSort(leather=False, scrolls=False)

    # Appraise for items worth keeping.
    appraise_jewelry(backpack)
    appraise_weapons(backpack)
    appraise_armor(backpack)

    # Handle Chopping
    for bag in [backpack, toolBag]:
        smelt_items(bag)
        fletch_items(bag)
        chop_items(bag)
        scissor_items(bag)

    # Keys: 
    do_metal_keys(backpack)
    do_wood_keys(backpack)
    do_tailor_keys(backpack)
    do_tool_house(backpack)
    do_tool_house(recycleBag)
    do_runic_tool_house(backpack)

    # Cleanup
    do_spell_keys(backpack) # again for bones
    trashJunk(backpack)
    do_edge_cases(backpack)
    QuickSort()
    sortPeerlessLoot(backpack)
    BoDsToBook(backpack)
    InstrumentStocker()

    # All Done
    Misc.SendMessage("Job's Done...", 69)
    Target.Cancel()
    
if __name__ == "__main__":
    main()
