from AutoComplete import *
from Eremite.utils.enemies import GetEnemies, GetEnemyNotorieties, WarEnemiesInRange, FindNearestEnemy, PickSpecialAbility
from Eremite.utils.buffs import AttackBuffs
from Eremite.utils.barding import Discordance
from Eremite.utils.items import RepairCheck
from Eremite.utils.sorting import QuickSort, trashJunk

enemy = FindNearestEnemy()
enemycount = len(GetEnemies( Mobiles, maxRange=1))
if enemy != None:
    #Misc.ScriptStop("RecycleWeight.py")
    Player.Attack(enemy)
    PickSpecialAbility(enemycount)
    Discordance(enemy)
    Target.Cancel()
    AttackBuffs()
else:
    Misc.SendMessage("No enemies in range.", 69)
    if not Misc.ScriptStatus("RecycleWeight.py"):
        Misc.ScriptRun("RecycleWeight.py")

RepairCheck()
if not Misc.ScriptStatus("WeaponLevelGump.py"):
    Misc.ScriptRun("WeaponLevelGump.py")
