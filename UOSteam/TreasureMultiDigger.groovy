// Treasure Dig - MultiMap
//   - Eremite
//
// Add all your treasure maps to a single bag/pouch in your main inventory and select
//  it when prompted.  It will loop through all of them and try to dig at your feet.
//  Will warn if you (or an entity) is standing on top of the treasure.
//  Will try to pull a shovel from your toolhouse if you have one.
//  Dismounts before digging so your pet can help with the mobs that spawn. (comment out if unwanted)
//  Auto trash completed maps if you have a trash4tokens bag.
//
//  I found this useful before getting a treasure map book as you can sort maps by region
//   in different bags manually, then just pick up that bag and go to the area to do a sweep.
//
// Prompt for treasure map bag if it's missing or existing one has no maps inside.
if not @findobject 'tmapbag' 'any' 'backpack' or not @findtype 0x14ec 'any' 'tmapbag' 'any' 1
  headmsg 'Select Treasure Map Bag' 69 'self'
  promptalias 'tmapbag'
endif
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
// Look for a shovel if we don't have one, else pull one from a tool house.
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
    headmsg 'out of shovels?' 33 'self'
    stop
  endif
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
  elseif @injournal 'standing on top of it' 'system' or @injournal 'something is keeping it from being dug up'
    headmsg "Move, fatty." 33 'self'
    pause 1000
  elseif @injournal 'already digging treasure' 'system'
    ignoreobject 'found'
    stop
  endif
endwhile
headmsg 'No Map Here' 69 'self'
@clearignorelist
