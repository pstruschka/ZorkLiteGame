package io.muic.ooc.zork.map;

import io.muic.ooc.zork.characters.Monster;
import io.muic.ooc.zork.items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private final static int MAX_ITEMS = 3;
    public static int GlobalID = 0;
    private static List<Room> Rooms = new ArrayList<>();
    private final int ID;
    private final int COORD_X;
    private final int COORD_Y;
    private List<Item> items = new ArrayList<>();
    private Monster monster = null;

    private Map<Direction, Room> exitMap = new HashMap<>();

    public Room(int x, int y) {
        ID = GlobalID++;
        COORD_X = x;
        COORD_Y = y;
    }

    public boolean addItem(Item item) {
        if (items.size() < MAX_ITEMS) {
            items.add(item);
            return true;
        } else {
            return false;
        }
    }

    public boolean roomHasItem(Item item) {
        return items.contains(item);
    }

    public void getInfo() {
        System.out.printf("Room ID: %d\n", ID);
        for (Map.Entry<Direction, Room> exit:exitMap.entrySet()) {
            System.out.printf("Direction: %s -> to %d\n", exit.getKey().toString(), exit.getValue().getID());
        }
        /* TODO: print monster and items */
    }

    public void setMonster(Monster monster) {
        if (this.monster != null) {
            this.monster = monster;
        }
    }
    public void setExit(Direction direction, Room exitingRoom) {
        exitMap.put(direction, exitingRoom);
    }

    public Room getExit(Direction direction) {
        return exitMap.getOrDefault(direction, null);
    }

    public int[] getCoords() {
        return new int[]{COORD_X, COORD_Y};
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Room -- ID: " + ID + " (" + COORD_X + ", " + COORD_Y +")";
    }

}
