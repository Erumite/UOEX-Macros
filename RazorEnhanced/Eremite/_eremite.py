
# Hard Coded Values for Myself. :) 
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

# Run startup.py to include shared values.
Misc.ScriptRun("_startup.py")

Player.HeadMessage(69, 'Loaded.')