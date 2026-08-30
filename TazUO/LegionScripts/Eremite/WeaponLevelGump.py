import re
import time

MAX_XP = 999900
REFRESH_SEC = 1.0


def get_level_text(API: API, weapon):
    """
    Extract Level and Experience from item tooltip properties in TazUO.
    """
    if not weapon:
        return 0, 0
    props = API.ItemNameAndProps(weapon.Serial, True) or ""
    level_match = re.search(r'Level:\s*(\d+)', props, re.IGNORECASE)
    xp_match = re.search(r'Experience:\s*(\d+)', props, re.IGNORECASE)
    level = int(level_match.group(1)) if level_match else 0
    experience = int(xp_match.group(1)) if xp_match else 0
    return level, experience


def current_level_progress(level: int, experience: int) -> float:
    """
    Calculates progress ratio within the current weapon level (0.0 to 1.0).
    """
    if level <= 0:
        return 0.0
    denom = 200 * level + 100
    if denom == 0:
        return 0.0
    progress = (experience - (100 * level * level - 100)) / denom
    return max(0.0, min(1.0, progress))


def _create_gump(API: API, accept_mouse=True, can_move=True, keep_open=False):
    if hasattr(API, 'Gumps') and hasattr(API.Gumps, 'CreateGump'):
        return API.Gumps.CreateGump(accept_mouse, can_move, keep_open)
    return API.CreateGump(accept_mouse, can_move, keep_open)


def _add_gump(API: API, gump):
    if hasattr(API, 'Gumps') and hasattr(API.Gumps, 'AddGump'):
        API.Gumps.AddGump(gump)
    else:
        API.AddGump(gump)


def _create_tiled_pic(API: API, graphic: int, width: int, height: int, hue: int = 0):
    if hasattr(API, 'Gumps') and hasattr(API.Gumps, 'CreateTiledGumpPic'):
        return API.Gumps.CreateTiledGumpPic(graphic, width, height, hue)
    elif hasattr(API, 'CreateTiledGumpPic'):
        return API.CreateTiledGumpPic(graphic, width, height, hue)
    elif hasattr(API, 'Gumps') and hasattr(API.Gumps, 'CreateGumpPic'):
        return API.Gumps.CreateGumpPic(graphic, 0, 0, hue)
    elif hasattr(API, 'CreateGumpPic'):
        return API.CreateGumpPic(graphic, 0, 0, hue)
    return None


def _create_label(API: API, text: str, hue: int = 55):
    if hasattr(API, 'Gumps') and hasattr(API.Gumps, 'CreateGumpLabel'):
        return API.Gumps.CreateGumpLabel(text, hue)
    return API.CreateGumpLabel(text, hue)


def SendGump(API: API, last_xp: int, gained: bool, active_gump=None):
    """
    Renders/updates the Weapon Level Gump in TazUO while preserving user-dragged window position.
    """
    gump_x = API.GetSharedVar("WeaponLevelGump_X") or 120
    gump_y = API.GetSharedVar("WeaponLevelGump_Y") or 100

    # Save last position from active gump before processing
    if active_gump and not getattr(active_gump, 'IsDisposed', True):
        try:
            curr_x = active_gump.GetX()
            curr_y = active_gump.GetY()
            if curr_x is not None and curr_y is not None:
                gump_x, gump_y = curr_x, curr_y
                API.SetSharedVar("WeaponLevelGump_X", gump_x)
                API.SetSharedVar("WeaponLevelGump_Y", gump_y)
        except Exception:
            pass

    weapon = (
        API.FindLayer("OneHanded")
        or API.FindLayer("TwoHanded")
        or API.FindLayer("RightHand")
        or API.FindLayer("LeftHand")
    )
    if not weapon:
        if active_gump and not getattr(active_gump, 'IsDisposed', True):
            try:
                active_gump.Dispose()
            except Exception:
                pass
        return last_xp, False, None

    level, experience = get_level_text(API, weapon)

    if experience == last_xp and not gained:
        return last_xp, False, active_gump

    gained_xp = experience - last_xp
    gained = gained_xp > 0
    last_xp = experience

    base_width = 108
    overall = int(experience / MAX_XP * base_width)
    current = int(current_level_progress(level, experience) * base_width)

    # Dispose existing gump instance if open to prevent stacking UI elements
    if active_gump and not getattr(active_gump, 'IsDisposed', True):
        try:
            active_gump.Dispose()
        except Exception:
            pass

    # Create new TazUO custom Gump at preserved screen coordinates
    gump = _create_gump(API, accept_mouse=True, can_move=True, keep_open=False)
    gump.SetPos(gump_x, gump_y)

    # Background frame (gump pic 0x0E10)
    bg = _create_tiled_pic(API, 0x0E10, 118, 45)
    if bg:
        bg.SetPos(0, 0)
        gump.Add(bg)

    # Overall XP Progress Bar (Graphic 0x805 / 0x809)
    bar1_bg = _create_tiled_pic(API, 0x805, base_width, 12)
    if bar1_bg:
        bar1_bg.SetPos(4, 4)
        gump.Add(bar1_bg)

    if overall > 0:
        bar1_fill = _create_tiled_pic(API, 0x809, min(overall, base_width), 12)
        if bar1_fill:
            bar1_fill.SetPos(4, 4)
            gump.Add(bar1_fill)

    # Current Level Progress Bar (Graphic 0x805 / 0x808) or MAX label
    if experience < MAX_XP:
        bar2_bg = _create_tiled_pic(API, 0x805, base_width, 12)
        if bar2_bg:
            bar2_bg.SetPos(4, 16)
            gump.Add(bar2_bg)

        if current > 0:
            bar2_fill = _create_tiled_pic(API, 0x808, min(current, base_width), 12)
            if bar2_fill:
                bar2_fill.SetPos(4, 16)
                gump.Add(bar2_fill)
    else:
        lbl_max = _create_label(API, "MAX", 55)
        lbl_max.SetPos(43, 16)
        gump.Add(lbl_max)

    # Level & Experience Text
    lbl_info = _create_label(API, f"Lv: {level} | {experience}", 55)
    lbl_info.SetPos(4, 28)
    gump.Add(lbl_info)

    # Gained XP popup label
    if gained and gained_xp > 0:
        lbl_gained = _create_label(API, f"+{gained_xp}", 55)
        lbl_gained.SetPos(15, -12)
        gump.Add(lbl_gained)

    _add_gump(API, gump)
    return last_xp, gained, gump


def main(API: API):
    last_xp = 0
    gained = False
    active_gump = None

    while True:
        last_xp, gained, active_gump = SendGump(API, last_xp, gained, active_gump)
        API.Pause(REFRESH_SEC)


if __name__ in ("__main__", "<module>"):
    main(API)
