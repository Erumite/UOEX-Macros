import os
import re
import time
import API

# ================= User Configuration =================
# Window Geometry & Font Settings
DEFAULT_WIDTH = 350
DEFAULT_HEIGHT = 400
FONT_SIZE = 16
LINE_SPACING_PX = 0        # Pixel spacing between text lines
FONT_FAMILY = "Roboto-Mono"
SPEAKER_FONT_FAMILY = "Noto Sans Mono ExtraBold"
DEFAULT_X = 200
DEFAULT_Y = 50

# Channel & Message Display Toggles
SHOW_GLOBAL_CHAT = True
SHOW_LOCAL_CHAT = True    # Say, Whisper, Yell
SHOW_PARTY_CHAT = True
SHOW_GUILD_CHAT = True
SHOW_SYSTEM_CHAT = False   # System messages toggle (False by default)

SHOW_CHANNEL_TAGS = False  # Show or hide [Global], [Local], [Party] tags
SMALL_TIMESTAMPS = True    # Make timestamps smaller (FONT_SIZE - 2)

SHOW_SPELL_WORDS = False     # Hide words of power (e.g. Sanctum Viatas, Kal Vas Flam, Forul Solum, Consecrus Arma, Divinum Furis)
SHOW_WORLD_SAVES = False     # Hide world save announcements and safebet messages
SHOW_POISON_MESSAGES = False # Hide poison ticks, cure, and poison resistance alerts
SHOW_DAMAGE_MESSAGES = False # Hide combat damage numbers and DPS popups
SHOW_COORDINATES = False     # Hide sextant coordinate messages (e.g. 83° 24'N, 110° 52'E)
SHOW_SCRIPT_SAVES = False    # Hide script saved notifications (e.g. Saved ChatUI.py)
SHOW_NUMERIC_MESSAGES = False# Hide pure numeric overhead damage popups (e.g. 42, 128)

# Client Monster Hues for auto-filtering generic mob chatter (e.g. 'a skeleton', 'an orcish lord')
MONSTER_HUES = {34, 144, 946}

# Ignored NPC / Monster Speaker Names (exact match, case-insensitive)
IGNORED_NPC_NAMES = {
    "an orcish lord",
    "an orcish mage",
    "an orc bomber",
    "an orcish scout",
    "an orc captain",
    "an orc",
    "an orcish brute",
    "linked gate",
    "lady melisande",
}

# Fast Exact String Ignore List (everything here should be all lowercase)
EXACT_IGNORE_MESSAGES = {
    "bank", "guards",
    "the spell fizzles.",
    "you have hidden yourself well.",
    "you are now hidden.",
    "you enter stealth mode.",
    "me hurt!", "nooooo!", "aaah! that hurt...", "good blow!", "oof! that hurt!", "ouch! me hurt!",
    "away with thee!", "me dying?", "me die!", "must... not die...",
    "no, kill me not!",
    "i can't reach that.",
    "take a look at my goods.",
    "take a look at your goods.",
    "greetings.  have a look around.",
    "please stand still, you are being moved.",
    "you are being moved. please stand still.",
    "lady melisande feels your presence, and approaches",
    "you fail to make anything of the map.",
    "you successfully decode a treasure map!",
    "*acid blood scars your weapon!*",
    "you are bleeding profusely",
    "you stepped onto a spike trap!",
    "you stepped onto a blade trap!",
    "you are enveloped by a noxious gas cloud!",
    "you manage to decipher the encoded location.",
    "i now own your soul!!!", "your weak spells have no effect on me, muahahaha!!",
    "we are now one with each other!!", "thou shalt not pass my post!!",
    "your end is near young adventurer!!",
    f"have a look at my inventory {API.Player.Name}, i have the item you seek.",
    f"hey {API.Player.Name}, you can buy that item from me.",
}
# Enforce lowercase.
EXACT_IGNORE_MESSAGES = [m.lower() for m in EXACT_IGNORE_MESSAGES]

# System & Bank Regex Patterns to Ignore
IGNORED_REGEX_PATTERNS = [
    r"^bank container has \d+ items",
    r"^thy current bank balance is \d+ gold.$",
    r"^The item has been added to your exex account",
    r"^Lead on! Payment will be made when we arrive",
    r"^We have arrived! I thank thee,",
    r"^The total of thy purchase is \d+ gold",
    r"^\S+ wants a cracker.$",    
]
IGNORED_REGEX_PATTERNS=[re.compile(pattern, re.IGNORECASE) for pattern in IGNORED_REGEX_PATTERNS]

