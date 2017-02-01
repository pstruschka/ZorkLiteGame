package io.muic.ooc.zork.commands;

import io.muic.ooc.zork.characters.Character;

import java.util.Scanner;

public class Go extends Command {
    public Go(Character character) {
        super(character);
    }

    @Override
    public void run(Scanner args) {
        args.next();
        if (!args.hasNext()) {
            throw new IllegalArgumentException("Invalid direction");
        }
        System.out.println("Pick a direction");
        String direction = args.next().toLowerCase();
        switch (direction) {
            case "north":
            case "n": {
                System.out.println("north");
                break;
            }
            case "south":
            case "s": {
                System.out.println("south");
                break;
            }
            case "east:":
            case "e": {
                System.out.println("east");
                break;
            }
            case "west":
            case "w": {
                System.out.println("west");
                break;
            }
            default:
                System.out.println("WHERE?");
        }
    }
}
