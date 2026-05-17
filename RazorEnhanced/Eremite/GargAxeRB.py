from System import Int32
from System.Collections.Generic import List

class GargAxeChopper():
    boh = Misc.ReadSharedValue("BagOfHolding")
    runebooks = [0x406F1B45] # Replace me

    chop_end = [ "logs in your backpack", "you carefully extract", "you hack at the tree for a while", "not enough wood here to harvest" ]
    
    def __init__(self):
        garg_axe = Items.FindByID(0x0F45, 0x0973, Player.Backpack.Serial, 1)
        if not garg_axe:
            garg_axe = Player.GetItemOnLayer('LeftHand')
            garg_axe = garg_axe if garg_axe.ItemID == 0x0F45 and garg_axe.Color == 0x0973 else None
        self.garg_axe = garg_axe
        self.garunebook = Misc.ReadSharedValue("garunebook") or self.runebooks[0]
        self.gaslot = Misc.ReadSharedValue("gaslot") or 0
        
    def EquipGargAxe(self):
        left_hand = Player.GetItemOnLayer('LeftHand')
        left_hand = left_hand if left_hand != self.garg_axe else None
        right_hand = Player.GetItemOnLayer('RightHand')

        if left_hand:
            Items.Move(left_hand, self.boh, -1)
            Misc.Pause(600)
        if right_hand:
            Items.Move(right_hand, self.boh, -1)
            Misc.Pause(600)
        while Player.GetItemOnLayer('LeftHand') != self.garg_axe:
            Player.EquipItem(self.garg_axe)
            Misc.Pause(100)
        Misc.Pause(600)
        
    @staticmethod
    def EquipWeapon():
        Dress.ChangeList('singletarget')
        Dress.DressFStart()
        while Dress.DressStatus():
            Misc.Pause(100)
        Misc.Pause(600)
        
    def RecallToRuneSlot(book, slot, next = False):
        book = book or self.garunebook
        slot = book or self.gaslot
        if next:
            slot = slot + 1 if slot < 15 else 0
            book_ind = self.runebooks.index(book)
            book_ind = book_ind if len(self.runebooks) < book_ind else 0
            book = self.runebooks[book_ind]
            Misc.SetSharedValue(garunebook, book)
            Misc.SetSharedValue(gaslot, slot)
        Items.UseItem(book)
        Gumps.WaitForGump(0x554b87f3,1500)
        Gumps.SendAction(0x554b87f3, slot)
        Misc.Pause(2000)

    
    @staticmethod
    def ElementalSpawned(): # -> bool
        filter = Mobiles.Filter()
        filter.Bodies = List[Int32]([0x012D]) # Wood Elemental
        filter.RangeMax = 4
        filter.RangeMin = 0
        filter.IgnorePets = True
        enemies = Mobiles.ApplyFilter(filter)
        if enemies:
            Player.Attack(enemies[0])
            return enemies[0]
        None
        
    def ChopTree(self, x_off=0, y_off=-1):
       while not Target.HasTarget():
           Items.UseItem(self.garg_axe)
           Target.WaitForTarget(600)
       tree = Statics.GetStaticsTileInfo(Player.Position.X, Player.Position.Y + y_off, Player.Map)
       z = 0 if not tree else tree[0].StaticZ
       id = 0 if not tree else tree[0].StaticID
       Target.TargetExecute(Player.Position.X, Player.Position.Y + y_off, z, id)
       
    def WaitForChop(self):
        self.ClearJournal(self.chop_end)
        while not any([Journal.Search(text) for text in self.chop_end]):
            if self.ElementalSpawned():
                return True
            Misc.Pause(100)
        return True
    
    @staticmethod
    def ClearJournal(msgs):
        for m in msgs:
            Journal.Clear(m)

    def HarvestTree(self):
        while True:
            Player.HeadMessage(49,'chop')
            self.ChopTree()
            self.WaitForChop()
            if Journal.Search("not enough wood here to harvest"):
                print("EMPTY")
                return True
            elemental = self.ElementalSpawned()
            if elemental:
                self.EquipWeapon()
                while Mobiles.FindBySerial(elemental.Serial):
                    Player.WeaponPrimarySA()
                    Player.Attack(elemental)
                    Misc.Pause(1250)
            self.EquipGargAxe()
            Misc.Pause(50)
        return True
        
    def LogsToBoards(self):
        logs = Items.FindAllByID(0x1BDD, -1, Player.Backpack.Serial, 0)
        for log in logs:
            Misc.Pause(600)
            Items.UseItem(self.garg_axe)
            Target.WaitForTarget(1000)
            Target.TargetExecute(log)
            
    def WeightCheck(self):
        if Player.Weight > Player.MaxWeight * 0.8 or True:
            Misc.ScriptRun("RecycleWeight.py")
            while Misc.ScriptStatus("RecycleWeight.py"):
                Misc.Pause(500)
                
    def ClaimBodies(self):
        Misc.ScriptRun("CutClaimall.py")
        while Misc.ScriptStatus("CutClaimall.py"):
            Misc.Pause(500)
                
            
def main():
    chopper = GargAxeChopper()
    chopper.EquipGargAxe()
    chopper.HarvestTree()
    chopper.LogsToBoards()
    chopper.WeightCheck()
    chopper.ClaimBodies()
    chopper.LogsToBoards()
    chopper.WeightCheck()
    
    
if __name__ == "__main__":
    main()