package io.muic.ooc.zork;

import io.muic.ooc.zork.Exceptions.NameBoundException;
import io.muic.ooc.zork.characters.Player;
import io.muic.ooc.zork.commands.Command;
import io.muic.ooc.zork.commands.Go;
import io.muic.ooc.zork.commands.Look;
import io.muic.ooc.zork.commands.Quit;

import java.util.HashMap;
import java.util.Scanner;

import static io.muic.ooc.zork.MapGenerator.GenerateDemoMap;

public class ZorkGame {
    public void start() {
        Player player = null;

        // TODO: create demo map

        Map map = GenerateDemoMap();
        try {
            player = new Player(map, 0, 0);
        } catch (NameBoundException e) {
        }

        if (player == null) System.exit(100);

        java.util.Map<String, Command> actions = new HashMap<>();
        actions.put("go", new Go(player));
        actions.put("look", new Look(player));
        actions.put("quit", new Quit(player));

        boolean quit = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Start:");
        while (!quit) {
            try {
                String line = in.nextLine();
                String words[] = line.trim().split("\\s+");
                actions.get(words[0]).run(new Scanner(line));
            } catch (NullPointerException e) {
                System.out.println("Invalid Command");
            }
        }
    }
}
