import API

# Hard Coded Values for Myself. :)
API.SetSharedVar("PlayerName", "Eremite")

# Various Bags for Sorting,etc.
API.SetSharedVar("ToolBag", 0x41A15E99)
API.SetSharedVar("ScrollBoH", 0x4278EB00)
API.SetSharedVar("BagOfHolding", 0x412D8C13)
API.SetSharedVar("LootBag", 0x433FD36C)
API.SetSharedVar('mapbook', 0x402E714F)
API.SetSharedVar('sosbook', 0x4213F97B)

# Run startup script to initialize item lists and maps
API.PlayScript("Eremite/startup.py")

# All Done!
API.HeadMsg('Loaded.', API.Player.Serial, 69)