# =============== Item IDs ===============
Misc.SetSharedValue('smith_hammer_id' ,0x13E4)
Misc.SetSharedValue('fletching_tools_id', 0x1022)
Misc.SetSharedValue('carpenter_hammer_id' ,0x102A)
Misc.SetSharedValue('shovel_id', 0x0F39)
Misc.SetSharedValue('scissors_id', 0x0F9F)
Misc.SetSharedValue('butchers_war_cleaver_id', 0x2D2F)
Misc.SetSharedValue('scissors_id', 0x0F9F)
Misc.SetSharedValue('keys_id', 0x176B)
Misc.SetSharedValue('toolhouse_id', 0x22C4)
    
# =============== Item Lists ===============

smeltables = [
    0x26c1, # Crescent Blades
    0x1b73, # Bucklers
    0x13ff, # Katana
    0x26bf, # DoubleBladed Staff
    0xf52,  # Daggers
    0x1410, # plate arms
    0x1411, # Plate Legs
    0x1412, # Plate Helm
    0x1413, # Plate Gorget
    0x1414, # Plate Gloves
    0x1408, # Close Helmet
    0x1415, # Plate Chest
    0x1c04, # Female Plate Chest
    0x13b6, # Scimitar
    0x13f0, # Ring Legs
    0x13ee, # ring arms
    0x26be, # Pike
    0x143b, # Maul
    0x143e, # Halberd
    0x1439, # War Hammer
    0x13fb, # Large Battle Axe
    0xf4d,  # Bardiche
    0x1405, # War Fork
    0x1b74, # Kite Shield
    0x1b76, # Heater Shield
    0x1b7b, # Metal Round Shield
    0xf4b,  # Double Axe
    0x1B79, # Tear Kite Shield
    0x140c, # Bascinet Helm
    0x1401, # Kriss
    0x13be, # Chain Legs
    0x13bb, # Chain Coif
    0x13b9, # Viking Sword
    0xf61,  # Long Sword
    0x1b72, # Bronze round Shield
    0xf45,  # Executioner Axe
    0x140a, # Helmet
    0xe87,  # Pitchfork
    0xf62,  # Spear
    0x13ec, # Ringmail Tunic
    0x13EB, # Ringmail Gloves
    0xf49,  # Axe
    0x26c0, # Lance
    0xf5e,  # Broadsword
    0x26ba, # Scythe
    0x13b0, # War Axe
    0x1403, # Short Spear
    0x26bc, # Scepter
    0x1407, # War Mace
    0x140e, # Norse Helm
    0x26bb, # Bone Harvester
    0xf47,  # Battle Axe
    0x1443, # Battle Axe
    0x26bd, # Bladed Staff
    0x13bf, # Chainmail Tunic
    0xf5c,  # Mace
    0x1441, # Cutlass
    0x2781, # Jingasa
    0x27A7, # Lajatang
    0x27AD, # Kama
    0x27A9, # Daisho
    0x27AB, # Tekagi
    0x27A2, # No-Dachi
    0x27A4, # Wakizashi
    0x27AF, # Sai
    0x143d,  # Hammer Pick
    0x1BC3, # Chaos Shield
]
Misc.RemoveSharedValue('smeltables')
Misc.SetSharedValue('smeltables', smeltables)


fletchables = [
    0x13b2, # Bow
    0xf50,  # X-Bow
    0x13fd, # Heavy X-Bow
    0x26c3, # Repeating X-Bow
    0x26c2  # Composite Bow
]
Misc.RemoveSharedValue("fletchables")
Misc.SetSharedValue("fletchables", fletchables)


choppables = [
    0x13f8, # Gnarled Staff
    0xe89,  # Quarter Staff
    0xdf0,  # Black Staff
    0xe81,  # Shepherd's Crook
    0x27a8, # Bokuto
    0x27a6  # Tetsubo
]
Misc.RemoveSharedValue('choppables')
Misc.SetSharedValue('choppables', choppables)

