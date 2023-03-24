// Recycling Script - Eremite
// 
// Welcome to the [claimall life.
// This is essentially an inventory sorter that will handle most everything in your
//  pack after doing [claimall on a bunch of bodies.
// Tried to optimize for speed as much as possible, but it can be quite slow.
//  Particularly the scissoring of tailoring items, sorting, etc.
//
// This will require some manual setup of Organizers before it will work properly.
// I considered hard-coding, but doing so makes it more difficult for people to modify
//  the organizing to fit their needs.  Organizers needed:
//   * Trash4Tokens - Anything you want to trash to the token bag.
//   * ChopItems    - Any junk that should always be chopped/smelted.
//   * LootToSellBag- Any stuff you want to keep (scrolls, etc)
//   * stop         - Empty organizer used to stop any current organizing.
//
// Recommended Items:
//  * Recycle Container- Any pouch/bag/etc for it to move recyclable stuff to for chopping/smelting.
//  * Trash4Tokens Bag - Get tokens for trash that can't be recycled.
//  * Various Resource Keys, pouches, holders:
//    * Spell Keys, Tailor Keys, Wood Keys, Metal Keys, Gem Pouch, Tool House
//  * Bag of Holding   - Very expensive, but dumping gold into here is really nice for weight management.

// Can hard code the alias here if preferred
//  Can also set it to anything if you don't have the item.
@setalias 'recyclebag' 0x41a15e99
@setalias 'tokenbag' 0x41a15e96
@setalias 'spellkeys' 0x42197127
@setalias 'tailorkeys' 0x4408d37c
@setalias 'woodkeys' 0x4781065e
@setalias 'metalkeys' 0x4356a885
@setalias 'gempouch' 0x455ce42e
@setalias 'mobileforge' 0x407e65b2
@setalias 'toolhouse' 0x4635cfea
@setalias 'holdingbag' 0x412d8c13
// Set the token bag alias
if not @findobject 'recyclebag'
  headmsg "Select Recycle Bag"
  promptalias 'recyclebag'
endif
// Set to the portable trash bag thing.
if not @findobject 'tokenbag'
  headmsg "Select Trash4Token Bag"
  promptalias 'tokenbag'
endif
// Set Spell Keys for holding reagents
if not @findobject 'spellkeys'
  headmsg "Select Spell Keys"
  promptalias 'spellkeys'
endif
// Set Various Keys if not found.
if not @findobject 'tailorkeys'
  headmsg "Select Tailor Keys"
  promptalias 'tailorkeys'
endif
if not @findobject 'woodkeys'
  headmsg "Select Woodworker Keys"
  promptalias 'woodkeys'
endif
if not @findobject 'metalkeys'
  headmsg "Select Metal Worker Keys"
  promptalias 'metalkeys'
endif
if not @findobject 'gempouch'
  headmsg "Select Gem Pouch"
  promptalias 'gempouch'
endif
if not @findobject 'mobileforge'
  headmsg 'Select Mobile Forge'
  promptalias 'mobileforge'
endif
if not @findobject 'toolhouse'
  headmsg 'Select Tool House'
  promptalias 'toolhouse'
endif
// Remove all lists while testing/building
// Can be removed once the list is finalized.
//@removelist 'smeltables'
//@removelist 'scissorables'
//@removelist 'fletchables'
//@removelist 'carpenterchop'
//@removelist 'keyreagents'
//@removelist 'keycloths'
//@removelist 'keywood'
//@removelist 'keymetals'
//@removelist 'pouchgems'
//@removelist 'smeltores'
@removelist 'tools'
@removelist 'bohitems'
// Stop organizing if one's running
if organizing
  organizer 'stop'
endif
// Add all reagents to spell caster's keys if they're in top level of backpack
//  Should ignore anything in a reagent bag in inventory.
//  Do this first as it typically opens up a lot of inventory space.
//   Bones from chopping bone armor may get left behind, but that's fine.
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
  pushlist 'keyreagents' 0x26b7 // Zoogi Fungus
