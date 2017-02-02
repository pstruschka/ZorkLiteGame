package io.muic.ooc.zork;

import io.muic.ooc.zork.Exceptions.NameBoundException;
import io.muic.ooc.zork.characters.Player;
import io.muic.ooc.zork.commands.*;
import io.muic.ooc.zork.map.Map;
import io.muic.ooc.zork.map.Room;

import java.util.HashMap;
import java.util.Scanner;

import static io.muic.ooc.zork.map.MapGenerator.createMap;

public class ZorkGame {
    public void start() {
        Player player = null;

        Map map = createMap();
        Room start = map.getRoom(0);
        try {
            player = new Player(map, start);
        } catch (NameBoundException e) {
            e.printStackTrace();
        }

        if (player == null) System.exit(100);

        java.util.Map<String, Command> actions = new HashMap<>();
        actions.put("go", new Go(player));
        actions.put("look", new Look(player));
        actions.put("quit", new Quit(player));
        actions.put("inventory", new Inventory(player));

        boolean quit = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Start:");
        while (!quit) {
            try {
                String line = in.nextLine();
                String words[] = line.trim().split("\\s+");
                actions.get(words[0].toLowerCase()).run(new Scanner(line));
            } catch (NullPointerException e) {
                System.out.println("Invalid Command");
            }
        }
    }
}
