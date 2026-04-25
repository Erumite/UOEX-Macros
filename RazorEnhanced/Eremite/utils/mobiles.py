facet_map = {
    0: "Felucca",
    1: "Trammel",
    2: "Ilshenar",
    3: "Malas",
    4: "Tokuno"
}

def GetFacet(mob):
    map = mob.Map
    return facet_map.get(map, map)  