import API
from Eremite.utils.items import AppraiseWeapon


def main(API: API):
    API.SysMsg("Weapon to appraise?", 111)
    target_serial = API.RequestTarget(timeout=10.0)
    if not target_serial:
        return

    weapon = API.FindItem(target_serial)
    if weapon:
        API.ItemNameAndProps(weapon.Serial, wait=True)
        AppraiseWeapon(API, weapon, summary=True)


if __name__ in ("__main__", "<module>"):
    main(API)
