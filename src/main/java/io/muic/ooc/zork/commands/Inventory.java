package io.muic.ooc.zork.commands;

import io.muic.ooc.zork.characters.Player;

import java.util.Scanner;

public class Inventory extends Command {
    public Inventory(Player player) {
        super(player);
    }

    @Override
    public void run(Scanner args) {
        System.out.printf("Your current inventory is:\n%s\n", player.getInventory());
    }
}
