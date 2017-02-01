package io.muic.ooc.zork.characters;

import io.muic.ooc.zork.Exceptions.NameBoundException;
import io.muic.ooc.zork.Map;
import io.muic.ooc.zork.Room;
import io.muic.ooc.zork.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character {

    private final int MAX_INVENTORY = 3;
    private List<Item> inventory;

    public Player(Map map, int x, int y) throws NameBoundException {
        super("Player", 50, map, x, y);
        inventory = new ArrayList<>(MAX_INVENTORY);
        alive = true;
    }

    boolean changeLevel(Map map, int x, int y) {
        currentMap = map;
        coordX = x;
        coordY = y;
        return true;
    }

    public Room getCurrentRoom() {
        return currentMap.getRoom(coordX, coordY);
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
