package io.muic.ooc.zork.commands;

import io.muic.ooc.zork.Exceptions.BadSyntaxException;
import io.muic.ooc.zork.characters.Player;
import io.muic.ooc.zork.items.Item;

import java.util.Scanner;

public class Drop extends Command {
    public Drop(Player player) {
        super(player);
    }

    @Override
    public void run(Scanner args) throws BadSyntaxException {
        args.next();
        if (!args.hasNext()) {
            System.out.println("Syntax: drop [item]");
            throw new BadSyntaxException();
        }
        String name = args.next().toLowerCase();
        Item item = Item.getItem(name);
        if (item == null || !player.hasItem(item)) {
            System.out.println("Not a valid item or item not in inventory");
            throw new BadSyntaxException();
        }
        player.removeFromInventory(item);
        player.getLocation().addItem(item);
    }
}
