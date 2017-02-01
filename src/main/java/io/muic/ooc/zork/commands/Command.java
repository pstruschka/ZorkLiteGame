package io.muic.ooc.zork.commands;


import io.muic.ooc.zork.characters.Character;

import java.util.Scanner;

public abstract class Command {
    Character character;

    public Command(Character character) {
        this.character = character;
    }

    public abstract void run(Scanner args);
}
