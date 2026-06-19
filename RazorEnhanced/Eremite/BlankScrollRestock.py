
class ScrollRestock():
    scrollbook = Items.FindBySerial(0x4621E9B3)
    holdingbag = Items.FindBySerial(0x412D8C13)
    
    def __init__(self):
        pass
        
    def RecallAndBuyAll(self):
        for runeslot in range(7, 160, 10):
            while not Gumps.HasGump(1431013363):
                Items.UseItem(self.scrollbook.Serial)
                Gumps.WaitForGump(1431013363, 600)
            Gumps.SendAction(1431013363, runeslot)
            Misc.Pause(2500)
            self.BuyScrolls()
            
    def BuyScrolls(self):
        BuyAgent.ChangeList("scrolls")
        if not BuyAgent.Status():
            BuyAgent.Enable()
        vendors = self.GetScrollVendors()
        for vendor in vendors:
            Mobiles.UseMobile(vendor)
            Misc.Pause(1000)
        scrolls = Items.FindAllByID(0x0EF3, 0, Player.Backpack.Serial,0) or []
        for scroll in scrolls:
            Items.Move(scroll, self.holdingbag, -1)
            Misc.Pause(600)
        
    def GetScrollVendors(self):
        filter = Mobiles.Filter()
        filter.Enabled = True
        filter.RangeMin = 0
        filter.RangeMax = 10
        filter.IsHuman = True
        npcs = Mobiles.ApplyFilter(filter)
        mages = []
        for n in npcs:
            for prop in n.Properties:
                if any([title in str(prop).lower() for title in ["scribe", "mage", "mapmaker"]]) and "guildmaster" not in str(prop).lower() and "guildmistress" not in str(prop).lower():
                    mages.append(n)
        return mages
                    
    def RecallHome(self):
        while not Gumps.HasGump(1431013363):
            Items.UseItem(0x4040330D)
            Gumps.WaitForGump(0x554b87f3, 10000)
        Gumps.SendAction(0x554b87f3, 7)
        Misc.Pause(3000)
        
    def StartCrafting(self):
        pen = Items.FindAllByID(0x0FBF,0, Player.Backpack.Serial, 1)
        _ = [Items.WaitForProps(p, 1000) for p in pen]
        pen = [p for p in pen if p.Name.lower() == "scribe's pen"]
        while Player.Mount:
            Mobiles.UseMobile(Player.Serial)
            Misc.Pause(600)
        Items.UseItem(pen[0])
        Gumps.WaitForGump(0xdb74b85f, 10000)
        Gumps.SendAction(0xdb74b85f, 60004) # Magery
        Gumps.WaitForGump(0xdb74b85f, 10000)
        Gumps.SendAction(0xdb74b85f, 60011) # 7th Circle
        Gumps.WaitForGump(0xdb74b85f, 10000)
        Gumps.SendAction(0xdb74b85f, 60020) # FlameStrike
    
def main():
    sr = ScrollRestock()
    while Player.Gold > 10000:
        if Player.WarMode:
            Player.HeadMessage(33, "War: Skipping")
        else:
            sr.RecallAndBuyAll()
            sr.RecallHome()
        Player.UseSkill("Hiding")
        sr.StartCrafting()
        if Player.Gold > 10000:
            Misc.Pause(30 * 60 * 1000) # 30 minutes
        

if __name__ == "__main__":
    main()
    