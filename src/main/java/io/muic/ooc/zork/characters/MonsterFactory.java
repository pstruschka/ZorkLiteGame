package io.muic.ooc.zork.characters;

import io.muic.ooc.zork.Exceptions.NameBoundException;

import java.util.ArrayList;
import java.util.List;

public class MonsterFactory {

    public static List<Monster> generateMonstersLevel1(){
        List<Monster> monsterList = new ArrayList<>();
        try {
            monsterList.add(new Monster("GreenSlime", 20, 5));
            monsterList.add(new Monster("GreenerSlime", 50, 5));
        } catch (NameBoundException e) {
            e.printStackTrace();
        }
        return monsterList;
    }

    public static List<Monster> generateMonstersLevel2(){
        List<Monster> monsterList = new ArrayList<>();
        try {
            monsterList.add(new Monster("SoldierSlime", 100, 5));
            monsterList.add(new Monster("GuardSlime", 125, 10));
        } catch (NameBoundException e) {
            e.printStackTrace();
        }
        return monsterList;
    }

    public static List<Monster> generateMonstersLevel3(){
        List<Monster> monsterList = new ArrayList<>();
        try {
            monsterList.add(new Monster("GuardianSlime", 125, 10));
            monsterList.add(new Monster("BossSlime", 200, 15));
        } catch (NameBoundException e) {
            e.printStackTrace();
        }
        return monsterList;
    }
}
