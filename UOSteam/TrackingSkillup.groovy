// Tracking Skillup Macro
//   - Eremite
// Find an area with no other animals around to pollute the tracking menu
///  hit play and it'll summon a creature, track it, then dismiss it.
// Need enough magery to cast 5th level spells and 100 Lower Reagent Cost helps.
//
// Summon an animal to track.
cast 'Summon Creature'
pause 8000
// Find the animal we just summoned
if @getfriend 'any' 'nearest'
  @setalias 'summon' 'friend'
  // Tracking -> Animals -> First Entry
  useskill 'Tracking'
  waitforgump 2976808305 15000
  replygump 0xb16e7d71 1
  waitforgump 993494147 15000
  replygump 0x3b378483 1
  pause 2000
  // Release the pet we found.
  waitforcontext 'summon' 5 15000
  headmsg 'See ya!' 69
  pause 1000
endif