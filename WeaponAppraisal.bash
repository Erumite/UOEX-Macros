#! /bin/bash
# 
# This is used to generate the weapon appraisal script for UOSteam programmatically
#  as there are an ungodly number of condititions to add manually.
# 
# Essentially it parses all the relevant properties of weapons, then counts up the total value
#  of those properties in terms of levelable weapon spending points.  If it's above the value
#  defined below, it will move it to a keep bag, else to the trash bag.
#
# It's not perfect, but it vastly diminishes the amount of manual checking required to find
#  good weapon drops.
#
# Note, after organizing, this will currently play the "RecycleStuff" macro.  Can remove the last
#  "playmacro" line to stop it doing this.
#
# Value (in weapon spending points) at which the item is considered worth considering.
min_value_to_keep=250

# Some arrays:
declare -A props
declare -A max

# Melee Attributes
props["Defence Chance Increase"]=3
max["Defence Chance Increase"]=50
props["Hit Chance Increase"]=3
max["Hit Chance Increase"]=45
props["Damage Increase"]=4
max["Damage Increase"]=60
props["Swing Speed Increase"]=4
max["Swing Speed Increase"]=40
props["Reflect Physical Damage"]=3
max["Reflect Physical Damage"]=15
# Magic Attributes
props["Spell Damage"]=2
max["Spell Damage"]=20
props["Faster Cast Recovery"]=5
max["Faster Cast Recovery"]=6
#  Faster Casting is special and handled manually.
# props["Faster Casting"]=50
props["Lower Mana Cost"]=5
max["Lower Mana Cost"]=10
props["Lower Reagent Cost"]=5
max["Lower Reagent Cost"]=20
props["Enhance Potions"]=2
max["Enhance Potions"]=25
# Ignore Mage Weapon
# Character Stats
props["Regen Hits"]=2
max["Regen Hits"]=6
props["Regen Stamina"]=1
max["Regen Stamina"]=10
props["Regen Mana"]=6
max["Regen Mana"]=6
props["Bonus Strength"]=4
max["Bonus Strength"]=8
props["Bonus Dex"]=4
max["Bonus Dex"]=8
props["Bonus Int"]=4
max["Bonus Int"]=8
props["Bonus Hits"]=3
max["Bonus Hits"]=8
props["Bonus Stamina"]=3
max["Bonus Stamina"]=8
props["Bonus Mana"]=3
max["Bonus Mana"]=8
# Ignore Lower Stat Requirement
# Resistances
props["Physical Resist"]=5
max["Physical Resist"]=20
props["Fire Resist"]=5
max["Fire Resist"]=20
props["Cold Resist"]=5
max["Cold Resist"]=20
props["Poison Resist"]=5
max["Poison Resist"]=20
props["Energy Resist"]=5
max["Energy Resist"]=20
# Weapon Hits
props["Hit Life Leech"]=3
max["Hit Life Leech"]=60
props["Hit Stamina Leech"]=3
max["Hit Stamina Leech"]=60
props["Hit Mana Leech"]=3
max["Hit Mana Leech"]=60
props["Hit Lower Attack"]=3
max["Hit Lower Attack"]=60
props["Hit Lower Defense"]=3
max["Hit Lower Defense"]=60
props["Hit Magic Arrow"]=4
max["Hit Magic Arrow"]=60
props["Hit Harm"]=4
max["Hit Harm"]=60
props["Hit Fireball"]=4
max["Hit Fireball"]=60
props["Hit Lightning"]=4
max["Hit Lightning"]=60
# Ignore Hit Dispel
# Misc Attributes
# Ignore Luck as it can be added with ED:
# props["Luck"]=3
# max["Luck"]=150
# Ignore Other Misc Attributes
# Non-Weapon Stuff with Values
props["Hit Energy Area"]=4
max["Hit Energy Area"]=50
props["Hit Fire Area"]=4
max["Hit Fire Area"]=50
props["Hit Poison Area"]=4
max["Hit Poison Area"]=50
props["Hit Cold Area"]=4
max["Hit Cold Area"]=50
props["Hit Physical Area"]=4
max["Hit Physical Area"]=50

