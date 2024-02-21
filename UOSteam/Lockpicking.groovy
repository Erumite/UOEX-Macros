//UOS
// Lockpicking Boxes Script (And looter)
//   - Eremite
//
//    Need lockpicks in your inventory (obviously)
// It will prmopt you to select them if the alias isn't set yet.
//
// Running the macro also will do a color-coded headmsg of all chests in the area
//   with locks or items inside.  Useful to scan the area for lootable boxes.
//
// Hit the macro and it will look for a locked box within 1 tile.
//   If none is found, it will ask for the box you want to pick.
//   You can select an unlocked box and it will try to remove trap (if enabled below) and
//        run a looter against the box once it's safe.
//
// Also works on boxes in inventory (Paragon Chests, Tokuno chest, etc)
// If it's a select box type in inventory (swamp box, etc), it will move it to
//   your trash can once it has been looted.
// It will also perform different looting logic on inventory boxes, using spell/gem keys
//   instead of moving items one at a time as it's significantly faster.
//
//   Will also keep track of the most recently untrapped "safe" box so interrupted
//    looting (from tmap spawns, etc) don't have you waiting for skill cooldown.
//
// The first time you use the script, it will ask for the picks you want to use
//   - (if you run out of picks, it'll prompt again)
//
// It will also ask for your trash bag - this is the Trash 4 Tokens bag.
// You'll also need a few Organizers:
//   - LootPickedBox       :  Items you want to keep (will go to your backpack)
//   - LootPickedBoxTrash  :  Items you want to trash for some free tokens.
//   - LootPickedBoxSell   :  Items to sell to vendors. (scrolls, gems, etc)
// I just build these as I go until eventually it's all auto-looted.
// 
// If the trap fails to disarm after like 10-20 tries with no skillups, just double-click
//   the chest to pop the trap.  The script will notice it's not trapped and move on to loot.
//
//   Happy Lockpicking!
//
// If we have a holding bag, move gold into it first for weight.
// This is set manually for now - this is mine so it will likely not find it
//  and default to looting gold to inventory with organizers.
@setalias 'holdingbag' 0x412d8c13
// Comment out the setalias commands to skip remove trap.
//   skipremovetrap: If not set, then it skips removing trap entirely.
//   skipremovetrapatmax : If not set, then it will only remove trap when under 120 skill.
@unsetalias 'skipremovetrap'
@unsetalias 'skipremovetrapatmax'
// @setalias 'skipremovetrap' 'self'
@setalias 'skipremovetrapatmax' 'self'
// Find Gem Pouch
if not @findobject 'gempouch'
  if @findtype 0xe79 2165 'backpack' 'any' 2
    @setalias 'gempouch' 'found'
  endif
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
// List of Lockables to look for.
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
// Scan all lockable items within 20 tiles - if the target is
//  within 1 tile, set the 'box' alias to target it without
//  prompting for a target.  Also display headmsg of lock type/etc.
@clearignorelist
@unsetalias 'box'
for 0 in 'lockables'
  while @findtype lockables[] 'any' 'ground' 'any' 20
    @unsetalias 'ignoreme'
    if @property 'Agapite Lock' 'found'
      headmsg '=(Agapite)=' 46 'found'
    elseif @property 'Bronze Lock' 'found'
      headmsg '=(Bronze)=' 444 'found'
    elseif @property 'Blaze Lock' 'found'
      headmsg '=(Blaze)=' 39 'found'
    elseif @property 'Shadow Iron Lock' 'found'
      headmsg '=(S.Iron)=' 999 'found'
    elseif @property 'Gold Lock' 'found'
      headmsg '=(Gold)=' 53 'found'
    elseif @property 'Valorite Lock' 'found'
      headmsg '=(Valorite)=' 91 'found'
    elseif @property 'Verite Lock' 'found'
      headmsg '=(Verite)=' 61 'found'
    elseif @property 'Toxic Lock' 'found'
      headmsg '=(Toxic)=' 69 'found'
    elseif @property 'Ice Lock' 'found'
      headmsg '=(Ice)=' 88 'found'
    elseif @property 'Platinum Lock' 'found'
      headmsg '=(Platinum)=' 2442 'found'
    elseif @property 'Lock' 'found'
      headmsg '=(^_^)=' 68 'found'
    elseif @property "0 Items, 0 Stones" 'found' and @property "Items, " 'found'
      @setalias 'ignoreme' 'found'
      // No Message if the box is empty and is an actual container (not deco)
    elseif @property "0/" 'found' and @property "Items, " 'found'
      @setalias 'ignoreme' 'found'
      // No Message - This is for items with like: (0/125 Items, 0 Stones)
    elseif @property "Items, " "found"
      headmsg '=(Items)=' 69 'found'
    endif
    if @inrange 'found' 1 and not @findalias 'ignoreme'
      setalias 'box' 'found'
    endif
    @ignoreobject 'found'
  endwhile