# Log File Settings
LOG_TO_FILE = True
LOG_FILE_PATH = "/mnt/THRASHER/UO/Logs/Chat.log"

DEBUG_LOG_RAW = True
RAW_LOG_FILE_PATH = "/mnt/THRASHER/UO/Logs/RawChat.log"

# Advanced / Engine Settings
GUMP_ID = 3135545776
MAX_HISTORY_ENTRIES = 100
UPDATE_INTERVAL_SEC = 0.5

# Color Palette
CHAT_TEXT_COLOR = "#C0C0C0"
GLOBAL_CHAT_COLOR = "#85C1E9"
PARTY_CHAT_COLOR = "#FFD700"
GUILD_CHAT_COLOR = "#32CD32"
QUEST_CHAT_COLOR = "#1E90FF"
SYSTEM_CHAT_COLOR = "#A9A9A9"

PALETTE_SPEAKER_COLORS = [
    "#E6B422", "#85C1E9", "#A3E4D7", "#F5B7B1", "#D7BDE2",
    "#F7DC6F", "#76D7C4", "#F8C471", "#BB8FCE", "#73C6B6",
    "#F1948A", "#7FB3D5", "#82E0AA", "#F0B27A", "#C39BD3",
]

UO_HUE_TO_HEX = {
    0: "#C0C0C0",     # Default speech
    20: "#B87333",    # Copper
    33: "#FF3333",    # Red / Danger
    39: "#FF5500",    # Blaze
    44: "#FFAA00",    # Orange
    46: "#FFD700",    # Agapite Gold
    53: "#E6B422",    # Yellow / Gold
    55: "#FFFF55",    # Bright Yellow
    61: "#32CD32",    # Verite Green
    66: "#82E0AA",    # Light Green
    69: "#00FF66",    # Bright Green
    88: "#00FFFF",    # Ice / Cyan
    89: "#3FA9FF",    # Light Blue
    91: "#1E90FF",    # Valorite Deep Blue
    175: "#76D7C4",   # Teal / Cyan
    444: "#CD7F32",   # Bronze
    946: "#C39BD3",   # Violet / Purple
    996: "#FFFFFF",   # Pure White
    999: "#888888",   # Dark Grey
    1153: "#FFFFFF",  # Pure White
    1173: "#D7BDE2",  # Soft Lavender
    2165: "#F5B7B1",  # Soft Coral
    2442: "#E5E4E2",  # Platinum
}

# UOEX Global Chat Pattern
SYSTEM_GLOBAL_PATTERN = re.compile(
    r"^\[[\d:]+\]\s*(?P<speaker>\+?[\w\d\s]+):\s*(?P<message>.+)\s*$",
    re.IGNORECASE
)

# Sextant Coordinates Pattern (e.g. 83° 24'N, 110° 52'E)
SEXTANT_PATTERN = re.compile(
    r"^\d+[\s\S]*[NS]\s*,\s*\d+[\s\S]*[EW]$",
    re.IGNORECASE
)

# Spell Words of Power Syllables & Words
MAGERY_POWER_SYLLABLES = {
    "an", "kal", "vas", "corp", "por", "flam", "nox", "mani", "in", "des",
    "ylem", "grav", "wis", "rel", "sanct", "hur", "lor", "xen", "tym", "ort",
    "ex", "uus", "bet", "jux", "forul", "solum", "consecrus", "arma", "divinum", "furis",
    "sanctum", "viatas", "flamus", "repurgo", "temptatio", "exsuscito", "invocatio",
    "omnisum", "exortus", "fiat", "vita", "adscendit", "me", "imperium", "arcane", "focus",
}


def is_spell_word(text: str) -> bool:
    clean_text = re.sub(r'\s*\[[^\]]+\]$', '', text.strip()).lower()
    tokens = [t for t in re.split(r'\W+', clean_text) if t]
    if tokens and all(t in MAGERY_POWER_SYLLABLES for t in tokens):
        return True
    return False


