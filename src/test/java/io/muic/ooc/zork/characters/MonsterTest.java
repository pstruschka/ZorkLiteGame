package io.muic.ooc.zork.characters;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by peter on 2/4/17.
 */
public class MonsterTest {
    @Test
    public void attack() throws Exception {
        Monster testMonster = new Monster("testMonster3", 10, 10);
        assertTrue(testMonster.attack(new Monster("testMonster4", 100, 0)) > 10*0.75);
        assertTrue(testMonster.attack(new Monster("testMonster5", 100, 0)) < 10*1.25);
    }

}