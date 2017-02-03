package io.muic.ooc.zork;

import io.muic.ooc.zork.Exceptions.BadSyntaxException;
import io.muic.ooc.zork.Exceptions.NameBoundException;
import io.muic.ooc.zork.characters.Monster;
import io.muic.ooc.zork.characters.MonsterFactory;
import io.muic.ooc.zork.characters.Player;
import io.muic.ooc.zork.commands.*;
import io.muic.ooc.zork.items.Item;
import io.muic.ooc.zork.items.ItemFactory;
import io.muic.ooc.zork.items.Weapon;
import io.muic.ooc.zork.map.Map;
import io.muic.ooc.zork.map.MapPopulater;
import io.muic.ooc.zork.map.Room;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static io.muic.ooc.zork.map.MapGenerator.createMap;

public class ZorkGame {
    public void start() {
        Player player = null;

        Map map = createMap();
        List<Item> itemList = ItemFactory.generateItemsLevel1();
        List<Monster> monsterList = MonsterFactory.generateMonstersLevel1();
        MapPopulater.populate(map, itemList, monsterList);
        Room start = map.getRoom(0);
        try {
            player = new Player(map, start);
            player.addToInventory(new Weapon("WoodenAxe", 5));
        } catch (NameBoundException e) {
            e.printStackTrace();
        }

        if (player == null) System.exit(100);

        java.util.Map<String, Command> actions = new HashMap<>();
        actions.put("go", new Go(player));
        actions.put("look", new Look(player));
        actions.put("quit", new Quit(player));
        actions.put("inventory", new Inventory(player));
        actions.put("drop", new Drop(player));
        actions.put("take", new Take(player));
        actions.put("attack", new Attack(player));
        actions.put("info", new Info(player));
        actions.put("use", new Use(player));

        boolean quit = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Start:");
        while (!quit) {
            try {
                String line = in.nextLine();
                String words[] = line.trim().split("\\s+");
                actions.get(words[0].toLowerCase()).run(new Scanner(line));
            } catch (NullPointerException | BadSyntaxException e) {
                System.out.println("Invalid Command");
                continue;
            }
            if (player.getLocation().hasMonster()) {
                player.getLocation().getMonster().attack(player);
            }
            System.out.println();
            if (!player.isAlive()) {
                System.out.println("You died");
                quit = true;
            }
        }
    }
}