echo "
@setalias 'sellbag' 0x433fd36c
@setalias 'recyclebag' 0x41a15e99
@removelist 'weapons'
@createlist 'weapons'
pushlist 'weapons' 0x26c0 // Lance
pushlist 'weapons' 0xf4b  // DoubleAxe
pushlist 'weapons' 0xe87  // Pitchfork
pushlist 'weapons' 0xf61  // Longsword
pushlist 'weapons' 0xdf0  // Black Staff
pushlist 'weapons' 0x26bd // Bladed Staff
pushlist 'weapons' 0x13f8 // Gnarled Staff
pushlist 'weapons' 0x1405 // War Fork
pushlist 'weapons' 0x1443 // 2H Axe
pushlist 'weapons' 0xf5c  // Mace
pushlist 'weapons' 0xf49  // Axe
pushlist 'weapons' 0x143e // Halberd
pushlist 'weapons' 0xf4d  // Bardiche
pushlist 'weapons' 0x1403 // Short Spear
pushlist 'weapons' 0x13b2 // Bow
pushlist 'weapons' 0x13b9 // Viking Sword
pushlist 'weapons' 0x1401 // Kryss
pushlist 'weapons' 0x26c1 // Crescent Blade
pushlist 'weapons' 0x26bf // Double Bladed Staff
pushlist 'weapons' 0x26bb // Bone Harvester
pushlist 'weapons' 0x13fd // Heavy Crossbow
pushlist 'weapons' 0x1441 // Cutlass
pushlist 'weapons' 0x13b6 // Scimitar
pushlist 'weapons' 0x26ba // Scythe
pushlist 'weapons' 0x26be // Pike
pushlist 'weapons' 0xf5e  // Broadsword
pushlist 'weapons' 0x26c3 // Repeating XBow
pushlist 'weapons' 0xf62  // Spear
pushlist 'weapons' 0x143b // Maul
pushlist 'weapons' 0x1439 // War Hammer
pushlist 'weapons' 0x1407 // War Mace
pushlist 'weapons' 0x143d // Hammer Pick
pushlist 'weapons' 0x26bc // Scepter
pushlist 'weapons' 0x26c2 // Composite Bow
pushlist 'weapons' 0xf47  // Battle Axe
pushlist 'weapons' 0x13b0 // War Axe
pushlist 'weapons' 0xf52  // Dagger
pushlist 'weapons' 0xe89  // Quarter Staff
pushlist 'weapons' 0xf45  // Executioner Axe
pushlist 'weapons' 0x13ff // Katana
pushlist 'weapons' 0x13fb // Large Battle Axe
pushlist 'weapons' 0xf50  // Crossbow
pushlist 'weapons' 0xe81  // Shepherd's Crook
@clearignorelist
for 0 in 'weapons'
  while @findtype weapons[] 'any' 'backpack' 'any' 0
    @removelist 'valuetally'
    @createlist 'valuetally'
    // Boost these by a lot for manual checking since UOS can't access them.
    if @property 'Resistances:' 'found'
      for 150
        pushlist 'valuetally' 'x'
      endfor
    endif"

for p in "${!props[@]}"; do
  echo "    if @property '${p}' 'found' > 0"
  echo "      if @property '${p}' 'found' == 1
        for ${props[$p]}
          pushlist 'valuetally' 'x'
        endfor"
  submax=$((${max[${p}]} - 1))
  for i in $(eval echo $(echo {2..${submax}})) ; do
    echo "      elseif @property '${p}' 'found' == ${i}
        for $((${i}*${props[$p]}))
          pushlist 'valuetally' 'x'
        endfor"
  done
  echo "      elseif @property '${p}' 'found' >= ${max[${p}]}
        for $((${max[${p}]}*${props[$p]}))
          pushlist 'valuetally' 'x'
        endfor
      endif"
  echo "    endif"
done

echo "    if @property 'Faster Casting' 'testweap' < 0
      for 50
        poplist 'valuetally' 'back'
      endfor
    elseif @property 'Faster Casting' 'testweap' > 0
      for 50
        pushlist 'valuetally' 'x'
      endfor
    endif
    @ignoreobject 'found'
    if list 'valuetally' > ${min_value_to_keep}
      headmsg 'Keep' 69
      moveitem 'found' 'sellbag' 0 0 0
      pause 750
    else
      headmsg 'Trash' 33
      moveitem 'found' 'recyclebag' 0 0 0
      pause 750
    endif
  endwhile
endfor
@removelist 'valuetally'
headmsg '*Appraisal Done*' 69
playmacro 'RecycleStuff'
"
