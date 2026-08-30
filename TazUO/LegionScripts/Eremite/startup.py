# =============== Settings ===============
max_weight = getattr(API.Player, 'WeightMax', 400)
API.SetSharedVar("WarnWeight", max_weight * 0.85)
API.SetSharedVar("CriticalWeight", max_weight * 0.95)

# =============== Item Lists ===============
smeltables = [
    0x26c1, 0x1b73, 0x13ff, 0x26bf, 0xf52, 0x1410, 0x1411, 0x1412,
    0x1413, 0x1414, 0x1408, 0x1415, 0x1c04, 0x13b6, 0x13f0, 0x13ee,
    0x26be, 0x143b, 0x143e, 0x1439, 0x13fb, 0xf4d, 0x1405, 0x1b74,
    0x1b76, 0x1b7b, 0xf4b, 0x1B79, 0x140c, 0x1401, 0x13be, 0x13bb,
    0x13b9, 0xf61, 0x1b72, 0xf45, 0x140a, 0xe87, 0xf62, 0x13ec,
    0x13EB, 0xf49, 0x26c0, 0xf5e, 0x26ba, 0x13b0, 0x1403, 0x26bc,
    0x1407, 0x140e, 0x26bb, 0xf47, 0x1443, 0x26bd, 0x13bf, 0xf5c,
    0x1441, 0x2781, 0x27A7, 0x27AD, 0x27A9, 0x27AB, 0x27A2, 0x27A4,
    0x27AF, 0x143d, 0x1BC3
]
API.SetSharedVar('smeltables', smeltables)

fletchables = [
    0x13b2, 0xf50, 0x13fd, 0x26c3, 0x26c2
]
API.SetSharedVar("fletchables", fletchables)

choppables = [
    0x13f8, 0xe89, 0xdf0, 0xe81, 0x27a8, 0x27a6
]
API.SetSharedVar('choppables', choppables)

scissorables = [
    0x1efd, 0x171B, 0x1718, 0x1714, 0x1F7B, 0x1517, 0x2310, 0x1537,
    0x153D, 0x1541, 0x1FFD, 0x1713, 0x1515, 0x1F9F, 0x1544, 0x1F01,
    0x152E, 0x1539, 0x1F00, 0x1715, 0x1719, 0x1540, 0x2306, 0x153B,
    0x1516, 0x144f, 0x1452, 0x1451, 0x13d6, 0x170b, 0x230E, 0x1F9F,
    0x171C, 0x170F, 0x170d, 0x1711, 0x144e, 0x1450, 0x1db9, 0x13d5,
    0x1c00, 0x13cd, 0x1c06, 0x13c6, 0x1c0c, 0x13cb, 0x13db, 0x13cc,
    0x13c7, 0x2776, 0x1c0a, 0x13da, 0x13dc, 0x1c08, 0x1F03, 0x1c02,
    0x27c6, 0x2796, 0x278a, 0x277e, 0x278e, 0x2797, 0x2791, 0x2792,
    0x2793, 0x27A1, 0x2798, 0x2782, 0x2B78, 0x2B74, 0x2B75, 0x2B77,
    0x277F
]
API.SetSharedVar('scissorables', scissorables)

cloths = [
    0x1081, 0xdf8, 0xfa0, 0x26b4, 0x1766
]
API.SetSharedVar('cloths', cloths)

wooditems = [
    0x1bd4, 0x1bd1, 0x1bd7, 0xf3f, 0x1bfb
]
API.SetSharedVar("wooditems", wooditems)

corpse_ignore = [
    1, 3, 4, 7, 8, 11, 13, 14, 15, 16, 17, 18, 21, 22, 24, 26, 28, 31, 39,
    40, 47, 48, 50, 51, 53, 56, 57, 58, 67, 70, 71, 72, 75, 76, 85, 86, 87,
    89, 124, 125, 130, 148, 149, 152, 154, 181, 182, 189, 196, 199, 203,
    219, 238, 240, 241, 245, 247, 251, 252, 253, 258, 263, 266, 271, 290,
    301, 302, 303, 304, 305, 307, 308, 309, 317, 400, 401, 752, 753, 754,
    755, 756, 757, 763, 764, 765, 766, 767, 768, 775, 776, 777, 778, 780,
    784, 785, 789, 790, 792, 793, 795, 796, 806, 970
]
API.SetSharedVar('corpse_ignore_list', corpse_ignore)

magery_reagents = [0xf7a, 0xf7b, 0xf84, 0xf85, 0xf86, 0xf88, 0xf8d, 0xf8c]
necro_reagents = [0xf78, 0xf7d, 0xf8f, 0xf8e, 0xf8a]
other_reagents = [0xf7e, 0xf81, 0xf0e, 0xef3, 0x1f14, 0x26b7, 0xf8f, 0xf80, 0xe1f, 0x97a, 0x26b8]
API.SetSharedVar("magery_reagents", magery_reagents)
API.SetSharedVar("necro_reagents", necro_reagents)
API.SetSharedVar("other_reagents", other_reagents)
API.SetSharedVar("key_reagents", magery_reagents + necro_reagents + other_reagents)

