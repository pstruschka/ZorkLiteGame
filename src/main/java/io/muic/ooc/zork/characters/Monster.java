package io.muic.ooc.zork.characters;

import io.muic.ooc.zork.Exceptions.NameBoundException;
import io.muic.ooc.zork.Map;

import java.util.Random;

public class Monster extends Character{

    private final int damage;

    Monster(String name, int maxHP, Map map, int x, int y, int damage) throws NameBoundException {
        super(name, maxHP, map, x, y);
        this.damage = damage;
    }

    public int attack(Character character) {
        Random random = new Random();
        int randDamage = (-1) * random.nextInt(damage/2)+((damage/4)*3); /* Damage is +- between 0 and damage/4 */
        character.changeHealth(randDamage);
        return randDamage;
    }
}
