// Treasure Dig - MultiMap
//   - Eremite
//
// Just need the target map in your main pack and a shovel
//   (or a tool house that contains shovels)
if not @findobject 'tmapbag' 'any' 'backpack' or not @findtype 0x14ec 'any' 'tmapbag' 'any' 1
  headmsg 'Select Treasure Map Bag' 69 'self'
  promptalias 'tmapbag'
endif
// Look for a shovel if we don't have one, else pull one from a tool house.
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
    @setalias 'shovel' 'found'
  else
    headmsg 'out of shovels?' 33 'self'
    stop
  endif
endif
// Find a trash4tokens bag
if not @findobject 'trashcan'
  @findtype 0x9b2 1173 'backpack' 'any' 0
  @setalias 'trashcan' 'found'
endif
// Dismount if we're riding:
if mounted 'self'
  @useobject 'self'
  pause 600
endif
// Discard any completed treasure maps.
@clearignorelist
while @findtype 0x14ec 'any' 'tmapbag' 'any' 1
  if @property 'Completed by' 'found'
    @moveitem 'found' 'trashcan'
  else
    ignoreobject 'found'
  endif
endwhile
// Loop through all treasure maps in the bag and try to dig.
@clearignorelist
while @findtype 0x14ec 'any' 'tmapbag' 'any' 1
  @clearjournal
  waitforcontext 'found' 1 1500
  waitfortarget 1500
  targettileoffset! 0 0 0
  pause 600
  if @injournal 'fail to find any treasure' 'system' or @injournal 'wrong facet' 'system'
    ignoreobject 'found'
    continue
  elseif @injournal 'standing on top of it' 'system'
    headmsg "Move, fatty." 33 'self'
    stop
  elseif @injournal 'already digging treasure' 'system'
    ignoreobject 'found'
    stop
  endif
endwhile
