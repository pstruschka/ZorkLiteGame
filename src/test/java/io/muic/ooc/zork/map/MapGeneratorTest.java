package io.muic.ooc.zork.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class MapGeneratorTest {
    @Test
    public void testCreateMap() throws Exception {
        Map map = MapGenerator.createMap();
        assertEquals(map.getSize(), 9);
        assertArrayEquals(map.getDimensions(), new int[]{3,3});
    }

}