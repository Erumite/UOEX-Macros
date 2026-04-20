ethy = Items.FindBySerial(0x41A37C36)
if Player.Mount:
    Mobiles.UseMobile(Player.Serial)
else:
    Items.UseItem(ethy)