scissorables = [
    0x1efd, # Fancy Shirt
    0x1718, # Wizard Hat
    0x1F7B, # Doublet
    0x1517, # Shirt
    0x1713, # Floppy Hat
    0x1515, # Cloak
    0x1F9F, # Fur Cape
    0x1544, # Skull Cap
    0x1F01, # Plain Dress
    0x152E, # Short Pants
    0x1F00, # Fancy Dress
    0x1715, # Cap
    0x1540, # Bandana
    0x153B, # Half Apron
    0x1516, # Skirt
    0x144f, # Bone Chest
    0x1452, # Bone Legs
    0x1451, # Bone Helm
    0x13d6, # studded gorget
    0x170b, # Boots
    0x230E, # Gilded Dress
    0x1F9F, # Jester Suit
    0x171C, # Jester Hat
    0x170F, # Shoes
    0x170d, # Sandals
    0x1711, # thigh boots
    0x144e, # Bone Wrists
    0x1450, # bone gloves
    0x1db9, # leather hat
    0x13d5, # Studded gloves
    0x1c00, # Leather Shorts
    0x13cd, # Leather Sleeves
    0x1c06, # Female Leather Armor
    0x13c6, # Leather Gloves
    0x1c0c, # Studded Bustier
    0x13cb, # Leather Legs
    0x13db, # Studded Tunic
    0x13cc, # Leather Tunic
    0x13c7, # Leather Gorget
    0x2776, # Leather Jingasa
    0x1c0a, # Leather Bustier
    0x13da, # Studded Leggings
    0x13dc, # Studded Sleeves
    0x1c08, # Leather Skirt
    0x1F03, # Robe
    0x1c02, # Studded Armor
    0x27c6, # Leather Do
    0x2796, # Waraji and Tabi
    0x278a, # Leather Haidate
    0x277e, # Leather Hiro Sode
    0x278e, # Leather Ninja Hood
    0x2797, # Ninja Tabi
    0x2791, # Leather Ninja Pants
    0x2792, # Leather Ninja Mitts
    0x2793  # Leather Ninja Jacket
]
Misc.RemoveSharedValue('scissorables')
Misc.SetSharedValue('scissorables', scissorables)

cloth_items = [
    0x1081, # Leather (Any)
    0xdf8,  # Wool
    0xfa0,  # Spools of Thread
    0x26b4, # Scales
    0x1766  # Cut Cloth
]
Misc.RemoveSharedValue('cloths')
Misc.SetSharedValue('cloths', cloth_items)


wood_key_items = [
    0x1bd4, # Shafts
    0x1bd1, # Feathers
    0x1bd7, # Boards
    0xf3f,  # Arrows
    0x1bfb  # bolts
]
Misc.RemoveSharedValue("wooditems")
Misc.SetSharedValue("wooditems", wood_key_items)

corpse_ignore = [
    1,   # Ogre
    3,   # Zombie
    4,   # Gargoyle
    7,   # Orc Lord
    8,   # Corpser
    11,  # Dread Spider
    13,  # Air Elemental
    14,  # Earth Elemental
    15,  # Fire Elemental
    16,  # Blood Elemental
    17,  # Orc
    18,  # Ettin
    21,  # Silver Serpent
    22,  # Gazer
    24,  # Lich
    26,  # Shade
    28,  # Giant Spider
    31,  # Headless One
    39,  # Mongbat
    40,  # Balron
    47,  # Reaper
    48,  # Giant Scorpion
    50,  # Skeleton
    51,  # Slime
    53,  # Troll
    56,  # Another Skeleton
    57,  # Skeletal Knight
    58,  # Wisp
    67,  # Stone Gargoyle
    70,  # Terathan Warrior
    71,  # Terathan Drone
    72,  # Terathan Matriarch
    75,  # Cyclops
    85,  # Ophidian Mage/Shaman
    86,  # Ophidian Avenger
    87,  # Ophidian Matriarch
    89,  # Fungal Lurker
    124, # Evil Mage
    125, # Evil Mage Lord
    130, # Fire Gargoyle
    148, # Skeletal Mage
    149, # Succubus
    152, # Terathan Avenger
    154, # Mummy
    181, # Orc ??? (weird shambly thing)
    182, # Orc Bomber
    196, # Kaze Kemono
    199, # Shadow
    219, # Forest Ostard
    238, # Rat
    240, # Kappa
    241, # Oni
    245, # Yomutsu Warrior
    247, # Fan Dancer
    251, # Revenant Lion
    252, # Lady of the Snow
    253, # Yumutsu Priest
    302, # Skittering Hopper
    303, # Devourer of Souls
    305, # Gore Fiend
    307, # Gibbering Corpse
    308, # Bone Daemon
    309, # Patchwork Skeleton
    317, # Vampire Bat
    400, # Human Male
    401, # Human Female
    752, # Golem
    753, # Enslaved Gargoyle
    754, # Gargoyle Enforcer
    755, # Gargoyle Destroyer
    756, # Exodus Overseer
    757, # Exodus Minion
    764, # Juka Warrior
    765, # Juka Mage
    766, # Juka Lord
    775, # Plague Beast
    776, # Horde Minion
    777, # Doppelganger
    778, # Gazer Larva
    780, # Bog Thing
    785, # Moloch
    789, # Quagmire
    790, # Sand Vortex
    792, # Chaos Demon
    793, # Undead Steed
    806, # Solen Infiltrator
    970  # Restless Soul (shrouded human)
]
Misc.RemoveSharedValue('corpse_ignore_list')
Misc.SetSharedValue('corpse_ignore_list', corpse_ignore)


