// Claim Body - Eremite
//
// Used for cleaning up corpses and extracting as much as possible from them.
// Will cut the body first (if it's not in an exclusion below)
// Will open the body if cut and scissor any hides into leather to reduce weight. (buggy)
// Will then use [claimall command on the body
// Trashes any bodyparts nearby if you cut humanoids (currently ignored)
//   (these can be free tokens if you have patience and enough item space in backpack)
// Also warns if weight/items are above a level defined at the end of the script.
//
// Aliases may be hard-coded below, but should try to find them otherwise.  Can define them manually if desired.
//
// Find & Set Scissors Alias
if not @findobject 'scissors'
  @findtype 0xf9f 'any' 'backpack' 'any' 1
  @setalias 'scissors' 'found'
endif
// Skinning Knife Alias (Currently using a Butcher Knife)
//  This can be most bladed weapons, and apparently even relayered bladed weapons.
if not @findobject 'skinningknife'
  @findtype 0x13f6 'any' 'backpack' 'any' 1
  @setalias 'skinningknife' 'found'
endif
if not @findobject 'skinningknife'
  headmsg "Select Bladed Object"
  promptalias 'skinningknife'
endif
// Body types that should not be skinned to claim faster. (Very incomplete)
//  Currently will 'removelist' and recreate every time so this can expand easily.
@removelist 'corpseignore'
if not @listexists 'corpseignore'
  @createlist 'corpseignore'
  pushlist 'corpseignore'   1 // Ogre
  pushlist 'corpseignore'   3 // Zombie
  pushlist 'corpseignore'   4 // Gargoyle
  pushlist 'corpseignore'   7 // Orc Lord
  pushlist 'corpseignore'   8 // Corpser
  pushlist 'corpseignore'  11 // Dread Spider
  pushlist 'corpseignore'  13 // Air Elemental
  pushlist 'corpseignore'  14 // Earth Elemental
  pushlist 'corpseignore'  15 // Fire Elemental
  pushlist 'corpseignore'  16 // Blood Elemental
  pushlist 'corpseignore'  17 // Orc
  pushlist 'corpseignore'  18 // Ettin
  pushlist 'corpseignore'  21 // Silver Serpent
  pushlist 'corpseignore'  22 // Gazer
  pushlist 'corpseignore'  24 // Lich
  pushlist 'corpseignore'  26 // Shade
  pushlist 'corpseignore'  28 // Giant Spider
  pushlist 'corpseignore'  31 // Headless One
  pushlist 'corpseignore'  39 // Mongbat
  pushlist 'corpseignore'  40 // Balron
  pushlist 'corpseignore'  47 // Reaper
  pushlist 'corpseignore'  48 // Giant Scorpion
  pushlist 'corpseignore'  50 // Skeleton
  pushlist 'corpseignore'  51 // Slime
  pushlist 'corpseignore'  53 // Troll
  pushlist 'corpseignore'  56 // Another Skeleton
  pushlist 'corpseignore'  57 // Skeletal Knight
  pushlist 'corpseignore'  58 // Wisp
  pushlist 'corpseignore'  67 // Stone Gargoyle
  pushlist 'corpseignore'  70 // Terathan Warrior
  pushlist 'corpseignore'  71 // Terathan Drone
  pushlist 'corpseignore'  72 // Terathan Matriarch
  pushlist 'corpseignore'  75 // Cyclops
  pushlist 'corpseignore'  85 // Ophidian Mage/Shaman
  pushlist 'corpseignore'  86 // Ophidian Avenger
  pushlist 'corpseignore'  87 // Ophidian Matriarch
  pushlist 'corpseignore'  89 // Fungal Lurker
  pushlist 'corpseignore' 124 // Evil Mage
  pushlist 'corpseignore' 125 // Evil Mage Lord
  pushlist 'corpseignore' 130 // Fire Gargoyle
  pushlist 'corpseignore' 148 // Skeletal Mage
  pushlist 'corpseignore' 149 // Succubus
  pushlist 'corpseignore' 152 // Terathan Avenger
  pushlist 'corpseignore' 154 // Mummy
  pushlist 'corpseignore' 182 // Orc Bomber
  pushlist 'corpseignore' 196 // Kaze Kemono
  pushlist 'corpseignore' 219 // Forest Ostard
  pushlist 'corpseignore' 238 // Rat
  pushlist 'corpseignore' 240 // Kappa
  pushlist 'corpseignore' 241 // Oni
  pushlist 'corpseignore' 245 // Yomutsu Warrior
  pushlist 'corpseignore' 247 // Fan Dancer
  pushlist 'corpseignore' 252 // Lady of the Snow
  pushlist 'corpseignore' 253 // Yumutsu Priest
  pushlist 'corpseignore' 302 // Skittering Hopper
  pushlist 'corpseignore' 303 // Devourer of Souls
  pushlist 'corpseignore' 308 // Bone Daemon
  pushlist 'corpseignore' 400 // Human Male
  pushlist 'corpseignore' 401 // Human Female
  pushlist 'corpseignore' 752 // Golem
  pushlist 'corpseignore' 764 // Juka Warrior
  pushlist 'corpseignore' 765 // Juka Mage
  pushlist 'corpseignore' 766 // Juka Lord
  pushlist 'corpseignore' 776 // Horde Minion
  pushlist 'corpseignore' 777 // Doppelganger
  pushlist 'corpseignore' 778 // Gazer Larva
  pushlist 'corpseignore' 780 // Bog Thing
  pushlist 'corpseignore' 785 // Moloch
  pushlist 'corpseignore' 789 // Quagmire
  pushlist 'corpseignore' 792 // Chaos Demon
  pushlist 'corpseignore' 793 // Undead Steed
  pushlist 'corpseignore' 806 // Solen Infiltrator
  pushlist 'corpseignore' 970 // Restless Soul (shrouded human)
