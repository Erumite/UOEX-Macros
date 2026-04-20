from Eremite.utils.items import GetRecycleBag

left_hand = Player.GetItemOnLayer("LeftHand")
Player.UnEquipItemByLayer("LeftHand", 600)



backpack = Player.Backpack.Serial
recyclebag = GetRecycleBag()
recyclebag = recyclebag.Serial

poison_pots = Items.FindAllByID(0x0F0A,0,backpack,0)
poison_pots += Items.FindAllByID(0x0F0A,0,recyclebag,0)

agility_pots = Items.FindAllByID(0x0F08,0,backpack,0)
agility_pots += Items.FindAllByID(0x0F08,0,recyclebag,0)

strength_pots = Items.FindAllByID(0x0F09,0,backpack,0) 
strength_pots += Items.FindAllByID(0x0F09,0,recyclebag,0)

heal_pots = Items.FindAllByID(0x0F0C,0,backpack,0) 
heal_pots += Items.FindAllByID(0x0F0C,0,recyclebag,0)

stam_pots = Items.FindAllByID(0x0F0B,0,backpack,0) 
stam_pots += Items.FindAllByID(0x0F0B,0,recyclebag,0) 

cure_pots = Items.FindAllByID(0x0F07,0,backpack,0)
cure_pots += Items.FindAllByID(0x0F07,0,recyclebag,0)

for pot in poison_pots:
    s = pot.Serial
    while Items.FindBySerial(s):
        Items.UseItem(pot)
        Misc.Pause(100)
        
if Player.Poisoned and len(cure_pots) > 0:
    for pot in cure_pots:
        s = pot.Serial
        while Items.FindBySerial(s):
            Items.UseItem(pot)
            Misc.Pause(100)
            if Journal.Search("would surely kill you"):
                break
if Player.Poisoned:
    Player.ChatSay(0, '[cs Cure')
    Target.WaitForTarget(1500)
    Target.Self()
    
for pot in Items.FindAllByID(0x0F07,0,backpack,0):
    Items.Move(pot, recyclebag, -1)
    Misc.Pause(600)


for pot in agility_pots:
    s = pot.Serial
    while Items.FindBySerial(s):
        Items.UseItem(pot)
        Misc.Pause(100)
        
for pot in stam_pots:
    if Player.Stam >= Player.StamMax:
        break
    s = pot.Serial
    while Items.FindBySerial(s):
        Items.UseItem(pot)
        Misc.Pause(100)
        
for pot in strength_pots:
    s = pot.Serial
    while Items.FindBySerial(s):
        Items.UseItem(pot)
        Misc.Pause(100)
        
for pot in heal_pots:
    if Player.Hits >= Player.HitsMax:
        break
    s = pot.Serial
    while Items.FindBySerial(s):
        Items.UseItem(pot)
        Misc.Pause(100)
        
for heal_pot in Items.FindAllByID(0x0F0C,0,backpack,0):
    Items.Move(pot, recyclebag, -1)
    Misc.Pause(600)
    
for stam_pot in Items.FindAllByID(0x0F0B,0,backpack,0):
    Items.Move(pot, recyclebag, -1)
    Misc.Pause(600)
        
Misc.Pause(600)

if left_hand:
    Player.EquipItem(left_hand)