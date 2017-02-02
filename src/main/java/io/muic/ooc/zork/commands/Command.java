package io.muic.ooc.zork.commands;


import io.muic.ooc.zork.characters.Character;
import io.muic.ooc.zork.characters.Player;

import java.util.Scanner;

public abstract class Command {
    Player player;

    public Command(Player player) {
        this.player = player;
    }

    public abstract void run(Scanner args);
}
