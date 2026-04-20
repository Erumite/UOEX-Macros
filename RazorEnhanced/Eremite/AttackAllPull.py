from Eremite.utils.enemies import GetEnemies

def PullAllMobs():
    enemies = GetEnemies( Mobiles, maxRange = 15)
    if len(enemies) == 0:
        return
    for enemy in enemies:
        Player.Attack(enemy)
        Misc.Pause(30)
    return
    
PullAllMobs()