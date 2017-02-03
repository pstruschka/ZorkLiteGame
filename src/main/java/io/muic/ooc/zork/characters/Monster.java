package io.muic.ooc.zork.characters;

import io.muic.ooc.zork.Exceptions.NameBoundException;
import io.muic.ooc.zork.map.Map;
import io.muic.ooc.zork.map.Room;
import io.muic.ooc.zork.utils.DamageHandler;

import java.util.Random;

public class Monster extends Character{

    private final int damage;

    Monster(String name, int maxHP, int damage) throws NameBoundException {
        super(name, maxHP);
        this.damage = damage;
    }

    public int attack(Character character) {
        int thisDamage = DamageHandler.getRandomDamage(character, damage);
        System.out.printf("%s attacks for %d damage.\n", this.getName(), thisDamage);
        return thisDamage;
    }
}
