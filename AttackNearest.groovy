// Find and attack closest enemy.
@cleartargetqueue
@getenemy 'criminal' 'enemy' 'murderer' 'gray' 'closest'
@attack 'enemy'
// Have pet attack also - only works for one pet.
// Uses context menus to avoid spamming chat messages.
// Since a pet told to "attack" will not follow afterward,
//  it will tell the pet to "guard" if you are not in war mode
//  or if you are in war mode with no enemies nearby.
if not @findobject 'mypet' 'any' 'ground' 'any'
  if @getfriend 'friend' 'nearest'
    @setalias 'mypet' 'friend'
  endif
endif
if @findobject 'mypet' 'any' 'ground' 'any' 20
  if war 'self' and @findobject 'enemy' 'any' 'ground' 'any'
    // Attack the target
    @waitforcontext 'mypet' 3 1500
    waitfortarget 1500
    target! 'enemy'
  elseif war 'self' and not @findobject 'enemy' 'any' 'ground' 'any'
    // Guard
    @waitforcontext 'mypet' 0 1500
  else
    // Guard
    @waitforcontext 'mypet' 0 1500
  endif
endif
// Budget WhirlWind
if mana > 30
  cast 'Momentum Strike'
endif
// Consecrate & Confidence
if not timerexists 'consecratetimer'
  @settimer 'consecratetimer' 9001
endif
if not @timerexists 'confidencetimer'
  @settimer 'confidencetimer' 19999
endif
if timer 'consecratetimer' > 8000
  cast 'Consecrate Weapon'
  @settimer 'consecratetimer' 0
  pause 1000
elseif timer 'confidencetimer' > 12500
  cast 'Confidence'
  @settimer 'confidencetimer' 0
  pause 1000
endif
// Discord Target
useskill 'Discordance'
waitfortarget 1500
target! 'enemy'
// Organize on the fly.
if not organizing
  if @findalias 'orgtoggle'
    @organizer 'BushidoChop'
    @unsetalias 'orgtoggle'
  else
    @organizer 'Trash4Tokens'
    @setalias 'orgtoggle' 'self'
  endif
endif
// Check Durability and put up a headmsg if anything's below 15.
//  Doesn't check slots with no durability (jewelry, etc)
@findlayer 'self' 1
if @property 'Durability' 'found' < 15
  headmsg "*REPAIR WEAPON R*" 33
endif
@findlayer 'self' 2
if @property 'Durability' 'found' < 15
  headmsg "*REPAIR WEAPON L*" 33
endif
@findlayer 'self' 6
if @property 'Durability' 'found' < 15
  headmsg "*REPAIR HELM*" 33
endif
@findlayer 'self' 7
if @property 'Durability' 'found' < 15
  headmsg "*REPAIR GLOVES*" 33
endif
@findlayer 'self' 10
if @property 'Durability' 'found' < 15
  headmsg "*REPAIR NECK*" 33
endif
@findlayer 'self' 12
if @property 'Durability' 'found' < 15
  headmsg "*REPAIR WAIST*" 33
endif
@findlayer 'self' 13
if @property 'Durability' 'found' < 15
  headmsg "*REPAIR Inner Torso*" 33
endif
@findlayer 'self' 17
if @property 'Durability' 'found' < 15
  headmsg "*REPAIR Middle Torso*" 33
endif
@findlayer 'self' 19
if @property 'Durability' 'found' < 15
  headmsg "*REPAIR ARMS*" 33
endif
@findlayer 'self' 22
if @property 'Durability' 'found' < 15
  headmsg "*REPAIR Outer Torso*" 33
endif
@findlayer 'self' 23
if @property 'Durability' 'found' < 15
  headmsg "*REPAIR Outer Legs*" 33
endif
@findlayer 'self' 24
if @property 'Durability' 'found' < 15
  headmsg "*REPAIR Inner Legs*" 33
endif
