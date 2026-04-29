from datetime import datetime
from collections import OrderedDict

my_pets = [
    0x001C4E5F, # self - for testing
    0x011C7009, # Eggplant (mule)
]

# Percent of HP to cast:
SACRED_BOON_THRESHOLD = 90.0
TOUCH_OF_LIFE_THRESHOLD = 90.0
BANDAGE_THRESHOLD = 80.0
SB_DURATION = 30.0 # Sacred Boon Duration

# Keep track of sacred boon timers (template)
#sacred_boon_timer = {
#    0x0000 : datetime.now
#}

def SacredBoon(pet):
    sb_timers = Misc.ReadSharedValue('sb_timers') or {}
    last = sb_timers.get(pet.Serial, None)
    now = int(datetime.now().timestamp())
    if not last or now - last > SB_DURATION:
        Player.ChatSay(77, '[cs sacredboon')
        Target.WaitForTarget(2500)
        Target.TargetExecute(pet)
        sb_timers[pet.Serial] = now
        Misc.SetSharedValue('sb_timers',sb_timers)

def TouchOfLife(pet):
    Player.ChatSay(77, '[cs touchoflife')
    Target.WaitForTarget(3500)
    Target.TargetExecute(pet)

def pet_hpp(pet): # -> float : pet HP Percent as float (clamped in increments of 4)
    return pet.Hits / pet.HitsMax * 100
    
def heal_pets():
    Player.HeadMessage(69, "Healing Pets")
    pets = [Mobiles.FindBySerial(pet) for pet in my_pets]
    pets = [pet for pet in pets if pet] # filter unfound.
    pet_prio = {pet: pet_hpp(pet) for pet in pets}
    pet_prio = OrderedDict(sorted(pet_prio.items(), key=lambda item: item[1], reverse=False))
    for pet in pets:
        while pet_hpp(pet) <= BANDAGE_THRESHOLD and Player.DistanceTo(pet) < 3:
            Player.ChatSay(77, '[band')
            Target.WaitForTarget(1000)
            Target.TargetExecute(pet)
            TouchOfLife(pet)
            Misc.Pause(2000)
        if pet_hpp(pet) <= TOUCH_OF_LIFE_THRESHOLD:
            TouchOfLife(pet)
        if pet_hpp(pet) <= SACRED_BOON_THRESHOLD:
            SacredBoon(pet)
    Player.HeadMessage(69, "Pet Heal Done")
        
def main():
    heal_pets()
    
if __name__ == "__main__":
    main()