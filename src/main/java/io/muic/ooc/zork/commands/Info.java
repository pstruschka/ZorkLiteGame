package io.muic.ooc.zork.commands;

import io.muic.ooc.zork.characters.Player;

import java.util.Scanner;

public class Info extends Command{

    public Info(Player player) {
        super(player);
    }

    @Override
    public void run(Scanner args) {
        System.out.println(player.getHealth());
        System.out.println(player.getInventory());
    }
}
