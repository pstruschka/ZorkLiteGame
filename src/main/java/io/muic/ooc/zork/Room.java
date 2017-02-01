package io.muic.ooc.zork;

import io.muic.ooc.zork.characters.Monster;
import io.muic.ooc.zork.items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private final static int MAX_ITEMS = 3;
    private List<Item> items = new ArrayList<>();
    private Monster monster = null;

    private Map<String, Room> exitMap = new HashMap<>();

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

    public String getInfo() {
        // print items
        // print monster
        // print exits
        return "TODO";
    }

    public void setMonster(Monster monster) {
        if (this.monster != null) {
            this.monster = monster;
        }
    }
    public void setExit(String direction, Room exitingRoom) {
        if (direction.equals("north") || direction.equals("south") || direction.equals("east") || direction.equals("west")) {
            exitMap.put(direction, exitingRoom);
        } else System.out.printf("Invalid direction\n");

    }

}
