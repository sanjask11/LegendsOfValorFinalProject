package world.tiles;

public enum LoVTileType {
    NEXUS,
    INACCESSIBLE,   // new
    OBSTACLE,       // new (can be removed -> PLAIN)
    BUSH,
    CAVE,
    KOULOU,
    PLAIN,
    WALL            // lane separator columns (always impassable)
}
