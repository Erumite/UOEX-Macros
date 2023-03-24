// Potion Dump - Eremite
//
// When hunting, we get a lot of crappy potions that can be trashed.
//  Might as well use up as many as possible before trashing to get
//  some free empty bottles and reduce item count in backpack.
// This doesn't look deeper than the base backpack, so good potions can
//  be kept in a sub-container to avoid being used/trashed.
//
// Drink all the poisons, lol.
while @findtype 0xf0a 'any' 'backpack' 'any' 0
  useobject 'found'
endwhile
// Use up existing junk potions.
if not listexists 'junkpotions'
  @createlist 'junkpotions'
  @pushlist 'junkpotions' 0xf08 // Agility
  @pushlist 'junkpotions' 0xf09 // Strength
endif
for 0 in 'junkpotions'
  while @findtype junkpotions[] 'any' 'backpack' 'any' 0
    useobject 'found'
  endwhile
endfor
// Drink all the cures if poisoned.
while poisoned and @findtype 0xf07 'any' 'backpack' 'any' 0
  useobject 'found'
endwhile
// If no cures found or still poisoned, cure it first:
while poisoned
  msg '[cs purge'
  waitfortarget 1500
  target! 'self'
endwhile
// Use heals if HP low
while @findtype 0xf0c 'any' 'backpack' 'any' 0 and hits < maxhits
  useobject 'found'
endwhile
// Use refresh potions if stam low:
while @findtype 0xf0b 'any' 'backpack' 'any' and stam < maxstam
  useobject 'found'
endwhile
// Trash any leftover potions that aren't useful.
@removelist 'trashpotions'
@createlist 'trashpotions'
@pushlist 'trashpotions' 0xf0c // Heals
@pushlist 'trashpotions' 0xf07 // Cure
@pushlist 'trashpotions' 0xf0b // Refresh
if not @findobject 'trashcan'
  @findtype 0x9b2 1173 'backpack' 'any' 0
  @setalias 'trashcan' 'found'
endif
for 0 in 'trashpotions'
  while @findtype trashpotions[] 'any' 'backpack' 'any' 0
    moveitem 'found' 'trashcan'
  endwhile
endfor
