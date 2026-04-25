def getQuestItems():
    toadstools = Items.FindAllByID(0x1125, 0x0877, Player.Backpack.Serial, 1)
    foulfungi = Items.FindAllByID(0x26B7, 0x0801, Player.Backpack.Serial, 1)
    stifftwigs = Items.FindAllByID(0x1B9C, 0x08ad, Player.Backpack.Serial, 1)
    petritwigs = Items.FindAllByID(0x1B9D, 0x0482, Player.Backpack.Serial, 1)
    fossiltwigs = Items.FindAllByID(0x1B9C, 0x0850, Player.Backpack.Serial, 1)
    Misc.SendMessage(f"{len(toadstools)} : Deadly Toadstools : Ground", 77)
    Misc.SendMessage(f"{len(foulfungi)} : Foul Fungi      : Moss Maiden", 77)
    Misc.SendMessage(f"{len(stifftwigs)} : Stiffened Twigs  : TreeFellow ", 77)
    Misc.SendMessage(f"{len(petritwigs)} : Petrified Twigs  : Reaper", 77)
    Misc.SendMessage(f"{len(fossiltwigs)} : Fossilized Twigs  : Changeling", 77)
    has_all_five = all([len(x) > 0 for x in [toadstools, foulfungi, stifftwigs, petritwigs, fossiltwigs]])
    return toadstools, foulfungi, stifftwigs, petritwigs, fossiltwigs, has_all_five

def ClearStaleGumps():
    while Gumps.HasGump(0xfd84f341):
        Gumps.SendAction(0xfd84f341, 3)
        Misc.Pause(200)
    
def FillLadyMelBook():
    melbook = Items.FindByID(0x0E3B,0x01f4,Player.Backpack.Serial,0)
    toadstools, foulfungi, stifftwigs, petritwigs, fossiltwigs, has_all_five = getQuestItems()
    
    mel_start_stone = Items.FindBySerial(0x40866623)
    if not mel_start_stone or Player.DistanceTo(mel_start_stone) > 10:
        Player.HeadMessage(44, "Too Far")
        Misc.SendMessage("More than 10 tiles from start stone - move to the quest area.")
        return False
    
    if not has_all_five:
        Player.HeadMessage(44, "Missing Items")
        return False    
        
    if not melbook:
        PathFinding.PathFindTo(6455, 834, 0)
        while True:
            Player.ChatSay(77,"fight lady mel")
            Misc.Pause(5000)
            melbook = Items.FindByID(0x0E3B,0x01f4,Player.Backpack.Serial,0)
            if melbook:
                break
    
    if not Gumps.HasGump(0xc563d169):
        Items.UseItem(melbook)
        Gumps.WaitForGump(0xc563d169, 1000)
    Target.Cancel()

    Gumps.SendAction(0xc563d169, 700)
    Target.WaitForTarget(1000, False)
    Target.TargetExecute(foulfungi[0])
    Target.WaitForTarget(1000, False)

    if not Target.HasTarget():
        Gumps.SendAction(0xc563d169, 700)
        Target.WaitForTarget(1000, False)
    Target.TargetExecute(stifftwigs[0])
    Target.WaitForTarget(1000)

    if not Target.HasTarget():
        Gumps.SendAction(0xc563d169, 700)
        Target.WaitForTarget(1000, False)
    Target.TargetExecute(petritwigs[0])
    Target.WaitForTarget(1000)

    if not Target.HasTarget():
        Gumps.SendAction(0xc563d169, 700)
        Target.WaitForTarget(1000, False)
    Target.TargetExecute(toadstools[0])
    Target.WaitForTarget(1000)

    if not Target.HasTarget():
        Gumps.SendAction(0xc563d169, 700)
        Target.WaitForTarget(1000, False)
    Target.TargetExecute(fossiltwigs[0])
    Target.WaitForTarget(1000)

    Gumps.CloseGump(0xc563d169)
    Target.Cancel()
    
    
    PathFinding.PathFindTo(6450, 840, 0)
    Misc.Pause(600)
    
    while Items.FindByID(0x0E3B,0x01f4,Player.Backpack.Serial,0):
        Player.ChatSay(77,"ready")
        Misc.Pause(5000)
    
def main():
    FillLadyMelBook()
    ClearStaleGumps()
        
if __name__ == "__main__":
    main()
