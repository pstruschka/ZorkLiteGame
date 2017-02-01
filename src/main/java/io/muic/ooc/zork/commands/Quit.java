package io.muic.ooc.zork.commands;

import io.muic.ooc.zork.characters.Character;

import java.util.Scanner;

public class Quit extends Command {
    public Quit(Character character) {
        super(character);
    }

    @Override
    public void run(Scanner args) {
        System.exit(0);
    }
}
