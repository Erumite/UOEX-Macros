from Eremite.utils.enemies import WarEnemiesInRange, FindNearestEnemy, PickSpecialAbility
from Eremite.utils.buffs import AttackBuffs
from Eremite.utils.barding import Discordance
from Eremite.utils.items import RepairCheck

enemy = FindNearestEnemy()
enemycount = WarEnemiesInRange()
if enemy != None:
    Player.Attack(enemy)
    PickSpecialAbility(enemycount, singletarget=True)
    Discordance(enemy)
    AttackBuffs()
else:
    Misc.SendMessage("No enemies in range.", 69)
    
    
RepairCheck()