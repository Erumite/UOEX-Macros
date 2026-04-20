lesser_tokuno_relics = {
    0x2811: "Chest of Heirlooms",
    0x0EFF: "Pigments of Tokuno",
    0x27A8: "Peasant's Bokuto",
    0x27AE: "Dragon Nunchaku",
    0x277D: "Ancient Samurai Do",
    0x2798: "Ancient Farmer's Kasa",
    0x277E: "Arms of Tactical Excellence",
    0x27A2: "The Destroyer",
    0x0EFA: "Tome of Enlightenment",
    0x278F: "Black Lotus Hood",
    0x2788: "Legs of Stability",
    0x2805: "Flute of Renewal",
    0x27A6: "Exiler",
    0x2792: "Gloves of the Sun",
    0x2785: "Daimyo's Helm",
    0x27A3: "Pilfered Dancer Fans",
    0x27A5: "Hanzo's Bow",
    0x27AF: "Demon Forks",
    0x2A4B: "Honorable Swords of", # random name
    0x2A47: "Honorable Swords of", # random name
    0x2A49: "Honorable Swords of", # random name
    0x2A45: "Honorable Swords of", # random name
    0x241D: "Ancient Urn of", # random name

}
lesser_tokuno_relic_ids = list(lesser_tokuno_relics.keys())
collector_npc = 0x0000E50B # The quest guy to give stuff to.

my_box_serial = 0x400CC718
my_box = Items.FindBySerial(my_box_serial)

if not my_box.Contains:
    Items.WaitForContents(my_box,600)
    Misc.Pause(600)

for relic in Items.FindAllByID(lesser_tokuno_relic_ids, -1, my_box_serial, 1):
    if lesser_tokuno_relics[relic.ItemID] in relic.Name.strip():
        Items.Move(relic, collector_npc, -1)
        Misc.Pause(600)
    else:
        print(f"MisMatch: '{relic.Name}' != '{lesser_tokuno_relics[relic.ItemID]}'")