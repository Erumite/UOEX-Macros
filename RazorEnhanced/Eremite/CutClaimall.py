from System.Collections.Generic import List
from collections import OrderedDict
from System import Int32
from Eremite.utils.items import GetSkinningKnife
from Eremite.utils.sorting import QuickSort, trashJunk

# This takes precedence over RecycleWeight and LootBox:
if Misc.ScriptStatus("RecycleWeight.py"):
    Misc.ScriptStop("RecycleWeight.py")
if Misc.ScriptStatus("LootBox.py"):
    Misc.ScriptStop("LootBox.py")

# Unchoppable Bodies
unchoppable = Misc.ReadSharedValue('corpse_ignore_list')
mobileforge = Misc.ReadSharedValue("mobileforge")

CORPSE_ID = 0x2006
WARN_WEIGHT = Misc.ReadSharedValue("WarnWeight")
CRIT_WEIGHT = Misc.ReadSharedValue("CriticalWeight")

def WeightCheck():
    if Player.Weight > CRIT_WEIGHT:
        QuickSort(scrolls = False)
        UseOres()
    if Player.Weight > CRIT_WEIGHT:
        Misc.SendMessage("Weight Too High!", 33)
        return False
    return True

def UseOres():
    ores = Items.FindAllByID(0x19B9,-1,Player.Backpack.Serial,0) # Ores
    for ore in ores:
        while Items.FindBySerial(ore.Serial):
            Items.UseItem(ore)
            Target.WaitForTarget(600)
            Target.TargetExecute(mobileforge)
            Misc.Pause(600)

# Doesn't seem to work - Ground Items show ID 0 because reserved?
def UseGroundOres():
    filt = Items.Filter()
    filt.Enabled = True
    filt.RangeMax = 1
    filt.RangeMin = 0
    filt.OnGround = True
    filt.Graphics=List[Int32]([0x19B9])
    ores = Items.ApplyFilter(filt)
    ores = [c for c in ores]
    for ore in ores:
        while Items.FindBySerial(ore.Serial):
            Items.UseItem(ore)
            Target.WaitForTarget(600)
            Target.TargetExecute(mobileforge)
            Misc.Pause(600)

def ScanCorpses(search_range=2):
    filt = Items.Filter()
    filt.Enabled = True
    filt.RangeMax = search_range
    filt.RangeMin = 0
    filt.OnGround = True
    filt.Graphics=List[Int32]([0x2006])
    corpses = Items.ApplyFilter(filt)
    corpses = [c for c in corpses]
    return corpses

def CutCorpses(corpses):
    Misc.ClearDragQueue()
    skinning_knife = GetSkinningKnife()
    if not skinning_knife:
        Misc.SendMessage("No Skinning Knife! Skipping cutting.")
        return
    for c in corpses:
        if Player.DistanceTo(c) > 2:
            Items.Message(c, 33, "?")
            continue
        if not WeightCheck():
            return
        Items.UseItem(skinning_knife)
        Target.WaitForTarget(600)
        if not Target.HasTarget():
            Items.UseItem(skinning_knife)
            Target.WaitForTarget(600)
        Target.TargetExecute(c)
        Player.ChatSay("[claimall")        
        Target.WaitForTarget(1500)
        Target.TargetExecute(c)
        Target.WaitForTarget(1500)
        Target.Cancel()
    Target.Cancel()
        
def ClaimAllCorpses(corpses):
    Target.Cancel()
    if len(corpses) == 0:
        return
    # Claim nearest first.
    corpses = {k: Player.DistanceTo(k) for k in corpses}
    corpses = OrderedDict(sorted(corpses.items(), key=lambda item: item[1]))
    corpses = corpses.keys()
    # Claimall
    Player.ChatSay("[claimall")
    Target.WaitForTarget(500)
    for c in corpses:
        if not WeightCheck():
            return
        if Target.HasTarget():
            Target.TargetExecute(c)
            Target.WaitForTarget(600)
        else:
            Player.ChatSay("[claimall")        
            Target.WaitForTarget(600)
            Target.TargetExecute(c)
            Target.WaitForTarget(600)
    Target.Cancel()

def main():
    if not WeightCheck():
        return
    Misc.ClearDragQueue()

    # Claim all non-choppable corpses within 10 tiles, ramping up.
    Misc.SendMessage("Scanning Far Corpses..." , 69)
    corpses = ScanCorpses(10)
    to_claim = [c for c in corpses if c.Amount in unchoppable]
    if len(to_claim) > 0:
        Misc.SendMessage(f"Claiming Far Corpses..." , 69)
        ClaimAllCorpses(to_claim)
    
    # Scan for choppable bodies within 2 tiles and clean them up
    Misc.SendMessage("Scanning Near Corpses..." , 69)
    corpses = ScanCorpses(2)
    to_chop = [c for c in corpses if c.Amount not in unchoppable]
    if len(to_chop) > 0:
        Misc.SendMessage("Chopping Near Corpses..." , 69)
        CutCorpses(to_chop)
    
    # Misc cleanup from earth eles/etc.
    UseOres()
    UseGroundOres()
    Misc.SendMessage("Yoink!", 69)
    
# Main()
main()
CUO.PlayMacro("AllNames")
QuickSort()
trashJunk()