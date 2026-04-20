from Eremite.utils.sorting import QuickSort

no_interest = "You have nothing I would be interested in"

SellAgent.ChangeList("junkbag")
if not SellAgent.Status():
    SellAgent.Enable()

def promptVendor():
    vendor = Target.PromptTarget("Select Vendor", 88)
    if Mobiles.FindBySerial(vendor):
        Mobiles.UseMobile(vendor) # refresh inventory
        return vendor
    else:
        print("Not a vendor!")
        return None

def cleanJournal():
    Journal.Clear("storage is full")
    Journal.Clear(no_interest)
        
vendor = promptVendor()    
cleanJournal()

while True:
    if not vendor or vendor == -1 or not Mobiles.FindBySerial(vendor) or Player.DistanceTo(vendor) > 10:
        break

    if Player.Weight > Player.MaxWeight * .8:
        QuickSort()

    Misc.WaitForContext(vendor, 10000)
    Misc.ContextReply(vendor, 2)
    Misc.Pause(300)

    if Journal.Search(no_interest):
        cleanJournal()
        break
    if Journal.Search("storage is full"):
        cleanJournal()
        vendor = promptVendor()
       
QuickSort()