def is_poison_message(text_lower: str) -> bool:
    if "poison" in text_lower:
        return True
    poison_phrases = (
        "you feel nauseous",
        "you feel a bit nauseous",
        "you feel sick",
        "you feel very sick",
        "you feel severely ill",
        "extremely weak and are in severe pain",
        "in extreme pain, and require immediate aid",
        "wracked with extreme pain",
        "begin to feel pain",
    )
    return any(p in text_lower for p in poison_phrases)


def get_char_width():
    return FONT_SIZE * 0.50


def get_line_height():
    return FONT_SIZE + LINE_SPACING_PX


def wrap_chat_item(timestamp_str: str, channel: str, speaker: str, message: str, max_width_px: int, font_size: int):
    tag_part = f"[{channel}] " if SHOW_CHANNEL_TAGS else ""
    header = f"[{timestamp_str}] {tag_part}{speaker}: "
    
    char_w = font_size * 0.38
    total_usable_chars = max(1, int((max_width_px - 20) / char_w))
    indent_spaces = "    "
    
    words = message.split(" ")
    lines = []
    current_line = header
    
    for word in words:
        if not current_line:
            current_line = (indent_spaces + word) if lines else word
        elif len(current_line) + 1 + len(word) <= total_usable_chars:
            current_line += " " + word
        else:
            lines.append(current_line)
            current_line = indent_spaces + word

    if current_line:
        lines.append(current_line)

    return lines

def uo_hue_to_color(hue: int, default_color: str) -> str:
    if not hue or hue == 0:
        return default_color
    if hue in UO_HUE_TO_HEX:
        return UO_HUE_TO_HEX[hue]
    idx = hue % len(PALETTE_SPEAKER_COLORS)
    return PALETTE_SPEAKER_COLORS[idx]


def get_speaker_color(name: str) -> str:
    if not name:
        return CHAT_TEXT_COLOR
    key = name.strip().lower()
    h = 0x811C9DC5
    for ch in key:
        h ^= ord(ch)
        h = (h * 0x01000193) & 0xFFFFFFFF
    idx = h % len(PALETTE_SPEAKER_COLORS)
    return PALETTE_SPEAKER_COLORS[idx]


def log_chat_entry(timestamp_str: str, channel: str, speaker: str, message: str):
    if not LOG_TO_FILE or not LOG_FILE_PATH:
        return
    try:
        log_dir = os.path.dirname(LOG_FILE_PATH)
        if log_dir and not os.path.exists(log_dir):
            os.makedirs(log_dir, exist_ok=True)
        line = f"[{timestamp_str}] [{channel}] {speaker}: {message}\n"
        with open(LOG_FILE_PATH, "a", encoding="utf-8") as f:
            f.write(line)
    except Exception:
        pass


def reset_raw_log():
    if not DEBUG_LOG_RAW or not RAW_LOG_FILE_PATH:
        return
    try:
        log_dir = os.path.dirname(RAW_LOG_FILE_PATH)
        if log_dir and not os.path.exists(log_dir):
            os.makedirs(log_dir, exist_ok=True)
        with open(RAW_LOG_FILE_PATH, "w", encoding="utf-8") as f:
            f.write("# Raw Chat Log Reset\n")
    except Exception:
        pass


def log_raw_entry(entry):
    if not DEBUG_LOG_RAW or not RAW_LOG_FILE_PATH:
        return
    try:
        text = (getattr(entry, 'Text', '') or '').strip()
        if "ChatUI active" in text:
            return

        log_dir = os.path.dirname(RAW_LOG_FILE_PATH)
        if log_dir and not os.path.exists(log_dir):
            os.makedirs(log_dir, exist_ok=True)

        name = getattr(entry, 'Name', '') or ''
        msg_type = str(getattr(entry, 'MessageType', '') or getattr(entry, 'TextType', '') or '')
        hue = getattr(entry, 'Hue', 0)
        time_val = getattr(entry, 'Time', '')

        raw_line = f"[{time_val}] [Type: {msg_type}] [Hue: {hue}] [Name: {name}] -> {text}\n"
        with open(RAW_LOG_FILE_PATH, "a", encoding="utf-8") as f:
            f.write(raw_line)
    except Exception:
        pass


