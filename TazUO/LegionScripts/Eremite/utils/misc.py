from Eremite.utils.sorting import QuickSort
import re

# Relative to the TazUO/LegionScripts directory.
item_lock_scripts = [
    "Eremite/RecycleWeight.py", "Eremite/LootBox.py", "Eremite/DrinkPotionsForBottles.py",
    "Eremite/TreasureDig.py", "Eremite/FishSwampNotes.py", "Eremite/BlankScrollRestock.py", "Eremite/CutClaimall.py"
]

def GetItemLock(API: API, requester, wait=False, takeover=False):
    '''
    Acquires script lock among item-handling scripts.
    '''
    requester = requester.split("LegionScripts/")
    if len(requester) == 2:
        requester = requester[1]
    
    scripts = [s for s in item_lock_scripts if s != requester]
    
    while any(API.IsScriptRunning(s) for s in scripts):
        if takeover:
            API.ClearMoveQueue()
            for s in scripts:
                if API.IsScriptRunning(s):
                    API.StopScript(s)
                    API.Pause(0.1)
            API.Pause(1.0)
            return True
        elif not wait:
            return False
        API.Pause(1.0)
    return True

def GetPackItemCount(API: API):
    '''
    Returns current_items, max_items, percent for player backpack.
    '''
    if not getattr(API, 'Player', None) or not getattr(API.Player, 'Backpack', None):
        return 0, 125, 0.0

    bp_serial = getattr(API.Player.Backpack, 'Serial', None)
    if not bp_serial:
        return 0, 125, 0.0

    props = API.ItemNameAndProps(bp_serial, True) or ""
    # Parse lines matching e.g. "items: 45 / 125" or "45/125 items"
    match = re.search(r'(\d+)\s*/\s*(\d+)', props)
    if match:
        current_items = int(match.group(1))
        max_items = int(match.group(2))
        percent = (current_items / float(max_items)) * 100.0 if max_items > 0 else 0.0
        return current_items, max_items, percent
    return 0, 125, 0.0

def WeightCheck(API: API):
    '''
    Checks weight and pack item count limits.
    '''
    if not getattr(API, 'Player', None) or not getattr(API.Player, 'Backpack', None):
        return True

    player_weight = getattr(API.Player, 'Weight', 0)
    player_max_weight = getattr(API.Player, 'WeightMax', 400)
    crit_weight = API.GetSharedVar("CriticalWeight") or player_max_weight
    current_items, max_items, percent = GetPackItemCount(API)

    if player_weight > crit_weight:
        API.SysMsg(f"Weight High ({player_weight}/{player_max_weight}) - QuickSorting.", 44)
        QuickSort(API, scrolls=False)

    if player_weight > crit_weight:
        if getattr(API.Player, 'Serial', None):
            API.HeadMsg("High Weight", API.Player.Serial, 33)
        API.SysMsg(f"Weight Too High! {player_weight}/{player_max_weight}", 33)
        return False

    if percent > 95.0:
        if getattr(API.Player, 'Serial', None):
            API.HeadMsg("Too Many Items!", API.Player.Serial, 33)
        return False

    return True