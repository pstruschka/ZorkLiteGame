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
            System.out.println("Not a valid item or item not in room");
            throw new BadSyntaxException();
        }
        player.addToInventory(item);
        player.getLocation().removeItem(item);

    }
}
