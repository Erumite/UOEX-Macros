// Attack All Pulling Macro
//   - Eremite
//
// This will attack all enemies on-screen to get aggro and pull them to you.
// Useful for grouping up peaceful mobs, or speeding up aggressive mobs noticing you.
//
// This has some optimizations around the speed that mobs are attacked at (pauses) and should
//   ideally not be looped without pausing as I worry it would send a lot of messages to the
//   server very quickly.
// It continually finds/attacks enemies until it loops back around to the original enemy as
//   @ignoreobject doesn't seem to work with @getenemy
// The headmsg can be removed if desired - I see it as a useful indicator of which mobs have been pulled.
unsetalias 'firstenemy'
while @getenemy 'criminal' 'enemy' 'murderer' 'gray'
  if not @findobject 'enemy'
    continue
  endif
  if not @findalias 'firstenemy'
    setalias 'firstenemy' 'enemy'
  elseif not @findobject 'firstenemy' or serial 'firstenemy' == serial 'enemy'
    stop
  endif
  @attack 'enemy'
  @headmsg '*grr*' 33 'enemy'
  pause 50
endwhile
pause 1000