endif
headmsg "*spell keys*"
@unsetalias 'dokeyregs'
for 0 in 'keyreagents'
  if @findtype keyreagents[] 'any' 'backpack' 'any' 0
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
    while @findtype keyreagents[] 'any' 'backpack' 'any' 0
      target! 'found'
      waitfortarget 1500
    endwhile
  endfor
  replygump 0xebcd833 0
endif
@canceltarget
// Gem Pouch -- Near top since it's fast and chopping stuff doesn't produce gems.
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
endif
@unsetalias 'dopouchgems'
for 0 in 'pouchgems'
  if @findtype pouchgems[] 'any' 'backpack' 'any' 1
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
    while @findtype pouchgems[] 'any' 'backpack' 'any' 1
      target! 'found'
      waitfortarget 1500
    endwhile
  endfor
  replygump 0x1277dd7b 0
endif
@canceltarget
// Add any tools to tool house if they're in the main backpack.
if not @listexists 'tools'
  @createlist 'tools'
  pushlist 'tools' 0xe86  // Pickaxe
  pushlist 'tools' 0xf39  // Shovel
  pushlist 'tools' 0xe9b  // Mortar and Pestle
  pushlist 'tools' 0xfbf  // Scribe's Pen
  pushlist 'tools' 0xf9d  // Sewing Kit
  pushlist 'tools' 0x13e4 // Smith's Hammer
  pushlist 'tools' 0x1022 // Fletching Tools
  pushlist 'tools' 0xf43  // Hatchet
  pushlist 'tools' 0x1eb8 // Tinker Tools
  pushlist 'tools' 0x1373 // Pet Brush
  pushlist 'tools' 0x102a // Carp Hammer
  pushlist 'tools' 0x1034 // Saw

endif
@unsetalias 'dotoolhouse'
for 0 in 'tools'
  if @findtype tools[] 'any' 'backpack' 'any' 0
    @setalias 'dotoolhouse' 'self'
  endif
endfor
if @findalias 'dotoolhouse'
  headmsg '*tools*'
  @useobject 'toolhouse'
  waitforgump 1513449091 1500
  replygump 0x5a356683 60030
  waitfortarget 1500
  for 0 in 'tools'
    while @findtype tools[] 'any' 'backpack' 'any' 0
      target! 'found'
      waitfortarget 1500
    endwhile
  endfor
endif
// gargoyle knife
while @findtype 0x13f6 2419 'backpack' 'any' 0
  pause 600
  @useobject 'toolhouse'
  waitforgump 1513449091 1500
  replygump 0x5a356683 60030
  waitfortarget 1500
  target! 'found'
endwhile
// Gargoyle Axe
while @findtype 0xf45 2419 'backpack' 'any' 0
  pause 600
  @useobject 'toolhouse'
  waitforgump 1513449091 1500
  replygump 0x5a356683 60030
  waitfortarget 1500
  target! 'found'
endwhile
// Move heavy items worth keeping to the bag of holding (eg gold)
if not @listexists 'bohitems'
  createlist 'bohitems'
  pushlist 'bohitems' 0xeed // Gold
  pushlist 'bohitems' 0xe21 // Bandages
  pushlist 'bohitems' 0xf3f // Arrows
  pushlist 'bohitems' 0x9f1 // Cut of Ribs (3g Each - one slot)
endif
for 0 in 'bohitems'
  while @findtype bohitems[] 'any' 'backpack' 'any' 0
    moveitem 'found' 'holdingbag'
  endwhile
endfor
// Smelt stuff in mobile forge - frees up a lot of weight quickly.
if not @listexists 'smeltores'
  @createlist 'smeltores'
  @pushlist 'smeltores' 0x19b9 // Big Ore Stack
endif
headmsg '*smelting ores*'
for 0 in 'smeltores'
  while @findtype smeltores[] 'any' 'backpack' 'any' 1
    @useobject 'found'
    waitfortarget 1500
    target! 'mobileforge'
    pause 500
  endwhile
endfor
@canceltarget
// If we are in war mode, then do a basic organize first.
if war 'self'
  headmsg '*pre oraganize*' 33
  organizer 'Trash4Tokens'
  while organizing
    pause 200
  endwhile
  organizer "ChopItems"
  while organizing
    pause 200
  endwhile
