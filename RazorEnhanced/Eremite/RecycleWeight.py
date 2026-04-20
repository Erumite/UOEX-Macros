while Misc.ScriptStatus("CutClaimall.py"):
    Misc.Pause(1000)

from Scripts.Eremite.utils.items import GetSmithHammer,GetCarpHammer, GetFletchingTools, GetScissors, GetRecycleBag, GetKeys, GetToolHouse, GetGemPouch
from Eremite.utils.items import AppraiseWeapon, AppraiseJewelry
from Eremite.utils.sorting import QuickSort, trashJunk
from Eremite.utils.barding import InstrumentStocker

smith_hammer = GetSmithHammer()
carpenter_hammer = GetCarpHammer()
fletching_tools = GetFletchingTools()
scissors = GetScissors()
gem_pouch = GetGemPouch()

WEAP_KEEP_THRESHOLD = 250

# Containers
lootBag = Misc.ReadSharedValue("LootBag")
toolBag = Items.FindBySerial(Misc.ReadSharedValue("ToolBag"))
recycleBag = GetRecycleBag()
backpack = Player.Backpack

# Keys:
wood_keys = GetKeys("wood")
spell_keys = GetKeys("spell")
metal_keys = GetKeys("metal")
tailor_keys = GetKeys("tailor")
tool_house = GetToolHouse()

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
    
def useWhenBusy(item):
    Journal.Clear(busy_text)
    Misc.Pause(600)
    Items.UseItem(item)
    while Journal.Search(busy_text):
        Journal.Clear(busy_text)
        Misc.Pause(600)
        Items.UseItem(item)
    return None
    
def appraise_weapons(pack):
    # Smeltable Weapons
    items = Items.FindAllByID(weapons, -1, pack.Serial, 0)
    items = [item for item in items if not isBlessed(item)]
    if len(items) > 0: 
        Misc.SendMessage("Analyzing Weapons...", 69)
    for item in items:
        if AppraiseWeapon(item) >= WEAP_KEEP_THRESHOLD:
            Items.Move(item,lootBag,-1)
            Misc.Pause(600)
    # Trash4Tokens Weapons
    items = Items.FindAllByID(trash_weapons, -1, pack.Serial, 0)
    items = [item for item in items if not isBlessed(item)]
    if len(items) > 0: 
        Misc.SendMessage("Analyzing Trash Weapons...", 69)
    for item in items:
        if AppraiseWeapon(item) >= WEAP_KEEP_THRESHOLD:
            Items.Move(item,lootBag,-1)
            Misc.Pause(600)
        else:
            Items.Move(item,recycleBag,-1)
            Misc.Pause(600)    
            
def appraise_jewelry(pack):
    items = Items.FindAllByID(jewelry, -1, pack.Serial, 0)
    for item in items:
        dest = lootBag if AppraiseJewelry(item) else recycleBag
        Items.Move(item,dest,-1)
        Misc.Pause(600)
            
def smelt_items(pack):
    items = Items.FindAllByID(smeltables, -1, pack.Serial, 0, True)
    items = [item for item in items if not isBlessed(item)]
    if len(items) > 0:
        Misc.SendMessage(f"Smelting {len(items)} items...", 69)
        useWhenBusy(smith_hammer)
        Gumps.WaitForGump(949095101, 1500)
        Gumps.SendAction(0x38920abd,14)
        Target.WaitForTarget(1500)
        for item in items:
            Target.TargetExecute(item)
            Gumps.WaitForGump(949095101, 1500)
            Gumps.SendAction(0x38920abd,14)
            Target.WaitForTarget(1500)
        Target.Cancel()
    while Gumps.HasGump(0x38920abd):
        Gumps.CloseGump(0x38920abd)
    
def fletch_items(pack):
    items = Items.FindAllByID(fletchables, -1, pack.Serial, 0, True)
    items = [item for item in items if not isBlessed(item)]
    if len(items) > 0:
        Misc.SendMessage(f"Fletching {len(items)} items...", 69)
        if not Gumps.HasGump(949095101):
            useWhenBusy(fletching_tools)
            Gumps.WaitForGump(949095101,1500)
        Gumps.SendAction(0x38920abd,14)
        Target.WaitForTarget(1500)
        for item in items:
            Target.TargetExecute(item)
            Gumps.WaitForGump(949095101,1500)
            Gumps.SendAction(0x38920abd,14)
            Target.WaitForTarget(1500)
        Target.Cancel()
    while Gumps.HasGump(949095101):
        Gumps.CloseGump(949095101)

def chop_items(pack):
    items = Items.FindAllByID(choppables, -1, pack.Serial, 0, True)
    items = [item for item in items if not isBlessed(item)]
    if len(items) > 0:
        Misc.SendMessage(f"Chopping {len(items)} items...")
        if not Gumps.HasGump(949095101):
            useWhenBusy(carpenter_hammer)
            Gumps.WaitForGump(949095101, 1000)
        for item in items:
            Gumps.SendAction(0x38920abd, 14)
            Target.WaitForTarget(1500)
            Target.TargetExecute(item)
            Gumps.WaitForGump(949095101, 1000)
        Target.WaitForTarget(600)
        Target.Cancel()
    while Gumps.HasGump(0x38920abd):
        Gumps.CloseGump(0x38920abd)

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
    items = Items.FindAllByID(scissorables, -1, pack.Serial, 0, True)
    items = [item for item in items if not isBlessed(item)]
    if len(items) > 0:
        Misc.SendMessage(f"Scissoring {len(items)} items...", 69)
        Items.UseItem(scissors)
        Target.WaitForTarget(600)
        for item in items:
            scissorItem(item)
        Target.Cancel()

