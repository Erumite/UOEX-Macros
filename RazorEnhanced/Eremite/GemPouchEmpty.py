from Eremite.utils.items import GetGemPouch

gempouch = GetGemPouch()
warnweight = Misc.ReadSharedValue('WarnWeight')
gems = Misc.ReadSharedValue('gems')
sellbag = Misc.ReadSharedValue("ScrollBoH")

gemgump = 0x1277dd7b
outmsg = "You do not have any of these gems!"

def GemSlotEmpty():
    if Journal.Search(outmsg):
        Journal.Clear(outmsg)
        return True
    return False
    

def EmptyGemPouch():
    Journal.Clear(outmsg)
    Items.UseItem(gempouch)
    Gumps.WaitForGump(gemgump, 1000)
    for i in range(1, 9):
        while not GemSlotEmpty() and Player.Weight < warnweight:
            Gumps.SendAction(gemgump, i)
            Gumps.WaitForGump(gemgump, 1000)
    Gumps.CloseGump(gemgump)
    Misc.Pause(600)
    for gem in Items.FindAllByID(gems , -1, Player.Backpack.Serial, 0):
        Items.Move(gem, sellbag, -1)
    Player.HeadMessage(69, "Go Sell!")
    
if gempouch:
    EmptyGemPouch()
    