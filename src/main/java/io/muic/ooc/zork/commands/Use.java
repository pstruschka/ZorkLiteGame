package io.muic.ooc.zork.commands;

import io.muic.ooc.zork.Exceptions.BadSyntaxException;
import io.muic.ooc.zork.characters.Player;
import io.muic.ooc.zork.items.Consumable;
import io.muic.ooc.zork.items.Item;

import java.util.Scanner;

public class Use extends Command{
    public Use(Player player) {
        super(player);
    }

    @Override
    public void run(Scanner args) throws BadSyntaxException{
        args.next();
        if (!args.hasNext()) {
            System.out.println("Syntax: use [Item]");
            throw new BadSyntaxException();
        }
        String name = args.next().toLowerCase();
        Item item = Item.getItem(name);
        Consumable consumable = null;
        if (item instanceof Consumable) consumable = (Consumable) item;
        else {
            System.out.printf("%s is not a consumable\n", name);
            throw new BadSyntaxException();
        }
        try {
            consumable.use(player);
            if (consumable.getUses() == 0){
                player.removeFromInventory(consumable);
                Item.deleteItem(consumable.getName());
            }
        } catch (NullPointerException e) {
            throw new BadSyntaxException();
        }
    }
}
