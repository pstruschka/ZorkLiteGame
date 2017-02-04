package io.muic.ooc.zork.map;

import io.muic.ooc.zork.characters.Monster;
import io.muic.ooc.zork.items.Item;

import java.util.*;

public class MapPopulater {
    public static boolean populate(Map map, List<Item> items, List<Monster> monsters) {
        Random rand = new Random();
        int mapSize = map.getSize();
        int itemSize = items.size();
        int monsterSize = monsters.size();
        int itemInc = mapSize/itemSize;
        int monsterInc = mapSize/monsterSize;
        int index;

        Iterator<Item> itemIterator = items.iterator();
        Iterator<Monster> monsterIterator = monsters.iterator();
        index = 0;
        while (itemIterator.hasNext()) {
            index += rand.nextInt(itemInc);
            Item currentItem = itemIterator.next();
            Room currentRoom = map.getRoom(index);
            System.out.printf("%s - %s\n", currentRoom, currentItem);
            currentRoom.addItem(currentItem);
        }
        index = 1;
        while (monsterIterator.hasNext()) {
            index += rand.nextInt(monsterInc);
            Monster currentMonster = monsterIterator.next();
            Room currentRoom = map.getRoom(index);
            System.out.printf("%s - %s\n", currentRoom, currentMonster);
            currentRoom.setMonster(currentMonster);
        }
        return true;
    }
}
