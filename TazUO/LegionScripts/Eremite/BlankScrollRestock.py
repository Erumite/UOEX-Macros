import API
from Eremite.utils.items import GetMyItem, MoveItemToContainer

# Configuration Serials
SCROLLBOOK_SERIAL = 0x4621E9B3   # Runebook/Runetome for vendor recall buying
HOLDINGBAG_SERIAL = 0x412D8C13   # Bag to dump blank scrolls into
HOME_RUNE_SERIAL = 0x4040330D    # Home recall rune/book
GOLD_MIN=10000

PEN_GUMP=0xDB74B85F
RUNEBOOK_GUMP=0x554B87F3
backpack_serial = API.Player.Backpack.Serial

def GoldCheck(API: API):
    return API.Player.Gold >= GOLD_MIN


def GetScrollVendors(API: API):
    mobiles = API.GetAllMobiles(distance=10) or []
    vendors = []
    for m in mobiles:
        if not getattr(m, 'IsHuman', False):
            continue
        props = (API.ItemNameAndProps(m.Serial, True) or "").lower()
        if any(title in props for title in ["scribe", "mage", "mapmaker"]) and "guildmaster" not in props and "guildmistress" not in props:
            vendors.append(m)
    return vendors


def ScrollsInPack(API: API):
    items_in_pack = API.ItemsInContainer(backpack_serial) or []
    scrolls = [i for i in items_in_pack if getattr(i, 'Graphic', 0) == 0x0EF3]
    return scrolls


def BuyScrolls(API: API, holdingbag_serial: int):
    vendors = GetScrollVendors(API)
    for vendor in vendors:
        API.UseObject(vendor.Serial)
        API.Pause(1.0)
        for scroll in ScrollsInPack(API):
            MoveItemToContainer(API, scroll.Serial, holdingbag_serial)
            API.Pause(0.6)


def RecallAndBuyAll(API: API, scrollbook_serial: int, holdingbag_serial: int):
    for runeslot in range(7, 160, 10):
        while not API.HasGump(RUNEBOOK_GUMP):
            API.UseObject(scrollbook_serial)
            API.WaitForGump(RUNEBOOK_GUMP, delay=0.6)
        API.ReplyGump(runeslot)
        API.Pause(2.5)
        BuyScrolls(API, holdingbag_serial)
        if not GoldCheck(API):
            break


def RecallHome(API: API, home_rune_serial: int):
    while not API.HasGump(RUNEBOOK_GUMP):
        API.UseObject(home_rune_serial)
        API.WaitForGump(RUNEBOOK_GUMP, delay=0.6)
    API.ReplyGump(7)
    API.Pause(3.0)


def StartCrafting(API: API):
    pens = API.FindTypeAll(0x0FBF, container=backpack_serial) or []
    scribe_pens = [p for p in pens if "scribe's pen" in (API.ItemNameAndProps(p.Serial, True) or "").lower()]

    if not scribe_pens:
        API.SysMsg("No Scribe's Pen found in backpack.", 33)
        return

    # Dismount if mounted
    if getattr(API.Player, 'IsMounted', False) or getattr(API.Player, 'Mount', None):
        API.UseObject(API.Player.Serial)
        API.Pause(0.6)

    # Open Scribe Pen craft gump & craft Flamestrike
    pen_serial = scribe_pens[0].Serial
    API.UseObject(pen_serial)
    while not API.HasGump(PEN_GUMP):
        API.Pause(0.1)
    API.ReplyGump(60004, PEN_GUMP)
    while not API.HasGump(PEN_GUMP):
        API.Pause(0.1)
    API.ReplyGump(60011, PEN_GUMP)
    while not API.HasGump(PEN_GUMP):
        API.Pause(0.1)
    API.ReplyGump(60020, PEN_GUMP)


def main(API: API):
    if not getattr(API, 'Player', None) or not getattr(API.Player, 'Backpack', None):
        return

    holdingbag = API.FindItem(HOLDINGBAG_SERIAL) or GetMyItem(API, "holdingbag")
    holdingbag_serial = getattr(holdingbag, 'Serial', HOLDINGBAG_SERIAL) if holdingbag else HOLDINGBAG_SERIAL

    while GoldCheck:
        if getattr(API.Player, 'InWarMode', False):
            API.HeadMsg("War: Skipping", API.Player.Serial, 33)
        else:
            RecallAndBuyAll(API, SCROLLBOOK_SERIAL, holdingbag_serial)
            RecallHome(API, HOME_RUNE_SERIAL)
            API.UseSkill("Hiding")
            StartCrafting(API)

        if not GoldCheck:
            API.SysMsg("Done buying.  Out of Gold!", 69)
            return
        API.SysMsg("Waiting 30 minutes to try again.")

        # Wait 30 minutes before next restock run
        for _ in range(0, 1800, 1): 
            API.Pause(1)  


if __name__ in ("__main__", "<module>"):
    main(API)
