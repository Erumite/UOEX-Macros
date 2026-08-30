from Eremite.utils.enemies import GetEnemies

enemies, _, _ = GetEnemies(API, maxRange=12)

for enemy in enemies:
    API.Attack(enemy)
    API.ItemNameAndProps(enemy)
    API.Pause(0.01)