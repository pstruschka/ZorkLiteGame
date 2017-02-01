package io.muic.ooc.zork.items;

import io.muic.ooc.zork.Exceptions.NameBoundException;

import java.util.Map;

public abstract class Item {
    private final String name;
    private static Map<String, Item> items;

    Item(String name) throws NameBoundException {
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
        return items.getOrDefault(name, null);
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

    public abstract void use();

}
