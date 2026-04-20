if Player.Mana > 30:
    Spells.CastMagery("Reveal")
else:
    Player.UseSkill("Peacemaking")
Target.WaitForTarget(1000, False)
Target.TargetExecute(0x1C4E5F)