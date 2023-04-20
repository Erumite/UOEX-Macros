//UOS
// Vesper Lockpicking Boxes Script
//   - Eremite
//
// Need lockpicks in your inventory (obviously)
// Hit the macro and it will look for a locked box within 1 tile.
//   If none is found, it will ask for the box you want to pick.
//   You can select an unlocked box and it will try to remove trap and'
//     run a looter against the box once it's safe.
//   Also works on boxes in inventory (Paragon Chests, Tokuno chest, etc)
// The first time you use the script, it will ask for the picks you want to use
//   - (if you run out of picks, it'll prompt again)
// It will also ask for your trash bag - this is the Trash 4 Tokens bag.
// You'll also need two Organizers:
//   - LootPickedBox       :  Items you want to keep (will go to your backpack)
//   - LootPickedBoxTrash  :  Items you want to trash for some free tokens.
//   - LootPickedBoxSell   :  Items to sell to vendors. (scrolls, gems, etc)
// I just build these as I go until eventually it's all auto-looted.
// If the trap fails to disarm after like 10-20 tries with no skillups, just double-click
//   the chest to pop the trap.  The script will notice it's not trapped and move on to loot.
//
//   Happy Lockpicking!
//
// List of Lockables
@removelist 'lockables'
if not @listexists 'lockables'
  @createlist 'lockables'
  @pushlist 'lockables' 0xe7c // Grey EW
  @pushlist 'lockables' 0x9ab // Gray NS
  @pushlist 'lockables' 0xe41 // Gray/Gold NS
  @pushlist 'lockables' 0xe40 // Gray/Gold EW
  @pushlist 'lockables' 0xe43 // Wood/Gold NS
  @pushlist 'lockables' 0xe42 // Wood/Gold EW
  @pushlist 'lockables' 0xe3e // Med Wood Crate WE
  @pushlist 'lockables' 0x9a9 // Small Wood Crate NS
  @pushlist 'lockables' 0xe3c // Big Wood Crate (Square)
  @pushlist 'lockables' 0xe7f // Keg
  @pushlist 'lockables' 0xe77 // Barrel
endif
// Look for a locked container within 1 tile.
// Seems glitchy in some areas for some reason.
@clearignorelist
@unsetalias 'box'
for 0 in 'lockables'
  while @findtype lockables[] 'any' 'ground' 'any' 1
    if @property 'Lock' 'found'
      headmsg 'Oi!' 69 'found'
      @setalias 'box' 'found'
      break
    else
      ignoreobject 'found'
    endif
  endwhile
endfor
// Ask the user for the box to pick if nothing on ground.
if not @findalias 'box'
  headmsg 'What should I pick?' 64
  promptalias 'box'
endif
// If no box defined, bail.
if not @findalias 'box'
  stop
endif
// If pick is missing or ran out, set the alias to something random and prompt till we
//   have a proper lockpick.  If you want to change lockpicks, uncomment the unsetalias
//   below and run the script again. (or have a different macro that does so)
//
// @unsetalias 'pick'
if not @findobject 'pick' 'any' 'backpack' 1
  setalias 'pick' 'box'
  while graphic 'pick' != 0x14fc
    headmsg "Which lockpicks?" 64
    promptalias 'pick'
  endwhile
endif
// Set the trash bag if not defined.
if not @findobject 'trash'
  if @findtype 0x9b2 1173 'backpack' 'any' 0
    setalias 'trash' 'found'
  else
    headmsg 'Trash can?' 64
    promptalias 'trash'
  endif
endif
// Set sell bag if not defined
if not @findobject 'sellbag'
  headmsg 'Sell bag?' 64
  promptalias 'sellbag'
endif
// Hacky boolean value for seeing when we're done.
@setalias 'working' 'box'
// Try to pick the chest.
while @findobject 'pick'
  if @findalias 'working'
    // If box isn't locked, we can skip picking.
    // (useful if interupted or for general looting of containers)
    if not @property 'Lock' 'box'
      @unsetalias 'working'
      break
    endif
    headmsg "*pick*" 43
    clearjournal
    useobject 'pick'
    waitfortarget 1000
    target! 'box'
    pause 1000
    if @injournal "does not appear to be locked"
      headmsg "It's not locked. :D"
      @unsetalias 'working'
    else
      pause 2500
    endif
    if @injournal 'cannot possibly pick this lock' 'system'
      headmsg "Too hard. :(" 34
      stop
    elseif @injournal 'you manage to open the lock with no effort' 'system' or @injournal 'no effort at all you successfully pick the lock'
      headmsg "Too Easy!" 64
      @unsetalias 'working'
    elseif @injournal "With the flick of your wrist the lock gives in" 'system'
      headmsg "Too Easy!" 64
      @unsetalias 'working'
    elseif @injournal 'you manage to unlock it nonetheless' 'system' or @injournal "you manage to pick the lock"
      headmsg "WooHoo!" 64
      @unsetalias 'working'
    elseif @injournal 'the lock yields' 'system' or @injournal 'the lock gives in' 'system'
      headmsg "WooHoo!" 64
      @unsetalias 'working'
    elseif @injournal 'you manage to pick the lock' 'system'
      headmsg "WooHoo!" 64
      @unsetalias 'working'
    elseif @injournal "You broke the lockpick"
      headmsg "%#$@!" 34
    elseif not @findalias 'pick'
      headmsg "Out of picks!" 34
      stop
    endif
  else
    break
  endif
endwhile
// Only successes above will unset this alias so we can continue to disarm.
if not @findalias 'working'
  @setalias 'working' 'box'
  while @findalias 'working'
    clearjournal
    useskill 'Remove Trap'
    waitfortarget 1500
    target! 'box'
    headmsg "*disarm*" 43
    pause 1000
    if @injournal "That doesn't appear to be trapped"
      headmsg "No Trap!" 64
      @unsetalias 'working'
    elseif @injournal 'You successfully render the trap harmless'
      headmsg "Safe!" 64
      @unsetalias 'working'
    elseif @injournal "replace this with the failed message of a trap exploding"
      headmsg "OUCH!" 34
      @unsetalias 'working'
    elseif @injournal "must wait a few moments to use another skill"
      pause 100
    else
      pause 10200
    endif
  endwhile
  headmsg "*looting*" 43
  pause 600
  // Box must be opened to run organizers on it.
  useobject 'box'
  pause 600
  organizer 'LootPickedBox' 'box' 'backpack'
  while organizing
    pause 100
  endwhile
  organizer 'LootPickedBoxTrash' 'box' 'trash'
  while organizing
    pause 100
  endwhile
  organizer 'LootPickedBoxSell' 'box' 'sellbag'
endif
headmsg "Done!" 64
