bank_stone = Items.FindBySerial(0x404DC5BE)
scroll_pouch_serial = 0x42926A5A
keep_scrolls = [
    0x1F4C, # Recall
    0x1F60, # Gate Travel
]

def GetNearbyExexBox():
    exexbox = Items.FindByID(0x0E7D,0x082a, -1,2)
    if exexbox and exexbox.Name == "Exex Deposit box":
       return exexbox
    return False

def exexDump():
    exex = GetNearbyExexBox()
    if not exex:
        return
    Items.Message(exex,0x082a,"Nom.")
    # Dump Gold
    for gold in Items.FindAllByID(0x0EED, 0, Player.Backpack.Serial,1):
        Items.Move(gold,exex,-1)
        Misc.Pause(600)
    # Ointments
    ointments = Items.FindAllByID(0x0E24, 0, Player.Backpack.Serial,1)
    _ = [Items.WaitForProps(o, 600) for o in ointments]
    for oint in ointments:
        if "Ointment" in oint.Name:
            Items.Move(oint, exex, -1)
            Misc.Pause(600)
    # Essences
    essences = Items.FindAllByID(0x0E24, 0x0679, Player.Backpack.Serial, 1)
    _ = [Items.WaitForProps(e, 600) for e in essences]
    for ess in essences:
        if "Essence of " in ess.Name:
            Items.Move(ess, exex, -1)
            Misc.Pause(600)
    Items.Message(exex,0x082a,"*burp*")
    # Elven Notes
    notes = Items.FindAllByID(0x0E39,0x0a43, Player.Backpack.Serial, 1)
    _ = [Items.WaitForProps(n, 600) for n in notes]
    for note in notes:
        if "elven note" in note.Name.lower():
            Items.Move(note, exex, -1)
            Misc.Pause(600)
    # Do Bank Stuff
    scroll_pouch = Items.FindBySerial(scroll_pouch_serial)
    Items.UseItem(bank_stone)
    Misc.Pause(600)
    if scroll_pouch:
        for scroll in Items.FindAllByID(keep_scrolls, 0, Player.Backpack.Serial, 1):
            Items.Move(scroll, scroll_pouch, -1)
            Misc.Pause(600)

exexDump()