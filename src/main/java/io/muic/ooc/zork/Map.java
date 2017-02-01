package io.muic.ooc.zork;

public class Map {
    private Room[][] map;

    Map(Room[][] map) {
        this.map = map;
    }

    public Room getRoom(int x, int y) {
        return map[x][y];
    }
}
