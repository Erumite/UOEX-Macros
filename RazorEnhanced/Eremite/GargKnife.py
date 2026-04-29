
def GargChop():
    gargknife = Items.FindAllByID(0x13F6, 0x0973, Player.Backpack.Serial, 1)
    if not gargknife:
        Player.HeadMessage(33, "No Garg Knife")
        return False

    # Unmount for more mirror images.
    while Player.Mount:
        Mobiles.UseMobile(Player.Serial)
        Misc.Pause(300)
    # Cast Mirror Images to avoid one-shots from Ethy Elementals
    while Player.Followers < Player.FollowersMax:
        Player.ChatSay(77, '[cs mirrorimage')
        Misc.Pause(2500)
    # Cast Evasion to soak a one-shot.
    Player.ChatSay(77, '[cs evasion')

    
    Target.Cancel()
    while not Target.HasTarget():
        Items.UseItem(gargknife[0])
        Misc.Pause(600)
        
    Player.HeadMessage(77, "Chop what?")
    corpse = Target.PromptTarget("Target mob to chop.", 77)

    Journal.Clear("You skin it")
    Journal.Clear("You cut away")
    Target.TargetExecute(corpse)
    Misc.Pause(600)

    if Journal.Search("You skin it") or Journal.Search("You cut away some") or Journal.Search("nothing of value"):
        Player.ChatSay(77, '[claimall')
        Target.WaitForTarget(1500)
        Target.TargetExecute(corpse)
        Target.WaitForTarget(600)
    
    Target.Cancel()
        
if __name__ == "__main__":
    GargChop()