package io.muic.ooc.zork.items;

import io.muic.ooc.zork.characters.Player;
import io.muic.ooc.zork.map.Map;
import io.muic.ooc.zork.map.MapGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsumableTest {
    @Test
    public void testConsumableUsage() throws Exception {
        Consumable testConsumable = new Consumable("testConsumable1", 10, 3);
        Map testMap = MapGenerator.createMap();
        Player testPlayer1 = new Player("testPlayer1", testMap, testMap.getRoom(0));
        testPlayer1.changeHealth(-50);
        assertEquals(testPlayer1.getHealth(), 100);
        testConsumable.use(testPlayer1);
        assertEquals(testPlayer1.getHealth(), 110);
        testConsumable.use(testPlayer1);
        assertEquals(testPlayer1.getHealth(), 120);
        testConsumable.use(testPlayer1);
        assertEquals(testPlayer1.getHealth(), 130);
    }
    @Test
    public void testConsumableUses() throws Exception {
        Consumable testConsumable = new Consumable("testConsumable2", 10, 3);
        Map testMap = MapGenerator.createMap();
        Player testPlayer2 = new Player("testPlayer2", testMap, testMap.getRoom(0));
        testConsumable.use(testPlayer2);
        testConsumable.use(testPlayer2);
        testConsumable.use(testPlayer2);
        assertEquals(testConsumable.getUses(), 0);
    }
}