if API.IsScriptRunning("Eremite/LootBox.py"):
    API.StopScript("Eremite/LootBox.py")
    API.Pause(0.05)
if not API.IsScriptRunning("Eremite/LootBox.py"):
    API.PlayScript("Eremite/LootBox.py")
