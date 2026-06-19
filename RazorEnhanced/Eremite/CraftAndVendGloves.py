from Eremite.utils.items import getSewingKit

class GloveCrafter():
    # -- Settings --
    craft_bag_serial = 0x427497F2
    gold_bag_serial = 0x412D8C13
    armorer_books = {
        0x43672748: 16,
        0x425805BE: 11, 
    }
    # ---------
    craft_bag = Items.FindBySerial(craft_bag_serial)
    gold_bag = Items.FindBySerial(gold_bag_serial)
    glove_buyers = ["armorer", "blacksmith"]
    armorer = None
    
    def __init__(self):
        pass

    def startCrafting(self):
        sewingkit = getSewingKit()
        if sewingkit is None:
            Player.HeadMessage(33, "No Sewing Kit")
            return False
        Items.UseItem(sewingkit)
        Gumps.WaitForGump(0xdb74b85f, 1500) # Sewing Gump
        Gumps.SendAction(0xdb74b85f, 60009) # Armor
        Gumps.WaitForGump(0xdb74b85f, 1500)
        Gumps.SendAction(0xdb74b85f, 60010) # Leather
        Gumps.WaitForGump(0xdb74b85f, 1500)
        Gumps.SendAction(0xdb74b85f, 60022) # Craft Leather Gloves
        

    def getArmorer(self):
        filter = Mobiles.Filter()
        filter.Enabled = True
        filter.RangeMin = 0
        filter.RangeMax = 10
        filter.IsHuman = True
        npcs = Mobiles.ApplyFilter(filter)
        for n in npcs:
            for prop in n.Properties:
                if any([title in str(prop).lower() for title in self.glove_buyers]) and "guildmaster" not in str(prop).lower() and "guildmistress" not in str(prop).lower():
                    self.armorer = n
                    Misc.Pause(650)
                    Mobiles.UseMobile(n)
                    Misc.Pause(500)
                    return n
                
    def recallToArmorer(self, next=False):
        self.armorer = None
        current = Misc.ReadSharedValue('glovesellcurrent') or {"book": 0, "rune": 0}
        if next:
            if current["rune"] < 16:
                current["rune"]+=1
            else:
                current["rune"] = 0
                if current["book"] < len(self.armorer_books) - 1:
                    current["book"]+=1
                else:
                    current["book"] = 0
        Misc.SetSharedValue("glovesellcurrent",current)
        book_serial = list(self.armorer_books.keys())[current["book"]]
        while not Gumps.HasGump(1431013363):
            Items.UseItem(book_serial)
            Gumps.WaitForGump(1431013363, 600)
        button = f'{current["rune"]}7'
        button = int(button)
        Gumps.SendAction(1431013363, button)
        Misc.Pause(2000)


    def craftAndVend(self):
        self.startCrafting()
        Journal.Clear("storage is full")
        while True:
            if len(self.craft_bag.Contains) > 50:
                self.sellToArmorer()
            Misc.Pause(1000)
            if Journal.Search("storage is full"):
                break
        Misc.Pause(650)
        return True
            
    def sellToArmorer(self):
        armorer = self.armorer or self.getArmorer()
        Misc.WaitForContext(armorer.Serial, 10000)
        Misc.ContextReply(armorer.Serial, 2)
        Misc.Pause(600)
        
    def moveGold(self):
        for gold in Items.FindAllByID(0x0EED, 0, Player.Backpack.Serial, 0):
            Items.Move(gold, self.gold_bag, -1)
            Misc.Pause(600)
        
    def go(self):
        SellAgent.ChangeList("craftvend")
        SellAgent.Enable()
        self.recallToArmorer()
        while True:
            self.moveGold()
            self.craftAndVend()
            self.recallToArmorer(next=True)

        
def main():
    crafter = GloveCrafter()
    crafter.go()
    
if __name__ == "__main__":
    main()
