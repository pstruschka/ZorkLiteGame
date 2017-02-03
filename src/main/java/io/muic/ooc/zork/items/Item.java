package io.muic.ooc.zork.items;

import io.muic.ooc.zork.Exceptions.NameBoundException;
import io.muic.ooc.zork.characters.Character;

import java.util.HashMap;
import java.util.Map;

public abstract class Item {
    private final String name;
    private static Map<String, Item> items = new HashMap<>();

    Item(String name) throws NameBoundException {
        name = name.toLowerCase();
        if (!items.containsKey(name)) {
            this.name = name;
            items.put(name, this);
        } else
            throw new NameBoundException("Item of name\"" + name + "\"already exists ");
    }

    public String getName() {
        return name;
    }

    public static Item getItem(String name) {
        name = name.toLowerCase();
        return items.getOrDefault(name, null);
    }

    public static void deleteItem(String name) {
        name = name.toLowerCase();
        if (items.containsKey(name)) {
            items.remove(name);
        }
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Item)) return false;
        Item item = (Item) object;
        return item.name.equals(name);
    }

    @Override
    public String toString() {
        return name;
    }

    public abstract void use(Character character);

}
