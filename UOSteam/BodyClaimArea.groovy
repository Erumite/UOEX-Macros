// Area Body Claimer
//  - Eremite
// Claim all bodies within 10 tiles (archery range)
// Will ignore and move on if a body is out of view.
//  ALso will smelt ores and warn about weight at the end.
@clearignorelist
@clearjournal
msg '[claimall'
waitfortarget 1500
while @findtype 0x2006 'any' 'ground' 'any' 10
  if weight > 550 or contents 'backpack' > 290
    headmsg '** Weight High **' 33
    break
  endif
  target! 'found'
  waitfortarget 500
  if @injournal 'Target cannot be seen.' or @injournal "You did not earn the right"
    @clearjournal
    msg '[claimall'
    waitfortarget 1000
  endif
  @ignoreobject 'found'
endwhile
canceltarget
// Smelt ore from mobs because that crap's heavy.
if not @findobject 'mobileforge'
  @setalias 'mobileforge' 0x407e65b2
endif
while @findtype 0x19b9 'any' 'backpack' 'any' 0
  useobject 'found'
  waitfortarget 1500
  target! 'mobileforge'
endwhile
while @findtype 0x19b9 'any' 'ground' 'any' 1
  useobject 'found'
  waitfortarget 1500
  target! 'mobileforge'
endwhile
// Weight Warnings
if weight > 540
  headmsg "*HIGH WEIGHT*" 33
elseif weight > 480
  headmsg "Weight Warning" 53
endif
// Item Count Warnings
if contents 'backpack' > 290
  headmsg '190+ Items!!!' 33
elseif contents 'backpack' > 280
  headmsg '180+ Items' 53
endif
sysmsg 'Yoink!' 69
playmacro 'OTFWEapAppraise'
