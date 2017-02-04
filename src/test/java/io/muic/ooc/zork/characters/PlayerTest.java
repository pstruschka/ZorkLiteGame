package io.muic.ooc.zork.characters;

import io.muic.ooc.zork.map.Map;
import io.muic.ooc.zork.map.MapGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void isAlive() throws Exception {
        Map testMap = MapGenerator.createMap();
        Player testPlayer3 = new Player("testPlayer3", testMap, testMap.getRoom(0));
        assertTrue(testPlayer3.isAlive());
        testPlayer3.changeHealth(-150);
        assertFalse(testPlayer3.isAlive());
    }

    @Test
    public void getHealth() throws Exception {
        Map testMap = MapGenerator.createMap();
        Player testPlayer4 = new Player("testPlayer4", testMap, testMap.getRoom(0));
        assertEquals(testPlayer4.getHealth(), 150);
        testPlayer4.changeHealth(-50);
        assertEquals(testPlayer4.getHealth(), 100);
    }

    @Test
    public void changeHealth() throws Exception {
        Map testMap = MapGenerator.createMap();
        Player testPlayer5 = new Player("testPlayer5", testMap, testMap.getRoom(0));
        assertEquals(testPlayer5.getHealth(), 150);
        testPlayer5.changeHealth(-50);
        assertEquals(testPlayer5.getHealth(), 100);
        testPlayer5.changeHealth(25);
        assertEquals(testPlayer5.getHealth(), 125);
    }

}