magery_reagents = [
    0xf7a,  # Black Pearl
    0xf7b,  # Bloodmoss
    0xf84,  # Garlic
    0xf85,  # Ginseng
    0xf86,  # Mandrake Root
    0xf88,  # Nightshade
    0xf8d,  # Spider's Silk
    0xf8c   # Sulfurous Ash
]
necro_reagents = [
    0xf78,  # Bat Wings
    0xf7d,  # Daemon's Blood
    0xf8f,  # Grave Dust
    0xf8e,  # Nox Crystals
    0xf8a   # Pig Iron
]
other_reagents = [
    0xf7e,  # Bone
    0xf81,  # Fertile Dirt
    0xf0e,  # Empty Bottle
    0xef3,  # Blank Scrolls
    0x1f14, # Recall Rune
    0x26b7, # Zoogi Fungus
    0xf8f,  # Ethereal Powder
    0xf80,  # Daemon Bone
    0xe1f,  # Destroying Angel
    0x97a,  # Petrified Wood
    0x26b8, # Powder of Translocation
]

Misc.RemoveSharedValue("MageryReagents")
Misc.SetSharedValue("MageryReagents", magery_reagents)

Misc.RemoveSharedValue("NecromancyReagents")
Misc.SetSharedValue("NecromancyReagents", necro_reagents)

Misc.RemoveSharedValue("OtherReagents")
Misc.SetSharedValue("OtherReagents", other_reagents)

Misc.RemoveSharedValue("KeyReagents")
Misc.SetSharedValue("KeyReagents", magery_reagents + necro_reagents + other_reagents)


gems = [
  0x0f2d, # Tourmaline
  0x0f16, # Amethyst
  0x0f19, # Sapphire
  0x0f21, # Star Sapphire
  0x0f26, # Diamond
  0x0f10, # Emerald
  0x0f13, # Ruby
  0x0f25, # Pice of Amber
  0x0f15, # Citrine
  0x1ea7, # Arcane Gem
  0x3198, # Blue Diamond
  0x3193, # Turquoise
  0x3195, # Ecru Citrine
  0x3192, # Dark Sapphire
  0x3197, # Fire Ruby
  0x3199, # Brilliant Amber
  0x3194, # Perfect Emerald
]
Misc.RemoveSharedValue("gems")
Misc.SetSharedValue("gems", gems)

tools = [
    0xe86,  # Pickaxe
    0xf39,  # Shovel
    0xe9b,  # Mortar and Pestle
    0xfbf,  # Scribe's Pen
    0xf9d,  # Sewing Kit
    0x13e4, # Smith's Hammer
    0x1022, # Fletching Tools
    0xf43,  # Hatchet
    0x1eb8, # Tinker Tools
    0x1373, # Pet Brush
    0x102a, # Carp Hammer
    0x1034, # Saw
    0x97f,  # Skillet
    0xfbb,  # Tongs
    0x9f5   # Hive Tool
]
Misc.RemoveSharedValue("tools")
Misc.SetSharedValue("tools", tools)


