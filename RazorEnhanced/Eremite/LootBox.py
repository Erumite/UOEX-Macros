import re
from Eremite.utils.items import GetRecycleBag, GetGemPouch, GetLockpicks
from Eremite.utils.sorting import QuickSort

holdingbag = Misc.ReadSharedValue("BagOfHolding")
gempouch = GetGemPouch()
recyclebag = GetRecycleBag()
lockpicks = GetLockpicks(best=True)

LOCK_PATTERN = re.compile(r'.*(?<=>)([^<]+)(?= lock).*')
WARN_WEIGHT = Misc.ReadSharedValue("WarnWeight")
CRIT_WEIGHT = Misc.ReadSharedValue("CriticalWeight")

lockables = [
    0xe7c, # Grey EW
    0x9ab, # Gray NS
    0xe41, # Gray/Gold NS
    0xe40, # Gray/Gold EW
    0xe43, # Wood/Gold NS
    0xe42, # Wood/Gold EW
    0xe3e, # Med Wood Crate WE
    0x9a9, # Small Wood Crate NS
    0xe3c, # Big Wood Crate (Square)
    0xe7f, # Keg
    0xe77, # Barrel
]

color_map = {
    "Bronze": 444,
    "Shadow Iron": 999,
    "Agapite": 46,
    "Blaze": 39,
    "Gold": 53,
    "Valorite": 91,
    "Verite": 61,
    "Toxic": 69,
    "Ice": 88,
    "Platinum": 2442
}

def FindLockables():
    filter = Items.Filter()
    filter.Enabled = True
    filter.IsContainer = True
    filter.OnGround = True
    filter.RangeMin = 0
    filter.RangeMax = 15
    chests = Items.ApplyFilter(filter)
    chests = [chest for chest in chests if chest.ItemID in lockables]
    chests = [chest for chest in chests if HasLoot(chest)]
    near = [chest for chest in chests if Player.DistanceTo(chest) <= 1]
    return near[0] if near else []

def HasLoot(chest):
    for prop in chest.Properties:
        prop = str(prop)
        if 'lock' in prop.lower():
           match = LOCK_PATTERN.match(prop)
           if match:
               level = match.group(1).strip()
               color = color_map.get(level, 0) or 0
               Items.Message(chest,color,f"-=({level})=-")
               return True
        if 'items' in prop.lower():
            count = prop.split(' items')[0]
            count = int(count)
            if int(count) > 0:
                Items.Message(chest,69,f"-=({count} Items)=-")
                return True
    return False

def WeightCheck():
    if Player.Weight > CRIT_WEIGHT:
        QuickSort(scrolls = False)
    if Player.Weight > CRIT_WEIGHT:
        Misc.SendMessage("Weight Too High!", 33)
        return False
    return True

def isLocked(chest):
    for prop in chest.Properties:
        if "lock<" in (str(prop)):
            return True
    return False
    
def DoLockPick(box):
    if not lockpicks:
        GetLockpicks(best=True)
    if not lockpicks:
        Misc.SendMessage("No Lockpicks!", 33)
        Misc.Pause(1000)
        return False
    Items.UseItem(lockpicks)
    Target.WaitForTarget(600)
    if not Target.HasTarget():
        Items.UseItem(lockpicks)
        Target.WaitForTarget(600)
    Target.TargetExecute(box)
    Misc.Pause(4100)
     
def DisposeBox(box):
    while not Items.WaitForContents(box, 1000):
        pass
    if box.Contains:
        print("Dispose failed: has items")
        return
    if box.OnGround:
        # Remove Chest on treasure boxes.
        Misc.WaitForContext(box, 1500)
        Misc.ContextReply(box, 0)
        Gumps.WaitForGump(0xc8fd1ea7, 10000)
        Gumps.SendAction(0xc8fd1ea7, 1)
        
def DragGemsToPouch(box, gempouch):
    gems = Misc.ReadSharedValue('gems')
    gs = Items.FindAllByID(gems, -1, box.Serial, 0)
    while len(gs) > 0:
        for g in gs:
            Items.Move(g, gempouch, -1)
            Misc.Pause(600)
        gs = Items.FindAllByID(gems, -1, box.Serial, 0)
    return True
    
def DragGoldToBoH(box, boh):
    gold = Items.FindAllByID(0x0EED,0, box.Serial,0)
    while len(gold) > 0:
        for g in gold:
            Items.Move(g, boh, -1)
            Misc.Pause(600)        
        gold = Items.FindAllByID(0x0EED,0, box.Serial,0)
    return True
    
def DragLootToBackpack(box):
    while len(box.Contains) > 0:
        for loot in box.Contains:
            if not WeightCheck():
                Player.HeadMessage(33, "High Weight")
                return
            Items.Move(loot,Player.Backpack.Serial,-1)
            Misc.Pause(600)
        Items.WaitForContents(box, 600)
    return True

def main():
    Target.Cancel()
    target = FindLockables()
    if not target:
        target = Target.PromptTarget("Loot what?", 91)
        target = Items.FindBySerial(target)
    if not target or target == -1:
        return
    if target.OnGround and Player.DistanceTo(target) > 1:
        Items.Message(target, 66, "Too far.")
        return
    Items.Message(target,69,"V")
    while isLocked(target):
        DoLockPick(target)
    while not Items.WaitForContents(target,600):
        pass
    Misc.Pause(600)
    Misc.ClearDragQueue()
    if holdingbag:
        DragGoldToBoH(target, holdingbag)
    if gempouch: 
        DragGemsToPouch(target, gempouch)
    DragLootToBackpack(target)
    DisposeBox(target)

main()
QuickSort()