endif
// Hacky bool to see if the corpse should be ignored.
@unsetalias 'ignoreme'
// Find and analyze a body within 2 tiles.
if @findtype 0x2006 'any' 'ground' 'any' 2
  @setalias 'body' 'found'
  for 0 in corpseignore
    if @amount 'body' == corpseignore[]
      @setalias 'ignoreme' 'body'
      break
    endif
  endfor
  if not @findobject 'ignoreme'
    // Stop organizing so we dont' lock up while skinning.
    //  Needs an empty organizer called 'stop'
    if organizing
      @organizer 'stop'
    endif
    useobject 'skinningknife'
    // Long delay so it will lock up if it was unable to use skinning knife
    // due to item use queueing/cooldown.
    waitfortarget 30000
    target! 'body'
    pause 200
    // This doesn't seem to work on bodies.
    // waitforcontents 'body' 3000
    @useobject 'body'
    pause 400
    if @findtype 0x1079 'any' 'body' 'any' 1
      useobject 'scissors'
      waitfortarget 1000
      target! 'found'
    endif
  endif
  msg '[claimall'
  waitfortarget 1500
  target! 'body'
  waitfortarget 1500
  canceltarget
  pause 400
endif
// Cut up hides in pack to reduce weight. Sometimes it fails to cut in the corpse.
while @findtype 0x1079 'any' 'backpack' 'any' 1
  @setalias 'hides' 'found'
  useobject 'scissors'
  waitfortarget 1000
  target! 'hides'
endwhile
// Also do any on the ground if we went overweight.  Scavenger agent should grab them if added.
while @findtype 0x1079 'any' 'ground' 'any' 1
  @setalias 'hides' 'found'
  useobject 'scissors'
  waitfortarget 1000
  target! 'hides'
endwhile
// Set a trashbag
if not @findalias 'trashbag'
  @setalias 'trashbag' 0x69420
endif
if not @findobject 'trashbag'
  findtype 0x9b2 1173 'backpack' 'any' 0
  setalias 'trashbag' 'found'
endif
// If a humanoid gets cut, delete all the body parts for free tokens.
//  This won't get triggered if 400 and 401 are in the ignore list.
if not @listexists 'bodyparts'
  createlist 'bodyparts'
  pushlist 'bodyparts' 0x1da0 // Head
  pushlist 'bodyparts' 0x1dae // Head 2
  pushlist 'bodyparts' 0x1da1 // Left Arm
  pushlist 'bodyparts' 0x1db0 // Left Arm 2
  pushlist 'bodyparts' 0x1daf // Right Arm
  pushlist 'bodyparts' 0x1da2 // Right Arm 2
  pushlist 'bodyparts' 0x1d9f // Body
  pushlist 'bodyparts' 0x1dad // Body 2
  pushlist 'bodyparts' 0x1da3 // Left Leg
  pushlist 'bodyparts' 0x1db2 // Left Leg 2
  pushlist 'bodyparts' 0x1da4 // Right Leg
  pushlist 'bodyparts' 0x1db1 // Right Leg 2
endif
for 0 in 'bodyparts'
  while @findtype bodyparts[] 0 'ground' 'any' 2
    @moveitem 'found' 'trashbag'
  endwhile
endfor
// Smelt ore from mobs because that crap's heavy.
if not @findobject 'mobileforge'
  @setalias 'mobileforge' 0x407e65b2
endif
while @findtype 0x19b9 'any' 'backpack' 'any' 0
  useobject 'found'
  waitfortarget 1500
  target! 'mobileforge'
endwhile
// Weight Warnings
if weight > 540
  headmsg "*HIGH WEIGHT*" 33
elseif weight > 480
  headmsg "Weight Warning" 53
endif
// Item Count Warnings
if contents 'backpack' > 290
  headmsg '190+ Items!!!' 33
elseif contents 'backpack' > 280
  headmsg '180+ Items' 53
endif
sysmsg 'Yoink!' 69
