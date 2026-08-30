import API

API.UseObject(0x4040330D)
while not API.HasGump(0x554B87F3):
    API.Pause(0.1)
API.ReplyGump(7, 0x554B87F3)