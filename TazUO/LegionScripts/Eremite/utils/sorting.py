from Eremite.utils.items import GetMyItem, MoveItemToContainer

LEATHER = 0x1081
GOLD = 0x0EED
WOOL = 0x0DF8
RIBS = 0x09F1
LOGS = 0x1BDD
ESSENCES = 0x0E24
RESOURCES = [
    0x0E21  # Bandage
]

trash_items = [
    0x1F0B,  # orc helm
    0x09B9,  # raw bird
    0x1609,  # raw leg of lamb
    0x1B7A,  # wooden shield
    0x0EB1,  # Standing Harp
    0x1F1C,  # Power Crystal
    0x0E73,  # Bola Balls // Mossy Cannonball
    0x154B,  # Tribal Mask
    0x09D0,  # Tribal Berry
    0x141B,  # Orc Mask
    0x09C8,  # Jug of Cider
    0x09C7,  # Bottle of Wine
    0x0A28,  # Candle
    0x0DCF,  # Seeds
    0x1EA8,  # Clockwork Assembly
    0x1053,  # Gears
    0x2645,  # dragon helm
    0x0F0A,  # Poison Potion
    0x0F0B,  # Refresh Potion
    0x0F07,  # Cure Potion
    0x0F08,  # Agility Potion
    0x0F09,  # Strength Potion
    0x0F0D,  # Explosion Potion
    0x0F0C,  # Heal Potion
    0x0DF5,  # Wand (hex)
    0x0DF3,  # Wand CattleProd
    0x0DF4,  # Wand Star
    0x0DF2,  # Wand Fleur
    0x1DA0,  # Head
    0x1DA1,  # Left Arm
    0x1DA2,  # Right Arm
    0x1DA3,  # Left Leg
    0x1DA4,  # Right Leg
    0x1D9F,  # Torso
    0x1CED,  # Heart (A Bloody Offering)
    0x0CEB,  # Vines
    0x0CEC,  # Vines
    0x0CED,  # Vines
    0x0CEE,  # Vines
    0x0CEF,  # Vines
    0x0CF0,  # Vines
    0x0CF1,  # Vines
    0x0CF2,  # Vines
]

necro_scrolls = [
    0x2269, 0x2266, 0x226A, 0x226E, 0x2261, 0x2267, 0x2262, 0x2265,
    0x226F, 0x2264, 0x2270, 0x226D, 0x226C, 0x2260, 0x226B, 0x2263, 0x2268
]

swamp_trash = [
    0x101F, 0x0DBC, 0x0DBD, 0x0D3B, 0x0C2D, 0x0C2E, 0x0C30, 0x0C2F,
    0x0DEA, 0x28D9, 0x1CE8, 0x1AE0, 0x1B18, 0x1BE1, 0x1BDE, 0x0A19,
    0x13A8, 0x09E2, 0x09D8, 0x0A58, 0x1EB7, 0x136C, 0x0F03, 0x0F60,
    0x0B2B, 0x1E85, 0x0DEB, 0x2655, 0x170F, 0x0EE9, 0x0EB3, 0x10EE,
    0x0F3B, 0x0C40, 0x1125, 0x113C, 0x09C9, 0x097D
]

shipwreck_trash = [
    0x0EA2, 0x1B0E, 0x13A5, 0x13AD, 0x0FC9, 0x0FCB
]

hue_specific = {
    0x0DF9: 0x04e6,  # Purple Fungus
    0x0F83: 0x0000,  # Executioner's Cap
    0x0FC7: 0x0466,  # Fire horn
}

