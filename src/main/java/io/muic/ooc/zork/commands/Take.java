package io.muic.ooc.zork.commands;

import io.muic.ooc.zork.Exceptions.BadSyntaxException;
import io.muic.ooc.zork.characters.Player;
import io.muic.ooc.zork.items.Item;

import java.util.Scanner;

public class Take extends Command{
    public Take(Player player) {
        super(player);
    }

    @Override
    public void run(Scanner args) throws BadSyntaxException{
        args.next();
        if (!args.hasNext()) {
            System.out.println("Syntax: take <Item>");
            throw new BadSyntaxException();
        }
        String name = args.next().toLowerCase();
        Item item = Item.getItem(name);
        if (item == null || !player.getLocation().hasItem(item)) {
            System.out.printf("There is no %s in this room\n", name);
            System.out.printf("This room has %s\n", player.getLocation().getItems().toString());
            throw new BadSyntaxException();
        }
        if(player.addToInventory(item))
            player.getLocation().removeItem(item);
        else
            System.out.println("Your inventory is full");

    }
}
