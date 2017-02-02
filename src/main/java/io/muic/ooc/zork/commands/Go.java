package io.muic.ooc.zork.commands;

import io.muic.ooc.zork.characters.Player;
import io.muic.ooc.zork.map.Direction;
import io.muic.ooc.zork.map.Room;

import java.util.Scanner;

public class Go extends Command {
    public Go(Player player) {
        super(player);
    }

    @Override
    public void run(Scanner args) {
        String BLOCKED = "A wall blocks your path";
        args.next();
        if (!args.hasNext()) {
            System.out.printf("Invalid syntax: go [n,s,e,w] or go [north,south,east,west]");
            return;
        }
        System.out.println("Pick a direction");
        String direction = args.next().toLowerCase();
        System.out.println(direction);
        switch (direction) {
            case "north":
            case "n": {
                Room nextRoom = player.getLocation().getExit(Direction.NORTH);
                if (nextRoom == null) {
                    System.out.println(BLOCKED);
                    return;
                }
                if (player.move(nextRoom))
                    nextRoom.getInfo();
                else System.out.println("error");
                break;
            }
            case "south":
            case "s": {
                Room nextRoom = player.getLocation().getExit(Direction.SOUTH);
                if (nextRoom == null) {
                    System.out.println(BLOCKED);
                    return;
                }
                if (player.move(nextRoom))
                    nextRoom.getInfo();
                else System.out.println("error");
                break;
            }
            case "east":
            case "e": {
                Room nextRoom = player.getLocation().getExit(Direction.EAST);
                if (nextRoom == null) {
                    System.out.println(BLOCKED);
                    return;
                }
                if (player.move(nextRoom))
                    nextRoom.getInfo();
                else System.out.println("error");
                break;
            }
            case "west":
            case "w": {
                Room nextRoom = player.getLocation().getExit(Direction.WEST);
                if (nextRoom == null) {
                    System.out.println(BLOCKED);
                    return;
                }
                if (player.move(nextRoom))
                    nextRoom.getInfo();
                else System.out.println("error");
                break;
            }
            default:
                System.out.println("WHERE?");
        }
    }
}
