Misc.SetSharedValue("PlayerName", "Eremite")

# Various Bags for Sorting,etc.
Misc.SetSharedValue("ToolBag", 0x41A15E99)
Misc.SetSharedValue("ScrollBoH", 0x4278EB00)
Misc.SetSharedValue("BagOfHolding", 0x412D8C13)
Misc.SetSharedValue("LootBag", 0x433FD36C)
Misc.SetSharedValue('gem_pouch', Items.FindBySerial(0x455CE42E))
Misc.SetSharedValue('mobileforge', 0x407E65B2)
Misc.SetSharedValue('mapbook', 0x402E714F)
Misc.SetSharedValue('sosbook', 0x4213F97B)

# Looting/Sorting Values      
Misc.SetSharedValue("WarnWeight", Player.MaxWeight * 0.85)
Misc.SetSharedValue("CriticalWeight", Player.MaxWeight * 0.95)

Misc.ScriptRun("_startup.py")


# Re-run this after 10 seconds on first start to give client time to
#   get player weight and search all bags.
Misc.Pause(10000)
initialized = Misc.ReadSharedValue("initialized")
if not initialized:
    Misc.ScriptRun("_eremite.py")
Misc.SetSharedValue("initialized", True)

    