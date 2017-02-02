package io.muic.ooc.zork.characters;

import io.muic.ooc.zork.Exceptions.NameBoundException;
import io.muic.ooc.zork.map.Map;
import io.muic.ooc.zork.map.Room;
import io.muic.ooc.zork.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character {

    private final int MAX_INVENTORY = 3;
    private List<Item> inventory;

    public Player(Map map, Room room) throws NameBoundException{
        super("Player", 50, map, room);
        inventory = new ArrayList<>(MAX_INVENTORY);
        alive = true;
    }

    public boolean changeLevel(Map map, Room room) {
        if (map.roomExists(room)) {
            currentMap = map;
            currentRoom = room;
            return true;
        }
        else return false;
    }

    public boolean move(Room room) {
        if (currentMap.roomExists(room)) {
            currentRoom = room;
            return true;
        }
        else return false;
    }

    public Room getLocation() {
        return currentRoom;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public boolean addToInventory(Item item) {
        if (inventory.size() < MAX_INVENTORY) {
            inventory.add(item);
            return true;
        } else
            return false;
    }

    public boolean dropItem(Item item) {
        if (inventory.contains(item)) {
            inventory.remove(item);
            return true;
        } else
            return false;
    }
}
