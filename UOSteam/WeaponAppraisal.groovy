
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
    if @property 'Regen Stamina' 'found' > 0
      if @property 'Regen Stamina' 'found' == 1
        for 1
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Stamina' 'found' == 2
        for 2
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Stamina' 'found' == 3
        for 3
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Stamina' 'found' == 4
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Stamina' 'found' == 5
        for 5
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Stamina' 'found' == 6
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Stamina' 'found' == 7
        for 7
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Stamina' 'found' == 8
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Stamina' 'found' == 9
        for 9
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Stamina' 'found' >= 10
        for 10
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
    if @property 'Damage Increase' 'found' > 0
      if @property 'Damage Increase' 'found' == 1
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 2
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 3
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 4
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 5
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 6
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 7
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 8
        for 32
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 9
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 10
        for 40
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 11
        for 44
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 12
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 13
        for 52
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 14
        for 56
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 15
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 16
        for 64
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 17
        for 68
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 18
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 19
        for 76
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 20
        for 80
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 21
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 22
        for 88
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 23
        for 92
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 24
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 25
        for 100
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 26
        for 104
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 27
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 28
        for 112
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 29
        for 116
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 30
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 31
        for 124
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 32
        for 128
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 33
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 34
        for 136
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 35
        for 140
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 36
        for 144
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 37
        for 148
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 38
        for 152
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 39
        for 156
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 40
        for 160
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 41
        for 164
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 42
        for 168
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 43
        for 172
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 44
        for 176
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 45
        for 180
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 46
        for 184
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 47
        for 188
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 48
        for 192
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 49
        for 196
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 50
        for 200
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 51
        for 204
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 52
        for 208
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 53
        for 212
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 54
        for 216
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 55
        for 220
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 56
        for 224
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 57
        for 228
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 58
        for 232
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' == 59
        for 236
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Damage Increase' 'found' >= 60
        for 240
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
    if @property 'Bonus Mana' 'found' > 0
      if @property 'Bonus Mana' 'found' == 1
        for 3
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Mana' 'found' == 2
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Mana' 'found' == 3
        for 9
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Mana' 'found' == 4
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Mana' 'found' == 5
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Mana' 'found' == 6
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Mana' 'found' == 7
        for 21
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Mana' 'found' >= 8
        for 24
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
    if @property 'Bonus Dex' 'found' > 0
      if @property 'Bonus Dex' 'found' == 1
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Dex' 'found' == 2
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Dex' 'found' == 3
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Dex' 'found' == 4
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Dex' 'found' == 5
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Dex' 'found' == 6
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Dex' 'found' == 7
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Dex' 'found' >= 8
        for 32
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
    if @property 'Regen Hits' 'found' > 0
      if @property 'Regen Hits' 'found' == 1
        for 2
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Hits' 'found' == 2
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Hits' 'found' == 3
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Hits' 'found' == 4
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Hits' 'found' == 5
        for 10
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Hits' 'found' >= 6
        for 12
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
    if @property 'Luck' 'found' > 0
      if @property 'Luck' 'found' == 1
        for 3
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 2
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 3
        for 9
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 4
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 5
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 6
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 7
        for 21
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 8
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 9
        for 27
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 10
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 11
        for 33
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 12
        for 36
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 13
        for 39
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 14
        for 42
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 15
        for 45
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 16
        for 48
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 17
        for 51
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 18
        for 54
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 19
        for 57
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 20
        for 60
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 21
        for 63
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 22
        for 66
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 23
        for 69
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 24
        for 72
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 25
        for 75
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 26
        for 78
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 27
        for 81
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 28
        for 84
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 29
        for 87
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 30
        for 90
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 31
        for 93
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 32
        for 96
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 33
        for 99
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 34
        for 102
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 35
        for 105
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 36
        for 108
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 37
        for 111
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 38
        for 114
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 39
        for 117
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 40
        for 120
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 41
        for 123
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 42
        for 126
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 43
        for 129
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 44
        for 132
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 45
        for 135
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 46
        for 138
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 47
        for 141
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 48
        for 144
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 49
        for 147
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 50
        for 150
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 51
        for 153
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 52
        for 156
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 53
        for 159
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 54
        for 162
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 55
        for 165
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 56
        for 168
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 57
        for 171
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 58
        for 174
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 59
        for 177
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 60
        for 180
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 61
        for 183
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 62
        for 186
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 63
        for 189
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 64
        for 192
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 65
        for 195
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 66
        for 198
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 67
        for 201
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 68
        for 204
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 69
        for 207
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 70
        for 210
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 71
        for 213
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 72
        for 216
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 73
        for 219
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 74
        for 222
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 75
        for 225
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 76
        for 228
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 77
        for 231
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 78
        for 234
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 79
        for 237
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 80
        for 240
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 81
        for 243
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 82
        for 246
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 83
        for 249
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 84
        for 252
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 85
        for 255
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 86
        for 258
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 87
        for 261
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 88
        for 264
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 89
        for 267
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 90
        for 270
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 91
        for 273
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 92
        for 276
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 93
        for 279
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 94
        for 282
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 95
        for 285
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 96
        for 288
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 97
        for 291
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 98
        for 294
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 99
        for 297
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 100
        for 300
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 101
        for 303
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 102
        for 306
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 103
        for 309
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 104
        for 312
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 105
        for 315
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 106
        for 318
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 107
        for 321
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 108
        for 324
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 109
        for 327
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 110
        for 330
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 111
        for 333
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 112
        for 336
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 113
        for 339
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 114
        for 342
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 115
        for 345
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 116
        for 348
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 117
        for 351
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 118
        for 354
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 119
        for 357
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 120
        for 360
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 121
        for 363
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 122
        for 366
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 123
        for 369
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 124
        for 372
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 125
        for 375
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 126
        for 378
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 127
        for 381
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 128
        for 384
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 129
        for 387
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 130
        for 390
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 131
        for 393
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 132
        for 396
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 133
        for 399
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 134
        for 402
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 135
        for 405
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 136
        for 408
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 137
        for 411
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 138
        for 414
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 139
        for 417
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 140
        for 420
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 141
        for 423
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 142
        for 426
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 143
        for 429
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 144
        for 432
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 145
        for 435
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 146
        for 438
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 147
        for 441
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 148
        for 444
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' == 149
        for 447
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Luck' 'found' >= 150
        for 450
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
    if @property 'Bonus Strength' 'found' > 0
      if @property 'Bonus Strength' 'found' == 1
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Strength' 'found' == 2
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Strength' 'found' == 3
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Strength' 'found' == 4
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Strength' 'found' == 5
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Strength' 'found' == 6
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Strength' 'found' == 7
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Strength' 'found' >= 8
        for 32
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Bonus Stamina' 'found' > 0
      if @property 'Bonus Stamina' 'found' == 1
        for 3
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Stamina' 'found' == 2
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Stamina' 'found' == 3
        for 9
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Stamina' 'found' == 4
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Stamina' 'found' == 5
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Stamina' 'found' == 6
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Stamina' 'found' == 7
        for 21
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Stamina' 'found' >= 8
        for 24
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Regen Mana' 'found' > 0
      if @property 'Regen Mana' 'found' == 1
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Mana' 'found' == 2
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Mana' 'found' == 3
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Mana' 'found' == 4
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Mana' 'found' == 5
        for 30
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Regen Mana' 'found' >= 6
        for 36
          pushlist 'valuetally' 'x'
        endfor
      endif
    endif
    if @property 'Bonus Hits' 'found' > 0
      if @property 'Bonus Hits' 'found' == 1
        for 3
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Hits' 'found' == 2
        for 6
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Hits' 'found' == 3
        for 9
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Hits' 'found' == 4
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Hits' 'found' == 5
        for 15
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Hits' 'found' == 6
        for 18
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Hits' 'found' == 7
        for 21
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Hits' 'found' >= 8
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
    if @property 'Bonus Int' 'found' > 0
      if @property 'Bonus Int' 'found' == 1
        for 4
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Int' 'found' == 2
        for 8
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Int' 'found' == 3
        for 12
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Int' 'found' == 4
        for 16
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Int' 'found' == 5
        for 20
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Int' 'found' == 6
        for 24
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Int' 'found' == 7
        for 28
          pushlist 'valuetally' 'x'
        endfor
      elseif @property 'Bonus Int' 'found' >= 8
        for 32
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
      moveitem 'found' 'sellbag'
      pause 800
    else
      headmsg 'Trash' 33
      moveitem 'found' 'recyclebag'
      pause 800
    endif
  endwhile
endfor
@removelist 'valuetally'
headmsg '*Appraisal Done*' 69
playmacro 'RecycleStuff'