weapons = [
    0x26c0, # Lance
    0xf4b,  # DoubleAxe
    0xe87,  # Pitchfork
    0xf61,  # Longsword
    0xdf0,  # Black Staff
    0x26bd, # Bladed Staff
    0x13f8, # Gnarled Staff
    0x1405, # War Fork
    0x1443, # 2H Axe
    0xf5c,  # Mace
    0xf49,  # Axe
    0x143e, # Halberd
    0xf4d,  # Bardiche
    0x1403, # Short Spear
    0x13b2, # Bow
    0x13b9, # Viking Sword
    0x1401, # Kryss
    0x26c1, # Crescent Blade
    0x26bf, # Double Bladed Staff
    0x26bb, # Bone Harvester
    0x13fd, # Heavy Crossbow
    0x1441, # Cutlass
    0x13b6, # Scimitar
    0x26ba, # Scythe
    0x26be, # Pike
    0xf5e,  # Broadsword
    0x26c3, # Repeating XBow
    0xf62,  # Spear
    0x143b, # Maul
    0x1439, # War Hammer
    0x1407, # War Mace
    0x143d, # Hammer Pick
    0x26bc, # Scepter
    0x26c2, # Composite Bow
    0xf47,  # Battle Axe
    0x13b0, # War Axe
    0xf52,  # Dagger
    0xe89,  # Quarter Staff
    0xf45,  # Executioner Axe
    0x13ff, # Katana
    0x13fb, # Large Battle Axe
    0xf50,  # Crossbow
    0xe81   # Shepherd's Crook
]
Misc.RemoveSharedValue("weapons")
Misc.SetSharedValue("weapons", weapons)

trash_weapons = [
    0x0EC3, # Cleaver
    0x0EC4, # Skinning Knife
    0x13B4, # Club
]
Misc.RemoveSharedValue("trash_weapons")
Misc.SetSharedValue("trash_weapons", trash_weapons)


jewelry = [
    0x1f06, # Silver Bracelet
    0x1086, # Gold Bracelet
    0x108a, # Gold Ring
    0x1f09 # Silver Ring
]
Misc.SetSharedValue("jewelry", jewelry)

weapon_point_map = {
    "Defence Chance Increase": {"points": 3, "max": 50},
    "Hit Chance Increase": {"points": 3, "max": 45},
    "Swing Speed Increase": {"points": 4, "max": 40},
    "Reflect Physical Damage": {"points": 3, "max": 15},
    "Spell Damage": {"points": 2, "max": 20},
    "Faster Cast Recovery": {"points": 5, "max": 6},
    "Lower Mana Cost": {"points": 5, "max": 10},
    "Lower Reagent Cost": {"points": 5, "max": 20},
    "Enhance Potions": {"points": 2, "max": 25},
    "Hit Point Regeneration": {"points": 2, "max": 6},
    "Stamina Regeneration": {"points": 1, "max": 10},
    "Mana Regeneration": {"points": 6, "max": 6},
    "Strength Bonus": {"points": 4, "max": 8},
    "Dexterity Bonus": {"points": 4, "max": 8},
    "Intelligence Bonus": {"points": 4, "max": 8},
    "Hit Point Increase": {"points": 3, "max": 8},
    "Stamina Increase": {"points": 3, "max": 8},
    "Mana Increase": {"points": 3, "max": 8},
    "Physical Resist": {"points": 5, "max": 20},
    "Fire Resist": {"points": 5, "max": 20},
    "Cold Resist": {"points": 5, "max": 20},
    "Poison Resist": {"points": 5, "max": 20},
    "Energy Resist": {"points": 5, "max": 20},
    "Hit Life Leech": {"points": 3, "max": 60},
    "Hit Stamina Leech": {"points": 3, "max": 60},
    "Hit Mana Leech": {"points": 3, "max": 60},
    "Hit Lower Attack": {"points": 3, "max": 60},
    "Hit Lower Defense": {"points": 3, "max": 60},
    "Hit Magic Arrow": {"points": 4, "max": 60},
    "Hit Harm": {"points": 4, "max": 60},
    "Hit Fireball": {"points": 4, "max": 60},
    "Hit Lightning": {"points": 4, "max": 60},
    "Hit Energy Area": {"points": 4, "max": 50},
    "Hit Fire Area": {"points": 4, "max": 50},
    "Hit Poison Area": {"points": 4, "max": 50},
    "Hit Cold Area": {"points": 4, "max": 50},
    "Hit Physical Area": {"points": 4, "max": 50},
}
Misc.RemoveSharedValue("weapon_point_map")
Misc.SetSharedValue("weapon_point_map", weapon_point_map)

