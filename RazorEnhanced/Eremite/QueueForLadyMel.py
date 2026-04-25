def WaitForMelStone():
    Misc.SendMessage("Waiting for Lady Mel stone", 77)
    while not Items.FindBySerial(0x408832D7): # mel stone
        Misc.Pause(1000)

def main():
    WaitForMelStone()
    for i in range(0,10):
        Misc.PlaySound(0x335, Player.Position.X,Player.Position.Y, Player.Position.Z)
        Misc.Pause(1000)

if __name__ == "__main__":
    main()