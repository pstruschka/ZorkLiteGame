package io.muic.ooc.zork.commands;

import io.muic.ooc.zork.Exceptions.BadSyntaxException;
import io.muic.ooc.zork.characters.Player;
import io.muic.ooc.zork.map.Map;
import io.muic.ooc.zork.map.Room;

import java.util.Scanner;

public class Descend extends Command{
    public Descend(Player player) {
        super(player);
    }

    @Override
    public void run(Scanner args) throws BadSyntaxException {
        if (player.getLocation().canDescend() && !player.getLocation().hasMonster()) {
            Map map = player.getLocation().getNextMap();
            Room room = player.getLocation().getNextRoom();
            if (map == null || room == null) {
                System.out.println("You beat the game!");
                System.exit(0);
            }
            player.changeLevel(map, room);
            System.out.println("Descended the maze to the next level");
        } else {
            System.out.println("Can't descend the maze, kill the monster or find the correct room");
        }
    }
}
