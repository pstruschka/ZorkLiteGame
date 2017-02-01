package io.muic.ooc.zork.commands;

import io.muic.ooc.zork.characters.Character;

import java.util.Scanner;

public class Look extends Command {
    public Look(Character character) {
        super(character);
    }

    @Override
    public void run(Scanner args) {
        System.out.println("look");
    }
}
