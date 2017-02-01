package io.muic.ooc.zork.items;

import io.muic.ooc.zork.Exceptions.NameBoundException;

public class Consumable extends Item {


    public Consumable(String name) throws NameBoundException {
        super(name);
    }

    @Override
    public void use() {

    }
}
