package io.muic.ooc.zork.commands;

import io.muic.ooc.zork.characters.Player;

import java.util.Scanner;

public class Look extends Command {
    public Look(Player player) {
        super(player);
    }

    @Override
    public void run(Scanner args) {
        System.out.println("You see");
        player.getLocation().getInfo();
    }
}
