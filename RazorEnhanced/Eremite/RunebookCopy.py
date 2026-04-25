from Eremite.utils.items import GetKeys

# =============== Runebook Copy Script ===============
# Will prompt for a source, then destination book.
# If source is not in pack, will prompt for a reference rune
#   to recall back to where the source book is at.
# Recalls to each slot in sequence, marks a rune and will either:
#    1. Prompt for user if no NAMES are provided before continuing.
#    2. OR use the value from NAMES provided.
# NAMES should be a list of 16 strings.  eg:
#    ["name1", "name2", "name3", ... "name16"]
# Prefers finding runes in your backpack, but if none is found,
#   it will remove one rune from SpellKeys.  Have at least 16!

NAMES = None

# Set Custom Names or comment out.
# eg: TMap Numbers 1-16
# NAMES = [str(i) for i in range(1, 16 +1)]

# --- Constants ---

RUNE_ID = 0x1F14
RB_GUMP_ID = 0x554b87f3
RB_GUMP_BUTTONS = [
      7,  17,  27,  37,  47,  57,  67,  77,
      87, 97, 107, 117, 127, 137, 147, 157,
]
SPELLKEYS = GetKeys('spell')
RENAMED_TEXT = "The etching on the rune has been changed."

# --- Helpers ---

def GetRune(exclude=[]):
    runes = Items.FindAllByID(RUNE_ID, 0, Player.Backpack.Serial, 0)
    runes = [rune for rune in runes if rune not in exclude]
    if len(runes) > 0:
        return runes[0]
    else:
        return GetRuneFromKeys()
    
def GetRuneFromKeys():
    while not Gumps.HasGump(247257139):
        Items.UseItem(SPELLKEYS)
        Gumps.WaitForGump(247257139, 1500)
    Gumps.SendAction(247257139, 60026)
    Misc.Pause(600)
    return GetRune()

def PromptBooks():
    SRC_RB = Target.PromptTarget("Select source runebook.")
    SRC_RB = Items.FindBySerial(SRC_RB) if SRC_RB != -1 else None
    DST_RB = Target.PromptTarget("Select blank runebook.")
    DST_RB = Items.FindBySerial(DST_RB) if DST_RB != -1 else None
    REF_RUNE = None
    if SRC_RB.RootContainer != Player.Backpack.Serial:
        REF_RUNE = Target.PromptTarget("Select Rune by Source to Recall to.")
        REF_RUNE = Items.FindBySerial(REF_RUNE) if REF_RUNE != -1 else None
    return SRC_RB, DST_RB, REF_RUNE 
    
# --- Main Function ---
        
def CopyRunebook(SRC_RB, DST_RB, REF_RUNE=None, NAMES = None):
    if not SRC_RB or not DST_RB:
        return
    if NAMES:
        Misc.SendMessage(f"Using {len(NAMES)} custom names: {NAMES}")

    Journal.Clear(RENAMED_TEXT)
    Misc.CancelPrompt()
    for slot in range(0,16):
        Misc.SendMessage(f"Copying rune {slot + 1}...")
        if REF_RUNE and Player.DistanceTo(SRC_RB) > 5:
            Player.ChatSay(0, '[cs sacredjourney')
            Target.WaitForTarget(3000)
            Target.TargetExecute(REF_RUNE)
            Misc.Pause(2000)
        Items.UseItem(SRC_RB)
        Gumps.WaitForGump(RB_GUMP_ID,1500)
        Gumps.SendAction(RB_GUMP_ID, RB_GUMP_BUTTONS[slot])
        Misc.Pause(2000)
        rune = GetRune(exclude=[REF_RUNE] or [])
        Player.ChatSay(0, '[cs mark')
        Target.WaitForTarget(3000)
        Target.TargetExecute(rune)
        Items.UseItem(rune)
        if not NAMES:
            Player.HeadMessage(69, 'Enter Name')
            while not Journal.Search(RENAMED_TEXT):
                Misc.Pause(200)
            Journal.Clear(RENAMED_TEXT)
        else:
            while not Misc.HasPrompt():
                Misc.Pause(100)
            Misc.ResponsePrompt(NAMES[slot])
            Misc.Pause(600)
        Items.Move(rune, DST_RB, -1)
    # Go back to ref run at the end.
    Player.ChatSay(0, '[cs sacredjourney')
    Target.WaitForTarget(3000)
    Target.TargetExecute(REF_RUNE)
    Misc.Pause(2000)

# --- main ---

SRC_RB, DST_RB, REF_RUNE = PromptBooks()
CopyRunebook(SRC_RB, DST_RB, REF_RUNE, NAMES)
