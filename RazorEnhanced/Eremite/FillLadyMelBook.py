from Scripts.Eremite.utils.items import GetRecycleBag
from Eremite.utils.mobiles import GetFacet
from random import randint

def getQuestItems():
    toadstools = Items.FindAllByID(0x1125, 0x0877, Player.Backpack.Serial, 1)
    foulfungi = Items.FindAllByID(0x26B7, 0x0801, Player.Backpack.Serial, 1)
    stifftwigs = Items.FindAllByID(0x1B9C, 0x08ad, Player.Backpack.Serial, 1)
    petritwigs = Items.FindAllByID(0x1B9D, 0x0482, Player.Backpack.Serial, 1)
    fossiltwigs = Items.FindAllByID(0x1B9C, 0x0850, Player.Backpack.Serial, 1)

    has_all_five = all([len(x) > 0 for x in [toadstools, foulfungi, stifftwigs, petritwigs, fossiltwigs]])
    return toadstools, foulfungi, stifftwigs, petritwigs, fossiltwigs, has_all_five

def MelTicketCount():
    ticks = Items.FindAllByID(0x14EF, 0, Player.Backpack.Serial, 1)
    _ = [Items.WaitForProps(tick, 500) for tick in ticks]
    ticks = [tick for tick in ticks if "melisande" in tick.Name.lower()]
    Misc.SendMessage(f"Mel Tickets: {len(ticks)}", 88)
    
def ClearStaleGumps():
    while Gumps.HasGump(0xfd84f341):
        Gumps.SendAction(0xfd84f341, 3)
        Misc.Pause(200)
        
def FillLadyMelBook():
    while True:
        melbook = Items.FindByID(0x0E3B,0x01f4,Player.Backpack.Serial,0)
        toadstools, foulfungi, stifftwigs, petritwigs, fossiltwigs, has_all_five = getQuestItems()
        Misc.SendMessage(f"{len(toadstools)} : Deadly Toadstools : Ground", 77)
        Misc.SendMessage(f"{len(foulfungi)} : Foul Fungi      : Moss Maiden", 77)
        Misc.SendMessage(f"{len(stifftwigs)} : Stiffened Twigs  : TreeFellow ", 77)
        Misc.SendMessage(f"{len(petritwigs)} : Petrified Twigs  : Reaper", 77)
        Misc.SendMessage(f"{len(fossiltwigs)} : Fossilized Twigs  : Changeling", 77)
        
        mel_start_stone = Items.FindBySerial(0x40866623)
        if not mel_start_stone or Player.DistanceTo(mel_start_stone) > 10:
            Player.HeadMessage(44, "Too Far")
            Misc.SendMessage("More than 10 tiles from start stone - move to the quest area.", 44)
            return False
        
        if not has_all_five:
            Player.HeadMessage(44, "Missing Items")
            return False    
            
        if not melbook:
            PathFinding.PathFindTo(6455, 834, 0)
            while True:
                Player.ChatSay(77,"fight lady mel")
                for i in range(0,6):
                    Misc.Pause(1000)
                    melbook = Items.FindByID(0x0E3B,0x01f4,Player.Backpack.Serial,0)
                    if melbook:
                        break
                if melbook:
                        break
    
        if not Gumps.HasGump(0xc563d169):
            Items.UseItem(melbook)
            Gumps.WaitForGump(0xc563d169, 1000)
        Target.Cancel()

        for qitem in [foulfungi[0], stifftwigs[0], petritwigs[0], toadstools[0], fossiltwigs[0]]:
            if not Target.HasTarget():
                Gumps.SendAction(0xc563d169, 700)
                Target.WaitForTarget(1000, False)
            Target.TargetExecute(qitem)
            Target.WaitForTarget(1000)

        Gumps.CloseGump(0xc563d169)
        Target.Cancel()
        
        
        PathFinding.PathFindTo(6450, 840, 0)
        Misc.Pause(600)
        
        while Items.FindByID(0x0E3B,0x01f4,Player.Backpack.Serial,0):
            Player.ChatSay(77,"ready")
            for i in range(0,6):
                melbook = Items.FindByID(0x0E3B,0x01f4,Player.Backpack.Serial,0)
                if not melbook:
                    break
                Misc.Pause(1000)

def GetPeerlessBag():
    pouches = Items.FindAllByID(0x0E79, 0, Player.Backpack.Serial, 0)
    _ = [Items.WaitForProps(p, 700) for p in pouches]
    pouches = [p for p in pouches if "peerless" in str(p.Properties).lower()]
    return pouches[0] if len(pouches) > 0 else None
                
def SortMelItems():
    toadstools, foulfungi, stifftwigs, petritwigs, fossiltwigs, has_all_five = getQuestItems()
    trash_bag = GetRecycleBag()
    pouch = GetPeerlessBag()
    if not pouch:
        return False
    keep_max = min(len(foulfungi), len(fossiltwigs)) + 5
    
    for qitem in [toadstools, foulfungi, stifftwigs, petritwigs, fossiltwigs]:
        in_pouch = [q for q in qitem if q.Container == pouch.Serial]
        in_pack = [q for q in qitem if q.Container == Player.Backpack.Serial]
        kept = len(in_pouch)
        for item in in_pack:
            if kept < keep_max:
                Items.Move(item, pouch, -1, randint(44, 100), 100)
                kept += 1
            else:
                Items.Move(item, trash_bag, -1, 0, 0)
            Misc.Pause(600)
            
    mel_tickets = Items.FindAllByID(0x14EF, 0, Player.Backpack.Serial, 0)
    for tick in mel_tickets:
        Items.WaitForProps(tick, 600)
        if "melisande master ticket" in tick.Name.lower():
            Items.Move(tick, pouch, -1, randint(44, 85), 0)
            Misc.Pause(600)
            
def TrashMelItems():
    toadstools, foulfungi, stifftwigs, petritwigs, fossiltwigs, has_all_five = getQuestItems()
    trash_bag = GetRecycleBag()
    for qitem in [toadstools, foulfungi, stifftwigs, petritwigs, fossiltwigs]:
        for item in qitem:
            Items.Move(item, trash_bag, -1, 0, 0)
            Misc.Pause(600)

def TrashMelJunk():
    trash_bag = GetRecycleBag()
    trees = Items.FindAllByID(0x20FA, -1, Player.Backpack.Serial, 0)
    for tree in trees:
        Items.WaitForProps(tree, 750)
        if "eternally corrupt tree" in tree.Name.lower():
            Items.Move(tree, trash_bag, -1, 0, 0)
            Misc.Pause(600)
    recipes = Items.FindAllByID(0x2831, 0, Player.Backpack.Serial, 0)
    for recipe in recipes:
        Items.WaitForProps(recipe, 750)
        if "recipe scroll" not in recipe.Name.lower():
            continue
        Journal.Clear("already know this recipe")
        Items.UseItem(recipe)
        Misc.Pause(600)
        if Journal.Search("already know this recipe"):
            Items.Move(recipe, trash_bag, -1, 0, 0)
            Misc.Pause(600)
        
    
def main():
    FillLadyMelBook()
    MelTicketCount()
    ClearStaleGumps()
    if GetFacet(Player) == "Felucca":
        SortMelItems()
    else:
        TrashMelItems()
    TrashMelJunk()
    
        
if __name__ == "__main__":
    main()
