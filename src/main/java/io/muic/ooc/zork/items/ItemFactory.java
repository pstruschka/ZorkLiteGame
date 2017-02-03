package io.muic.ooc.zork.items;

import io.muic.ooc.zork.Exceptions.NameBoundException;

import java.util.ArrayList;
import java.util.List;

public class ItemFactory {

    public static List<Item> generateItemsLevel1() {
        List<Item> itemList = new ArrayList<Item>();
        try {
            itemList.add(new Consumable("Potion1", 10, 3));
            itemList.add(new Weapon("StoneAxe", 15));
            itemList.add(new Consumable("Potion2", 20, 3));
            itemList.add(new Weapon("IronAxe", 20));
        } catch (NameBoundException e) {
            e.printStackTrace();
        }
        return itemList;
    }
}
