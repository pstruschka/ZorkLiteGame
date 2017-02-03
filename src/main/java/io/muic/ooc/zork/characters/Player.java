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

    private Map currentMap;
    private Room currentRoom;
    private int damageModifier;

    public Player(Map map, Room room) throws NameBoundException{
        super("Player", 100);
        inventory = new ArrayList<>(MAX_INVENTORY);
        alive = true;
        damageModifier = 1;
        currentMap = map;
        currentRoom = room;
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

    public int getDamageModifier() {
        return damageModifier;
    }

    public boolean addToInventory(Item item) {
        if (inventory.size() < MAX_INVENTORY) {
            inventory.add(item);
            return true;
        } else
            return false;
    }

    public boolean removeFromInventory(Item item) {
        if (inventory.contains(item)) {
            inventory.remove(item);
            return true;
        } else
            return false;
    }

    public boolean hasItem(Item item) {
        return inventory.contains(item);
    }
}
