import re 

MAX_XP = 999900
REFRESH_MS = 1000

def get_level_text(weapon):
    pattern = re.compile(r'.*(?<=Level: )(\d+).*(?<=Experience: )(\d+).*')
    for prop in weapon.Properties:
        if "Level" in prop.Args:
            match = pattern.match(str(prop.Args))
            if match: # tuple(Level: int, XP: int)
                return int(match.group(1)), int(match.group(2))
    return 0,0
    
def current_level_progress(level, experience):
    progress = (experience - (100 * level * level - 100)) / (200 * level + 100)
    return progress

def SendGump(last_xp, gained): # int, bool -> int, bool
    weapon = Player.GetItemOnLayer("RightHand") or Player.GetItemOnLayer("LeftHand")
    if not weapon:
        return last_xp, False

    if not weapon.PropsUpdated:
        Items.GetProperties(weapon.Serial, 100)

    level, experience = get_level_text(weapon) if weapon else (0,0)

    if experience == last_xp and not gained:
            return last_xp, False


    gained_xp = experience - last_xp
    gained = gained_xp > 0
    last_xp = experience
    
    base_width = 108
    overall = int(experience / MAX_XP * base_width)
    current = int(current_level_progress(level, experience) * base_width)

    gd = Gumps.CreateGump(True,True,False,False)
    Gumps.AddBackground(gd, 0, 0, 118, 45, 153)
    Gumps.AddSpriteImage(gd,4,4,0x805,0,0,base_width,12)
    Gumps.AddSpriteImage(gd,4,4,0x809,0,0,overall,12)
    if experience < MAX_XP:
        Gumps.AddSpriteImage(gd,4,16,0x805,0,0,base_width,12)
        Gumps.AddSpriteImage(gd,4,16,0x808,0,0,current,12)
    else:
        Gumps.AddLabel(gd,43,16,55,f"MAX")
    Gumps.AddLabel(gd,4,28,55,f"Lv: {level} | {experience}")
    label = f"+{gained_xp}" if gained else ""
    Gumps.AddLabel(gd,15,-12, 55, label)
    Gumps.SendGump(123456, Player.Serial, 120, 100, gd.gumpDefinition, gd.gumpStrings)
    return last_xp, gained

last_xp = 0
gained = False
while True:
    last_xp, gained = SendGump(last_xp, gained)
    Misc.Pause(REFRESH_MS)
