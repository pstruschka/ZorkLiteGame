package io.muic.ooc.zork.characters;

import io.muic.ooc.zork.Exceptions.NameBoundException;

import java.util.ArrayList;
import java.util.List;

public class MonsterFactory {

    public static List<Monster> generateMonstersLevel1(){
        List<Monster> monsterList = new ArrayList<>();
        try {
            monsterList.add(new Monster("GreenSlime", 20, 5));
            monsterList.add(new Monster("GreenerSlime", 25, 5));
        } catch (NameBoundException e) {
            e.printStackTrace();
        }
        return monsterList;
    }
}
