// Copy a Runebook - https://www.uoex.net/forum/viewtopic.php?f=39&t=14282
//  - Eremite
//
// Find Spell Keys for a rune source:
//  Optionally hard-code the spell keys (faster)
@setalias 'spellkeys' 0x42197127
if not @findobject 'spellkeys'
  if @findtype 0x176b 33 'backpack' 'any' 2
    @setalias 'spellkeys' 'found'
  else
    headmsg 'Select Spell Keys' 69 'self'
    promptalias 'spellkeys'
  endif
endif
// Set the source and target runebooks with prompt
@unsetalias 'sourcebook'
@unsetalias 'newbook'
headmsg 'Select Source Runebook' 69 'self'
promptalias 'sourcebook'
headmsg '(source)' 69 'sourcebook'
headmsg 'Select New Runebook' 69 'self'
promptalias 'newbook'
headmsg '(target)' 69 'newbook'
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
// Make sure we have 16 runes in our backpack.
if @counttype 0x1f14 0 'backpack' < 16
  useobject 'spellkeys'
  waitforgump 247257139 1500
  while @counttype 0x1f14 0 'backpack' < 16
    replygump 0xebcd833 60026
    waitforgump 247257139 1500
  endwhile
endif
// Loop through sacred journey to each slot in the list, 
//   mark a rune, prompt for rune name name, move to new book.
for 0 in runebookslots
  if @findtype 0x1f14 0 'backpack' 'any' 0
    setalias 'markrune' 'found'
  else
    headmsg 'OUT OF RUNES' 33 'self'
    stop
  endif
  pause 600
  @useobject 'sourcebook'
  waitforgump 'any' 1500
  replygump 'any' runebookslots[]
  pause 3000
  msg '[cs mark'
  waitfortarget 6000
  target! 'markrune'
  pause 1000
  // Hide for giggles just in case.
  msg '[skill hiding'
  pause 600
  // UOSteam Limitations - Can't get the name from the old book so it would need to be
  //  entered manually each time.
  useobject 'markrune'
  headmsg 'Enter the rune name' 69 'self'
  @clearjournal
  while not @injournal 'The etching on the rune has been changed.' 'system'
    pause 500
  endwhile
  moveitem 'markrune' 'newbook' 65535 65535 0
  // Runebook Cooldown
  pause 10000
endfor
