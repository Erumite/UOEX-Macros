import API

if API.IsScriptRunning("Eremite/CutClaimall.py"):
    API.StopScript("Eremite/CutClaimall.py")
    API.Pause(0.1)
    while API.IsScriptRunning("Eremite/CutClaimall.py") and not API.StopRequested:
        API.Pause(0.1)
API.PlayScript("Eremite/CutClaimall.py")