from Eremite.utils.items import AppraiseWeapon

target = Target.PromptTarget("Weapon to appraise?", 111)
if target and target != -1:
    weapon = Items.FindBySerial(target)
    Items.WaitForProps(weapon, 600)
    AppraiseWeapon(weapon, summary=True)