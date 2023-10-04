// Area Body Claimer
//  - Eremite
// Claim all bodies within 10 tiles (archery range)
// Will ignore and move on if a body is out of view.
//  ALso will smelt ores and warn about weight at the end.
//
//  Aliases:
@setalias 'mobileforge' 0x407e65b2
//
// Ranges to claim at in sequence (eg: claim within 2 tiles, then within 5, etc)
//  this fixes problems with it preferring to target corpses far away/behind walls.
if not @listexists 'rangestep'
  @createlist 'rangestep'
  @pushlist 'rangestep' 2
  @pushlist 'rangestep' 5
  @pushlist 'rangestep' 10
endif
@clearignorelist
@clearjournal
msg '[claimall'
waitfortarget 1500
for 0 in 'rangestep'
  while @findtype 0x2006 'any' 'ground' 'any' rangestep[]
    if weight > 640 or contents 'backpack' > 290
      headmsg '** Weight High **' 33
      break
    endif
    target! 'found'
    waitfortarget 500
    // If certain errors are in the log, it will cancel our target so we need to re-[claimall
    if @injournal 'Target cannot be seen.' or @injournal "You did not earn the right"
      @clearjournal
      msg '[claimall'
      waitfortarget 1000
    elseif @injournal "You may not loot" or @injournal "You can't claim that"
      @clearjournal
      msg '[claimall'
      waitfortarget 1000
    elseif @injournal "That isn't a corpse"
      @clearjournal
      msg '[claimall'
      waitfortarget 1000
    endif
    // Ignore the object (if it still exists) to avoid getting stuck on an unreachable corpse.
    @ignoreobject 'found'
  endwhile
endfor
canceltarget
// Smelt ore from mobs because that crap's heavy.  First those in backpack, then any that fell to ground.
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
if weight > 640
  headmsg "*HIGH WEIGHT*" 33
elseif weight > 580
  headmsg "Weight Warning" 53
endif
// Item Count Warnings
if contents 'backpack' > 290
  headmsg '290+ Items!!!' 33
elseif contents 'backpack' > 280
  headmsg '280+ Items' 53
endif
sysmsg 'Yoink!' 69
