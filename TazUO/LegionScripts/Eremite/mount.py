MOUNT = 0x4D52855F  # Ethereal mount serial from -info
API.Dismount() if API.Player.IsMounted else API.UseObject(MOUNT)