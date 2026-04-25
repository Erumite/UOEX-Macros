ethy = Items.FindBySerial(0x4D52855F)
if Player.Mount:
    while Player.Mount:
        Mobiles.UseMobile(Player.Serial)
        Misc.Pause(50)
else:
    while not Player.Mount:
        Items.UseItem(ethy)
        Misc.Pause(50)