endfor
// If no box in range, prompt to target a box.
if not @findalias 'box'
  headmsg 'What should I pick?' 64
  promptalias 'box'
endif
// If no box defined, bail.
if not @findalias 'box'
  stop
else
  headmsg "!!!" 69 'box'
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
// If we're skipping remove trap, mark the box as "safe" anyway.
// If we skip Remove Trap at max skill and are at 120, do the same.
// Otherwise if we can't find the last safe box, set it to self so
//   we can compare serials later.
if @findalias 'skipremovetrap'
  @setalias 'safebox' 'box'
elseif @findalias 'skipremovetrapatmax' and @skill 'Remove Trap' == 120
  @setalias 'safebox' 'box'
elseif not @findobject 'safebox'
  @setalias 'safebox' 'self'
endif
if not @findalias 'working'
  while serial 'safebox' != serial 'box'
    clearjournal
    useskill 'Remove Trap'
    waitfortarget 1500
    target! 'box'
    headmsg "*disarm*" 43
    pause 1000
    if @injournal "That doesn't appear to be trapped"
      headmsg "No Trap!" 64
      @setalias 'safebox' 'box'
    elseif @injournal 'You successfully render the trap harmless'
      headmsg "Safe!" 64
      @setalias 'safebox' 'box'
    elseif @injournal "replace this with the failed message of a trap exploding"
      headmsg "OUCH!" 34
      @setalias 'safebox' 'box'
    elseif @injournal "must wait a few moments to use another skill"
      pause 100
    else
      pause 10200
    endif
  endwhile
  if not @property '0 items, 0 stones' 'box'
    // Have to pop the trap before opening if we skipped
    if @findalias 'skipremovetrap'
      headmsg "*popping trap*" 33
      pause 600
      useobject 'box'
    elseif @findalias 'skipremovetrapatmax' and @skill 'Remove Trap' == 120
      headmsg "*popping trap*" 33
      pause 600
      useobject 'box'
    endif
    headmsg "*looting*" 43
    pause 600
    // Box must be opened to run organizers on it.
    useobject 'box'
    pause 600
    if @findobject 'holdingbag' 'any' 'backpack' 'any'
      while @findtype 0xeed 'any' 'box' 'any' 1
        moveitem 'found' 'holdingbag'
      endwhile
    endif
    while organizing
      organizer 'stop'
      pause 300
    endwhile
    if @findobject 'gempouch'
      if @findobject 'box' 'any' 'backpack' 'any'
        sysmsg 'box in backpack' 69
        if not @listexists 'pouchgems'
          createlist 'pouchgems'
          pushlist 'pouchgems' 0xf2d // Tourmaline
          pushlist 'pouchgems' 0xf16 // Amethyst
          pushlist 'pouchgems' 0xf19 // Sapphire
          pushlist 'pouchgems' 0xf21 // Star Sapphire
          pushlist 'pouchgems' 0xf26 // Diamond
          pushlist 'pouchgems' 0xf10 // Emerald
          pushlist 'pouchgems' 0xf13 // Ruby
          pushlist 'pouchgems' 0xf25 // Pice of Amber
          pushlist 'pouchgems' 0xf15 // Citrine
          pushlist 'pouchgems' 0x1ea7 // Arcane Gem
        endif
        @unsetalias 'dopouchgems'
        for 0 in 'pouchgems'
          if @findtype pouchgems[] 'any' 'box' 'any' 1
            @setalias 'dopouchgems' 'found'
            break
          endif
        endfor
        if @findobject 'dopouchgems'
          pause 600
          useobject 'gempouch'
          waitforgump 309845371 1500
          replygump 0x1277dd7b 30
          waitforgump 309845371 1500
          for 0 in 'pouchgems'
            while @findtype pouchgems[] 'any' 'box' 'any' 1
              target! 'found'
              waitfortarget 1500
            endwhile
          endfor
          replygump 0x1277dd7b 0
        endif
        @canceltarget
        if not @listexists 'keyreagents'
          createlist 'keyreagents'
          pushlist 'keyreagents' 0xf7a  // Black Pearl
          pushlist 'keyreagents' 0xf7b  // Bloodmoss
          pushlist 'keyreagents' 0xf84  // Garlic
          pushlist 'keyreagents' 0xf85  // Ginseng
          pushlist 'keyreagents' 0xf86  // Mandrake Root
          pushlist 'keyreagents' 0xf88  // Nightshade
          pushlist 'keyreagents' 0xf8d  // Spider's Silk
          pushlist 'keyreagents' 0xf8c  // Sulfurous Ash
          pushlist 'keyreagents' 0xf78  // Bat Wings
          pushlist 'keyreagents' 0xf7e  // Bone
          pushlist 'keyreagents' 0xf7d  // Daemon's Blood
          pushlist 'keyreagents' 0xf8f  // Grave Dust
          pushlist 'keyreagents' 0xf8e  // Nox Crystals
          pushlist 'keyreagents' 0xf8a  // Pig Iron
          pushlist 'keyreagents' 0xf81  // Fertile Dirt
          pushlist 'keyreagents' 0xf0e  // Empty Bottle
          pushlist 'keyreagents' 0xef3  // Blank Scrolls
          pushlist 'keyreagents' 0x1f14 // Recall Rune
          pushlist 'keyreagents' 0x26b7 // Zoogi Fungus
          pushlist 'keyreagents' 0xf8f  // Ethereal Powder
          pushlist 'keyreagents' 0xf80  // Daemon Bone
          pushlist 'keyreagents' 0xe1f  // Destroying Angel
          pushlist 'keyreagents' 0x97a  // Petrified Wood
          pushlist 'keyreagents' 0x26b8 // Powder of Translocation
        endif
        @unsetalias 'dokeyregs'
        for 0 in 'keyreagents'
          if @findtype keyreagents[] 'any' 'box' 'any' 0
            @setalias 'dokeyregs' 'found'
            break
          endif
        endfor
        if @findobject 'dokeyregs'
          pause 600
          useobject 'spellkeys'
          waitforgump 247257139 1000
          replygump 0xebcd833 60030
          waitforgump 247257139 1500
          for 0 in 'keyreagents'
            while @findtype keyreagents[] 'any' 'box' 'any' 0
              target! 'found'
              waitfortarget 1500
            endwhile
          endfor
          replygump 0xebcd833 0
        endif
        @canceltarget
      else
        organizer 'LootPickedBoxGems' 'box' 'gempouch'
        while organizing
          pause 100
        endwhile
      endif
    endif
    organizer 'LootPickedBox' 'box' 'backpack'
    while organizing
      pause 100
    endwhile
    organizer 'LootPickedBoxTrash' 'box' 'trash'
    while organizing
      pause 100
    endwhile
    @setalias 'holdingsell' 0x4278eb00
    organizer "BOHSell" 'box' 'holdingsell'
    while organizing
      pause 100
    endwhile
    organizer 'LootPickedBoxSell' 'box' 'sellbag'
  endif
  headmsg "Done!" 64
endif
// If the box is empty, try to remove chest via context menu (tmaps)
// Otherwise if it's a swamp box and empty, move to trash.
if @property '0 items, 0 stones' 'box' and not @property "Pulled From A Swamp" 'box'
  waitforcontext 'box' 0 15000
  waitforgump 3372031655 15000
  replygump 0xc8fd1ea7 1
elseif @property "Pulled From A Swamp" 'box' and @property '0 items, 0 stones' 'box'
  pause 600
  moveitem 'box' 'trash'
endif
