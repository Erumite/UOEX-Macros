import time
import API

from Eremite.utils.enemies import GetEnemies, FindNearestEnemy, PickSpecialAbility
from Eremite.utils.buffs import AttackBuffs
from Eremite.utils.barding import Discordance
from Eremite.utils.items import RepairCheck
from Eremite.utils.misc import WeightCheck

LOOP_DELAY_SEC = 1.0  # Seconds between attack iterations


def doAttack(API: API) -> bool:
    enemy, melee_range, bow_range = FindNearestEnemy(API)
    if enemy:
        PickSpecialAbility(API, melee_range, bow_range)
        API.Attack(enemy.Serial)
        if not API.IsScriptRunning('Eremite/RecycleWeight.py'):
            Discordance(API, enemy)  # Avoid target collision
            API.CancelTarget()
        AttackBuffs(API, limit=1)
        return True
    else:
        API.CancelTarget()
        return False


def ManageWeight(API: API):
    if not API.IsScriptRunning("Eremite/RecycleWeight.py") and not API.IsScriptRunning("Eremite/LootBox.py"):
        if not WeightCheck(API):
            API.PlayScript("Eremite/RecycleWeight.py")
        elif not API.IsScriptRunning("Eremite/CutClaimall.py"):
            API.PlayScript("Eremite/CutClaimall.py")


def main(API: API):
    if getattr(API, 'Player', None):
        API.HeadMsg("o-|==>", API.Player.Serial, 69)

    while not API.StopRequested:
        start_time = time.time()

        RepairCheck(API)
        had_target = doAttack(API)

        if not had_target:
            ManageWeight(API)

        # Maintain background helper scripts
        if not API.IsScriptRunning("Eremite/WeaponLevelGump.py"):
            API.PlayScript("Eremite/WeaponLevelGump.py")

        # Pace the loop
        elapsed = time.time() - start_time
        if elapsed < LOOP_DELAY_SEC:
            API.Pause(LOOP_DELAY_SEC - elapsed)


if __name__ in ("__main__", "<module>"):
    main(API)
