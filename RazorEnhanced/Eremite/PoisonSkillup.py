
def CraftPoison():
    Items.UseItemByID(0x0E9B,0) # Use Mortar/Pestle
    Gumps.WaitForGump(0xdb74b85f, 1000) # Alchemy Gump
    Gumps.SendAction(0xdb74b85f, 60004) # Potions
    Gumps.WaitForGump(0xdb74b85f, 1000) 
    Gumps.SendAction(0xdb74b85f, 60008) # Poison
    Gumps.WaitForGump(0xdb74b85f, 1000)
    Gumps.SendAction(0xdb74b85f, 60023) # Deadly Poison

    
def PoisonDagger():
    dagger = 1159039550
    Target.Cancel()
    while not Target.HasTarget():
        Player.UseSkill("Poisoning")
        Misc.Pause(200)
    Target.WaitForTarget(10000, False)
    Target.TargetType(0x0F0A, 0, 0) # Poison Potion
    Target.TargetExecute(1085294056)
    Target.WaitForTarget(10000, False)
    Target.TargetExecute(dagger)
    Misc.Pause(600)
    
    
while True:
    if Items.FindByID(0x0F0A, 0, Player.Backpack.Serial, 0):
        PoisonDagger()
    else:
        CraftPoison()
        Misc.Pause(5000)