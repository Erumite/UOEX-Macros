import API
API.UseObject(0x4040330D)
while not API.HasGump(0x554B87F3) and not API.StopRequested:
    API.Pause(0.1)
API.ReplyGump(17, 0x554B87F3)
