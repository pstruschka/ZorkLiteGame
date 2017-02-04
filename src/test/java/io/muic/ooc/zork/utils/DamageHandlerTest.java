package io.muic.ooc.zork.utils;

import io.muic.ooc.zork.characters.Character;
import io.muic.ooc.zork.characters.Player;
import io.muic.ooc.zork.map.Map;
import io.muic.ooc.zork.map.MapGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class DamageHandlerTest {
    @Test
    public void testGetRandomDamageOnPlayer() throws Exception {
        Map map = MapGenerator.createMap();
        Player player = new Player(map, map.getRoom(0));
        DamageHandler.getRandomDamage(player, 5);
    }

}