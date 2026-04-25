from Eremite.utils.items import GetRecycleBag

LEATHER=0x1081
GOLD=0x0EED
WOOL=0x0DF8
RIBS=0x09F1
LOGS=0x1BDD
RESOURCES = [
    0x0E21 # Bandage
]

toolBag = Misc.ReadSharedValue("ToolBag")
recycleBag = GetRecycleBag()
bagofholding = Misc.ReadSharedValue("BagOfHolding")
scrollbag = Misc.ReadSharedValue("ScrollBoH")
spell_scrolls = Misc.ReadSharedValue("spell_scrolls")


def QuickSort(leather = True, gold = True, wool=True, meat=True, scrolls=True, logs=True, resources=True):
    """Quick Sorting for when chopping."""
    if gold:
        found = Items.FindAllByID(GOLD, 0, Player.Backpack.Serial, 0)
        for f in found:
            Items.Move(f,bagofholding,-1)
            Misc.Pause(600)
    if leather:
        found = Items.FindAllByID(LEATHER, -1, Player.Backpack.Serial, 0)
        for f in found:
            Items.Move(f,bagofholding,-1)
            Misc.Pause(600)
    if wool:
        found = Items.FindAllByID(WOOL, -1, Player.Backpack.Serial, 0)
        for f in found:
            Items.Move(f,bagofholding,-1)
            Misc.Pause(600)
    if meat:
        for f in Items.FindAllByID(RIBS, 0, Player.Backpack.Serial, 0):
            Items.Move(f,scrollbag,-1)
            Misc.Pause(600)
        for f in Items.FindAllByID(RIBS, 0x0363, Player.Backpack.Serial, 0):
            Items.Move(f,recycleBag,-1) # Alligator meat
            Misc.Pause(600)
        for f in Items.FindAllByID(RIBS, 0x0355, Player.Backpack.Serial, 0):
            Items.Move(f,recycleBag,-1) # Snake meat
            Misc.Pause(600)
    if scrolls:
        for s in Items.FindAllByID(spell_scrolls, 0, Player.Backpack.Serial,0):
            try:
                Items.Move(s, scrollbag, -1)
            except Exception as e:
                Misc.SendMessage(f"Move failed: {e}", 33)
            Misc.Pause(600)
    if logs:
        for item in Items.FindAllByID(LOGS, 0, Player.Backpack.Serial,0):
            Items.Move(item,bagofholding,-1)
            Misc.Pause(600)
    if resources:
        for item in Items.FindAllByID(RESOURCES, -1, Player.Backpack.Serial, 0):
            Items.Move(item,bagofholding,-1)
            Misc.Pause(600)

trash_items = [
    0x1F0B, # orc helm
    0x09B9, # raw bird
    0x1609, # raw leg of lamb
    0x1B7A, # wooden shield
    0x0EB1, # Standing Harp
    0x1F1C, # Power Crystal
    0x0E73, # Bola Balls
    0x154B, # Tribal Mask
    0x09D0, # Tribal Berry
    0x141B, # Orc Mask
    0x09C8, # Jug of Cider
    0x09C7, # Bottle of Wine
    0x0A28, # Candle
    0x0DCF, # Seeds
    0x1EA8, # Clockwork Assembly
    0x1053, # Gears
    0x2645, # dragon helm
    0x0F0A, # Poison Potion
    0x0F0B, # Refresh Potion
    0x0F07, # Cure Potion
    0x0F08, # Agility Potion
    0x0F09, # Strength Potion
    0x0F0D, # Explosion Potion
    0x0F0C, # Heal Potion
    0x0DF5, # Wand (hex)
    0x0DF3, # Wand CattleProd
    0x0DF4, # Wand Star
    0x0DF2, # Wand Fleur
    0x1DA0, # Head
    0x1DA1, # Left Arm
    0x1DA2, # Right Arm
    0x1DA3, # Left Leg
    0x1DA4, # Right Leg
    0x1D9F, # Torso
    0x1CED, # Heart (A Bloody Offering)
    0x0CEB, # Vines
    0x0CEC, # Vines
    0x0CED, # Vines
    0x0CEE, # Vines
    0x0CEF, # Vines
    0x0CF0, # Vines
    0x0CF1, # Vines
    0x0CF2, # Vines
]
necro_scrolls = [
    0x2269, # poison strike
    0x2266, # lich form
    0x226A, # strangle
    0x226E, # wither
    0x2261, # blood oath
    0x2267, # mind rot
    0x2262, # corpse skin
    0x2265, # horrific beast
    0x226F, # wraith form
    0x2264, # evil omen
    0x2270, # exorcism
    0x226D, # vengeful spirit
    0x226C, # vampiric embrace
    0x2260, # animate dead
    0x226B, # summon familiar
    0x2263, # curse weapon
    0x2268, # pain spike
]
swamp_trash = [
    0x101F, # clump of swamp weed
    0x0DBC, # lilly pad
    0x0D3B, # branch
    0x0C2D, # rotten driftwood
    0x0DEA, # piece of wood
    0x1AE0, # mouldy skull
    0x1BE1, # mouldy logs
    0x1BDE, # mouldy logs
    0x0A19, # mouldy plate
    0x13A8, # mouldy pillow
    0x0A58, # mouldy sleeping bag
    0x1EB7, # empty tool kit
    0x136C, # spongey rock
    0x0F03, # mossy bottle
    0x0F60, # mossy longsword
    0x0B2B, # dead beetle
    0x1E85, # dead bird
    0x0DEB, # dead lizard
    0x2655, # old socks
    0x0EE9, # old bandages
    0x0EB3, # lute (Abandoned Hopes and Dreams)
    0x10EE, # garbage
    0x0C40, # fungus
]

hue_specific = { # item_id: hur,
    0x0DF9: 0x04e6,  # Purple Fungus
    0x0F83: 0x0000, # Executioner's Cap (Reagent) - exclude Scorp Stinger
    0x0FC7: 0x0466, # Fire horn - Exclude Horn of Defeat
}
            
def trashJunk(pack = Player.Backpack):
    # Druid Scrolls
    items = Items.FindAllByID([0x0E39],0x058b, pack.Serial,0)
    for item in items:
        Items.Move(item,recycleBag,-1)
        Misc.Pause(600)
    # Necromancy Scrolls
    items = Items.FindAllByID(necro_scrolls,-1, pack.Serial,0)
    for item in items:
        Items.Move(item,recycleBag,-1)
        Misc.Pause(600)
    # Misc Junk
    items = Items.FindAllByID(trash_items,-1, pack.Serial,0)
    for item in items:
        Items.Move(item,recycleBag,-1)
        Misc.Pause(600)
    Misc.Pause(600)
    # Swamp Trash
    items = Items.FindAllByID(swamp_trash, -1, pack.Serial, 0)
    for item in items:
        if 'pulled from a swamp' in str(item.Properties).lower():
            Items.Move(item,recycleBag,-1)
            Misc.Pause(600)
    # Hue-Specific Trash
    for item in Items.FindAllByID(list(hue_specific.keys()), -1, pack.Serial, 0):
        if item.Color == hue_specific[item.ItemID]:
            Items.Move(item,recycleBag,-1)
            Misc.Pause(600)
            
QuickSort()
trashJunk()