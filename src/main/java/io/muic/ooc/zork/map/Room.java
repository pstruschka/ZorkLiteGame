package io.muic.ooc.zork.map;

import io.muic.ooc.zork.characters.Monster;
import io.muic.ooc.zork.items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private final static int MAX_ITEMS = 10;
    public static int globalID = 0;
    private final int ID;
    private final int COORD_X;
    private final int COORD_Y;
    private List<Item> items = new ArrayList<>();
    private Monster monster = null;

    private boolean canDescend = false;
    private io.muic.ooc.zork.map.Map nextMap = null;
    private Room nextRoom = null;

    private Map<Direction, Room> exitMap = new HashMap<>();

    public Room(int x, int y) {
        ID = globalID++;
        COORD_X = x;
        COORD_Y = y;
    }

    public void makeDescendable(io.muic.ooc.zork.map.Map map, Room room) {
        canDescend = true;
        nextRoom = room;
        nextMap = map;
    }

    public boolean addItem(Item item) {
        if (items.size() < MAX_ITEMS) {
            items.add(item);
            return true;
        } else {
            return false;
        }
    }
    public boolean removeItem(Item item) {
        items.remove(item);
        return true;
    }

    public List<Item> getItems() {
        return items;
    }

    public static void resetCounter() {
        globalID = 0;
    }

    public boolean hasItem(Item item) {
        return items.contains(item);
    }

    public boolean roomHasItem(Item item) {
        return items.contains(item);
    }

    public void getInfo() {
        System.out.printf("Room ID: %d\n", ID);
        for (Map.Entry<Direction, Room> exit:exitMap.entrySet()) {
            System.out.printf("Direction: %s -> to %d\n", exit.getKey().toString(), exit.getValue().getID());
        }
        if (hasMonster())
            System.out.println(getMonster());
        else
            System.out.println("No monster resides here.");
        if (!items.isEmpty())
            System.out.println(items);
        else
            System.out.println("No items here.");
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Monster getMonster() {
        if (monster == null) return null;
        return monster;
    }

    public boolean hasMonster() {
        if (monster==null) return false;
        return true;
    }

    public boolean canDescend(){
        return canDescend;
    }

    public io.muic.ooc.zork.map.Map getNextMap() {
        if (canDescend) return nextMap;
        return null;
    }

    public Room getNextRoom() {
        if (canDescend) return  nextRoom;
        return null;
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
