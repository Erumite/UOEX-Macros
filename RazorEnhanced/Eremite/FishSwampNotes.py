from Eremite.utils.misc import GetItemLock

class NoteFisher():
    DONE_MSG = ["You fished up", "The fish got away", "The fish don't seem interested."]
    FINISHED_MSG = [
            "That would not work.", "fish don't seem to be biting", "not in your line of sight",
            "fished up a Wooden Chest", "Abandoned Trunk"
        ]
    ATTACKED_MSG = ["fungal lurker"]
    TO_CLEAN = DONE_MSG + FINISHED_MSG + ATTACKED_MSG
    
    FISHING_DRESS = "fishing"
    WEAPON_DRESS = "singletarget"
    
    def __init__(self): # -> None
        self.equipPole()
        self.fishpole = self.getFishPole()
        self.undressbag = Items.FindBySerial(Misc.ReadSharedValue("BagOfHolding")) or Player.Backpack
        self.left_hand  = Player.GetItemOnLayer("LeftHand")
        self.right_hand = Player.GetItemOnLayer("RightHand")
        
    def cleanJournal(self): # -> None
        for c in self.TO_CLEAN:
            Journal.Clear(c)
        return True

    @staticmethod
    def hasNote(): # -> bool
        NOTE_ID = 0x3418
        if not Items.FindAllByID(NOTE_ID, -1, Player.Backpack.Serial, 0): 
            return False
        return True

    @staticmethod
    def hasSoS(): # -> bool
        SOS_ID = 0x14ED
        if not Items.FindAllByID(SOS_ID, -1, Player.Backpack.Serial, 0):
            return False
        return True
            
    def getFishPole(self): # -> Item (fishpole) | None
        fishpole = Player.GetItemOnLayer("FirstValid")
        fishpole = fishpole if fishpole and fishpole.ItemID == 0x0DC0 else None
        if not fishpole:
            Player.HeadMessage(33, "No Fishing Pole")
            return False
        return fishpole
        
    def equipPole(self): # -> None
        Dress.ChangeList(self.FISHING_DRESS)
        Dress.DressFStart()
        while Dress.DressStatus():
            Misc.Pause(100)
        Misc.Pause(600)

    def fishSpot(self, X, Y): # -> None
        #water = Statics.GetStaticsTileInfo(X, Y, Player.Map)
        #water = water[0] if water else None
        #if not water:
        #    Player.HeadMessage(33, "No Water")
        #    return False
        Items.UseItem(self.fishpole)
        Target.WaitForTarget(600)
        #Target.TargetExecute(X, Y, water.StaticZ, water.StaticID or 0x0000)        
        Target.TargetExecute(X, Y, 0, 0x0000)        

    def waitForCast(self): # -> tuple(bool, bool, bool)
        self.cleanJournal()
        done = False
        finished = False
        attacked = False
        while True:
            if any([Journal.Search(d) for d in self.DONE_MSG]):
                done = True
                break
            if any([Journal.Search(f) for f in self.FINISHED_MSG]):
                done = True
                finished = True
                break
            if any([Journal.Search(a) for a in self.ATTACKED_MSG]):
                attacked = True
                break
        # print(f"{done}, {finished}, {attacked}")
        return done, finished, attacked
            
    def reEquipHands(self): # -> None
        Dress.ChangeList(self.WEAPON_DRESS)
        Dress.DressFStart()
        while Dress.DressStatus():
            Misc.Pause(100)

    def FishNote(self): # -> bool (depleted)
        if (not self.hasNote() and not self.hasSoS()) or not self.getFishPole():
            Player.HeadMessage(33, "No Note|SOS|Pole")
            return False

        # Unmount to fish.
        while Player.Mount:
            Mobiles.UseMobile(Player.Serial)
            Misc.Pause(600)

        # Hide
        if Player.Visible:
            Player.UseSkill("Hiding")
            Misc.Pause(300)
            
        while self.cleanJournal():
            self.fishSpot(Player.Position.X, Player.Position.Y +2)
            done, finished, attacked = self.waitForCast()
            if finished:
                Misc.Pause(600)
                return True
            if attacked:
                Misc.Pause(600)
                print(f"A: {attacked} | V: {Player.Visible}")
                if Player.Visible:
                    self.reEquipHands()
                    return False
        return True
            
            
# ============================================================================
def main():
    GetItemLock(__file__, wait=True, takeover=True)
    nf = NoteFisher()
    nf.FishNote()
    
if __name__ == "__main__":
    main()