from datetime import datetime

def do_buff(name, timeout, casttime):
    buffs = Misc.ReadSharedValue("buff_timers") or {}
    now = int(datetime.now().timestamp())
    applied = buffs.get(f"buff_{name}", 0)
    if now - applied >= timeout:
        Player.ChatSay(0, f"[cs {name}")
        buffs[f"buff_{name}"] = now
        Misc.SetSharedValue("buff_timers", buffs)
        Misc.Pause(casttime * 1000)

consecrate_karma = {
    "Glorious": 9,
    "Illustrious": 8
}
        
def AttackBuffs():      
    consecrate_delay = consecrate_karma.get(Player.KarmaTitle, 7)
    do_buff("consecrateweapon", consecrate_delay, 1)
    do_buff("counterattack", 3, 1)
    if Player.Stam < 290:
        do_buff("divinefury", 0, 2)

def PreBuffs():
    do_buff("bless", 120, 1)
    Target.WaitForTarget(1500)
    Target.Self()
    do_buff("strength", 120, 1)
    Target.WaitForTarget(1500)
    Target.Self()
