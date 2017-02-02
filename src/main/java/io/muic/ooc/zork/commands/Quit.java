package io.muic.ooc.zork.commands;

import io.muic.ooc.zork.characters.Player;

import java.util.Scanner;

public class Quit extends Command {
    public Quit(Player player) {
        super(player);
    }

    @Override
    public void run(Scanner args) {
        System.exit(0);
    }
}
