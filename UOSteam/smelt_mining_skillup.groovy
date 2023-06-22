// Smelting Mining Skillup Trick
//   - Eremite
//
// When smelting, there's a chance to get a Mining skillup. 
// As this is unrelated to the size of the stack you're smelting, we can
//  use this to get a lot of passive mining skillups without having to mine for them.
// 
// To use:
//  Update the aliases below:
//   - resourcebag = Bag containing ores (BoH or Resource Bag)
//   - mobileforge = Mobile Forge, but could be a nearby forge on the ground.
//  To igore a type of ore that is too difficult or no longer gives skillups,
//   expand the if condition to add that ore type to the ignore list.
// 
@setalias 'resourcebag' 0x412d8c13
@setalias 'mobileforge' 0x407e65b2
@clearignorelist
while @findtype 0x19b9 'any' 'resourcebag' 'any' 0
  if @property 'FGSFDS' 'found'
    @ignoreobject 'found'
  else
    moveitem! 'found' 'backpack' 0 0 0 1
    pause 600
  endif
  if weight > 500
    while @findtype 0x19b9 'any' 'backpack' 'any' 0
      useobject 'found'
      waitfortarget 1500
      target! 'mobileforge'
    endwhile
  endif
endwhile
// Clean up any leftover ores after the bag runs out and we're still underweight:
while @findtype 0x19b9 'any' 'backpack' 'any' 0
    useobject 'found'
    waitfortarget 1500
    target! 'mobileforge'
endwhile