class ChatUIManager:
    def __init__(self, API: API):
        self.history = []  # dict: {channel, speaker, text, timestamp_str, color, lines}
        self.seen_signatures = set()
        self.last_rendered_sig = None
        self.active_gump = None
        self.chat_label = None
        self.gump_x = API.GetSharedVar("ChatUI_X") or DEFAULT_X
        self.gump_y = API.GetSharedVar("ChatUI_Y") or DEFAULT_Y
        self.gump_w = API.GetSharedVar("ChatUI_W") or DEFAULT_WIDTH
        self.gump_h = API.GetSharedVar("ChatUI_H") or DEFAULT_HEIGHT
        self.initialized = False

    def save_gump_position(self, API: API):
        if self.active_gump and not getattr(self.active_gump, 'IsDisposed', False):
            try:
                cur_x = self.active_gump.GetX()
                cur_y = self.active_gump.GetY()
                w = getattr(self.active_gump, 'Width', getattr(self.active_gump, 'GetWidth', lambda: None)())
                h = getattr(self.active_gump, 'Height', getattr(self.active_gump, 'GetHeight', lambda: None)())
                if cur_x is not None and cur_y is not None:
                    self.gump_x = cur_x
                    self.gump_y = cur_y
                    API.SetSharedVar("ChatUI_X", cur_x)
                    API.SetSharedVar("ChatUI_Y", cur_y)
                if w:
                    self.gump_w = w
                    API.SetSharedVar("ChatUI_W", w)
                if h:
                    self.gump_h = h
                    API.SetSharedVar("ChatUI_H", h)
            except Exception:
                pass

    def is_message_filtered(self, channel: str, speaker_name: str, text: str) -> bool:
        if not text or "ChatUI active" in text:
            return True

        speaker_lower = speaker_name.lower() if speaker_name else ""
        text_lower = text.lower()

        if speaker_name and speaker_lower == text_lower:
            return True

        if speaker_lower in IGNORED_NPC_NAMES:
            return True

        if text_lower in EXACT_IGNORE_MESSAGES:
            return True

        if any(pat.search(text_lower) for pat in IGNORED_REGEX_PATTERNS):
            return True

        if not SHOW_NUMERIC_MESSAGES and text.lstrip('-+').isdigit():
            return True

        if not SHOW_SCRIPT_SAVES and (text_lower.startswith("saved ") or "saved script" in text_lower):
            return True

        if not SHOW_WORLD_SAVES and (
            "world will save" in text_lower or
            "world is saving" in text_lower or
            "world save complete" in text_lower or
            "safebet" in text_lower
        ):
            return True

        if not SHOW_POISON_MESSAGES and is_poison_message(text_lower):
            return True

        if not SHOW_SPELL_WORDS and is_spell_word(text):
            return True

        if not SHOW_COORDINATES and SEXTANT_PATTERN.match(text):
            return True

        if "has logged in" in text_lower or "has logged out" in text_lower:
            return True

        if channel == "Global" and not SHOW_GLOBAL_CHAT:
            return True
        if channel == "Local" and not SHOW_LOCAL_CHAT:
            return True
        if channel == "Party" and not SHOW_PARTY_CHAT:
            return True
        if channel == "Guild" and not SHOW_GUILD_CHAT:
            return True
        if channel == "System" and not SHOW_SYSTEM_CHAT:
            return True

        return False

    def load_saved_log_history(self, max_entries: int = 30):
        if not LOG_FILE_PATH or not os.path.exists(LOG_FILE_PATH):
            return
        try:
            pattern = re.compile(r"^\[(?P<ts>[\d:]+)\]\s*\[(?P<ch>[^\]]+)\]\s*(?P<spk>[^:]+):\s*(?P<txt>.*)$")
            with open(LOG_FILE_PATH, "r", encoding="utf-8") as f:
                lines = f.readlines()

            recent_lines = lines[-max_entries:] if len(lines) > max_entries else lines
            for line in recent_lines:
                line_str = line.strip()
                m = pattern.match(line_str)
                if not m:
                    continue
                ts = m.group("ts")
                ch = m.group("ch")
                spk = m.group("spk").strip()
                txt = m.group("txt").strip()

                if self.is_message_filtered(ch, spk, txt):
                    continue

                sig = (ts, spk, txt)
                if sig in self.seen_signatures:
                    continue
                self.seen_signatures.add(sig)

                if ch == "Global":
                    txt_col = GLOBAL_CHAT_COLOR
                elif ch == "Party":
                    txt_col = PARTY_CHAT_COLOR
                elif ch == "Guild":
                    txt_col = GUILD_CHAT_COLOR
                elif ch == "System":
                    txt_col = SYSTEM_CHAT_COLOR
                elif ch == "Quest":
                    txt_col = QUEST_CHAT_COLOR
                else:
                    txt_col = get_speaker_color(spk)

                wrapped = wrap_chat_item(ts, ch, spk, txt, self.gump_w, FONT_SIZE)
                item_data = {
                    "channel": ch,
                    "speaker": spk,
                    "text": txt,
                    "timestamp": ts,
                    "speaker_color": txt_col,
                    "text_color": txt_col,
                    "wrapped_lines": wrapped,
                    "lines": max(1, len(wrapped)),
                }
                self.history.append(item_data)
        except Exception:
            pass

    def dispose_active_gump(self, API: API = None):
        if self.active_gump and not getattr(self.active_gump, 'IsDisposed', False):
            try:
                if API:
                    self.save_gump_position(API)
                self.active_gump.Dispose()
            except Exception:
                pass
            self.active_gump = None
            self.chat_label = None

    def process_journal_entries(self, API: API):
        is_startup = not self.initialized
        if is_startup:
            self.initialized = True
            reset_raw_log()
            # Load pre-existing chat history from saved Chat.log file
            self.load_saved_log_history(30)

        entries = API.GetJournalEntries(60.0) or []
        new_count = 0

        for entry in entries:
            text = (getattr(entry, 'Text', '') or '').strip()
            msg_type = str(getattr(entry, 'MessageType', '') or getattr(entry, 'TextType', '') or '').lower()
            speaker_name = (getattr(entry, 'Name', '') or '').strip()
            hue = getattr(entry, 'Hue', 0)

            # Ignore overhead name tag labels
            if msg_type == "label":
                continue

            # Drop entries where speaker name and text are identical (overhead click labels)
            if speaker_name and speaker_name.lower() == text.lower():
                continue

            # Drop generic overhead mob messages (Hue in 34, 144, 946 and starts with 'a ' or 'an ')
            if hue in MONSTER_HUES and (speaker_name.lower().startswith(("a ", "an ")) or text.lower().startswith(("a ", "an "))):
                continue

            # Hide combat damage numbers and DPS popups (msg_type == "damage")
            if not SHOW_DAMAGE_MESSAGES and msg_type == "damage":
                continue

            entry_time = getattr(entry, 'Time', None)
            timestamp_str = time.strftime('%H:%M:%S', time.localtime())
            if entry_time:
                try:
                    timestamp_str = entry_time.strftime('%H:%M:%S')
                except Exception:
                    pass

            sig = (str(entry_time), speaker_name, text)
            if sig in self.seen_signatures:
                continue
            self.seen_signatures.add(sig)

            # Log raw entry ONLY FOR LIVE NEW MESSAGES after script has opened
            if not is_startup:
                log_raw_entry(entry)

            channel = "Local"
            speaker = speaker_name or "System"
            msg = text
            text_color = uo_hue_to_color(hue, default_color=CHAT_TEXT_COLOR)

            # Test UOEX Global Pattern
            global_match = SYSTEM_GLOBAL_PATTERN.match(text)
            if global_match:
                channel = "Global"
                speaker = global_match.group('speaker').strip()
                msg = global_match.group('message').strip()
                text_color = uo_hue_to_color(hue, default_color=GLOBAL_CHAT_COLOR)
            else:
                if "party" in msg_type:
                    channel = "Party"
                    text_color = uo_hue_to_color(hue, default_color=PARTY_CHAT_COLOR)
                elif "guild" in msg_type:
                    channel = "Guild"
                    text_color = uo_hue_to_color(hue, default_color=GUILD_CHAT_COLOR)
                elif "system" in msg_type or speaker.lower() == "system":
                    channel = "System"
                    text_color = uo_hue_to_color(hue, default_color=SYSTEM_CHAT_COLOR)
                elif any(kw in text.lower() for kw in ["quest", "objective"]):
                    channel = "Quest"
                    text_color = uo_hue_to_color(hue, default_color=QUEST_CHAT_COLOR)

            if self.is_message_filtered(channel, speaker, msg):
                continue
            if channel == "Party" and not SHOW_PARTY_CHAT:
                continue
            if channel == "Guild" and not SHOW_GUILD_CHAT:
                continue
            if channel == "System" and not SHOW_SYSTEM_CHAT:
                continue

            wrapped = wrap_chat_item(timestamp_str, channel, speaker, msg, self.gump_w, FONT_SIZE)

            item_data = {
                "channel": channel,
                "speaker": speaker,
                "text": msg,
                "timestamp": timestamp_str,
                "speaker_color": text_color,
                "text_color": text_color,
                "wrapped_lines": wrapped,
                "lines": max(1, len(wrapped)),
            }

            self.history.append(item_data)

            # Log chat entry ONLY FOR LIVE NEW MESSAGES after script has opened
            if not is_startup:
                log_chat_entry(timestamp_str, channel, speaker, msg)

            new_count += 1

        if len(self.history) > MAX_HISTORY_ENTRIES:
            self.history = self.history[-MAX_HISTORY_ENTRIES:]

        return new_count

    def render_gump(self, API: API):
        try:
            self.save_gump_position(API)

            line_height = get_line_height()
            padding = 10
            usable_height = self.gump_h - padding
            width = self.gump_w

            # Determine visible entries starting from bottom (newest) and filling upward to top
            visible_items = []
            accumulated_height = 0

            for item in reversed(self.history):
                lines = len(wrap_chat_item(
                    item["timestamp"], item["channel"], item["speaker"], item["text"], width, FONT_SIZE
                ))
                item_h = lines * line_height
                if accumulated_height + item_h > usable_height:
                    break
                visible_items.append(item)
                accumulated_height += item_h

            visible_items.reverse()  # Chronological order: oldest at top, newest at bottom

            current_sig = tuple(f"{i['timestamp']}_{i['speaker']}_{i['text']}" for i in visible_items)
            if current_sig == self.last_rendered_sig and self.active_gump and not getattr(self.active_gump, 'IsDisposed', False):
                return

            # Format all visible messages as 1 single multiline string with inline color tags
            label_x = 10
            usable_w = max(50, width - 20)
            formatted_lines = []

            for item in visible_items:
                tag_part = f"[{item['channel']}] " if SHOW_CHANNEL_TAGS else ""
                txt_col = item["text_color"]
                entry_str = f"<color={txt_col}>[{item['timestamp']}] {tag_part}{item['speaker']}: {item['text']}</color>"
                formatted_lines.append(entry_str)

            full_chat_str = "\n".join(formatted_lines)

            # Ensure single persistent gump container instance
            gump_created = False
            if self.active_gump is None or getattr(self.active_gump, 'IsDisposed', False):
                self.active_gump = API.Gumps.CreateGump(acceptMouseInput=True, canMove=True)
                if not self.active_gump:
                    return
                self.active_gump.SetX(self.gump_x)
                self.active_gump.SetY(self.gump_y)
                API.CloseGump(GUMP_ID)
                API.Gumps.AddGump(self.active_gump)
                gump_created = True

            # If gump was just created or controls missing, build base layout
            if gump_created or self.chat_label is None or getattr(self.chat_label, 'IsDisposed', False):
                self.active_gump.Clear()
                self.chat_label = None

                # Mostly transparent dark background
                bg = API.Gumps.CreateGumpColorBox(opacity=0.35, color="#050505")
                if bg:
                    bg.SetRect(0, 0, width, self.gump_h)
                    self.active_gump.Add(bg)

                self.chat_label = API.Gumps.CreateGumpTTFLabel(
                    full_chat_str, FONT_SIZE, color="#FFFFFF", font=FONT_FAMILY, maxWidth=usable_w
                )
                if self.chat_label:
                    self.chat_label.SetX(label_x)
                    self.chat_label.SetY(5)
                    self.active_gump.Add(self.chat_label)
            else:
                # Update text in-place without clearing or re-instantiating gump controls!
                self.chat_label.SetText(full_chat_str)

            self.last_rendered_sig = current_sig
        except Exception:
            pass


def main(API: API):
    manager = ChatUIManager(API)
    try:
        while True:
            new_entries = manager.process_journal_entries(API)
            if new_entries > 0 or manager.last_rendered_sig is None:
                manager.render_gump(API)
            API.Pause(UPDATE_INTERVAL_SEC)
    finally:
        manager.dispose_active_gump(API)


if __name__ in ("__main__", "<module>"):
    main(API)