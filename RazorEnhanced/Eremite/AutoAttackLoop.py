from Eremite.utils.enemies import GetEnemies, FindNearestEnemy, PickSpecialAbility
from Eremite.utils.buffs import AttackBuffs
from Eremite.utils.barding import Discordance
from Eremite.utils.items import RepairCheck


def doAttack():
    enemy = FindNearestEnemy()
    if enemy != None:
        Player.Attack(enemy)
        enemycount = len(GetEnemies( Mobiles, maxRange=1))
        PickSpecialAbility(enemycount)
        if not Misc.ScriptStatus('RecycleWeight.py'):
            Discordance(enemy) # Avoid target collision
            Target.Cancel()
        AttackBuffs()
    RepairCheck()
    
while True:
    doAttack()
    delay = 1250
    Misc.Pause(delay)
    
    if Player.Weight > Player.MaxWeight * .75 and not Misc.ScriptStatus("RecycleWeight.py"):
        Misc.ScriptRun("RecycleWeight.py")
    elif not Misc.ScriptStatus("RecycleWeight.py"):
        Misc.ScriptRun("CutClaimAll.py")