craft_bag = Misc.ReadSharedValue("ScrollBoH")


def prepCrafting():
    Items.UseItemByID(0x1EB8,0) # Tinkering Kit
    Gumps.WaitForGump(0x38920abd, 10000)
    Gumps.SendAction(0x38920abd, 8) # Tools
    Gumps.WaitForGump(0x38920abd, 10000)
    Gumps.SendAction(0x38920abd, 121) # Lockpick
    Gumps.WaitForGump(0x38920abd, 10000)

while True:
    if not Gumps.HasGump(0x38920abd):
        prepCrafting()
    Gumps.SendAction(0x38920abd, 21)
    Gumps.WaitForGump(0x38920abd, 5000)
    picks = Items.FindByID(0x14FC,0,Player.Backpack.Serial, 0)
    if picks:
        Items.WaitForProps(picks, 500)
        if picks.Amount > 50:
            Items.Move(picks, craft_bag, -1)