endif
// Clear the ignore list from the weapon sorter:
@clearignorelist
// List of things to smelt if a forge is nearby.
if not @listexists 'smeltables'
  createlist 'smeltables'
  pushlist 'smeltables' 0x26c1 // Crescent Blades
  pushlist 'smeltables' 0x1b73 // Bucklers
  pushlist 'smeltables' 0x13ff // Katana
  pushlist 'smeltables' 0x26bf // DoubleBladed Staff
  pushlist 'smeltables' 0xf52  // Daggers
  pushlist 'smeltables' 0x1410 // plate arms
  pushlist 'smeltables' 0x1411 // Plate Legs
  pushlist 'smeltables' 0x1412 // Plate Helm
  pushlist 'smeltables' 0x1413 // Plate Gorget
  pushlist 'smeltables' 0x1414 // Plate Gloves
  pushlist 'smeltables' 0x1408 // Close Helmet
  pushlist 'smeltables' 0x1415 // Plate Chest
  pushlist 'smeltables' 0x1c04 // Female Plate Chest
  pushlist 'smeltables' 0x13b6 // Scimitar
  pushlist 'smeltables' 0x13f0 // Ring Legs
  pushlist 'smeltables' 0x13ee // ring arms
  pushlist 'smeltables' 0x26be // Pike
  pushlist 'smeltables' 0x143b // Maul
  pushlist 'smeltables' 0x143e // Halberd
  pushlist 'smeltables' 0x1439 // War Hammer
  pushlist 'smeltables' 0x13fb // Large Battle Axe
  pushlist 'smeltables' 0xf4d  // Bardiche
  pushlist 'smeltables' 0x1405 // War Fork
  pushlist 'smeltables' 0x1b74 // Kite Shield
  pushlist 'smeltables' 0x1b76 // Heater Shield
  pushlist 'smeltables' 0x1b7b // Metal Round Shield
  pushlist 'smeltables' 0xf4b  // Double Axe
  pushlist 'smeltables' 0x140c // Bascinet Helm
  pushlist 'smeltables' 0x1401 // Kriss
  pushlist 'smeltables' 0x13be // Chain Legs
  pushlist 'smeltables' 0x13bb // Chain Coif
  pushlist 'smeltables' 0x13b9 // Viking Sword
  pushlist 'smeltables' 0xf61  // Long Sword
  pushlist 'smeltables' 0x1b72 // Bronze round Shield
  pushlist 'smeltables' 0xf45  // Executioner Axe
  pushlist 'smeltables' 0x140a // Helmet
  pushlist 'smeltables' 0xe87  // Pitchfork
  pushlist 'smeltables' 0xf62  // Spear
  pushlist 'smeltables' 0x13ec // Ringmail Tunic
  pushlist 'smeltables' 0xf49  // Axe
  pushlist 'smeltables' 0x26c0 // Lance
  pushlist 'smeltables' 0xf5e  // Broadsword
  pushlist 'smeltables' 0x26ba // Scythe
  pushlist 'smeltables' 0x13b0 // War Axe
  pushlist 'smeltables' 0x1403 // Short Spear
  pushlist 'smeltables' 0x26bc // Scepter
  pushlist 'smeltables' 0x1407 // War Mace
  pushlist 'smeltables' 0x140e // Norse Helm
  pushlist 'smeltables' 0x26bb // Bone Harvester
  pushlist 'smeltables' 0xf47  // Battle Axe
  pushlist 'smeltables' 0x1443 // Battle Axe
  pushlist 'smeltables' 0x26bd // Bladed Staff
  pushlist 'smeltables' 0x13bf // Chainmail Tunic
  pushlist 'smeltables' 0xf5c  // Mace
  pushlist 'smeltables' 0x1441 // Cutlass
  pushlist 'smeltables' 0x143d // Hammer Pick
  pushlist 'smeltables' 0x1b79 // Tear Kite Shield
  pushlist 'smeltables' 0x13eb // Ringmail gloves
  pushlist 'smeltables' 0x2781 // Light Platemail Jingasa
  pushlist 'smeltables' 0x27a7 // Lajatang
  pushlist 'smeltables' 0x27a4 // Wakizashi
  pushlist 'smeltables' 0x27a2 // No-Datchi
  pushlist 'smeltables' 0x27a9 // Daisho
  pushlist 'smeltables' 0x27af // Sai
  pushlist 'smeltables' 0x27ab // Tekagi
  pushlist 'smeltables' 0x27ad // Kama
  // pushlist 'smeltables' 0xec3  // Cleaver - can't smelt
