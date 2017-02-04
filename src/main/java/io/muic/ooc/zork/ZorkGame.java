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

        Map level1 = createMap();
        List<Item> itemList = ItemFactory.generateItemsLevel1();
        List<Monster> monsterList = MonsterFactory.generateMonstersLevel1();
        MapPopulater.populate(level1, itemList, monsterList);
        Room.resetCounter();
        System.out.println("CreatedMap1");

        Map level2 = createMap();
        itemList = ItemFactory.generateItemsLevel2();
        monsterList = MonsterFactory.generateMonstersLevel2();
        MapPopulater.populate(level2, itemList, monsterList);
        Room.resetCounter();
        System.out.println("CreatedMap2");

        Map level3 = createMap();
        itemList = ItemFactory.generateItemsLevel3();
        monsterList = MonsterFactory.generateMonstersLevel3();
        MapPopulater.populate(level3, itemList, monsterList);
        System.out.println("CreatedMap3");

        level1.getRoom(level1.getSize()-1).makeDescendable(level2, level2.getRoom(0));
        level2.getRoom(level2.getSize()-1).makeDescendable(level3, level3.getRoom(0));
        level3.getRoom(level3.getSize()-1).makeDescendable(null, null);

        Room start = level1.getRoom(0);
        try {
            player = new Player(level1, start);
            player.addToInventory(new Weapon("WoodenAxe", 5));
            System.out.println("You have a woodenaxe");
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
        actions.put("descend", new Descend(player));

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
