package io.muic.ooc.zork.commands;

import io.muic.ooc.zork.Exceptions.BadSyntaxException;
import io.muic.ooc.zork.characters.Character;
import io.muic.ooc.zork.characters.Monster;
import io.muic.ooc.zork.characters.Player;
import io.muic.ooc.zork.items.Item;
import io.muic.ooc.zork.items.Weapon;

import java.util.Objects;
import java.util.Scanner;

public class Attack extends Command{
    private String help = "Invalid syntax: attack [monster] with [weapon]\n";

    public Attack(Player player) {
        super(player);
    }

    @Override
    public void run(Scanner args) throws BadSyntaxException{
        args.next();
        if (!args.hasNext()) {
            System.out.printf(help);
            throw new BadSyntaxException();
        }
        String name = args.next().toLowerCase();
        Character character = Character.getCharacter(name);
        Monster monster = null;
        if (character instanceof Monster) monster = (Monster) character;
        else {
            System.out.printf("%s is not a monster\n", name);
            throw new BadSyntaxException();
        }
        if (!Objects.equals(args.next(), "with")) {
            System.out.printf(help);
            throw new BadSyntaxException();
        }
        if (!args.hasNext()) {
            System.out.println(help);
            throw new BadSyntaxException();
        }
        name = args.next().toLowerCase();
        Item item = Item.getItem(name);
        Weapon weapon = null;
        if (item instanceof Weapon) weapon = (Weapon) item;
        else {
            System.out.printf("%s is not a weapon\n", name);
        }
        weapon.use(player, monster);
    }
}
