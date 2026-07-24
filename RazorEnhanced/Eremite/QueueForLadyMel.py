from System import Int32
from System.Collections.Generic import List
import re

mel_stone = 0x408832D7 # The green stone that is there when queue is ready.
mel_guide = Items.FindBySerial(0x449E44EE) # The stone next to the entry stone.
max_wait = 22 # minutes till respawn

def findTimeBag():
    filter = Items.Filter()
    filter.OnGround = True
    filter.Graphics = List[Int32]([0x0E76])
    filter.IsCorpse = False
    filter.IsContainer = True
    filter.Hues = List[Int32]([0x0])
    bag = Items.ApplyFilter(filter)
    _ = [Items.WaitForProps(b, 1000) for b in bag]
    bag = [b for b in bag if "time remaining" in b.Name.lower()]
    if bag:
        return bag[0]
    else:
        Misc.SendMessage("No Time Bag Found?", 33)

def timeRemaining(bag):
    if not bag or not Items.FindBySerial(bag.Serial):
        return 0
    pattern = re.compile(r"^(\d+) items,")
    for prop in bag.Properties:
        match = pattern.match(str(prop))
        if match:
            return match.group(1)
    return 0
            
def MelGump(time):
    base_width = 108
    id=123458
    gd = Gumps.CreateGump(True,True,False,False)
    if not time:
        Gumps.CloseGump(id)
        return None
    Gumps.AddBackground(gd, 0, 0, base_width + 8, 30, 153)
    Gumps.AddSpriteImage(gd,4,4,0x805,0,0,base_width,12)
    pct = (1 - (int(time) / max_wait)) * base_width
    pct = Int32(pct)
    Gumps.AddSpriteImage(gd,4,4,0x808,0,0,pct,12)
    Gumps.AddLabel(gd,4,15,88,f"{time} min left")
    Gumps.SendGump(id, Player.Serial, 420, 100, gd.gumpDefinition, gd.gumpStrings)

def WaitForMelStone():
    Misc.SendMessage("Waiting for Lady Mel stone", 77)
    timebag = findTimeBag()
    while True:
        if Items.FindBySerial(mel_stone):
            return True
        # Bail if we get farther away.
        elif Player.DistanceTo(mel_guide) > 15:
            Player.HeadMessage(45, 'Running away?')
            return False
        MelGump(timeRemaining(timebag))
        Misc.Pause(1000)

def main():
    if not WaitForMelStone():
        return False
    for i in range(0,5): # Loop a whistle sound to get player attention.
        Misc.PlaySound(0x335, Player.Position.X,Player.Position.Y, Player.Position.Z)
        Misc.Pause(1000)

if __name__ == "__main__":
    main()
    