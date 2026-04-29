mel_stone = 0x408832D7 # The green stone that is there when queue is ready.
mel_guide = Items.FindBySerial(0x449E44EE) # The stone next to the entry stone.

def WaitForMelStone():
    Misc.SendMessage("Waiting for Lady Mel stone", 77)
    while True:
        if Items.FindBySerial(mel_stone):
            return True
        # Bail if we get farther away.
        elif Player.DistanceTo(mel_guide) > 15:
            Player.HeadMessage(45, 'Running away?')
            return False

def main():
    if not WaitForMelStone():
        return False
    for i in range(0,10): # Loop a whistle sound to get player attention.
        Misc.PlaySound(0x335, Player.Position.X,Player.Position.Y, Player.Position.Z)
        Misc.Pause(1000)

if __name__ == "__main__":
    main()