# Resource Keys
def do_spell_keys(pack):
    items = Items.FindAllByID(spell_key_items, -1, pack.Serial, 0)
    if len(items) > 0:
        Misc.SendMessage(f"Adding {len(items)} reagents to spell keys...")
        if not Gumps.HasGump(247257139):
            useWhenBusy(spell_keys)
            Gumps.WaitForGump(247257139, 1000)
        Gumps.SendAction(0xebcd833,60030)
        Target.WaitForTarget(1000)
        for item in items:
            Target.TargetExecute(item)
            Target.WaitForTarget(1000)
        Target.Cancel()
    while Gumps.HasGump(0xebcd833):
        Gumps.CloseGump(0xebcd833)

def do_wood_keys(pack):
    items = Items.FindAllByID(wood_key_items, -1, pack.Serial, 0)
    if len(items) > 0:
        Misc.SendMessage(f"Adding {len(items)} wood to wood keys...")
        if not Gumps.HasGump(173511501):
            useWhenBusy(wood_keys)
            Gumps.WaitForGump(173511501,1000)
        Gumps.SendAction(0xa57934d,60023)
        Target.WaitForTarget(1000)
        for item in items:
            Target.TargetExecute(item)
            Target.WaitForTarget(1000)
        Target.Cancel()
    while Gumps.HasGump(0xa57934d):
        Gumps.CloseGump(0xa57934d)

def do_tailor_keys(pack):
    items = Items.FindAllByID(tailor_key_items, -1, pack.Serial, 1)
    if len(items) > 0:
        Misc.SendMessage(f"Adding {len(items)} cloth to tailor keys...")
        if not Gumps.HasGump(1106836505):
            useWhenBusy(tailor_keys)
            Gumps.WaitForGump(1106836505, 1000)
        Gumps.SendAction(0x41f8fc19, 60029)
        Target.WaitForTarget(1000)
        for item in items:
            Target.TargetExecute(item)
            Target.WaitForTarget(1000)
        Target.Cancel()
    while Gumps.HasGump(0x41f8fc19):
        Gumps.CloseGump(0x41f8fc19)
        
def do_metal_keys(pack):
    items = Items.FindAllByID(metal_key_items, -1, pack.Serial, 0)
    if len(items) > 0:
        Misc.SendMessage(f"Adding {len(items)} ingots to metal keys...")
        if not Gumps.HasGump(4213074123):
            useWhenBusy(metal_keys)
            Gumps.WaitForGump(4213074123,1000)
        Gumps.SendAction(0xfb1e68cb,60015)
        Target.WaitForTarget(1000)
        for item in items:
            Target.TargetExecute(item)
            Target.WaitForTarget(1000)
        Target.Cancel()
    while Gumps.HasGump(0xfb1e68cb):
        Gumps.CloseGump(0xfb1e68cb)
        
def do_tool_house(pack):
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
        Misc.SendMessage(f"Adding {len(items)} tools to tool house...")
        if not Gumps.HasGump(1513449091):
            useWhenBusy(tool_house)
            Gumps.WaitForGump(1513449091,1000)
        Gumps.SendAction(0x5a356683, 60030)
        Target.WaitForTarget(1000)
        for item in items:
            Target.TargetExecute(item)
            Target.WaitForTarget(1000)
        Target.Cancel()
    while Gumps.HasGump(0x5a356683):
        Gumps.CloseGump(0x5a356683)
        
def do_gem_pouch(pack):
    items = Items.FindAllByID(gems, -1, pack.Serial, 1)
    if len(items) > 0:
        Misc.SendMessage(f"Adding {len(items)} gems to gem pouch...")
        if not Gumps.HasGump(309845371):
            useWhenBusy(gem_pouch)
            Gumps.WaitForGump(309845371,1000)
        Gumps.SendAction(0x1277dd7b, 30)
        Target.WaitForTarget(1000)
        for item in items:
            Target.TargetExecute(item)
            Target.WaitForTarget(1000)
        Target.Cancel()
    while Gumps.HasGump(0x1277dd7b):
        Gumps.CloseGump(0x1277dd7b)

def do_edge_cases(pack):
    # Trash most nunchaku unless Dragon Nunchaku
    items = Items.FindAllByID(0x27AE,-1 , pack.Serial , 0)
    for item in items:
        dest = lootBag if "Dragon" in item.Name else recycleBag
        Items.Move(item,dest,-1)
        Misc.Pause(600)
    # Butchers' Knife - may be garg knife.
    items = Items.FindAllByID([0x13F6],-1,pack.Serial,0)
    for item in items:
        if "gargoyle" in str(item.Properties).lower():
           continue
        elif AppraiseWeapon(item) >= WEAP_KEEP_THRESHOLD:
            Items.Move(item,lootBag,-1)
            Misc.Pause(600)
        else:
            Items.Move(item,recycleBag,-1)
            Misc.Pause(600)
    # Harps - colored ones are special relics
    items = Items.FindAllByID([0x0EB2],0,pack.Serial,0)
    for item in items:
        Items.Move(item,recycleBag,-1)
        Misc.Pause(600)
    # Tribal spears can't be smelted
    for item in Items.FindAllByID(0x0F62,0x0345,pack.Serial,0):
        Items.Move(item,recycleBag,-1)
        Misc.Pause(600)

Misc.ClearDragQueue()
# These can finish quickly to lower weight.
do_spell_keys(backpack)
do_gem_pouch(backpack)
QuickSort(leather=False, scrolls=False)

# Appraise for items worth keeping.
appraise_jewelry(backpack)
appraise_weapons(backpack)

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
do_gem_pouch(backpack)

# Cleanup
do_spell_keys(backpack) # again for bones
trashJunk(backpack)
do_edge_cases(backpack)
QuickSort()
InstrumentStocker()

# All Done
Misc.SendMessage("Job's Done...", 69)