weapon_name_map = {
    "defense chance increase": "Defence Chance Increase",
    "hit chance increase": "Hit Chance Increase",
    "swing speed increase": "Swing Speed Increase",
    "reflect physical damage": "Reflect Physical Damage",
    "spell damage": "Spell Damage",
    "spell damage increase": "Spell Damage",
    "faster cast recovery": "Faster Cast Recovery",
    "lower mana cost": "Lower Mana Cost",
    "lower reagent cost": "Lower Reagent Cost",
    "enhance potions": "Enhance Potions",
    "hit point regeneration": "Hit Point Regeneration",
    "stamina regeneration": "Stamina Regeneration",
    "mana regeneration": "Mana Regeneration",
    "strength bonus": "Strength Bonus",
    "dexterity bonus": "Dexterity Bonus",
    "intelligence bonus": "Intelligence Bonus",
    "hit point increase": "Hit Point Increase",
    "stamina increase": "Stamina Increase",
    "mana increase": "Mana Increase",
    "physical resist": "Physical Resist",
    "fire resist": "Fire Resist",
    "cold resist": "Cold Resist",
    "poison resist": "Poison Resist",
    "energy resist": "Energy Resist",
    "hit life leech": "Hit Life Leech",
    "hit stamina leech": "Hit Stamina Leech",
    "hit mana leech": "Hit Mana Leech",
    "hit lower attack": "Hit Lower Attack",
    "hit lower defense": "Hit Lower Defense",
    "hit magic arrow": "Hit Magic Arrow",
    "hit harm": "Hit Harm",
    "hit fireball": "Hit Fireball",
    "hit lightning": "Hit Lightning",
    "hit energy area": "Hit Energy Area",
    "hit fire area": "Hit Fire Area",
    "hit poison area": "Hit Poison Area",
    "hit cold area": "Hit Cold Area",
    "hit physical area": "Hit Physical Area",
}
Misc.RemoveSharedValue("weapon_name_map")
Misc.SetSharedValue("weapon_name_map", weapon_name_map)

spell_scrolls = [
    7982, # Clumsy scroll
    7983, # Create Food scroll
    7984, # Feeblemind scroll
    7985, # Heal scroll
    7986, # Magic Arrow scroll
    7987, # Night Sight scroll
    7981, # Reactive Armor scroll
    7988, # Weaken scroll
    7989, # Agility scroll
    7990, # Cunning scroll
    7991, # Cure scroll
    7992, # Harm scroll
    7993, # Magic Trap scroll
    7994, # Magic Untrap scroll
    7995, # Protection scroll
    7996, # Strength scroll
    7997, # Bless scroll
    7998, # Fireball scroll
    7999, # Magic Lock scroll
    8000, # Poison scroll
    8001, # Telekinesis scroll
    8002, # Teleport scroll
    8003, # Unlock scroll
    8004, # Wall of Stone scroll
    8005, # Arch Cure scroll
    8006, # Arch Protection scroll
    8007, # Curse scroll
    8008, # Fire Field scroll
    8009, # Greater Heal scroll
    8010, # Lightning scroll
    8011, # Mana Drain scroll
    8012, # Recall scroll
    8013, # Blade Spirits scroll
    8014, # Dispel Field scroll
    8015, # Incognito scroll
    8016, # Magic Reflection scroll
    8017, # Mind Blast scroll
    8018, # Paralyze scroll
    8019, # Poison Field scroll
    8020, # Summon Creature scroll
    8021, # Dispel scroll
    8022, # Energy Bolt scroll
    8023, # Explosion scroll
    8024, # Invisibility scroll
    8025, # Mark scroll
    8026, # Mass Curse scroll
    8027, # Paralyze Field scroll
    8028, # Reveal scroll
    8029, # Chain Lightning scroll
    8030, # Energy Field scroll
    8031, # Flamestrike scroll
    8032, # Gate Travel scroll
    8033, # Mana Vampire scroll
    8034, # Mass Dispel scroll
    8035, # Meteor Swarm scroll
    8036, # Polymorph scroll
    8037, # Earthquake scroll
    8038, # Energy Vortex scroll
    8039, # Resurrection scroll
    8040, # Summon Air Elemental scroll
    8041, # Summon Daemon scroll
    8042, # Summon Earth Elemental scroll
    8043, # Summon Fire Elemental scroll
    8044, # Summon Water Elemental scroll
]
Misc.SetSharedValue("spell_scrolls", spell_scrolls)