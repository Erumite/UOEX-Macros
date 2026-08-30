import API
from Eremite.utils.items import MoveItemToContainer, FindTypesInContainer

bank_stone_serial = 0x404DC5BE
scroll_pouch_serial = 0x42926A5A
keep_scrolls = [
    0x1F4C,  # Recall
    0x1F60,  # Gate Travel
]


def GetNearbyExexBox(API: API):
    for graphic in [0x0E7D, 0x09AA]:
        ground_items = API.GetItemsOnGround(distance=2, graphic=graphic) or []
        if ground_items:
            break
    for item in ground_items:
        if getattr(item, 'Hue', 0) == 0x082A and "exex deposit box" in (API.ItemNameAndProps(item.Serial, True) or "").lower():
            return item
    return None


def exexDump(API: API):
    exex = GetNearbyExexBox(API)
    if not exex:
        API.SysMsg("No Exex Deposit Box nearby.", 33)
        return

    exex_serial = getattr(exex, 'Serial', exex)
    backpack_serial = API.Player.Backpack.Serial

    API.HeadMsg("Nom.", exex_serial, 0x082A)

    # Dump Gold
    gold_items = API.FindTypeAll(0x0EED, container=backpack_serial) or []
    for g in gold_items:
        MoveItemToContainer(API, g.Serial, exex_serial)
        API.Pause(0.6)

    # Ointments
    ointments = API.FindTypeAll(0x0E24, container=backpack_serial) or []
    for oint in ointments:
        name = (getattr(oint, 'Name', '') or API.ItemNameAndProps(oint.Serial, True) or "").lower()
        if "ointment" in name:
            MoveItemToContainer(API, oint.Serial, exex_serial)
            API.Pause(0.6)

    # Essences
    essences = API.FindTypeAll(0x0E24, container=backpack_serial, hue=0x0679) or []
    for ess in essences:
        name = (getattr(ess, 'Name', '') or API.ItemNameAndProps(ess.Serial, True) or "").lower()
        if "essence of " in name:
            MoveItemToContainer(API, ess.Serial, exex_serial)
            API.Pause(0.6)

    API.HeadMsg("*burp*", exex_serial, 0x082A)

    # Elven Notes
    notes = API.FindTypeAll(0x0E39, container=backpack_serial, hue=0x0A43) or []
    for note in notes:
        name = (getattr(note, 'Name', '') or API.ItemNameAndProps(note.Serial, True) or "").lower()
        if "elven note" in name:
            MoveItemToContainer(API, note.Serial, exex_serial)
            API.Pause(0.6)

    # Bank Stone & Scroll Pouch
    bank_stone = API.FindItem(bank_stone_serial)
    if bank_stone:
        API.UseObject(bank_stone_serial)
        API.Pause(0.6)

    scroll_pouch = API.FindItem(scroll_pouch_serial)
    if scroll_pouch:
        scrolls = FindTypesInContainer(API, graphics=keep_scrolls, container=backpack_serial)
        for s in scrolls:
            MoveItemToContainer(API, s.Serial, scroll_pouch_serial)
            API.Pause(0.6)


def main(API: API):
    exexDump(API)


if __name__ in ("__main__", "<module>"):
    main(API)
