package io.muic.ooc.zork.items;

import io.muic.ooc.zork.Exceptions.NameBoundException;
import io.muic.ooc.zork.characters.Character;
import io.muic.ooc.zork.characters.Player;
import io.muic.ooc.zork.utils.DamageHandler;

import java.util.Random;

public class Weapon extends Item{
    private int damage;

    public Weapon(String name, int damage) throws NameBoundException {
        super(name);
        this.damage = damage;
    }

    @Override
    public void use(Character character) {
        DamageHandler.getRandomDamage(character, damage);
    }

    public void use(Player player, Character target) {
        int thisDamage = DamageHandler.getRandomDamage(target, damage*player.getDamageModifier());
        System.out.printf("You attack %s for %d\n", target, thisDamage);
        System.out.printf("The %s has %d health left\n", target, target.getHealth());
        if (!target.isAlive()) {
            player.getLocation().setMonster(null);
            Character.deleteCharacter(target.toString());
        }
    }
}
