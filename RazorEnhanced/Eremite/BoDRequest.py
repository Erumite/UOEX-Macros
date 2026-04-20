# DOESN'T WORK!  Just playing around with reading gumps, etc.

CRAFTER_CTX = 3
TAMER_CTX = 5
CRAFTER_GUMP = 0x9bade6ea #  3188567326
TAMER_GUMP = 0x15bc9aa4
TIMEOUT = 1500



CARPENTER = 0x0005F453
TAILOR = 0x0005F471
SMITHY = 0x0005F282
FLETCHER = 0x0005F56B
TAMER = 0x0005F425


def RequestBoDs():
    Misc.WaitForContext(CARPENTER, TIMEOUT)
    Misc.ContextReply(CARPENTER, CRAFTER_CTX)
    Gumps.WaitForGump(CRAFTER_GUMP, TIMEOUT)
    Gumps.SendAction(CRAFTER_GUMP, 5121)
    Misc.WaitForContext(TAILOR, TIMEOUT)
    Misc.ContextReply(TAILOR, CRAFTER_CTX)
    Gumps.WaitForGump(CRAFTER_GUMP, TIMEOUT)
    Gumps.SendAction(CRAFTER_GUMP, 3020)
    Misc.WaitForContext(SMITHY, TIMEOUT)
    Misc.ContextReply(SMITHY, CRAFTER_CTX)
    Gumps.WaitForGump(CRAFTER_GUMP, TIMEOUT)
    Gumps.SendAction(CRAFTER_GUMP, 2229)
    Misc.WaitForContext(TAMER, TIMEOUT)
    Misc.ContextReply(TAMER, TAMER_CTX)
    Gumps.WaitForGump(TAMER_GUMP, TIMEOUT)
    Gumps.SendAction(TAMER_GUMP, 5024)
    Misc.WaitForContext(FLETCHER, TIMEOUT)
    Misc.ContextReply(FLETCHER, CRAFTER_CTX)
    Gumps.WaitForGump(CRAFTER_GUMP, TIMEOUT)
    Gumps.SendAction(CRAFTER_GUMP, 707)
    
#gd = Gumps.GetGumpRawLayout(3188567326)
#gd = Gumps.GetGumpText(3188567326)
#print(dir(gd))
#print(gd)
gumpid = 3188567326
layout = Gumps.GetGumpRawLayout(gumpid)
print(dir(layout))
print(layout)