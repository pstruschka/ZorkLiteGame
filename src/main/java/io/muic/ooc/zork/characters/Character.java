package io.muic.ooc.zork.characters;

import io.muic.ooc.zork.Exceptions.NameBoundException;
import io.muic.ooc.zork.map.Map;
import io.muic.ooc.zork.map.Room;

import java.util.HashMap;

public abstract class Character {
    private final String name;
    private static java.util.Map<String, Character> characters = new HashMap<>();

    final int MAX_HEALTH;
    final int MIN_HEALTH = 0;
    int health;
    boolean alive;

    Map currentMap;
    Room currentRoom;

    private Character(String name, int maxHP) throws NameBoundException {
        if (!characters.containsKey(name)) {
            this.name = name;
            MAX_HEALTH = maxHP;
            characters.put(name, this);
        } else
            throw new NameBoundException("Character of name\"" + name + "\"already exists");
    }

    Character(String name, int maxHP, Map map, Room room) throws NameBoundException {
        this(name, maxHP);
        health = MAX_HEALTH;
        alive = true;

        currentMap = map;
        currentRoom = room;
    }

    public boolean changeHealth(int deltaHealth) {
        if (deltaHealth > 0) {
            if (health == MAX_HEALTH) return false;
            health = (health + deltaHealth > MAX_HEALTH) ? MAX_HEALTH : health + deltaHealth;
        } else {
            if (health + deltaHealth < MIN_HEALTH) {
                health = 0;
                alive = false;
            } else
                health += deltaHealth;
        }
        return true;
    }

    public boolean isAlive() {
        return alive;
    }

    public static Character getCharacter(String name){
        return characters.getOrDefault(name, null);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Character)) return false;
        Character character = (Character) object;
        return character.name.equals(name);
    }
}
