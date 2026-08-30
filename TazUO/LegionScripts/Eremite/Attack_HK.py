if API.IsScriptRunning("Eremite/Attack.py"):
    API.StopScript("Eremite/Attack.py")
    API.Pause(0.1)
if API.IsScriptRunning("Eremite/AutoAttackLoop.py"):
    API.StopScript("Eremite/AutoAttackLoop.py")
    API.HeadMsg("o-|==>", API.Player.Serial, 33)
    API.Pause(0.1)
while API.IsScriptRunning("Eremite/Attack.py"):
    API.Pause(0.1)

API.PlayScript("Eremite/Attack.py")