
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
@unsetalias 'replaysort'
for 0 in 'weapons'
  while @findtype weapons[] 'any' 'backpack' 'any' 0
    if @property 'insured' 'found' or @property Blessed 'found'
      @ignoreobject 'found'
      continue
    endif
    @removelist 'valuetally'
    @createlist 'valuetally'
    // Boost these by a lot for manual checking since UOS can't access them.
    if @property 'Resistances:' 'found'
      for 150
        pushlist 'valuetally' 'x'
      endfor
    endif
    if @property 'Intelligence Bonus' 'found' > 0
      if @property 'Intelligence Bonus' 'found' == 1
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Intelligence Bonus' 'found' == 2
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Intelligence Bonus' 'found' == 3
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Intelligence Bonus' 'found' == 4
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Intelligence Bonus' 'found' == 5
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Intelligence Bonus' 'found' == 6
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Intelligence Bonus' 'found' == 7
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Intelligence Bonus' 'found' >= 8
        for 32
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Hit Mana Leech' 'found' > 0
      if @property 'Hit Mana Leech' 'found' == 1
        for 3
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 2
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 3
        for 9
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 4
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 5
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 6
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 7
        for 21
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 8
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 9
        for 27
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 10
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 11
        for 33
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 12
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 13
        for 39
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 14
        for 42
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 15
        for 45
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 16
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 17
        for 51
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 18
        for 54
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 19
        for 57
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 20
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 21
        for 63
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 22
        for 66
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 23
        for 69
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 24
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 25
        for 75
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 26
        for 78
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 27
        for 81
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 28
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 29
        for 87
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 30
        for 90
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 31
        for 93
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 32
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 33
        for 99
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 34
        for 102
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 35
        for 105
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 36
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 37
        for 111
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 38
        for 114
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 39
        for 117
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 40
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 41
        for 123
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 42
        for 126
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 43
        for 129
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 44
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 45
        for 135
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 46
        for 138
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 47
        for 141
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 48
        for 144
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 49
        for 147
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 50
        for 150
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 51
        for 153
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 52
        for 156
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 53
        for 159
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 54
        for 162
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 55
        for 165
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 56
        for 168
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 57
        for 171
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 58
        for 174
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' == 59
        for 177
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Mana Leech' 'found' >= 60
        for 180
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Hit Lower Attack' 'found' > 0
      if @property 'Hit Lower Attack' 'found' == 1
        for 3
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 2
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 3
        for 9
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 4
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 5
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 6
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 7
        for 21
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 8
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 9
        for 27
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 10
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 11
        for 33
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 12
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 13
        for 39
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 14
        for 42
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 15
        for 45
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 16
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 17
        for 51
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 18
        for 54
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 19
        for 57
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 20
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 21
        for 63
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 22
        for 66
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 23
        for 69
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 24
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 25
        for 75
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 26
        for 78
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 27
        for 81
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 28
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 29
        for 87
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 30
        for 90
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 31
        for 93
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 32
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 33
        for 99
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 34
        for 102
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 35
        for 105
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 36
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 37
        for 111
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 38
        for 114
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 39
        for 117
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 40
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 41
        for 123
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 42
        for 126
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 43
        for 129
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 44
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 45
        for 135
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 46
        for 138
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 47
        for 141
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 48
        for 144
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 49
        for 147
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 50
        for 150
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 51
        for 153
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 52
        for 156
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 53
        for 159
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 54
        for 162
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 55
        for 165
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 56
        for 168
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 57
        for 171
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 58
        for 174
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' == 59
        for 177
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Attack' 'found' >= 60
        for 180
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Reflect Physical Damage' 'found' > 0
      if @property 'Reflect Physical Damage' 'found' == 1
        for 3
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Reflect Physical Damage' 'found' == 2
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Reflect Physical Damage' 'found' == 3
        for 9
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Reflect Physical Damage' 'found' == 4
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Reflect Physical Damage' 'found' == 5
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Reflect Physical Damage' 'found' == 6
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Reflect Physical Damage' 'found' == 7
        for 21
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Reflect Physical Damage' 'found' == 8
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Reflect Physical Damage' 'found' == 9
        for 27
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Reflect Physical Damage' 'found' == 10
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Reflect Physical Damage' 'found' == 11
        for 33
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Reflect Physical Damage' 'found' == 12
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Reflect Physical Damage' 'found' == 13
        for 39
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Reflect Physical Damage' 'found' == 14
        for 42
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Reflect Physical Damage' 'found' >= 15
        for 45
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Hit Lightning' 'found' > 0
      if @property 'Hit Lightning' 'found' == 1
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 2
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 3
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 4
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 5
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 6
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 7
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 8
        for 32
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 9
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 10
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 11
        for 44
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 12
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 13
        for 52
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 14
        for 56
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 15
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 16
        for 64
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 17
        for 68
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 18
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 19
        for 76
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 20
        for 80
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 21
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 22
        for 88
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 23
        for 92
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 24
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 25
        for 100
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 26
        for 104
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 27
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 28
        for 112
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 29
        for 116
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 30
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 31
        for 124
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 32
        for 128
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 33
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 34
        for 136
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 35
        for 140
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 36
        for 144
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 37
        for 148
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 38
        for 152
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 39
        for 156
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 40
        for 160
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 41
        for 164
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 42
        for 168
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 43
        for 172
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 44
        for 176
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 45
        for 180
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 46
        for 184
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 47
        for 188
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 48
        for 192
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 49
        for 196
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 50
        for 200
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 51
        for 204
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 52
        for 208
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 53
        for 212
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 54
        for 216
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 55
        for 220
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 56
        for 224
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 57
        for 228
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 58
        for 232
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' == 59
        for 236
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lightning' 'found' >= 60
        for 240
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Hit Stamina Leech' 'found' > 0
      if @property 'Hit Stamina Leech' 'found' == 1
        for 3
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 2
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 3
        for 9
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 4
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 5
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 6
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 7
        for 21
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 8
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 9
        for 27
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 10
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 11
        for 33
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 12
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 13
        for 39
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 14
        for 42
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 15
        for 45
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 16
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 17
        for 51
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 18
        for 54
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 19
        for 57
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 20
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 21
        for 63
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 22
        for 66
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 23
        for 69
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 24
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 25
        for 75
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 26
        for 78
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 27
        for 81
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 28
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 29
        for 87
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 30
        for 90
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 31
        for 93
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 32
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 33
        for 99
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 34
        for 102
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 35
        for 105
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 36
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 37
        for 111
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 38
        for 114
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 39
        for 117
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 40
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 41
        for 123
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 42
        for 126
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 43
        for 129
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 44
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 45
        for 135
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 46
        for 138
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 47
        for 141
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 48
        for 144
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 49
        for 147
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 50
        for 150
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 51
        for 153
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 52
        for 156
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 53
        for 159
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 54
        for 162
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 55
        for 165
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 56
        for 168
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 57
        for 171
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 58
        for 174
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' == 59
        for 177
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Stamina Leech' 'found' >= 60
        for 180
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Mana Regeneration' 'found' > 0
      if @property 'Mana Regeneration' 'found' == 1
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Mana Regeneration' 'found' == 2
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Mana Regeneration' 'found' == 3
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Mana Regeneration' 'found' == 4
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Mana Regeneration' 'found' == 5
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Mana Regeneration' 'found' >= 6
        for 36
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Hit Poison Area' 'found' > 0
      if @property 'Hit Poison Area' 'found' == 1
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 2
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 3
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 4
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 5
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 6
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 7
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 8
        for 32
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 9
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 10
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 11
        for 44
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 12
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 13
        for 52
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 14
        for 56
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 15
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 16
        for 64
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 17
        for 68
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 18
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 19
        for 76
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 20
        for 80
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 21
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 22
        for 88
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 23
        for 92
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 24
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 25
        for 100
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 26
        for 104
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 27
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 28
        for 112
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 29
        for 116
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 30
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 31
        for 124
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 32
        for 128
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 33
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 34
        for 136
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 35
        for 140
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 36
        for 144
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 37
        for 148
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 38
        for 152
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 39
        for 156
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 40
        for 160
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 41
        for 164
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 42
        for 168
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 43
        for 172
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 44
        for 176
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 45
        for 180
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 46
        for 184
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 47
        for 188
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 48
        for 192
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' == 49
        for 196
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Poison Area' 'found' >= 50
        for 200
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Mana Increase' 'found' > 0
      if @property 'Mana Increase' 'found' == 1
        for 3
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Mana Increase' 'found' == 2
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Mana Increase' 'found' == 3
        for 9
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Mana Increase' 'found' == 4
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Mana Increase' 'found' == 5
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Mana Increase' 'found' == 6
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Mana Increase' 'found' == 7
        for 21
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Mana Increase' 'found' >= 8
        for 24
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Energy Resist' 'found' > 0
      if @property 'Energy Resist' 'found' == 1
        for 5
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' == 2
        for 10
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' == 3
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' == 4
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' == 5
        for 25
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' == 6
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' == 7
        for 35
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' == 8
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' == 9
        for 45
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' == 10
        for 50
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' == 11
        for 55
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' == 12
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' == 13
        for 65
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' == 14
        for 70
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' == 15
        for 75
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' == 16
        for 80
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' == 17
        for 85
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' == 18
        for 90
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' == 19
        for 95
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Energy Resist' 'found' >= 20
        for 100
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Faster Cast Recovery' 'found' > 0
      if @property 'Faster Cast Recovery' 'found' == 1
        for 5
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Faster Cast Recovery' 'found' == 2
        for 10
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Faster Cast Recovery' 'found' == 3
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Faster Cast Recovery' 'found' == 4
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Faster Cast Recovery' 'found' == 5
        for 25
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Faster Cast Recovery' 'found' >= 6
        for 30
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Defence Chance Increase' 'found' > 0
      if @property 'Defence Chance Increase' 'found' == 1
        for 3
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 2
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 3
        for 9
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 4
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 5
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 6
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 7
        for 21
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 8
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 9
        for 27
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 10
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 11
        for 33
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 12
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 13
        for 39
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 14
        for 42
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 15
        for 45
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 16
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 17
        for 51
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 18
        for 54
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 19
        for 57
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 20
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 21
        for 63
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 22
        for 66
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 23
        for 69
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 24
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 25
        for 75
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 26
        for 78
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 27
        for 81
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 28
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 29
        for 87
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 30
        for 90
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 31
        for 93
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 32
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 33
        for 99
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 34
        for 102
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 35
        for 105
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 36
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 37
        for 111
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 38
        for 114
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 39
        for 117
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 40
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 41
        for 123
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 42
        for 126
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 43
        for 129
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 44
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 45
        for 135
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 46
        for 138
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 47
        for 141
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 48
        for 144
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' == 49
        for 147
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Defence Chance Increase' 'found' >= 50
        for 150
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Hit Point Regeneration' 'found' > 0
      if @property 'Hit Point Regeneration' 'found' == 1
        for 2
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Point Regeneration' 'found' == 2
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Point Regeneration' 'found' == 3
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Point Regeneration' 'found' == 4
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Point Regeneration' 'found' == 5
        for 10
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Point Regeneration' 'found' >= 6
        for 12
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Poison Resist' 'found' > 0
      if @property 'Poison Resist' 'found' == 1
        for 5
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' == 2
        for 10
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' == 3
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' == 4
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' == 5
        for 25
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' == 6
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' == 7
        for 35
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' == 8
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' == 9
        for 45
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' == 10
        for 50
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' == 11
        for 55
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' == 12
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' == 13
        for 65
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' == 14
        for 70
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' == 15
        for 75
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' == 16
        for 80
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' == 17
        for 85
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' == 18
        for 90
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' == 19
        for 95
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Poison Resist' 'found' >= 20
        for 100
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Cold Resist' 'found' > 0
      if @property 'Cold Resist' 'found' == 1
        for 5
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' == 2
        for 10
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' == 3
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' == 4
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' == 5
        for 25
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' == 6
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' == 7
        for 35
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' == 8
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' == 9
        for 45
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' == 10
        for 50
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' == 11
        for 55
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' == 12
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' == 13
        for 65
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' == 14
        for 70
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' == 15
        for 75
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' == 16
        for 80
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' == 17
        for 85
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' == 18
        for 90
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' == 19
        for 95
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Cold Resist' 'found' >= 20
        for 100
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Dexterity Bonus' 'found' > 0
      if @property 'Dexterity Bonus' 'found' == 1
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Dexterity Bonus' 'found' == 2
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Dexterity Bonus' 'found' == 3
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Dexterity Bonus' 'found' == 4
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Dexterity Bonus' 'found' == 5
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Dexterity Bonus' 'found' == 6
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Dexterity Bonus' 'found' == 7
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Dexterity Bonus' 'found' >= 8
        for 32
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Hit Life Leech' 'found' > 0
      if @property 'Hit Life Leech' 'found' == 1
        for 3
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 2
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 3
        for 9
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 4
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 5
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 6
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 7
        for 21
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 8
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 9
        for 27
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 10
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 11
        for 33
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 12
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 13
        for 39
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 14
        for 42
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 15
        for 45
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 16
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 17
        for 51
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 18
        for 54
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 19
        for 57
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 20
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 21
        for 63
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 22
        for 66
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 23
        for 69
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 24
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 25
        for 75
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 26
        for 78
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 27
        for 81
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 28
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 29
        for 87
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 30
        for 90
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 31
        for 93
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 32
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 33
        for 99
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 34
        for 102
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 35
        for 105
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 36
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 37
        for 111
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 38
        for 114
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 39
        for 117
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 40
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 41
        for 123
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 42
        for 126
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 43
        for 129
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 44
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 45
        for 135
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 46
        for 138
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 47
        for 141
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 48
        for 144
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 49
        for 147
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 50
        for 150
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 51
        for 153
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 52
        for 156
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 53
        for 159
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 54
        for 162
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 55
        for 165
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 56
        for 168
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 57
        for 171
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 58
        for 174
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' == 59
        for 177
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Life Leech' 'found' >= 60
        for 180
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Hit Point Increase' 'found' > 0
      if @property 'Hit Point Increase' 'found' == 1
        for 3
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Point Increase' 'found' == 2
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Point Increase' 'found' == 3
        for 9
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Point Increase' 'found' == 4
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Point Increase' 'found' == 5
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Point Increase' 'found' == 6
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Point Increase' 'found' == 7
        for 21
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Point Increase' 'found' >= 8
        for 24
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Hit Lower Defense' 'found' > 0
      if @property 'Hit Lower Defense' 'found' == 1
        for 3
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 2
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 3
        for 9
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 4
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 5
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 6
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 7
        for 21
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 8
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 9
        for 27
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 10
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 11
        for 33
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 12
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 13
        for 39
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 14
        for 42
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 15
        for 45
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 16
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 17
        for 51
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 18
        for 54
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 19
        for 57
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 20
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 21
        for 63
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 22
        for 66
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 23
        for 69
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 24
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 25
        for 75
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 26
        for 78
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 27
        for 81
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 28
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 29
        for 87
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 30
        for 90
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 31
        for 93
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 32
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 33
        for 99
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 34
        for 102
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 35
        for 105
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 36
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 37
        for 111
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 38
        for 114
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 39
        for 117
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 40
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 41
        for 123
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 42
        for 126
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 43
        for 129
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 44
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 45
        for 135
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 46
        for 138
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 47
        for 141
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 48
        for 144
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 49
        for 147
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 50
        for 150
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 51
        for 153
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 52
        for 156
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 53
        for 159
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 54
        for 162
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 55
        for 165
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 56
        for 168
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 57
        for 171
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 58
        for 174
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' == 59
        for 177
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Lower Defense' 'found' >= 60
        for 180
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Hit Fireball' 'found' > 0
      if @property 'Hit Fireball' 'found' == 1
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 2
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 3
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 4
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 5
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 6
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 7
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 8
        for 32
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 9
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 10
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 11
        for 44
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 12
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 13
        for 52
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 14
        for 56
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 15
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 16
        for 64
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 17
        for 68
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 18
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 19
        for 76
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 20
        for 80
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 21
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 22
        for 88
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 23
        for 92
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 24
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 25
        for 100
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 26
        for 104
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 27
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 28
        for 112
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 29
        for 116
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 30
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 31
        for 124
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 32
        for 128
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 33
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 34
        for 136
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 35
        for 140
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 36
        for 144
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 37
        for 148
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 38
        for 152
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 39
        for 156
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 40
        for 160
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 41
        for 164
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 42
        for 168
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 43
        for 172
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 44
        for 176
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 45
        for 180
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 46
        for 184
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 47
        for 188
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 48
        for 192
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 49
        for 196
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 50
        for 200
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 51
        for 204
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 52
        for 208
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 53
        for 212
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 54
        for 216
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 55
        for 220
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 56
        for 224
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 57
        for 228
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 58
        for 232
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' == 59
        for 236
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fireball' 'found' >= 60
        for 240
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Enhance Potions' 'found' > 0
      if @property 'Enhance Potions' 'found' == 1
        for 2
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 2
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 3
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 4
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 5
        for 10
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 6
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 7
        for 14
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 8
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 9
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 10
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 11
        for 22
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 12
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 13
        for 26
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 14
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 15
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 16
        for 32
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 17
        for 34
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 18
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 19
        for 38
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 20
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 21
        for 42
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 22
        for 44
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 23
        for 46
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' == 24
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Enhance Potions' 'found' >= 25
        for 50
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Hit Harm' 'found' > 0
      if @property 'Hit Harm' 'found' == 1
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 2
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 3
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 4
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 5
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 6
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 7
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 8
        for 32
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 9
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 10
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 11
        for 44
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 12
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 13
        for 52
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 14
        for 56
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 15
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 16
        for 64
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 17
        for 68
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 18
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 19
        for 76
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 20
        for 80
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 21
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 22
        for 88
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 23
        for 92
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 24
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 25
        for 100
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 26
        for 104
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 27
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 28
        for 112
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 29
        for 116
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 30
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 31
        for 124
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 32
        for 128
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 33
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 34
        for 136
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 35
        for 140
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 36
        for 144
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 37
        for 148
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 38
        for 152
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 39
        for 156
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 40
        for 160
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 41
        for 164
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 42
        for 168
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 43
        for 172
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 44
        for 176
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 45
        for 180
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 46
        for 184
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 47
        for 188
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 48
        for 192
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 49
        for 196
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 50
        for 200
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 51
        for 204
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 52
        for 208
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 53
        for 212
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 54
        for 216
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 55
        for 220
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 56
        for 224
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 57
        for 228
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 58
        for 232
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' == 59
        for 236
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Harm' 'found' >= 60
        for 240
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Physical Resist' 'found' > 0
      if @property 'Physical Resist' 'found' == 1
        for 5
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' == 2
        for 10
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' == 3
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' == 4
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' == 5
        for 25
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' == 6
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' == 7
        for 35
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' == 8
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' == 9
        for 45
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' == 10
        for 50
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' == 11
        for 55
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' == 12
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' == 13
        for 65
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' == 14
        for 70
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' == 15
        for 75
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' == 16
        for 80
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' == 17
        for 85
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' == 18
        for 90
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' == 19
        for 95
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Physical Resist' 'found' >= 20
        for 100
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Fire Resist' 'found' > 0
      if @property 'Fire Resist' 'found' == 1
        for 5
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' == 2
        for 10
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' == 3
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' == 4
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' == 5
        for 25
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' == 6
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' == 7
        for 35
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' == 8
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' == 9
        for 45
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' == 10
        for 50
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' == 11
        for 55
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' == 12
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' == 13
        for 65
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' == 14
        for 70
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' == 15
        for 75
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' == 16
        for 80
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' == 17
        for 85
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' == 18
        for 90
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' == 19
        for 95
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Fire Resist' 'found' >= 20
        for 100
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Spell Damage' 'found' > 0
      if @property 'Spell Damage' 'found' == 1
        for 2
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' == 2
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' == 3
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' == 4
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' == 5
        for 10
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' == 6
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' == 7
        for 14
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' == 8
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' == 9
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' == 10
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' == 11
        for 22
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' == 12
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' == 13
        for 26
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' == 14
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' == 15
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' == 16
        for 32
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' == 17
        for 34
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' == 18
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' == 19
        for 38
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Spell Damage' 'found' >= 20
        for 40
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Hit Physical Area' 'found' > 0
      if @property 'Hit Physical Area' 'found' == 1
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 2
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 3
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 4
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 5
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 6
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 7
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 8
        for 32
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 9
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 10
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 11
        for 44
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 12
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 13
        for 52
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 14
        for 56
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 15
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 16
        for 64
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 17
        for 68
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 18
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 19
        for 76
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 20
        for 80
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 21
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 22
        for 88
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 23
        for 92
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 24
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 25
        for 100
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 26
        for 104
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 27
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 28
        for 112
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 29
        for 116
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 30
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 31
        for 124
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 32
        for 128
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 33
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 34
        for 136
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 35
        for 140
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 36
        for 144
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 37
        for 148
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 38
        for 152
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 39
        for 156
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 40
        for 160
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 41
        for 164
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 42
        for 168
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 43
        for 172
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 44
        for 176
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 45
        for 180
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 46
        for 184
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 47
        for 188
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 48
        for 192
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' == 49
        for 196
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Physical Area' 'found' >= 50
        for 200
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Hit Fire Area' 'found' > 0
      if @property 'Hit Fire Area' 'found' == 1
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 2
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 3
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 4
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 5
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 6
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 7
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 8
        for 32
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 9
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 10
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 11
        for 44
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 12
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 13
        for 52
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 14
        for 56
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 15
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 16
        for 64
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 17
        for 68
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 18
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 19
        for 76
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 20
        for 80
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 21
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 22
        for 88
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 23
        for 92
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 24
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 25
        for 100
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 26
        for 104
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 27
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 28
        for 112
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 29
        for 116
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 30
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 31
        for 124
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 32
        for 128
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 33
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 34
        for 136
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 35
        for 140
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 36
        for 144
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 37
        for 148
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 38
        for 152
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 39
        for 156
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 40
        for 160
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 41
        for 164
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 42
        for 168
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 43
        for 172
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 44
        for 176
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 45
        for 180
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 46
        for 184
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 47
        for 188
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 48
        for 192
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' == 49
        for 196
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Fire Area' 'found' >= 50
        for 200
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Stamina Regeneration' 'found' > 0
      if @property 'Stamina Regeneration' 'found' == 1
        for 1
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Stamina Regeneration' 'found' == 2
        for 2
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Stamina Regeneration' 'found' == 3
        for 3
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Stamina Regeneration' 'found' == 4
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Stamina Regeneration' 'found' == 5
        for 5
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Stamina Regeneration' 'found' == 6
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Stamina Regeneration' 'found' == 7
        for 7
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Stamina Regeneration' 'found' == 8
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Stamina Regeneration' 'found' == 9
        for 9
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Stamina Regeneration' 'found' >= 10
        for 10
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Stamina Increase' 'found' > 0
      if @property 'Stamina Increase' 'found' == 1
        for 3
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Stamina Increase' 'found' == 2
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Stamina Increase' 'found' == 3
        for 9
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Stamina Increase' 'found' == 4
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Stamina Increase' 'found' == 5
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Stamina Increase' 'found' == 6
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Stamina Increase' 'found' == 7
        for 21
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Stamina Increase' 'found' >= 8
        for 24
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Strength Bonus' 'found' > 0
      if @property 'Strength Bonus' 'found' == 1
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Strength Bonus' 'found' == 2
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Strength Bonus' 'found' == 3
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Strength Bonus' 'found' == 4
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Strength Bonus' 'found' == 5
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Strength Bonus' 'found' == 6
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Strength Bonus' 'found' == 7
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Strength Bonus' 'found' >= 8
        for 32
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Lower Mana Cost' 'found' > 0
      if @property 'Lower Mana Cost' 'found' == 1
        for 5
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Mana Cost' 'found' == 2
        for 10
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Mana Cost' 'found' == 3
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Mana Cost' 'found' == 4
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Mana Cost' 'found' == 5
        for 25
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Mana Cost' 'found' == 6
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Mana Cost' 'found' == 7
        for 35
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Mana Cost' 'found' == 8
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Mana Cost' 'found' == 9
        for 45
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Mana Cost' 'found' >= 10
        for 50
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Hit Energy Area' 'found' > 0
      if @property 'Hit Energy Area' 'found' == 1
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 2
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 3
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 4
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 5
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 6
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 7
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 8
        for 32
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 9
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 10
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 11
        for 44
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 12
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 13
        for 52
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 14
        for 56
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 15
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 16
        for 64
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 17
        for 68
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 18
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 19
        for 76
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 20
        for 80
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 21
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 22
        for 88
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 23
        for 92
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 24
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 25
        for 100
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 26
        for 104
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 27
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 28
        for 112
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 29
        for 116
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 30
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 31
        for 124
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 32
        for 128
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 33
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 34
        for 136
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 35
        for 140
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 36
        for 144
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 37
        for 148
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 38
        for 152
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 39
        for 156
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 40
        for 160
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 41
        for 164
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 42
        for 168
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 43
        for 172
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 44
        for 176
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 45
        for 180
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 46
        for 184
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 47
        for 188
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 48
        for 192
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' == 49
        for 196
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Energy Area' 'found' >= 50
        for 200
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Swing Speed Increase' 'found' > 0
      if @property 'Swing Speed Increase' 'found' == 1
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 2
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 3
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 4
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 5
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 6
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 7
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 8
        for 32
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 9
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 10
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 11
        for 44
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 12
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 13
        for 52
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 14
        for 56
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 15
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 16
        for 64
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 17
        for 68
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 18
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 19
        for 76
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 20
        for 80
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 21
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 22
        for 88
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 23
        for 92
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 24
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 25
        for 100
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 26
        for 104
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 27
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 28
        for 112
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 29
        for 116
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 30
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 31
        for 124
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 32
        for 128
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 33
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 34
        for 136
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 35
        for 140
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 36
        for 144
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 37
        for 148
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 38
        for 152
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' == 39
        for 156
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Swing Speed Increase' 'found' >= 40
        for 160
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Hit Chance Increase' 'found' > 0
      if @property 'Hit Chance Increase' 'found' == 1
        for 3
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 2
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 3
        for 9
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 4
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 5
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 6
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 7
        for 21
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 8
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 9
        for 27
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 10
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 11
        for 33
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 12
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 13
        for 39
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 14
        for 42
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 15
        for 45
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 16
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 17
        for 51
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 18
        for 54
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 19
        for 57
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 20
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 21
        for 63
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 22
        for 66
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 23
        for 69
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 24
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 25
        for 75
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 26
        for 78
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 27
        for 81
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 28
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 29
        for 87
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 30
        for 90
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 31
        for 93
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 32
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 33
        for 99
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 34
        for 102
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 35
        for 105
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 36
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 37
        for 111
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 38
        for 114
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 39
        for 117
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 40
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 41
        for 123
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 42
        for 126
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 43
        for 129
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' == 44
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Chance Increase' 'found' >= 45
        for 135
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Hit Cold Area' 'found' > 0
      if @property 'Hit Cold Area' 'found' == 1
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 2
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 3
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 4
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 5
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 6
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 7
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 8
        for 32
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 9
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 10
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 11
        for 44
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 12
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 13
        for 52
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 14
        for 56
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 15
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 16
        for 64
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 17
        for 68
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 18
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 19
        for 76
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 20
        for 80
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 21
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 22
        for 88
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 23
        for 92
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 24
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 25
        for 100
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 26
        for 104
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 27
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 28
        for 112
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 29
        for 116
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 30
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 31
        for 124
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 32
        for 128
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 33
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 34
        for 136
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 35
        for 140
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 36
        for 144
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 37
        for 148
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 38
        for 152
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 39
        for 156
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 40
        for 160
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 41
        for 164
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 42
        for 168
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 43
        for 172
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 44
        for 176
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 45
        for 180
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 46
        for 184
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 47
        for 188
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 48
        for 192
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' == 49
        for 196
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Cold Area' 'found' >= 50
        for 200
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Hit Magic Arrow' 'found' > 0
      if @property 'Hit Magic Arrow' 'found' == 1
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 2
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 3
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 4
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 5
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 6
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 7
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 8
        for 32
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 9
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 10
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 11
        for 44
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 12
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 13
        for 52
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 14
        for 56
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 15
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 16
        for 64
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 17
        for 68
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 18
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 19
        for 76
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 20
        for 80
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 21
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 22
        for 88
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 23
        for 92
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 24
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 25
        for 100
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 26
        for 104
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 27
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 28
        for 112
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 29
        for 116
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 30
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 31
        for 124
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 32
        for 128
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 33
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 34
        for 136
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 35
        for 140
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 36
        for 144
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 37
        for 148
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 38
        for 152
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 39
        for 156
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 40
        for 160
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 41
        for 164
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 42
        for 168
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 43
        for 172
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 44
        for 176
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 45
        for 180
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 46
        for 184
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 47
        for 188
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 48
        for 192
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 49
        for 196
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 50
        for 200
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 51
        for 204
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 52
        for 208
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 53
        for 212
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 54
        for 216
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 55
        for 220
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 56
        for 224
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 57
        for 228
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 58
        for 232
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' == 59
        for 236
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Hit Magic Arrow' 'found' >= 60
        for 240
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Lower Reagent Cost' 'found' > 0
      if @property 'Lower Reagent Cost' 'found' == 1
        for 5
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' == 2
        for 10
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' == 3
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' == 4
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' == 5
        for 25
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' == 6
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' == 7
        for 35
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' == 8
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' == 9
        for 45
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' == 10
        for 50
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' == 11
        for 55
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' == 12
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' == 13
        for 65
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' == 14
        for 70
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' == 15
        for 75
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' == 16
        for 80
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' == 17
        for 85
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' == 18
        for 90
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' == 19
        for 95
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Lower Reagent Cost' 'found' >= 20
        for 100
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Faster Casting' 'testweap' < 0
      for 50
        poplist 'valuetally' 'back'
      endfor
    elseif @property 'Faster Casting' 'testweap' > 0
      for 50
        pushlist 'valuetally' 'x'
      endfor
    endif
    @ignoreobject 'found'
    if list 'valuetally' > 250
      headmsg 'Keep' 69
      moveitem 'found' 'sellbag' 0 0 0
      pause 750
    else
      headmsg 'Trash' 33
      moveitem 'found' 'recyclebag' 0 0 0
      pause 750
    endif
    @setalias 'replaysort' 'found'
  endwhile
endfor
if @findalias 'replaysort'
  replay
endif
@removelist 'valuetally'
headmsg '*Appraisal Done*' 69
playmacro 'RecycleStuff'

