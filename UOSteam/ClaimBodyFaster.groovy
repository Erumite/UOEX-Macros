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
@removelist 'nochopcorpse'
if not @listexists 'nochopcorpse'
  @createlist 'nochopcorpse'
  pushlist 'nochopcorpse'   1 // Ogre
  pushlist 'nochopcorpse'   3 // Zombie
  pushlist 'nochopcorpse'   4 // Gargoyle
  pushlist 'nochopcorpse'   7 // Orc Lord
  pushlist 'nochopcorpse'   8 // Corpser
  pushlist 'nochopcorpse'  11 // Dread Spider
  pushlist 'nochopcorpse'  13 // Air Elemental
  pushlist 'nochopcorpse'  14 // Earth Elemental
  pushlist 'nochopcorpse'  15 // Fire Elemental
  pushlist 'nochopcorpse'  16 // Blood Elemental
  pushlist 'nochopcorpse'  17 // Orc
  pushlist 'nochopcorpse'  18 // Ettin
  pushlist 'nochopcorpse'  21 // Silver Serpent
  pushlist 'nochopcorpse'  22 // Gazer
  pushlist 'nochopcorpse'  24 // Lich
  pushlist 'nochopcorpse'  26 // Shade
  pushlist 'nochopcorpse'  28 // Giant Spider
  pushlist 'nochopcorpse'  31 // Headless One
  pushlist 'nochopcorpse'  39 // Mongbat
  pushlist 'nochopcorpse'  40 // Balron
  pushlist 'nochopcorpse'  47 // Reaper
  pushlist 'nochopcorpse'  48 // Giant Scorpion
  pushlist 'nochopcorpse'  50 // Skeleton
  pushlist 'nochopcorpse'  51 // Slime
  pushlist 'nochopcorpse'  53 // Troll
  pushlist 'nochopcorpse'  56 // Another Skeleton
  pushlist 'nochopcorpse'  57 // Skeletal Knight
  pushlist 'nochopcorpse'  58 // Wisp
  pushlist 'nochopcorpse'  67 // Stone Gargoyle
  pushlist 'nochopcorpse'  70 // Terathan Warrior
  pushlist 'nochopcorpse'  71 // Terathan Drone
  pushlist 'nochopcorpse'  72 // Terathan Matriarch
  pushlist 'nochopcorpse'  75 // Cyclops
  pushlist 'nochopcorpse'  85 // Ophidian Mage/Shaman
  pushlist 'nochopcorpse'  86 // Ophidian Avenger
  pushlist 'nochopcorpse'  87 // Ophidian Matriarch
  pushlist 'nochopcorpse'  89 // Fungal Lurker
  pushlist 'nochopcorpse' 124 // Evil Mage
  pushlist 'nochopcorpse' 125 // Evil Mage Lord
  pushlist 'nochopcorpse' 130 // Fire Gargoyle
  pushlist 'nochopcorpse' 148 // Skeletal Mage
  pushlist 'nochopcorpse' 149 // Succubus
  pushlist 'nochopcorpse' 152 // Terathan Avenger
  pushlist 'nochopcorpse' 154 // Mummy
  pushlist 'nochopcorpse' 182 // Orc Bomber
  pushlist 'nochopcorpse' 196 // Kaze Kemono
  pushlist 'nochopcorpse' 199 // Shadow
  pushlist 'nochopcorpse' 219 // Forest Ostard
  pushlist 'nochopcorpse' 238 // Rat
  pushlist 'nochopcorpse' 240 // Kappa
  pushlist 'nochopcorpse' 241 // Oni
  pushlist 'nochopcorpse' 245 // Yomutsu Warrior
  pushlist 'nochopcorpse' 247 // Fan Dancer
  pushlist 'nochopcorpse' 252 // Lady of the Snow
  pushlist 'nochopcorpse' 253 // Yumutsu Priest
  pushlist 'nochopcorpse' 302 // Skittering Hopper
  pushlist 'nochopcorpse' 303 // Devourer of Souls
  pushlist 'nochopcorpse' 308 // Bone Daemon
  pushlist 'nochopcorpse' 309 // Patchwork Skeleton
  pushlist 'nochopcorpse' 400 // Human Male
  pushlist 'nochopcorpse' 401 // Human Female
  pushlist 'nochopcorpse' 752 // Golem
  pushlist 'nochopcorpse' 753 // Enslaved Gargoyle
  pushlist 'nochopcorpse' 754 // Gargoyle Enforcer
  pushlist 'nochopcorpse' 755 // Gargoyle Destroyer
  pushlist 'nochopcorpse' 756 // Exoduse Overseer
  pushlist 'nochopcorpse' 757 // Exodus Minion
  pushlist 'nochopcorpse' 764 // Juka Warrior
  pushlist 'nochopcorpse' 765 // Juka Mage
  pushlist 'nochopcorpse' 766 // Juka Lord
  pushlist 'nochopcorpse' 776 // Horde Minion
  pushlist 'nochopcorpse' 777 // Doppelganger
  pushlist 'nochopcorpse' 778 // Gazer Larva
  pushlist 'nochopcorpse' 780 // Bog Thing
  pushlist 'nochopcorpse' 785 // Moloch
  pushlist 'nochopcorpse' 789 // Quagmire
  pushlist 'nochopcorpse' 790 // Sand Vortex
  pushlist 'nochopcorpse' 792 // Chaos Demon
  pushlist 'nochopcorpse' 793 // Undead Steed
  pushlist 'nochopcorpse' 806 // Solen Infiltrator
  pushlist 'nochopcorpse' 970 // Restless Soul (shrouded human)
endif
// Reset Ignore List
@clearignorelist
// Claimall if bodies nearby - else quit.
if @findtype 0x2006 'any' 'ground' 'any' 10
  msg '[claimall'
  waitfortarget 1500
else
  stop
endif
// Claim all the no-chop corpses first since we can do it quickly.
while @findtype 0x2006 'any' 'ground' nochopcorpse[] 10
  if weight > 550
    headmsg '** Weight High **' 33
    break
  endif
  @setalias 'body' 'found'
  @unsetalias 'chopme'
  for 0 in 'nochopcorpse'
    if @amount 'body' == nochopcorpse[]
      @setalias 'chopme' 'body'
      break
    endif
  endfor
  if @findobject 'chopme'
    target! 'body'
    waitfortarget 1500
  endif
  @ignoreobject 'body'
endwhile
@canceltarget
@clearignorelist
// Find and analyze any remaining bodies within 2 tiles for cutting.
while @findtype 0x2006 'any' 'ground' 'any' 2
  if weight > 550
    headmsg '** Weight High **' 33
    break
  endif
  @setalias 'body' 'found'
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
  msg '[claimall'
  waitfortarget 1500
  target! 'body'
  @ignoreobject 'body'
  waitfortarget 1500
  canceltarget
  while @findtype 0x1079 'any' 'backpack' 'any' 1
    @setalias 'hides' 'found'
    pause 600
    useobject 'scissors'
    waitfortarget 1500
    target! 'hides'
  endwhile
endwhile
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
