from Eremite.utils.sorting import QuickSort
WARN_WEIGHT = Misc.ReadSharedValue("WarnWeight")
CRIT_WEIGHT = Misc.ReadSharedValue("CriticalWeight")

item_lock_scripts = ["RecycleWeight.py", "LootBox.py", "DrinkPotionsForBottles.py", "TreasureDig.py", "FishSwampNotes.py"]
# Usage from other scripts::  GetItemLock(__file__)
def GetItemLock(requester, wait=False, takeover=False): # -> bool (lock acquired)
    if '\\' in requester:
        requester = requester.split('\\')[-1]
    scripts = [s for s in item_lock_scripts if s != requester]
    while any([Misc.ScriptStatus(s) for s in scripts]):
        if not wait:
            return False
        if takeover:
            for s in scripts:
                Misc.ScriptStop(s)
            return True
        Misc.Pause(1000)
    return True
    

def GetPackItemCount(): # -> int, int | current, max
    for p in Player.Backpack.Properties:
        if "items" in str(p):
            p = str(p)
            current_items = p.split('/')[0]
            max_items = p.split('/')[1]
            max_items = max_items.split(' ')[0]
            percent = int(current_items) / int(max_items) * 100
            return current_items, max_items, percent

            
def WeightCheck(): #-> bool
    current_items, max_items, percent = GetPackItemCount()
    CRIT_WEIGHT = Misc.ReadSharedValue("CriticalWeight")
    if Player.Weight > CRIT_WEIGHT:
        print(CRIT_WEIGHT)
        Misc.SendMessage(f"Weight High ({Player.Weight}/{Player.MaxWeight}) - QuickSorting.", 44)
        QuickSort(scrolls = False)
    if Player.Weight > CRIT_WEIGHT:
        Player.HeadMessage(33, "High Weight")
        Misc.SendMessage(f"Weight Too High! {Player.Weight}/{Player.MaxWeight}", 33)
        return False
    if percent > 95.0:
        Player.HeadMessage(33, "Too Many Items!")
        return False
    return True