endif
// Look for the mobile anvil in backpack
if not @findobject 'mobileanvil'
  @findtype 0xfaf 0 'backpack' 'any' 1
  @setalias 'mobileanvil' 'found'
endif
// Anvils we can smelt near:
@removelist 'anvils'
if not @listexists 'anvils'
  @createlist 'anvils'
  pushlist 'anvils' 0xfb0 // N/S Anvil
  pushlist 'anvils' 0xfaf // E/W Anvil
  pushlist 'anvils' 0x2dd5 // Elven Anvil South
endif
// Scan for anvil if we don't have a mobile forge.
if not @findobject 'mobileanvil'
  @unsetalias 'forgefound'
  headmsg '*scan for anvil*'
  for 0 in 'anvils'
    if @findtype anvils[] 'any' 'ground' 'any' 3
      @setalias 'forgefound' 'found'
      break
    endif
  endfor
endif
// See if we have anything to do:
@unsetalias 'dosmelting'
for 0 in smeltables
  if @findtype smeltables[] 'any' 'recyclebag' 'any' 1
    @setalias 'dosmelting' 'found'
    break
  endif
endfor
if @findobject 'dosmelting'
  if @findalias 'forgefound' or @findobject 'mobileanvil'
    headmsg "*smelting*"
    pause 600
    usetype 0x13e4 'any' 'backpack' 1 // Smithing Hammer
    waitforgump 949095101 1000
    for 0 in 'smeltables'
      while @findtype smeltables[] 'any' 'recyclebag' 'any' 1
        replygump 0x38920abd 14
        waitfortarget 1500
        target! 'found'
        waitforgump 949095101 1000
      endwhile
    endfor
    replygump 0x38920abd 0
  else
    headmsg "No forge in range" 34
  endif
endif
// Choppable Fletching
if not @listexists 'fletchables'
  createlist 'fletchables'
  pushlist 'fletchables' 0x13b2 // Bow
  pushlist 'fletchables' 0xf50  // X-Bow
  pushlist 'fletchables' 0x13fd // Heavy X-Bow
  pushlist 'fletchables' 0x26c3 // Repeating X-Bow
  pushlist 'fletchables' 0x26c2 // Composite Bow
endif
headmsg "*fletching*"
if not @findobject 'fletchtool'
  findtype 0x1022 'any' 'backpack' 'any' 2
  @setalias 'fletchtool' found
endif
// Check for fletchables
@unsetalias 'dofletching'
for 0 in 'fletchables'
  if @findtype fletchables[] 'any' 'recyclebag' 'any' 1
    @setalias 'dofletching' 'found'
    break
  endif
endfor
if @findobject 'dofletching'
  pause 600
  useobject 'fletchtool'
  waitforgump 949095101 1000
  for 0 in 'fletchables'
    while @findtype fletchables[] 'any' 'recyclebag' 'any' 1
      replygump 0x38920abd 14
      waitfortarget 1500
      target! 'found'
      waitforgump 'any' 1500
    endwhile
  endfor
  replygump 0x38920abd 0
endif
// Chopping Carpentry Stuff
if not @listexists 'carpenterchop'
  createlist 'carpenterchop'
  pushlist 'carpenterchop' 0x13f8 // Gnarled Staff
  pushlist 'carpenterchop' 0xe89  // Quarter Staff
  pushlist 'carpenterchop' 0xdf0  // Black Staff
  pushlist 'carpenterchop' 0xe81  // Shepherd's Crook
  pushlist 'carpenterchop' 0x27a8 // Bokuto
  pushlist 'carpenterchop' 0x27a6 // Tetsubo
  // pushlist 'carpenterchop' 0x13b4 // Clubs - Can't be chopped.
