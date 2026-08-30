import API
from Eremite.utils.items import MoveItemToContainer

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
    0x2A4B: "Honorable Swords of",
    0x2A47: "Honorable Swords of",
    0x2A49: "Honorable Swords of",
    0x2A45: "Honorable Swords of",
    0x241D: "Ancient Urn of",
}

COLLECTOR_NPC_SERIAL = 0x0000E50B
MY_BOX_SERIAL = 0x400CC718


def main(API: API):
    if not getattr(API, 'Player', None) or not getattr(API.Player, 'Backpack', None):
        return

    collector = API.FindMobile(COLLECTOR_NPC_SERIAL)
    if not collector:
        # Search nearby mobiles for minister of trade if hardcoded serial fails
        mobiles = API.GetAllMobiles(distance=10) or []
        for m in mobiles:
            props = (API.ItemNameAndProps(m.Serial, True) or "").lower()
            if "minister of trade" in props or "ihara soko" in props or "ihab" in props:
                collector = m
                break

    if not collector:
        API.SysMsg("Collector NPC not found nearby.", 33)
        return

    collector_serial = getattr(collector, 'Serial', collector)

    box = API.FindItem(MY_BOX_SERIAL)
    if not box:
        backpack_serial = API.Player.Backpack.Serial
        items = API.ItemsInContainer(backpack_serial) or []
        for item in items:
            if getattr(item, 'Serial', None) == MY_BOX_SERIAL:
                box = item
                break

    box_serial = getattr(box, 'Serial', MY_BOX_SERIAL) if box else MY_BOX_SERIAL

    # Get items in box
    items = API.ItemsInContainer(box_serial, recursive=True) or []
    relic_count = 0

    for item in items:
        graphic = getattr(item, 'Graphic', 0)
        if graphic in lesser_tokuno_relics:
            expected_name = lesser_tokuno_relics[graphic]
            props = (API.ItemNameAndProps(item.Serial, True) or getattr(item, 'Name', '') or "").lower()

            if expected_name.lower() in props:
                API.SysMsg(f"Turning in {expected_name}...", 68)
                MoveItemToContainer(API, item.Serial, collector_serial)
                relic_count += 1
                API.Pause(0.6)
            else:
                API.SysMsg(f"Mismatch: '{props}' != '{expected_name}'", 33)

    API.SysMsg(f"Completed Tokuno turnins. Total turned in: {relic_count}", 68)


if __name__ in ("__main__", "<module>"):
    main(API)
