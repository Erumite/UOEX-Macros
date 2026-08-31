import API
from Eremite.utils.sorting import QuickSort

NO_INTEREST = "you have nothing i would be interested in"
STORAGE_FULL = "storage is full"


def GetDistanceToPlayer(API: API, entity):
    if not entity:
        return 999
    ex = getattr(entity, 'X', API.Player.X)
    ey = getattr(entity, 'Y', API.Player.Y)
    return getattr(entity, 'Distance', max(abs(ex - API.Player.X), abs(ey - API.Player.Y)))


def promptVendor(API: API):
    API.SysMsg("Select Vendor", 88)
    vendor_serial = API.RequestTarget(timeout=10.0)
    if not vendor_serial:
        API.SysMsg("No vendor selected!", 33)
        return None

    vendor = API.FindMobile(vendor_serial)
    if vendor:
        API.UseObject(vendor_serial)
        API.Pause(0.4)
        return vendor
    else:
        API.SysMsg("Not a valid vendor!", 33)
        return None


def cleanJournal(API: API):
    API.InJournal(STORAGE_FULL, clearMatches=True)
    API.InJournal(NO_INTEREST, clearMatches=True)


def main(API: API):
    vendor = promptVendor(API)
    if not vendor:
        return

    cleanJournal(API)

    while not API.StopRequested:
        vendor_serial = getattr(vendor, 'Serial', vendor)
        vendor_mob = API.FindMobile(vendor_serial)

        if not vendor_mob or GetDistanceToPlayer(API, vendor_mob) > 10:
            break

        weight_max = getattr(API.Player, 'WeightMax', getattr(API.Player, 'MaxWeight', 400))
        if API.Player.Weight > weight_max * 0.8:
            QuickSort(API)

        # Context menu reply for Sell on vendor
        API.ContextMenu(vendor_serial, 2)
        API.Pause(0.6)

        if API.InJournal(NO_INTEREST, clearMatches=True):
            API.SysMsg("Vendor not interested or out of items.", 55)
            break

        if API.InJournal(STORAGE_FULL, clearMatches=True):
            API.SysMsg("Vendor storage full! Select another vendor.", 33)
            vendor = promptVendor(API)
            if not vendor:
                break

    QuickSort(API)


if __name__ in ("__main__", "<module>"):
    main(API)
