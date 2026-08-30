import time

def do_buff(API, name, timeout, casttime):
    '''
    Applies a buff if its timer has expired.
    name: spell/buff identifier
    timeout: duration in seconds before re-applying
    casttime: pause time in seconds after casting
    '''
    buffs = API.GetSharedVar("buff_timers") or {}
    now = int(time.time())
    applied = buffs.get(f"{name}", 0)
    
    if now - applied >= timeout:
        spell_map = {
            "consecrateweapon": "Consecrate Weapon",
            "counterattack": "Counter Attack",
            "divinefury": "Divine Fury",
            "bless": "Bless",
            "strength": "Strength"
        }
        spell_name = spell_map.get(name.lower().strip(), name)
        API.CastSpell(spell_name)
        buffs[f"{name}"] = now
        API.SetSharedVar("buff_timers", buffs)
        API.Pause(casttime)
        return True
    return False

def AttackBuffs(API: API, limit=999):
    count=0
    if count < limit:
        count += 1 if do_buff(API, "consecrateweapon", 7, 1) else 0
    if count < limit:
        count += 1 if do_buff(API, "counterattack", 3, 1) else 0
    if count < limit and getattr(API.Player, "Stamina", 999) < 290:
        count += 1 if do_buff(API, "divinefury", 0, 1) else 0

def PreBuffs(API):
    do_buff(API, "bless", 120, 1)
    if API.WaitForTarget(timeout=1.5):
        API.TargetSelf()
    do_buff(API, "strength", 120, 1)
    if API.WaitForTarget(timeout=1.5):
        API.TargetSelf()