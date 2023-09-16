// Treasure Map Digger
//   - Eremite
//
// Will search your main pack for a treasure map and dig at your feet.
//   - If a completed map is found, it's moved to your trash4tokens bag.
//   - If no shovel is found, it'll try to remove one from a toolhouse (if it exists)
//   - Dismounts before digging so your pet can help. Comment out if unwanted.
//
@clearignorelist
// Find a trash4tokens bag
if not @findobject 'trashcan'
  @findtype 0x9b2 1173 'backpack' 'any' 0
  @setalias 'trashcan' 'found'
endif
// Find a Tool House if we have one:
if not @findalias 'toolhouse' or not @findobject 'toolhouse' 69 'backpack' 'any'
  if @findobject 0x22c4 69 'backpack' 'any' 2
    @setalias 'toolhouse' 'found'
  endif
endif
// Discard any completed treasure maps.
@clearignorelist
while @findtype 0x14ec 'any' 'backpack' 'any' 0
  if @property 'Completed by' 'found'
    @moveitem 'found' 'trashcan'
  else
    ignoreobject 'found'
  endif
endwhile
// Dismount if we're riding.
if mounted 'self'
  @useobject 'self'
  pause 600
endif
// Find a shovel in backpack (or one deep)
//  If none found, try to pull one from a tool house.
if not @findobject 'shovel'
  if not @findtype 0xf39 'any' 'backpack' 'any' 1 and @findalias 'toolhouse'
    useobject 'toolhouse'
    waitforgump 1513449091 15000
    replygump 0x5a356683 60008
    waitforgump 1513449091 15000
    replygump 0x5a356683 0
    pause 1000
  endif
  if not @findtype 0xf39 'any' 'backpack' 'any' 1
    headmsg 'No Shovel?' 33 'self'
    stop
  endif
endif
@clearignorelist
// Use map and target ground beneath us if one is found.
if findtype 0x14ec 'any' 'backpack' 'any' 0
  waitforcontext 'found' 1 1500
  waitfortarget 1500
  targettileoffset 0 0 0
else
  headmsg "No map in main pack." 33 'self'
endif
