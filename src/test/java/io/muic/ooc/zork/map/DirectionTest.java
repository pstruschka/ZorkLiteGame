package io.muic.ooc.zork.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {
    @Test
    public void directionTestOpposite() {
        assertEquals(Direction.opposite(Direction.NORTH), Direction.SOUTH);
        assertEquals(Direction.opposite(Direction.SOUTH), Direction.NORTH);
        assertEquals(Direction.opposite(Direction.EAST), Direction.WEST);
        assertEquals(Direction.opposite(Direction.WEST), Direction.EAST);
    }
}