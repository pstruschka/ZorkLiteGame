package io.muic.ooc.zork;

public class MapGenerator {
    public static Map GenerateMap(int width, int height) {
        Room rooms[][] = new Room[width][height];
        Map map = new Map(rooms);
        return map;
    }

    public static Map GenerateDemoMap() {
        Room rooms[][] = new Room[3][3];
        Map map = new Map(rooms);
        return map;
    }
    /* TODO: prims maze generator */
}
