from System import Int32
from System.Collections.Generic import List
from random import randint

class CitadelHelper():
    book_barrel_serial = 0x4004A697
    book_barrel = Items.FindBySerial(book_barrel_serial)
    elixierchest_serial = 0x40012C6D
    elixierchest = Items.FindBySerial(elixierchest_serial)
    elixier_lever_serial = 0x40012C1A
    elixier_lever = Items.FindBySerial(elixier_lever_serial)

    def __init__(self):
        self.peerlessbag = self.GetPeerlessBag()
    
    @staticmethod
    def countBooks():
        book_count = Items.FindAllByID(0x0FF2,0,Player.Backpack.Serial,0)
        return len(book_count)
    
    @staticmethod
    def GetPeerlessBag():
        pouches = Items.FindAllByID(0x0E79, 0, Player.Backpack.Serial, 0)
        _ = [Items.WaitForProps(p, 700) for p in pouches]
        pouches = [p for p in pouches if "peerless" in str(p.Properties).lower()]
        return pouches[0] if len(pouches) > 0 else None

    def doBooks(self):
        Player.HeadMessage(88, "Doing books.")
        
        book_spawn_crate = Items.FindBySerial(0x40049745)
        book_spawn_barrel = Items.FindBySerial(0x40080553)
        
        while self.countBooks() < 7:
            book_filter = Items.Filter()
            book_filter.Graphics = List[Int32]([0x0FF2])
            book_filter.OnGround = True
            book_filter.RangeMax = 10
            book_filter.RangeMin = 0
            books = Items.ApplyFilter(book_filter)
            for book in books:
                PathFinding.PathFindTo(book.Position.X, book.Position.Y, book.Position.Z)
                Items.Move(book, Player.Backpack.Serial, -1)
                Misc.Pause(600)
            if self.countBooks() >= 7:
                break
            for cont in [book_spawn_crate, book_spawn_barrel]:
                if "0 items" in str(cont.Properties).lower():
                    Misc.Pause(600)
                    continue
                PathFinding.PathFindTo(cont.Position.X, cont.Position.Y +1, cont.Position.Z)
                Items.WaitForContents(cont,600)
                Misc.Pause(600)
                while not "0 items" in str(cont.Properties).lower():
                    books = Items.FindAllByID(0x0FF2,0,cont.Serial,0)
                    for book in books:
                        Items.Move(book, Player.Backpack.Serial, -1)
                        Misc.Pause(600)
                Misc.Pause(600)
                if self.countBooks() >= 7:
                    break
        # Once we have 7 books:
        PathFinding.PathFindTo(self.book_barrel.Position.X + 1, self.book_barrel.Position.Y, self.book_barrel.Position.Z)
        books = Items.FindAllByID(0x0FF2,0,Player.Backpack.Serial,0)
        for book in books:
            while book.RootContainer == Player.Backpack.Serial:
                Items.Move(book, self.book_barrel, -1)
                Misc.Pause(600)
        Misc.Pause(1000)
        PathFinding.PathFindTo(141, 1923, 0) # In front of door
        PathFinding.PathFindTo(138, 1928, 0) # In front of portal

    def doEntryPuzzle(self):
        PathFinding.PathFindTo(95, 1882, 0) # Teleport Spot
        Player.ChatSay(0, '[cs teleport')
        Target.WaitForTarget(1500)
        Target.TargetExecute(96,1881,0,0) # Teleport to other side of water.
        Misc.Pause(500)
        Dress.ChangeList("singletarget")
        Dress.DressFStart()
        PathFinding.PathFindTo(106, 1881, 0) # Walk to first room button
        Misc.Pause(100)
        PathFinding.PathFindTo(98, 1899, 0) # Walk to 2nd room button
        Misc.Pause(100)
        PathFinding.PathFindTo(98, 1868, 0) # Walk to near 3rd room lever
        Misc.Pause(100)
        Items.UseItem(0x4001218E) # Use 3rd room lever.
        Misc.Pause(100)
        PathFinding.PathFindTo(98, 1891, 0) # Walk to 4th Room Button
        PathFinding.PathFindTo(93, 1891, 0) #  - using straight lines - 
        PathFinding.PathFindTo(93, 1899, 0) # - to avoid getting stuck -
        Misc.Pause(100)
        PathFinding.PathFindTo(92, 1898, 0) # Walk through Moongate 
        
    def checkAction(self):
        if self.book_barrel and Player.DistanceTo(self.book_barrel) < 9:
            self.doBooks()
        elif abs(Player.Position.X - 96) < 5 and abs(Player.Position.Y - 1881) < 5:
            self.doEntryPuzzle()
        elif self.elixierchest and Player.DistanceTo(self.elixierchest) < 2:
            self.ElixierChest()
        elif self.elixier_lever and Player.DistanceTo(self.elixier_lever) < 2:
            Items.UseItem(self.elixier_lever)

    def KeyCount(self):
        keys = {
            0x100E: "Dragon Flame Key",
            0x1010: "Tiger Claw Key",
            0x100F: "Serpent Fang Key"
        }
        for key,name in keys.items():
            items = Items.FindAllByID(key, 0, Player.Backpack.Serial, 1, False)
            _ = [Items.WaitForProps(i, 500) for i in items]
            items = [item for item in items if item.Name.lower() == name.lower()]
            count = len(items)
            Misc.SendMessage(f"{count} : {name}", 88)
            keys = [i for i in items if i.Container == Player.Backpack.Serial]
            for key in keys:
                if "dragon" in key.Name.lower():
                    Items.Move(key, self.peerlessbag, -1, 145, randint(65,100))
                    Misc.Pause(600)
                elif "tiger" in key.Name.lower():
                    Items.Move(key, self.peerlessbag, -1, randint(110, 143), 144)
                    Misc.Pause(600)
                elif "serpent" in key.Name.lower():
                    Items.Move(key, self.peerlessbag, -1, randint(44, 85), 140)
                    Misc.Pause(600)
            


        
            
    def ElixierChest(self):
        if "iron lock" in str(self.elixierchest.Properties).lower():
            Items.UseItemByID(0x100E,0x09ca)
            Target.WaitForTarget(1500)
            Target.TargetExecute(self.elixierchest)
            Misc.Pause(600)
        Items.WaitForContents(self.elixierchest, 600)
        Misc.Pause(600)
        for item in self.elixierchest.Contains:
            Items.Move(item, Player.Backpack.Serial, -1)
            Misc.Pause(600)


def main():
    ch = CitadelHelper()
    ch.KeyCount()
    ch.checkAction()
    
if __name__ == "__main__":
    main()