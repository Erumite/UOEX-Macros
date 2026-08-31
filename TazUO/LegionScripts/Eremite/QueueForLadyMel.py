import re
import API

MEL_STONE_SERIAL = 0x408832D7  # Green stone when queue is ready
MEL_GUIDE_SERIAL = 0x449E44EE  # Stone next to entry stone
MAX_WAIT_MINUTES = 22.0
GUMP_ID = 123458
DEFAULT_X = 420
DEFAULT_Y = 100


def GetDistanceToSerial(API: API, serial: int) -> int:
    if not getattr(API, 'Player', None):
        return 999
    item = API.FindItem(serial)
    if not item:
        return 999
    ix = getattr(item, 'X', 0)
    iy = getattr(item, 'Y', 0)
    return getattr(item, 'Distance', max(abs(ix - API.Player.X), abs(iy - API.Player.Y)))


def SaveGumpPosition(active_gump):
    if active_gump and not getattr(active_gump, 'IsDisposed', False):
        try:
            cur_x = active_gump.GetX()
            cur_y = active_gump.GetY()
            if cur_x is not None and cur_y is not None:
                API.SetSharedVar("LadyMelGump_X", cur_x)
                API.SetSharedVar("LadyMelGump_Y", cur_y)
        except Exception:
            pass


def findTimeBag(API: API):
    if not getattr(API, 'Player', None) or not getattr(API.Player, 'Backpack', None):
        return None

    ground_items = API.FindTypeAll(0x0E76, range=15) or []
    for bag in ground_items:
        props = (API.ItemNameAndProps(bag.Serial, True) or "").lower()
        if "time remaining" in props:
            return bag
    return None


def timeRemaining(API: API, bag):
    if not bag:
        return 0
    props = API.ItemNameAndProps(bag.Serial, True) or ""
    pattern = re.compile(r"^(\d+)\s+items,", re.IGNORECASE)
    for line in props.splitlines():
        match = pattern.search(line.strip())
        if match:
            try:
                return int(match.group(1))
            except ValueError:
                pass
    return 0


def RenderMelGump(API: API, time_left: int, active_gump):
    base_width = 108
    if not time_left or time_left <= 0:
        SaveGumpPosition(active_gump)
        if active_gump and not getattr(active_gump, 'IsDisposed', False):
            try:
                active_gump.Dispose()
            except Exception:
                pass
        API.CloseGump(GUMP_ID)
        return None

    gump_x = API.GetSharedVar("LadyMelGump_X") or DEFAULT_X
    gump_y = API.GetSharedVar("LadyMelGump_Y") or DEFAULT_Y

    if active_gump is None or getattr(active_gump, 'IsDisposed', False):
        active_gump = API.Gumps.CreateGump(acceptMouseInput=True, canMove=True)
        if not active_gump:
            return None
        active_gump.SetX(gump_x)
        active_gump.SetY(gump_y)
        API.CloseGump(GUMP_ID)
        API.Gumps.AddGump(active_gump)
    else:
        SaveGumpPosition(active_gump)
        active_gump.Clear()

    # Translucent dark background box
    bg = API.Gumps.CreateGumpColorBox(opacity=0.6, color="#050505")
    if bg:
        bg.SetRect(0, 0, base_width + 8, 30)
        active_gump.Add(bg)

    # Progress bar background
    bar_bg = API.Gumps.CreateGumpColorBox(opacity=0.8, color="#333333")
    if bar_bg:
        bar_bg.SetRect(4, 4, base_width, 12)
        active_gump.Add(bar_bg)

    # Filled progress bar
    pct = max(0, min(base_width, int((1.0 - (float(time_left) / MAX_WAIT_MINUTES)) * base_width)))
    if pct > 0:
        bar_fill = API.Gumps.CreateGumpColorBox(opacity=0.9, color="#00FF66")
        if bar_fill:
            bar_fill.SetRect(4, 4, pct, 12)
            active_gump.Add(bar_fill)

    # Minutes left label
    label = API.Gumps.CreateGumpTTFLabel(f"{time_left} min left", 14, color="#FFFFFF")
    if label:
        label.SetX(4)
        label.SetY(14)
        active_gump.Add(label)

    return active_gump


def WaitForMelStone(API: API):
    API.SysMsg("Waiting for Lady Mel stone...", 77)
    timebag = findTimeBag(API)
    active_gump = None
    last_rendered_time = None

    try:
        while not API.StopRequested:
            # Check if green stone is present
            mel_stone = API.FindItem(MEL_STONE_SERIAL)
            if mel_stone:
                return True

            # Check distance to guide stone
            guide_dist = GetDistanceToSerial(API, MEL_GUIDE_SERIAL)
            if guide_dist > 15:
                if getattr(API, 'Player', None):
                    API.HeadMsg("Running away?", API.Player.Serial, 45)
                return False

            time_val = timeRemaining(API, timebag)

            # Skip re-rendering if remaining minutes haven't changed and gump is active
            if time_val == last_rendered_time and active_gump and not getattr(active_gump, 'IsDisposed', False):
                API.Pause(1.0)
                continue

            # Save gump position periodically
            SaveGumpPosition(active_gump)

            active_gump = RenderMelGump(API, time_val, active_gump)
            last_rendered_time = time_val
            API.Pause(1.0)
    finally:
        SaveGumpPosition(active_gump)
        if active_gump and not getattr(active_gump, 'IsDisposed', False):
            try:
                active_gump.Dispose()
            except Exception:
                pass
        API.CloseGump(GUMP_ID)

def main(API: API):
    if not getattr(API, 'Player', None) or not getattr(API.Player, 'Backpack', None):
        return False

    if not WaitForMelStone(API):
        return False

    # Whistle / alert sound 5 times when stone appears
    for _ in range(5):
        API.PlaySound(0x0335)
        API.Pause(1.0)

    return True


if __name__ in ("__main__", "<module>"):
    main(API)
