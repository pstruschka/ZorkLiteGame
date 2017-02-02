package io.muic.ooc.zork.map;

public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    static Direction opposite(Direction dir) {
        switch (dir) {
            case NORTH:
                return SOUTH;
            case SOUTH:
                return NORTH;
            case EAST:
                return WEST;
            case WEST:
                return EAST;
            default:
                return null;
        }
    }
    static String toString(Direction dir){
        switch (dir) {
            case NORTH:
                return "north";
            case SOUTH:
                return "south";
            case EAST:
                return "east";
            case WEST:
                return "west";
            default:
                return null;
        }
    }
}
