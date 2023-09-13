// Treasure Dig
//   - Eremite
//
// Just need the target map in your main pack and a shovel
//   (or a tool house that contains shovels)
// It'll use shovel, target the map, then target the ground at your feet.
if mounted 'self'
  @useobject 'self'
  pause 600
endif
if not @findobject 'shovel'
  if not @findtype 0xf39 'any' 'backpack' 'any' 1
    useobject 0x4635cfea
    waitforgump 1513449091 15000
    replygump 0x5a356683 60008
    waitforgump 1513449091 15000
    replygump 0x5a356683 0
    pause 1000
  endif
  if @findtype 0xf39 'any' 'backpack' 'any' 1
    @setalias 'shovel' 'found
  else
    headmsg 'out of shovels?' 33 'self'
    stop
  endif
endif
useobject 'shovel'
waitfortarget 1500
if findtype 0x14ec 'any' 'backpack' 'any' 0
  target! 'found'
  waitfortarget 1500
  targettileoffset 0 0 0
else
  headmsg "No map in main pack." 33 'self'
endif
pause 2000