endif
if not @findobject 'carphammer'
  findtype 0x102a 'any' 'backpack' 'any' 2
  @setalias 'carphammer' found
endif
headmsg "*carpenter*"
// Check for choppables
@unsetalias 'docarp'
for 0 in 'carpenterchop'
  if @findtype carpenterchop[] 'any' 'recyclebag' 'any' 1
    @setalias 'docarp' 'found'
    break
  endif
endfor
if @findobject 'docarp'
  pause 600
  useobject 'carphammer'
  waitforgump 949095101 1500
  for 0 in 'carpenterchop'
    while @findtype carpenterchop[] 'any' 'recyclebag' 'any' 1
      @setalias 'chopme' 'found'
      replygump 0x38920abd 14
      waitfortarget 1500
      target! 'chopme'
      waitforgump 949095101 1500
      //waitforgump 'any' 1500
    endwhile
  endfor
  replygump 0x38920abd 0
endif
// List of things to cut with scissors
if not @listexists 'scissorables'
  createlist 'scissorables'
  pushlist 'scissorables' 0x1efd // Fancy Shirt
  pushlist 'scissorables' 0x1516 // Skirt
  pushlist 'scissorables' 0x144f // Bone Chest
  pushlist 'scissorables' 0x1452 // Bone Legs
  pushlist 'scissorables' 0x1451 // Bone Helm
  pushlist 'scissorables' 0x13d6 // studded gorget
  pushlist 'scissorables' 0x170b // Boots
  pushlist 'scissorables' 0x170d // Sandals
  pushlist 'scissorables' 0x1711 // thigh boots
  pushlist 'scissorables' 0x144e // Bone Wrists
  pushlist 'scissorables' 0x1450 // bone gloves
  pushlist 'scissorables' 0x1db9 // leather hat
  pushlist 'scissorables' 0x13d5 // Studded gloves
  pushlist 'scissorables' 0x1c00 // Leather Shorts
  pushlist 'scissorables' 0x13cd // Leather Sleeves
  pushlist 'scissorables' 0x1c06 // Female Leather Armor
  pushlist 'scissorables' 0x13c6 // Leather Gloves
  pushlist 'scissorables' 0x1c0c // Studded Bustier
  pushlist 'scissorables' 0x13cb // Leather Legs
  pushlist 'scissorables' 0x13db // Studded Tunic
  pushlist 'scissorables' 0x13cc // Leather Tunic
  pushlist 'scissorables' 0x13c7 // Leather Gorget
  pushlist 'scissorables' 0x2776 // Leather Jingasa
  pushlist 'scissorables' 0x1c0a // Leather Bustier
  pushlist 'scissorables' 0x13da // Studded Leggings
  pushlist 'scissorables' 0x13dc // Studded Sleeves
  pushlist 'scissorables' 0x1c08 // Leather Skirt
  pushlist 'scissorables' 0x1c02 // Studded Armor
  pushlist 'scissorables' 0x27c6 // Leather Do
  pushlist 'scissorables' 0x2796 // Waraji and Tabi
  pushlist 'scissorables' 0x278a // Leather Haidate
  pushlist 'scissorables' 0x277e // Leather Hiro Sode
  pushlist 'scissorables' 0x278e // Leather Ninja Hood
  pushlist 'scissorables' 0x2797 // Ninja Tabi
  pushlist 'scissorables' 0x2791 // Leather Ninja Pants
  pushlist 'scissorables' 0x2792 // Leather Ninja Mitts
  pushlist 'scissorables' 0x2793 // Leather Ninja Jacket
endif
headmsg "*scissors*"
if not @findobject 'scissors'
  findtype 0xf9f 'any' 'backpack' 'any' 2
  @setalias 'scissors' 'found'
endif
// See if we have anythin to scissor:
@unsetalias 'doscissors'
for 0 in 'scissorables'
  if @findtype scissorables[] 'any' 'recyclebag' 'any' 1
    @setalias 'doscissors' 'found'
    break
  endif
