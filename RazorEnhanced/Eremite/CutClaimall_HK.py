# Crappy hack of a fix for the startup delay problem.
if not Misc.ReadSharedValue('gem_pouch'):
    Misc.ScriptRun("_eremite")

Misc.ScriptStop("RecycleWeight.py")
Misc.ScriptStop("Attack.py")
Misc.ScriptStop("LootBox.py")
Misc.ScriptStop("CutClaimall.py")

Misc.ScriptRun("CutClaimall.py")