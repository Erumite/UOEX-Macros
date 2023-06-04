// Runebook Mining
//   - Eremite
//
// https://www.uoex.net/forum/viewtopic.php?f=39&t=14281 
//
// Loop through all runebooks in a bag
//   (preferably a Blessed Item Pouch/etc)
// Recall to each position in the books,
//  mine the ground until all resources are
//  depleted before continuing.
//
// Find a shovel to use:
if not @findobject 'shovel'
  if @findtype 0xf39 'any' 'backpack' 'any' 2
    @setalias 'shovel' 'found'
  else
    headmsg 'No Shovel' 33 'self'
    stop
  endif
endif
// Find Mobile Forge & Metal Keys
@unsetalias 'smeltandkey'
@unsetalias 'fillresourcebag'
if not @findobject 'mobileforge'
  if @findtype 0xe32 1161 'backpack' 'any' 2
    setalias 'mobileforge' 'found'
  endif
endif
if not @findobject 'metalkeys'
  if @findtype 0x176b 20 'backpack' 'any' 2
    setalias 'metalkeys' 'found'
  endif
endif
// Else look for a resourcebag to move ores into if no keys/forge
if not @findobject 'mobileforge' and not @findobject 'metalkeys'
  @clearignorelist
  if not @findobject 'resourcebag'
    while @findtype 0xe76 2207 'backpack' 'any' 2
      if @property 'Always Weighs 100 Stones' 'found'
        @setalias 'resourcebag' 'found'
        break
      endif
      @ignoreobject 'found'
    endwhile
  endif
endif
// If we have a forge + keys, smelt and put into keys.
// Else if we have a resource bag, move ores into it.
// If we have neither, just exit as you'll run out of weight.
if @findobject 'mobileforge' and @findobject 'metalkeys'
  @setalias 'smeltandkey' 'self'
elseif @findobject 'resourcebag'
  @setalias 'fillresourcebag' 'self'
else
  headmsg 'No Forge+Keys or Resource Bag' 55 'self'
  stop
endif
// Prompt for runebook pouch & exit if not defined.
headmsg 'Runebook Pouch?' 69 'self'
promptalias 'runebookpouch'
if not @findobject 'runebookpouch'
  stop
endif
// Build a list of runebooks in the bag.
@removelist 'runebooks'
@createlist 'runebooks'
@clearignorelist
while @findtype 0x22c5 'any' 'runebookpouch' 'any' 0
  @pushlist 'runebooks' 'found'
  headmsg 'ping' 55 'found'
  @ignoreobject 'found'
endwhile
// Create a list with 16 slots for each in the runebook for looping.
//  First "Sacred Journey" button is 7, Second is 17, etc:
if not @listexists 'runebookslots'
  @createlist 'runebookslots'
  @pushlist 'runebookslots' 7
  @pushlist 'runebookslots' 17
  @pushlist 'runebookslots' 27
  @pushlist 'runebookslots' 37
  @pushlist 'runebookslots' 47
  @pushlist 'runebookslots' 57
  @pushlist 'runebookslots' 67
  @pushlist 'runebookslots' 77
  @pushlist 'runebookslots' 87
  @pushlist 'runebookslots' 97
  @pushlist 'runebookslots' 107
  @pushlist 'runebookslots' 117
  @pushlist 'runebookslots' 127
  @pushlist 'runebookslots' 137
  @pushlist 'runebookslots' 147
  @pushlist 'runebookslots' 157
endif
for 0 in runebooks
  for 0 in runebookslots
    // Sacred Journey to the current slot in current runebook:
    pause 600
    @useobject runebooks[]
    waitforgump 'any' 5000
    replygump 'any' runebookslots[]
    pause 3000
    // Mine until the metal runs out (or if the mining spot is invalid)
    @clearjournal
    while not @injournal 'no metal here to mine' and not @injournal "can't mine there"
      @useobject 'shovel'
      waitfortarget 5000
      targettileoffset! 0 0 0
    endwhile
    // Smelt all ores in pack if mobileforge is found.
    // Else move to resource bag if we have one.
    // Do backpack first, then check for any overflow on the ground.
    if @findobject 'smeltandkey'
      while @findtype 0x19b9 'any' 'backpack' 'any' 0
        useobject 'found'
        waitfortarget 1000
        target! 'mobileforge'
        pause 600
      endwhile
      while @findtype 0x19b9 'any' 'ground' 'any' 1
        useobject 'found'
        waitfortarget 1000
        target! 'mobileforge'
        pause 600
      endwhile
    elseif @findobject 'fillresourcebag'
      while @findtype 0x19b9 'any' 'backpack' 'any' 0
        moveitem 'found' 'resourcebag'
      endwhile
      while @findtype 0x19b9 'any' 'ground' 'any' 0
        moveitem 'found' 'resourcebag'
      endwhile
    endif
    // If weight is getting high and we're using keys, then we add all the ingots.
    // Weight may need adjusting based on your backpack upgrades.
    if @findobject 'smeltandkey' and weight > 500
      pause 600
      @useobject 'metalkeys'
      waitforgump 4213074123 1500
      replygump 0xfb1e68cb 60015
      waitfortarget 5000
      while @findtype 0x1bf2 'any' 'backpack' 'any' 0
        target! 'found'
        waitfortarget 5000
      endwhile
      replygump 0xfb1e68cb 0
    endif
  endfor
endfor