def QuickSort(API: API, leather=True, gold=True, wool=True, meat=True, scrolls=True, logs=True, resources=True, misc=True):
    '''
    Quick Sorting for looted materials in backpack.
    '''

    recycle_bag = GetMyItem(API, "recyclebag")
    bagofholding = API.GetSharedVar("BagOfHolding")
    scrollbag = API.GetSharedVar("ScrollBoH")
    spell_scrolls = API.GetSharedVar("spell_scrolls")
    loot_bag = API.GetSharedVar("LootBag")

    pack_items = API.ItemsInContainer(API.Player.Backpack, recursive=False) or []

    gold_items = [i for i in pack_items if i and getattr(i, 'Graphic', 0) == GOLD] if gold else []
    leather_items = [i for i in pack_items if i and getattr(i, 'Graphic', 0) == LEATHER and getattr(i, 'Amount', 0) > 20] if leather else []
    wool_items = [i for i in pack_items if i and getattr(i, 'Graphic', 0) == WOOL] if wool else []
    meat_items = [i for i in pack_items if i and getattr(i, 'Graphic', 0) == RIBS] if meat else []
    scroll_items = [i for i in pack_items if i and getattr(i, 'Graphic', 0) in spell_scrolls] if scrolls else []
    log_items = [i for i in pack_items if i and getattr(i, 'Graphic', 0) == LOGS] if logs else []
    resource_items = [i for i in pack_items if i and getattr(i, 'Graphic', 0) in RESOURCES] if resources else []
    # Misc Items for LootBag
    misc_items = [i for i in pack_items if i and getattr(i, 'Graphic', 0) == ESSENCES and "essence" in API.ItemNameAndProps(i, wait=True).lower()] if misc else []

    if gold_items and bagofholding:
        for i in gold_items:
            MoveItemToContainer(API, i, bagofholding)
            API.Pause(0.6)

    if leather_items and bagofholding:
        for i in leather_items:
            MoveItemToContainer(API, i, bagofholding)
            API.Pause(0.6)

    if wool_items and bagofholding:
        for i in wool_items:
            MoveItemToContainer(API, i, bagofholding)
            API.Pause(0.6)

    if all([meat_items, scrollbag, recycle_bag]):
        for i in meat_items:
            color = getattr(i, "Hue", 42)
            dest = scrollbag if color == 0 else recycle_bag
            MoveItemToContainer(API, i, dest)
            API.Pause(0.6)

    if all([scroll_items, scrollbag]):
        for i in scroll_items:
            MoveItemToContainer(API, i, scrollbag)
            API.Pause(0.6)

    if log_items and bagofholding:
        for i in log_items:
            MoveItemToContainer(API, i, bagofholding)
            API.Pause(0.6)

    if resource_items and bagofholding:
        for i in resource_items:
            MoveItemToContainer(API, i, bagofholding)
            API.Pause(0.6)

    if misc_items and loot_bag:
        for i in misc_items:
            MoveItemToContainer(API, i, loot_bag)
            API.Pause(0.6)

def trashJunk(API: API, pack=None):
    '''
    Trashes junk items into recycle bag.
    '''
    recycle_bag = GetMyItem(API, "recyclebag")
    if not recycle_bag:
        return

    pack_items = API.ItemsInContainer(API.Player.Backpack) or []
    to_trash = []
    to_trash.extend([i for i in pack_items if getattr(i, 'Graphic', 0) in trash_items])
    to_trash.extend([i for i in pack_items if getattr(i, 'Graphic', 0) == 0x0E39 and getattr(i, 'Hue', 0) == 0x058B])
    to_trash.extend([i for i in pack_items if getattr(i, 'Graphic', 0) in necro_scrolls])
    to_trash.extend([i for i in pack_items if getattr(i, 'Graphic', 0) in swamp_trash and 'pulled from a swamp' in (API.ItemNameAndProps(i) or "").lower()])
    to_trash.extend([i for i in pack_items if getattr(i, 'Graphic', 0) in shipwreck_trash and 'recovered from a shipwreck' in  (API.ItemNameAndProps(i) or "").lower()])
    for graphic, color in hue_specific.items():
        to_trash.extend([i for i in pack_items if getattr(i, 'Graphic', 0) == graphic and getattr(i, 'Hue', 0) == color])


    for item in to_trash:
        MoveItemToContainer(API, item, recycle_bag)
        API.Pause(0.6)
