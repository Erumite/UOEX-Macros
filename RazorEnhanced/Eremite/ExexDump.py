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
        
    # Ointments
    for oint in Items.FindAllByID(0x0E24, 0, Player.Backpack.Serial,1):
        if "Ointment" in oint.Name:
            Items.Move(oint, exex, -1)
            
    # Essences
    for ess in Items.FindAllByID(0x0E24, 0x0679, Player.Backpack.Serial, 1):
        if "Essence of " in ess.Name:
            Items.Move(ess, exex, -1)
        
    Items.Message(exex,0x082a,"*burp*")

exexDump()