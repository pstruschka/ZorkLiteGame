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
            itemList.add(new Consumable("Potion2", 15, 2));
            itemList.add(new Weapon("IronAxe", 20));
        } catch (NameBoundException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public static List<Item> generateItemsLevel2() {
        List<Item> itemList = new ArrayList<Item>();
        try {
            itemList.add(new Consumable("Potion3", 15, 2));
            itemList.add(new Weapon("SteelAxe", 25));
            itemList.add(new Consumable("Potion4", 20, 1));
            itemList.add(new Weapon("ReinforcedSteelAxe", 30));
        } catch (NameBoundException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public static List<Item> generateItemsLevel3() {
        List<Item> itemList = new ArrayList<Item>();
        try {
            itemList.add(new Consumable("Potion5", 20, 2));
            itemList.add(new Weapon("DeathAxe", 35));
            itemList.add(new Consumable("Potion6", 25, 1));
        } catch (NameBoundException e) {
            e.printStackTrace();
        }
        return itemList;
    }
}
