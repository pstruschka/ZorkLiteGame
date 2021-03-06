package io.muic.ooc.zork.map;

import java.util.HashMap;
import java.util.Iterator;

public class Map {
    private Room[][] map;
    private HashMap<Integer, Room> roomMap = new HashMap<>();

    Map(Iterable<Room> rooms, int width, int height) {
        this.map = new Room[height][width];
        Iterator<Room> roomIterator = rooms.iterator();
        while (roomIterator.hasNext()) {
            Room currentRoom = roomIterator.next();
            int roomID = currentRoom.getID();
            roomMap.put(roomID,
                    currentRoom);
            int[] currentCoord = currentRoom.getCoords();
            map[currentCoord[1]][currentCoord[0]] = currentRoom;
        }
    }

    public Room getRoom(int x, int y) {
        return map[x][y];
    }
    public Room getRoom(int id) {
        return roomMap.get(id);
    }
    public Iterator<Room> getRooms() {
        return roomMap.values().iterator();
    }
    public boolean roomExists(Room room) {
        return roomMap.containsValue(room);
    }
    public int[] getDimensions(){
        return new int[]{map[0].length, map.length};
    }
    public int getSize() {
        return roomMap.size();
    }
}
