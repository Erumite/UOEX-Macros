from Eremite.utils.enemies import GetEnemies, FindNearestEnemy, PickSpecialAbility
from Eremite.utils.buffs import AttackBuffs
from Eremite.utils.barding import Discordance
from Eremite.utils.items import RepairCheck

enemy = FindNearestEnemy()
enemycount = len(GetEnemies( Mobiles, maxRange=1))
if enemy != None:
    Player.Attack(enemy)
    PickSpecialAbility(enemycount)
    Discordance(enemy)
    Target.Cancel()
    AttackBuffs()
    Target.Cancel()
else:
    Misc.SendMessage("No enemies in range.", 69)
    Target.Cancel()
    if not Misc.ScriptStatus("RecycleWeight.py"):
        Misc.ScriptRun("RecycleWeight.py")

RepairCheck()

# Restart these in case the stop-all-scripts macro was hit:
if not Misc.ScriptStatus("WeaponLevelGump.py"):
    Misc.ScriptRun("WeaponLevelGump.py")
if not Misc.ScriptStatus("ChatUI.py"):
    Misc.ScriptRun("ChatUI.py")