endfor
if @findobject 'doscissors'
  pause 600
  for 0 in 'scissorables'
    while @findtype scissorables[] 'any' 'recyclebag' 'any' 1
      useobject 'scissors'
      waitfortarget 1500
      target! 'found'
      pause 600
      if @injournal 'Scissors cannot be used on that'
        @ignoreobject 'found'
        clearjournal
      endif
    endwhile
  endfor
endif
// Cloth into Tailor Keys
if not @listexists 'keycloths'
  createlist 'keycloths'
  pushlist 'keycloths' 0x1081 // Leather (Any)
  pushlist 'keycloths' 0xdf8  // Wool
  pushlist 'keycloths' 0xfa0  // Spools of Thread
  pushlist 'keycloths' 0x26b4 // Scales
  pushlist 'keycloths' 0x1766 // Cut Cloth
endif
headmsg "*cloth keys*"
@unsetalias 'docloth'
for 0 in 'keycloths'
  if @findtype keycloths[] 'any' 'backpack' 'any' 1
    @setalias 'docloth' 'found'
    break
  endif
endfor
if @findobject 'docloth'
  pause 600
  useobject 'tailorkeys'
  waitforgump 1106836505 1000
  replygump 0x41f8fc19 60029
  waitforgump 1106836505 1000
  for 0 in 'keycloths'
    while @findtype keycloths[] 'any' 'backpack' 'any' 1
      target! 'found'
      pause 500
    endwhile
  endfor
  replygump 0x41f8fc19 0
endif
@canceltarget
// Woodworker Keys
if not @listexists 'keywood'
  createlist 'keywood'
  pushlist 'keywood' 0x1bd4 // Shafts
  pushlist 'keywood' 0x1bd1 // Feathers
  pushlist 'keywood' 0x1bd7 // Boards
  pushlist 'keywood' 0xf3f  // Arrows
  pushlist 'keywood' 0x1bfb // bolts
endif
headmsg "*wood keys*"
// Check for stuff to add
@unsetalias 'dowoodkeys'
for 0 in 'keywood'
  if @findtype keywood[] 'any' 'backpack' 'any' 0
    @setalias 'dowoodkeys' 'found'
    break
  endif
endfor
if @findobject 'dowoodkeys'
  pause 600
  useobject 'woodkeys'
  waitforgump 173511501 1000
  replygump 0xa57934d 60023
  waitforgump 173511501 1000
  for 0 in 'keywood'
    while @findtype keywood[] 'any' 'backpack' 'any' 0
      target! 'found'
      waitfortarget 1500
    endwhile
  endfor
  replygump 0xa57934d 0
endif
@canceltarget
// Metal Keys
if not @listexists 'keymetals'
  createlist 'keymetals'
  pushlist 'keymetals' 0x1bf2 // Ingots
endif
headmsg "*metal keys*"
@unsetalias 'dometalkeys'
for 0 in 'keymetals'
  if @findtype keymetals[] 'any' 'backpack' 'any' 1
    @setalias 'dometalkeys' 'found'
    break
  endif
endfor
if @findobject 'dometalkeys'
  pause 600
  useobject 'metalkeys'
  waitforgump 4213074123 1500
  for 0 in 'keymetals'
    while @findtype keymetals[] 'any' 'backpack' 'any' 1
      replygump 0xfb1e68cb 60015
      waitforgump 4213074123 1500
      target! 'found'
    endwhile
  endfor
  replygump 0xfb1e68cb 0
endif
@canceltarget
// Hack for nunchaku when farming Dojo
while @findtype 0x27ae 'any' 'backpack' 'any' 0
  if property 'Damage Increase' 'found' > 0
    ignoreobject 'found'
  else
    moveitem 'found' 'trashbag'
  endif
endwhile
// Run an organizer for junk that can be trashed.
headmsg '*organize*'
if organizing
  stop
else
  organizer 'Trash4Tokens'
endif
while organizing
  pause 200
endwhile
organizer 'LootToSellBag'
while organizing
  pause 200
endwhile
headmsg "**DONE**" 64