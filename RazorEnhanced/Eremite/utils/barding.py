from Eremite.utils.items import GetRecycleBag
# Barding

# Vars
KEEP_STOCKED = 5

# ID: Weight
instruments = {
  0xe9d: 1,  # Tamborine
  0xe9e: 1,  # Tamborine with Tassel
  0x2805: 2, # bamboo flute
  0xe9c: 4,  # drums
  0xeb3: 5,  # lute
}
instrument_ids = list(instruments.keys())

# These are immune to discord until very low HP, ignore them till below 8% HP.
#   to conserve instrument charges.  Match any of the below (lowercase, stripped)
#   against the contents of the mob's full Mobile.Name value (lowercase, stripped)
discord_ignore = [
    "the spectre of chiret", # The Spectre Of Chiret, The Master Necromancer
    "the spectre of julius", # The Spectre Of Julius, The Master Rogue
    "the spectre of baelius", # The Spectre Of Baelius, The Master Mage
    "the spectre of tinmo", # The Spectre Of Tinmo, The Master Cleric
    "the spectre of tyre", # The Spectre Of Tyre, The Master Paladin 
    "the spectre of alamein", #The Spectre Of Alamein, The Master Fighter
    "the spectre queen", "slaarion", "lady melisande", "dread horn", "netopir",
    "skrat the imp lord", "katchaki", "the cyclopian warrior", "a saliva",
    "skeletor", "master jonath", "lord malachai", "monstrous interred grizzle",
    "ancient mage mikael"
]
discord_ignore_lc = [s.lower().strip() for s in discord_ignore]

toolbag = Misc.ReadSharedValue("ToolBag")
recyclebag = GetRecycleBag()

play_what_log = "What instrument shall you play"

def ShouldDiscord(target):
    mobname = target.Name.lower().strip()
    if any([t in mobname for t in discord_ignore_lc]):
        return target.Hits / target.HitsMax * 100 <= 9.0
    return True

# Cast Discordance on A Target
def Discordance(target):
    if not target:
        return False
    if not ShouldDiscord(target):
        return False
    Player.UseSkill("Discordance")
    if Journal.Search(play_what_log):
        Journal.Clear("play_what_log")
        FindInstrument()
        Misc.Pause(600)
        Player.UseSkill("Discordance")
    Target.WaitForTarget(1000)
    Target.TargetExecute(target)
    Target.Cancel()
    return True

# Instrument Finder
def FindInstrument():
    instruments = Items.FindAllByID(instrument_ids, 0, toolbag, 0)
    for i in instruments:
        if "flute of renewal" in i.Name.lower():
            continue
        Items.UseItem(i)
        return

# --- Instrument Stocker ---
def InstrumentStocker():
    # Get bag instruments - can return early if none.
    bag_instruments = Items.FindAllByID(instrument_ids, 0, toolbag, 0)
    if len(bag_instruments) == 0:
        return
    # Get all instruments in packs:
    pack_instruments = Items.FindAllByID(instrument_ids, 0, Player.Backpack.Serial, 0)
    # Ignore flute of renewal 
    for i in pack_instruments:
        if "flute of renewal" in i.Name.lower():
            pack_instruments.remove(i)
    # If total < our amount to keep stocked, just move everything into the tool bag.
    total_items = len(pack_instruments) + len(bag_instruments)
    if total_items < KEEP_STOCKED:
        for i in pack_instruments:
            Items.Move(i,toolbag,-1)
        return
    # Build list of all items with weight, flag if already in toolbag, and serial
    all_items = []
    for item in bag_instruments:
        weight = instruments.get(item.ItemID, 9999)
        all_items.append((weight, True, item.Serial))
    for item in pack_instruments:
        weight = instruments.get(item.ItemID, 9999)
        all_items.append((weight, False, item.Serial))
    # Sort by weight ascending, toolbag items first when weight ties
    all_items.sort(key=lambda x: (x[0], 0 if x[1] else 1))
    # Keep the first KEEP_STOCKED items
    keep_serials = {serial for _, _, serial in all_items[:KEEP_STOCKED]}
    # Move toolbag items that are not in keep set to recycle bag
    for item in bag_instruments:
        if item.Serial not in keep_serials:
            Items.Move(item, recyclebag, -1)
    # Move backpack items accordingly
    for item in pack_instruments:
        if item.Serial in keep_serials:
            if item.Container != toolbag:
                Items.Move(item, toolbag, -1)
        else:
            Items.Move(item, recyclebag, -1)