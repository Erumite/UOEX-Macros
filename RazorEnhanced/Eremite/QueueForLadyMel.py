from System import Int32
from System.Collections.Generic import List
import re

mel_stone = 0x408832D7 # The green stone that is there when queue is ready.
mel_guide = Items.FindBySerial(0x449E44EE) # The stone next to the entry stone.
max_wait = 22 # minutes till respawn

def findTimeBag():
    filter = Items.Filter()
    #filter.OnGround = True
    filter.Graphics = List[Int32]([0x0E76])
    filter.RangeMin = 0
    filter.RangeMin = 10
    #filter.IsCorpse = False
    filter.IsContainer = True
    filter.Hues = List[Int32]([0x0])
    bag = Items.ApplyFilter(filter)
    bag = [b for b in bag if "time remaining" in b.Name.lower()]
    if bag:
        return bag[0]#

def timeRemaining(bag):
    pattern = re.compile(r"^(\d+) items,")
    for prop in bag.Properties:
        match = pattern.match(str(prop))
        if match:
            return match.group(1)
            
def MelGump(time):
    base_width = 108
    gd = Gumps.CreateGump(True,True,False,False)
    if not time:
        Gumps.CloseGump(gd.gumpId)
        return None
    Gumps.AddBackground(gd, 0, 0, base_width, 30, 153)
    Gumps.AddSpriteImage(gd,4,4,0x805,0,0,base_width,12)
    pct = (1 - (int(time) / max_wait)) * base_width
    pct = Int32(pct)
    Gumps.AddSpriteImage(gd,4,4,0x808,0,0,pct,12)
    Gumps.AddLabel(gd,4,15,88,f"{time} min left")
    Gumps.SendGump(123458, Player.Serial, 420, 100, gd.gumpDefinition, gd.gumpStrings)

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
        if timebag:
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
    