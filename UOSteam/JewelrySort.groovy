// Jewelry Sorter - Eremite
//
// Sorts through Jewelry in inventory and will trash it if it doesn't contain certain
//  properties at a defined level.  Not perfect, but can help narrow down good from bad.
//
// Set up our trash bag alias - hard coded, but falls back to finding the Trash4Tokens bag.
@setalias 'trashbag' 0x41a15e96
if not @findobject 'trashbag'
  @findtype 0x9b2 1173 'backpack' 'any' 0
  @setalias 'trashbag' 'found'
endif
// Define a list of jewelry to sort. If this needs expanding, uncomment the removelist below temporarily to update. 
//@removelist 'jewelry'
if not @listexists 'jewelry'
  @createlist 'jewelry'
  pushlist 'jewelry' 0x1f06 // Silver Bracelet
  pushlist 'jewelry' 0x1086 // Gold Bracelet
  pushlist 'jewelry' 0x108a // Gold Ring
  pushlist 'jewelry' 0x1f09 // Silver Ring
endif
// Parse through all jewelry for defined properties, using the 'keep' alias as a bool for later.
for 0 in 'jewelry'
  while @findtype jewelry[] 'any' 'backpack' 'any' 0
    @setalias 'appraise' 'found'
    @unsetalias 'keep'
    // Check for some base good properties
    // if property ('name') (serial) [operator] [value]
    if @property 'Lower Reagent Cost' 'appraise' > 14
      @setalias 'keep' 'appraise'
    elseif @property 'Dexterity' 'appraise' > 6
      @setalias 'keep' 'appraise'
    elseif @property 'Strength' 'appraise' > 6
      @setalias 'keep' 'appraise'
    elseif @property 'Damage Increase' 'appraise' > 13
      @setalias 'keep' 'appraise'
    elseif @property 'Spell Damage Increase' 'appraise' > 13
      @setalias 'keep' 'appraise'
    elseif @property 'Intelligence Bonus' 'appraise' > 7
      @setalias 'keep' 'appraise'
    endif
    // If 'keep' is set, ignore this object so @findtype will not notice it.
    if @findobject 'keep'
      ignoreobject 'appraise'
    else
      moveitem 'appraise' 'trashbag'
    endif
  endwhile
endfor
headmsg '*Jewelry Done*' 69
// After sorting Jewelry, my current setup moves on to appraising weapons in the inventory
//  Can be removed if not needed:
playmacro 'WeaponAppraisal'
