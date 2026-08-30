from Eremite.utils.items import GetMyItem, FindTypesInContainer, MoveItemToContainer

KEEP_STOCKED = 5

instruments = {
    0x0E9D: 1,  # Tambourine
    0x0E9E: 1,  # Tambourine with Tassel
    0x2805: 2,  # Bamboo flute
    0x0E9C: 4,  # Drums
    0x0EB3: 5,  # Lute
}
instrument_ids = list(instruments.keys())

discord_ignore = [
    "the spectre of chiret",
    "the spectre of julius",
    "the spectre of baelius",
    "the spectre of tinmo",
    "the spectre of tyre",
    "the spectre of alamein",
    "the spectre queen", "slaarion", "lady melisande", "dread horn", "netopir",
    "skrat the imp lord", "katchaki", "the cyclopian warrior", "a saliva",
    "skeletor", "master jonath", "lord malachai", "monstrous interred grizzle",
    "ancient mage mikael", "a travesty"
]
discord_ignore_lc = [s.lower().strip() for s in discord_ignore]

def ShouldDiscord(target):
    if not target:
        return False
    mobname = (getattr(target, 'Name', '') or "").lower().strip()
    if any(t in mobname for t in discord_ignore_lc):
        hits = getattr(target, 'Hits', 1)
        hits_max = getattr(target, 'HitsMax', 25) or 25
        return (hits / float(hits_max)) * 100.0 <= 9.0
    return True

def FindInstrument(API: API):
    API.SysMsg("Finding instrument!", 88)
    toolbag = API.GetSharedVar("ToolBag") or API.Player.Backpack.Serial
    found_instruments = FindTypesInContainer(API=API, graphics=instrument_ids, container=toolbag, recursive=False)
    if found_instruments:
        API.UseObject(found_instruments[0])
        return found_instruments[0]
    return None

def Discordance(API: API, target):
    if not target:
        return False
    if not ShouldDiscord(target):
        return False

    API.UseSkill("Discordance")
    if API.WaitForTarget(timeout=0.6):
        API.Target(target.Serial)
    
    if API.InJournal("What instrument shall you play", clearMatches=True):
        FindInstrument(API)
        API.Pause(0.6)
        API.UseSkill("Discordance")

    if API.HasTarget():
        API.CancelTarget()
    return True

def InstrumentStocker(API:API):
    toolbag = API.GetSharedVar("ToolBag")
    if not toolbag:
        return
    recyclebag = GetMyItem(API, "recyclebag")
    backpack = getattr(API.Player, 'Backpack', None)
    backpack_serial = getattr(backpack, 'Serial', None)

    bag_instruments = []
    pack_instruments = []

    found = FindTypesInContainer(API, graphics=instrument_ids, container=backpack_serial, recursive=True)
    in_pack = [i for i in found if getattr(i, 'Container', None) == backpack_serial and "flute of renewal" not in (API.ItemNameAndProps(i.Serial, True) or "").lower()]
    pack_instruments.extend(in_pack)
    in_bag = [i for i in found if getattr(i, 'Container', None) == toolbag]
    bag_instruments.extend(in_bag)

    total_items = len(pack_instruments) + len(bag_instruments)
    if total_items < KEEP_STOCKED:
        for i in pack_instruments:
            MoveItemToContainer(API, i.Serial, toolbag)
            API.Pause(0.6)
        return

    all_items = []
    for item in bag_instruments:
        weight = instruments.get(item.Graphic, 9999)
        all_items.append((weight, True, item.Serial, item))
    for item in pack_instruments:
        weight = instruments.get(item.Graphic, 9999)
        all_items.append((weight, False, item.Serial, item))

    all_items.sort(key=lambda x: (x[0], 0 if x[1] else 1))
    keep_serials = {serial for _, _, serial, _ in all_items[:KEEP_STOCKED]}

    if recyclebag:
        recycle_serial = getattr(recyclebag, 'Serial', recyclebag)
        for item in bag_instruments:
            if item.Serial not in keep_serials:
                MoveItemToContainer(API, item.Serial, recycle_serial)
                API.Pause(0.6)

    for item in pack_instruments:
        if item.Serial in keep_serials:
            if getattr(item, 'Container', None) != toolbag:
                MoveItemToContainer(API, item.Serial, toolbag)
                API.Pause(0.6)
        elif recyclebag:
            recycle_serial = getattr(recyclebag, 'Serial', recyclebag)
            MoveItemToContainer(API, item.Serial, recycle_serial)
            API.Pause(0.6)
