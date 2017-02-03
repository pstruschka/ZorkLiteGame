package io.muic.ooc.zork.items;

import io.muic.ooc.zork.Exceptions.NameBoundException;
import io.muic.ooc.zork.characters.Character;

public class Consumable extends Item {
    private int healthMod;
    private int uses;

    public Consumable(String name, int healthMod, int uses) throws NameBoundException {
        super(name);
        this.healthMod = healthMod;
        this.uses = uses;
    }

    public int getUses() {
        return uses;
    }

    @Override
    public void use(Character character) {
        uses--;
        character.changeHealth(healthMod);
    }
}
