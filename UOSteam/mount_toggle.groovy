// Mount/Dismount Toggle
//  - Eremite
//
// Set to serial of ethereal mount.
@setalias 'ethy' 0x41a37c36
// Get on ethereal mount if unmounted, else dismount:
if not @mounted 'self'
  useobject 'ethy'
else
  useobject 'self'
endif
