from collections import OrderedDict
import API

from Eremite.utils.items import GetMyItem, UseOres, UseGroundOres
from Eremite.utils.misc import WeightCheck, GetItemLock
from Eremite.utils.sorting import QuickSort, trashJunk

CORPSE_ID = 0x2006


def ScanCorpses(API, search_range=2):
    return API.GetItemsOnGround(distance=search_range, graphic=CORPSE_ID) or []

def GetDistanceToPlayer(API, entity):
    ex = getattr(entity, 'X', API.Player.X)
    ey = getattr(entity, 'Y', API.Player.Y)
    return getattr(entity, 'Distance', max(abs(ex - API.Player.X), abs(ey - API.Player.Y)))

def CutCorpses(API, corpses):
    API.ClearMoveQueue()
    skinning_knife = GetMyItem(API, "skinningknife")
    if not skinning_knife:
        API.SysMsg("No Skinning Knife! Skipping cutting.", 33)
        return

    for c in corpses:
        if GetDistanceToPlayer(API, c) > 2:
            API.HeadMsg("?", c.Serial, 33)
            continue
        if not WeightCheck(API):
            return

        API.UseObject(skinning_knife)
        if not API.WaitForTarget(timeout=0.6):
            API.UseObject(skinning_knife)
            API.WaitForTarget(timeout=0.6)

        API.Target(c.Serial)
        API.Msg("[claimall")
        if API.WaitForTarget(timeout=1.5):
            API.Target(c.Serial)
            API.WaitForTarget(timeout=1.5)
            API.CancelTarget()

    API.CancelTarget()

def ClaimAllCorpses(API, corpses):
    API.CancelTarget()
    if not corpses:
        return

    # Sort nearest corpses first
    corpses_dist = {c: GetDistanceToPlayer(API, c) for c in corpses}
    sorted_corpses = sorted(corpses_dist.keys(), key=lambda c: corpses_dist[c])

    API.Msg("[claimall")
    API.WaitForTarget(timeout=0.5)

    for c in sorted_corpses:
        if not WeightCheck(API):
            return
        if API.HasTarget("any"):
            API.Target(c.Serial)
            API.WaitForTarget(timeout=0.6)
        else:
            API.Msg("[claimall")
            if API.WaitForTarget(timeout=0.6):
                API.Target(c.Serial)
                API.WaitForTarget(timeout=0.6)

    API.CancelTarget()

def main():
    if not getattr(API, 'Player', None) or not getattr(API.Player, 'Backpack', None):
        return

    gold = getattr(API.Player, 'Gold', 0)
    if not WeightCheck(API):
        UseOres(API)
        return

    API.ClearMoveQueue()
    GetItemLock(API, __file__, wait=True, takeover=True)

    unchoppable = API.GetSharedVar('corpse_ignore_list') or []

    # Claim all non-choppable corpses within 10 tiles
    corpses = ScanCorpses(API, 10)
    to_claim = [c for c in corpses if getattr(c, 'Amount', 1) in unchoppable]
    if to_claim:
        API.SysMsg("Claiming Far Corpses...", 69)
        ClaimAllCorpses(API, to_claim)

    # Scan for choppable bodies within 2 tiles and clean them up
    corpses = ScanCorpses(API, 2)
    to_chop = [c for c in corpses if getattr(c, 'Amount', 1) not in unchoppable]
    if to_chop:
        API.SysMsg("Chopping Near Corpses...", 69)
        CutCorpses(API, to_chop)

    API.CancelTarget()

    gained = getattr(API.Player, 'Gold', 0) - gold
    if gained > 20:
        API.HeadMsg(f"+{gained}", API.Player.Serial, 55)

    # Misc cleanup from earth elements/etc.
    UseOres(API)
    UseGroundOres(API)
    QuickSort(API)
    trashJunk(API)

if __name__ in ("__main__", "<module>"):
    main()
