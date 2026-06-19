from Eremite.utils.enemies import GetEnemies, FindNearestEnemy, PickSpecialAbility
from Eremite.utils.buffs import AttackBuffs
from Eremite.utils.barding import Discordance
from Eremite.utils.items import RepairCheck
from datetime import datetime


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
    
def ManageWeight():
    if Player.Weight > Player.MaxWeight * .75 and not Misc.ScriptStatus("RecycleWeight.py"):
        if Misc.ScriptStatus("CraftPicksToSell.py"):
            Misc.ScriptStop("CraftPicksToSell.py")
            Misc.Pause(1000)
            if Gumps.HasGump(0x38920abd):
                Gumps.SendAction(0x38920abd, 0)
        Misc.ScriptRun("RecycleWeight.py")
    elif not Misc.ScriptStatus("RecycleWeight.py") and not Misc.ScriptStatus("CutClaimAll.py") and not Misc.ScriptStatus("LootBox.py"):
        Misc.ScriptRun("CutClaimAll.py")
        
Player.HeadMessage(33, "o-|==>")
delay = 1.25 # seconds
while True:
    last = datetime.now().timestamp()
    RepairCheck()
    doAttack()
    ManageWeight()
    while datetime.now().timestamp() - last < delay:
        Misc.Pause(100)