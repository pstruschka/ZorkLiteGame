package io.muic.ooc.zork.map;

import java.util.*;

public class MapGenerator {

    private static final int MAP_WIDTH = 6;
    private static final int MAP_HEIGHT = 6;
    private static Set<Room> frontier = new HashSet<>();
    private static Set<Room> in = new HashSet<>();
    static Room rooms[][] = new Room[MAP_HEIGHT][MAP_WIDTH];

    private static void reset() {
        frontier = new HashSet<>();
        in = new HashSet<>();
        rooms = new Room[MAP_HEIGHT][MAP_WIDTH];
    }

    private static List<int[]> neighbours(Room room) {
        List<int[]> neighbours = new ArrayList<>();
        int roomCoords[] = room.getCoords();
        int x = roomCoords[0], y = roomCoords[1];
        if (x > 0 && in.contains(rooms[y][x-1])) {
            neighbours.add(new int[]{x-1, y});
        }
        if (x+1 < MAP_WIDTH && in.contains(rooms[y][x+1])) {
            neighbours.add(new int[]{x+1, y});
        }
        if (y > 0 && in.contains(rooms[y-1][x])) {
            neighbours.add(new int[]{x, y-1});
        }
        if (y+1 < MAP_HEIGHT && in.contains(rooms[y+1][x])) {
            neighbours.add(new int[]{x, y+1});
        }
        return neighbours;
    }

    private static void mark(Room room, int x, int y) {
        in.add(room);
        rooms[y][x] = room;
        Room newRoom;
        if (x > 0 && !in.contains(rooms[y][x-1]) && rooms[y][x-1]==null) {
            newRoom = new Room(x-1, y);
            rooms[y][x-1] = newRoom;
            frontier.add(newRoom);
        }
        if (x+1 < MAP_WIDTH && !in.contains(rooms[y][x+1]) && rooms[y][x+1]==null) {
            newRoom = new Room(x+1, y);
            rooms[y][x+1] = newRoom;
            frontier.add(newRoom);
        }
        if (y > 0 && !in.contains(rooms[y-1][x]) && rooms[y-1][x]==null) {
            newRoom = new Room(x, y-1);
            rooms[y-1][x] = newRoom;
            frontier.add(newRoom);
        }
        if (y+1 < MAP_HEIGHT && !in.contains(rooms[y+1][x]) && rooms[y+1][x]==null) {
            newRoom = new Room(x, y+1);
            rooms[y+1][x] = newRoom;
            frontier.add(newRoom);
        }
    }

    private static Direction direction(int fx ,int fy, int tx, int ty) {
        if (fx < tx) return Direction.EAST;
        else if (fx > tx) return Direction.WEST;
        else if (fy < ty) return Direction.SOUTH;
        else if (fy > ty) return Direction.NORTH;
        return null;
    }

    private static Map generate() {
        Random rand = new Random();
        int startx = rand.nextInt(MAP_WIDTH);
        int starty = rand.nextInt(MAP_HEIGHT);
        Room room = new Room(startx, starty);
        mark(room, startx, starty);
        while (!frontier.isEmpty()) {
            Room frontierRooms[] =  frontier.toArray(new Room[]{} );
            int randIndex = rand.nextInt(frontierRooms.length);
            Room prevRoom = frontierRooms[randIndex];
            frontier.remove(prevRoom);
            List<int[]> coords = neighbours(prevRoom);
            int nextRoomCoords[] = coords.get(rand.nextInt(coords.size()));
            Room nextRoom = rooms[nextRoomCoords[1]][nextRoomCoords[0]];
            int[] prevRoomCoords = prevRoom.getCoords();
            nextRoom.setExit(direction(nextRoomCoords[0], nextRoomCoords[1], prevRoomCoords[0], prevRoomCoords[1]), prevRoom);
            prevRoom.setExit(direction(prevRoomCoords[0], prevRoomCoords[1], nextRoomCoords[0], nextRoomCoords[1]), nextRoom);
            mark(prevRoom, prevRoomCoords[0], prevRoomCoords[1]);
        }
        System.out.println("finished Gen");
        for (Room row[]: rooms) {
            for (Room col :row) {
                System.out.println(col);
            }
        }
        Map map = new Map(in, MAP_WIDTH, MAP_HEIGHT);
        return map;
    }

    public static Map createMap() {
        Map map = generate();
        reset();
        return map;
    }
}
