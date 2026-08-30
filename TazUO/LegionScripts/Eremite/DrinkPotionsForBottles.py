import API
from Eremite.utils.items import GetMyItem, MoveItemToContainer


def find_pots(API: API, graphic: int, container_serial: int):
    if not container_serial:
        return []
    return list(API.FindTypeAll(graphic=graphic, container=container_serial)) or []


def main(API: API):
    left_hand = API.FindLayer("TwoHanded") or API.FindLayer("OneHanded")
    if left_hand:
        MoveItemToContainer(API, left_hand.Serial, API.Player.Backpack.Serial)
        API.Pause(0.6)

    backpack_serial = API.Player.Backpack.Serial
    recyclebag = GetMyItem(API, "recyclebag")
    recyclebag_serial = getattr(recyclebag, 'Serial', recyclebag) if recyclebag else None

    poison_pots = find_pots(API, 0x0F0A, backpack_serial) + find_pots(API, 0x0F0A, recyclebag_serial)
    agility_pots = find_pots(API, 0x0F08, backpack_serial) + find_pots(API, 0x0F08, recyclebag_serial)
    strength_pots = find_pots(API, 0x0F09, backpack_serial) + find_pots(API, 0x0F09, recyclebag_serial)
    heal_pots = find_pots(API, 0x0F0C, backpack_serial) + find_pots(API, 0x0F0C, recyclebag_serial)
    stam_pots = find_pots(API, 0x0F0B, backpack_serial) + find_pots(API, 0x0F0B, recyclebag_serial)
    cure_pots = find_pots(API, 0x0F07, backpack_serial) + find_pots(API, 0x0F07, recyclebag_serial)

    if poison_pots:
        for pot in poison_pots:
            pot_serial = getattr(pot, 'Serial', pot)
            while API.FindItem(pot_serial):
                API.UseObject(pot_serial)
                API.Pause(0.6)

        if getattr(API.Player, 'Poisoned', False) and cure_pots:
            for pot in cure_pots:
                pot_serial = getattr(pot, 'Serial', pot)
                while API.FindItem(pot_serial):
                    API.UseObject(pot_serial)
                    API.Pause(0.6)
                    if API.InJournal("would surely kill you", clearMatches=True):
                        break

        if getattr(API.Player, 'Poisoned', False):
            API.Msg("[cs purge")
            if API.WaitForTarget(timeout=1.5):
                API.Target(API.Player.Serial)

    for pot in find_pots(API, 0x0F07, backpack_serial):
        if recyclebag_serial:
            MoveItemToContainer(API, pot.Serial, recyclebag_serial)
            API.Pause(0.6)

    for pot in agility_pots:
        pot_serial = getattr(pot, 'Serial', pot)
        while API.FindItem(pot_serial):
            API.UseObject(pot_serial)
            API.Pause(0.6)

    for pot in stam_pots:
        pot_serial = getattr(pot, 'Serial', pot)
        while API.FindItem(pot_serial):
            if getattr(API.Player, 'Stamina', 0) >= getattr(API.Player, 'MaxStamina', 1):
                break
            API.UseObject(pot_serial)
            API.Pause(0.6)

    for pot in strength_pots:
        pot_serial = getattr(pot, 'Serial', pot)
        while API.FindItem(pot_serial):
            API.UseObject(pot_serial)
            API.Pause(0.6)

    for pot in heal_pots:
        pot_serial = getattr(pot, 'Serial', pot)
        while API.FindItem(pot_serial):
            if getattr(API.Player, 'Hits', 0) >= getattr(API.Player, 'MaxHits', 1):
                break
            API.UseObject(pot_serial)
            API.Pause(0.6)

    for pot in find_pots(API, 0x0F0C, backpack_serial):
        if recyclebag_serial:
            MoveItemToContainer(API, pot.Serial, recyclebag_serial)
            API.Pause(0.6)

    for pot in find_pots(API, 0x0F0B, backpack_serial):
        if recyclebag_serial:
            MoveItemToContainer(API, pot.Serial, recyclebag_serial)
            API.Pause(0.6)

    API.Pause(0.6)

    if left_hand:
        API.EquipItem(left_hand.Serial)


if __name__ in ("__main__", "<module>"):
    main(API)