gems = [
    0x0f2d, 0x0f16, 0x0f19, 0x0f21, 0x0f26, 0x0f10, 0x0f13, 0x0f25, 0x0f15,
    0x1ea7, 0x3198, 0x3193, 0x3195, 0x3192, 0x3197, 0x3199, 0x3194, 0x3196
]
API.SetSharedVar("gems", gems)

tools = [
    0xe86, 0xf39, 0xe9b, 0xfbf, 0xf9d, 0x13e4, 0x1022, 0xf43, 0x1eb8, 0x1373,
    0x102a, 0x1034, 0x97f, 0xfbb, 0x9f5
]
API.SetSharedVar("tools", tools)

weapons = [
    0xe86, 0xf43, 0x26c0, 0xf4b, 0xe87, 0xf61, 0xdf0, 0x26bd, 0x13f8, 0x1405,
    0x1443, 0xf5c, 0xf49, 0x143e, 0xf4d, 0x1403, 0x13b2, 0x13b9, 0x1401, 0x26c1,
    0x26bf, 0x26bb, 0x13fd, 0x1441, 0x13b6, 0x26ba, 0x26be, 0xf5e, 0x26c3,
    0xf62, 0x143b, 0x1439, 0x1407, 0x143d, 0x26bc, 0x26c2, 0xf47, 0x13b0,
    0xf52, 0xe89, 0xf45, 0x13ff, 0x13fb, 0xf50, 0xe81
]
API.SetSharedVar("weapons", weapons)

armors = [
    0x1410, 0x1411, 0x1412, 0x1413, 0x1414, 0x1408, 0x1415, 0x1c04, 0x13f0,
    0x13ee, 0x140c, 0x13be, 0x13bb, 0x140a, 0x13ec, 0x13EB, 0x140e, 0x13bf,
    0x144f, 0x1452, 0x1451, 0x13d6, 0x144e, 0x1450, 0x1db9, 0x13d5, 0x1c00,
    0x13cd, 0x1c06, 0x13c6, 0x1c0c, 0x13cb, 0x13db, 0x13cc, 0x13c7, 0x1c0a,
    0x13da, 0x13dc, 0x1c08, 0x1c02
]
API.SetSharedVar("armors", armors)

trash_weapons = [0x0EC3, 0x0EC4, 0x13B4, 0x13F6]
API.SetSharedVar("trash_weapons", trash_weapons)

jewelry = [0x1f06, 0x1086, 0x108a, 0x1f09, 0x1087, 0x1089]
API.SetSharedVar("jewelry", jewelry)

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
    "Resistances": {"points": 5, "max": 100},
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
API.SetSharedVar("weapon_point_map", weapon_point_map)

relevant_armor_props = {
    "Defence Chance Increase", "Hit Chance Increase", "Swing Speed Increase", "Reflect Physical Damage",
    "Spell Damage", "Faster Cast Recovery", "Lower Mana Cost", "Lower Reagent Cost", "Enhance Potions",
    "Hit Point Regeneration", "Stamina Regeneration", "Mana Regeneration", "Strength Bonus",
    "Dexterity Bonus", "Intelligence Bonus", "Hit Point Increase", "Stamina Increase", "Mana Increase",
    "Physical Resist", "Fire Resist", "Cold Resist", "Poison Resist", "Energy Resist", "Resistances"
}
API.SetSharedVar("relevant_armor_props", relevant_armor_props)

relevant_weapon_props = {
    "Reflect Physical Damage", "Spell Damage", "Strength Bonus", "Hit Point Increase", "Hit Life Leech",
    "Hit Stamina Leech", "Hit Mana Leech", "Hit Lower Attack", "Hit Lower Defense", "Hit Magic Arrow",
    "Hit Harm", "Hit Fireball", "Hit Lightning", "Hit Energy Area", "Hit Fire Area", "Hit Poison Area",
    "Hit Cold Area", "Hit Physical Area",
}
API.SetSharedVar("relevant_weapon_props", relevant_weapon_props)

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
API.SetSharedVar("weapon_name_map", weapon_name_map)

spell_scrolls = [
    7982, 7983, 7984, 7985, 7986, 7987, 7981, 7988, 7989, 7990, 7991, 7992,
    7993, 7994, 7995, 7996, 7997, 7998, 7999, 8000, 8001, 8002, 8003, 8004,
    8005, 8006, 8007, 8008, 8009, 8010, 8011, 8012, 8013, 8014, 8015, 8016,
    8017, 8018, 8019, 8020, 8021, 8022, 8023, 8024, 8025, 8026, 8027, 8028,
    8029, 8030, 8031, 8032, 8033, 8034, 8035, 8036, 8037, 8038, 8039, 8040,
    8041, 8042, 8043, 8044
]
API.SetSharedVar("spell_scrolls", spell_scrolls)

ingots = [0x1BF2]
API.SetSharedVar("ingots", ingots)