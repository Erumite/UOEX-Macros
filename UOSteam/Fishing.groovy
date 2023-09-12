// Fishing script (North/South)
//  - Eremite
//
// Get on a boat with a fishing pole in your pack, point the boat north (or south) with plenty of
//  space ahead of you, then hit Play.   Watch for AFK checks.
//
// If fishing pole is not set or if it breaks, find one.
if not @findobject 'fishrod'
  @findtype 0xdc0 'any' 'backpack' 'any' 0
  @setalias 'fishrod' 'found'
endif
// If no fishing rod was found, it might be equipped.  Check layer 1.
if not @findobject 'fishrod'
  @findlayer 'self' 1
  if @graphic 'found' == 0xdc0
    setalias 'fishrod' 'found'
  endif
endif
// If we don't have a bladed weapon to cut fish with, find a skinning knife.
if not @findobject 'bladed'
  @findtype 0xec4 'any' 'backpack' 'any' 1
  @setalias 'bladed' 'found'
endif
// Hide before continuing.  This is useful to avoid dying to serpents if you need to take a bio.
while not hidden
  @canceltarget
  useskill 'Hiding'
endwhile
// If the equipped item is NOT a fishing pole, move stuff in hands to backpack.
if @findlayer 'self' 1 and graphic 'found' != 0xdc0
  moveitem 'found' 'backpack'
  pause 1000
endif
if @findlayer 'self' 2
  moveitem 'found' 'backpack'
  pause 1000
endif
// Equip the fishing rod.
@equipitem 'fishrod' 1
pause 600
// Fishing - North  : Main Loop Start
@clearjournal
@unsetalias "seaserpent"
for 1000
  // If our fishing rod breaks, we also break this loop.
  if not @findobject 'fishrod'
    break
  endif
  useobject 'fishrod'
  waitfortarget 1000
  targettileoffset 6 0 0  // 6 tiles East
  pause 1000
  // Stop when we run out of fish or if the target is invalid.
  if @injournal "The fish don't seem to be biting here" "system" or @injournal "That would not work" "system"
    break
  else
    pause 6400
  endif
  // If we fish up a sea serpent, make a note of it so we kill it before moving forward.
  if @findtype 0x96 'any' 'ground' 'any' 15
    @setalias 'seaserpent' 'found'
    break
  endif
endfor
// If we found a serpent, then put on a Bow, consecrate to un-hide, then attack till all are dead.
if @findalias "seaserpent"
  @dress 'Bow'
  msg '[cs consecrateweapon'
  while @findtype 0x96 'any' 'ground' 'any' 15
    @attack 'found'
    pause 250
    while hits < 200
      msg '[bandself'
      pause 250
    endwhile
  endwhile
endif
// Heal up if we took some damage.
while hits < 200
    msg '[bandself'
    pause 500
endwhile
// Claim all bodies in the area
while @findtype 0x2006 'any' 'ground' 'any' 10
     msg '[claimall'
    waitfortarget 1000
    target! 'found'
    pause 200
endwhile
@canceltarget
// If our weight gets high, we do some item management.
//  All cuttable fish are chopped to steaks and stuffed into
//  the nearest ship hold.  Finally run "FishingJunk" organizer
//  to trash other items (buff fish, boots, etc)
if weight > 450
  if not @listexists 'fishies'
    @createlist 'fishies'
    @pushlist 'fishies' 0x9ce  // Purpley Fish.
    @pushlist 'fishies' 0x9cf  // Yellowy Fish
    @pushlist 'fishies' 0x9cc  // Green & Big Fish
    @pushlist 'fishies' 0x9cd  // GrayishBrown Fish
    @pushlist 'fishies' 0x2a4d // Redfish (Aquarium)
  endif
  if not @listexists 'shipholds'
    @createlist 'shipholds'
    @pushlist 'shipholds' 0x3eae // N/S Orientation
  endif
  if not @findobject 'shiphold' 'any' 'ground' 'any' 2
    for 0 in 'shipholds'
      if @findtype shipholds[] 'any' 'ground' 'any' 2
        @setalias 'shiphold' 'found'
        break
      endif
    endfor
  endif
  for 0 in fishies
    while @findtype fishies[] 'any' 'backpack' 'any' 0
      useobject 'bladed'
      waitfortarget 1500
      target! 'found'
      pause 600
    endwhile
  endfor
  if @findobject 'shiphold'
    organizer 'FishToHold' 'backpack' 'shiphold'
    while organizing
      pause 100
    endwhile
  else
    headmsg "No Shiphold Found!" 33
  endif
  organizer "FishingJunk"
endif
// Move foward if we didn't break for a sea serpent.
if not @findalias 'seaserpent'
    msg "slow forward"
    useskill 'Hiding'
    pause 10000
    msg "stop"
    pause 600
    useskill 'Hiding'
endif
