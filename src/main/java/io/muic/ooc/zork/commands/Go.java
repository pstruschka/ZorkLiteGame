package io.muic.ooc.zork.commands;

import io.muic.ooc.zork.Exceptions.BadSyntaxException;
import io.muic.ooc.zork.characters.Player;
import io.muic.ooc.zork.map.Direction;
import io.muic.ooc.zork.map.Room;

import java.util.Scanner;

public class Go extends Command {
    public Go(Player player) {
        super(player);
    }

    @Override
    public void run(Scanner args) throws BadSyntaxException{
        String BLOCKED = "A wall blocks your path";
        args.next();
        if (!args.hasNext()) {
            System.out.printf("Invalid syntax: go [n,s,e,w] or go [north,south,east,west]\n");
            throw new BadSyntaxException();
        }
        if (player.getLocation().hasMonster()) {
            System.out.printf("The %s blocks the exit.\n", player.getLocation().getMonster());
        }
        Room nextRoom = null;
        String direction = args.next().toLowerCase();
        switch (direction) {
            case "north":
            case "n": {
                nextRoom = player.getLocation().getExit(Direction.NORTH);
                if (nextRoom == null) {
                    System.out.println(BLOCKED);
                    return;
                }
                if (!player.move(nextRoom)) throw new BadSyntaxException();
                break;
            }
            case "south":
            case "s": {
                nextRoom = player.getLocation().getExit(Direction.SOUTH);
                if (nextRoom == null) {
                    System.out.println(BLOCKED);
                    return;
                }
                if (!player.move(nextRoom)) throw new BadSyntaxException();
                break;
            }
            case "east":
            case "e": {
                nextRoom = player.getLocation().getExit(Direction.EAST);
                if (nextRoom == null) {
                    System.out.println(BLOCKED);
                    return;
                }
                if (!player.move(nextRoom)) throw new BadSyntaxException();
                break;
            }
            case "west":
            case "w": {
                nextRoom = player.getLocation().getExit(Direction.WEST);
                if (nextRoom == null) {
                    System.out.println(BLOCKED);
                    return;
                }
                if (!player.move(nextRoom)) throw new BadSyntaxException();
                break;
            }
            default:
                System.out.printf("Invalid syntax: go [n,s,e,w] or go [north,south,east,west]\n");
                throw new BadSyntaxException();
        }
        if (nextRoom.canDescend()) {
            System.out.println("You can Descend the maze from here.");
        }
    }
}
