import time
import sys

# Mobs that are dangerous to attack, but not necessarily hostile.
danger_noodles = [
    (0x0114, "a rend"),
    (0x0114, "a dark blood"),
]

# Don't attack these ever.
ignore_list = [
    (0x000D, "energy vortex"),
    (0x023E, "blade spirit"),
    (0x007B, ""),
]

# Notorieties that are considered enemies.
def EnemyNotorieties(API: API):
    return [
        API.Notoriety.Gray,
        API.Notoriety.Criminal,
        API.Notoriety.Enemy,
        API.Notoriety.Murderer
    ]

def should_ignore_mobile_data(graphic: int, name: str, in_war: bool) -> bool:
    """Helper to check ignore rules against pure Python values."""
    for id_val, name_val in ignore_list:
        if graphic == id_val and (not name_val or name_val in name):
            return True
    if not in_war:
        for id_val, name_val in danger_noodles:
            if graphic == id_val and (not name_val or name_val in name):
                return True
    return False

def ignore_mobile(API: API, mob): # -> bool
    """Handle more complex ignore logic for mobs, such as ignoring un-aggro'd danger_noodles."""
    if not mob:
        return True
    mob_name = (getattr(mob, 'Name', '') or "").lower()
    mob_graphic = getattr(mob, 'Graphic', None)
    in_war = bool(getattr(mob, 'InWarMode', False))
    return should_ignore_mobile_data(mob_graphic, mob_name, in_war)

def GetEnemies(API: API, minRange=0, maxRange=12, notorieties=None):
    '''
    Returns a list of nearby enemies matching specified notorieties in TazUO.
    Ignore Party Members and anything in ignore_list or un-aggro'd danger_noodles.
    Ordered by distance from player.
    '''
    notorieties = notorieties or EnemyNotorieties(API)
    mobs = API.NearestMobiles(notorieties, maxRange) or []
    if not mobs:
        return [], 0, 0

    party_serials: set[int] = set(API.GetPartyMemberSerials() or [])

    cached_enemies = []
    melee_range = 0
    bow_range = 0

    # Single-pass snapshot: extract attributes from API objects at once to minimize IPC / main thread wrapper property lookups.
    for m in mobs:
        if not m:
            continue

        dist = getattr(m, 'Distance', 0)
        if not (minRange <= dist <= maxRange):
            continue

        serial = getattr(m, 'Serial', None)
        if serial in party_serials:
            continue

        if getattr(m, 'IsDead', False):
            continue

        if not m.HasLineOfSightFrom(API.Player):
            continue

        in_war = getattr(m, 'InWarMode', False)
        graphic = getattr(m, 'Graphic', None)
        name = (getattr(m, 'Name', '') or "").lower()

        if should_ignore_mobile_data(graphic, name, in_war):
            continue

        cached_enemies.append((dist, m))

        if dist <= 1:
            melee_range += 1
        if dist <= 10 and in_war:
            bow_range += 1

    if not cached_enemies:
        return [], 0, 0

    # Sort pure Python tuples by distance
    cached_enemies.sort(key=lambda t: t[0])
    enemies = [t[1] for t in cached_enemies]

    return enemies, melee_range, bow_range

def FindNearestEnemy(API: API): # -> tuple(list, int int)
    '''
    Finds and returns the nearest enemy, using TazUO's native API.NearestMobile.
    '''
    enemies, melee_range, bow_range = GetEnemies(API, 0, 12)
    return enemies[0] if enemies else [], melee_range, bow_range

def FireHorn(API: API, enemy):
    '''
    Uses Fire Horn on enemy if within 3 tiles and cooldown has elapsed.
    '''
    if not enemy:
        return

    dist = getattr(enemy, 'Distance', max(abs(enemy.X - API.Player.X), abs(enemy.Y - API.Player.Y)))
    if dist > 3:
        return

    firehorn_delay = 6
    last_fh_use = API.GetSharedVar("firehorn") or 0
    diff = time.time() - last_fh_use
    if diff < firehorn_delay:
        return

    firehorns = API.FindTypeAll(0x0FC7, container=API.Player.Backpack.Serial, hue=0x0466)
    if firehorns:
        API.UseObject(firehorns[0].Serial)
        if API.WaitForTarget(timeout=1.5):
            API.Target(enemy.Serial)
            API.SetSharedVar("firehorn", time.time())

def PickSpecialAbility(API: API, melee_range: int = 1, bow_range: int = 1, singletarget=False,):
    '''
    Selects and toggles appropriate primary/secondary weapon ability or casts Bushido/Ninjitsu spell based on equipped weapon.
    '''
    weapon = API.FindLayer("OneHanded") or API.FindLayer("TwoHanded")
    if not weapon or API.Player.Mana < 40:
        return  # Conserve MP for Buffs

    weapon_id = getattr(weapon, 'Graphic', None)

    if weapon_id == 0x27A2:  # No-Dachi
        if not singletarget and melee_range > 1:
            API.CastSpell("Momentum Strike")
        else:
            if not API.PrimaryAbilityActive():
                API.ToggleAbility("Primary")  # Crushing Blow
    elif weapon_id == 0x0F4B:  # Double Axe
        if not singletarget and melee_range > 1:
            if not API.SecondaryAbilityActive():
                API.ToggleAbility("Secondary")  # WhirlWind
        else:
            if not API.PrimaryAbilityActive():
                API.ToggleAbility("Primary")  # Double Strike
    elif weapon_id in [0x143E, 0x13FB]:  # Halberd | Large Battle Axe
        if not singletarget and melee_range > 1:
            if not API.PrimaryAbilityActive():
                API.ToggleAbility("Primary")  # WhirlWind
        else:
            API.CastSpell("Focus Attack")
    elif weapon_id == 0x27A5:  # Yumi
        if not singletarget and bow_range > 1:
            API.CastSpell("Momentum Strike")
        else:
            if not API.PrimaryAbilityActive():
                API.ToggleAbility("Primary")  # Armor Pierce
    elif weapon_id == 0x27A9:  # Swords of Prosperity
        if not singletarget and melee_range > 1:
            API.CastSpell("Momentum Strike")
        else:
            if not API.SecondaryAbilityActive():
                API.ToggleAbility("Secondary")  # Double Strike
    else:  # Fallback if not specifically configured.
        if not singletarget and melee_range > 1:
            API.CastSpell("Momentum Strike")
        else:
            API.CastSpell("Focus Attack")