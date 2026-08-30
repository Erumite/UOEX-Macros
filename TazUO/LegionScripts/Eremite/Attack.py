from Eremite.utils.enemies import GetEnemies, FindNearestEnemy, PickSpecialAbility
from Eremite.utils.buffs import AttackBuffs
from Eremite.utils.barding import Discordance
from Eremite.utils.items import RepairCheck

DEBUG=True

def main():
    enemy, melee_range, bow_range = FindNearestEnemy(API)
    if enemy:
        PickSpecialAbility(API, melee_range, bow_range)
        API.Attack(enemy.Serial)
        # FireHorn(API, enemy)
        if not API.IsScriptRunning('Eremite/RecycleWeight.py'):
            Discordance(API, enemy)  # Avoid target collision
            API.CancelTarget()
        AttackBuffs(API)
    else:
        API.SysMsg("No enemies in range.", 69)
        API.CancelTarget()
        if not API.IsScriptRunning("Eremite/RecycleWeight.py") and not API.IsScriptRunning("Eremite/LootBox.py"):
            API.PlayScript("Eremite/RecycleWeight.py")
    RepairCheck(API)

    # Restart these in case the stop-all-scripts macro was hit:
    if not API.IsScriptRunning("Eremite/WeaponLevelGump.py"):
        API.PlayScript("Eremite/WeaponLevelGump.py")
    # if not API.IsScriptRunning("Eremite/ChatUI.py"):
    #     API.PlayScript("Eremite/ChatUI.py")

if __name__ in ("__main__", "<module>"):
    main()