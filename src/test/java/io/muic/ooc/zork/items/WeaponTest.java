package io.muic.ooc.zork.items;

import io.muic.ooc.zork.characters.Monster;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by peter on 2/4/17.
 */
public class WeaponTest {
    @Test
    public void testWeaponUsage() throws Exception {
        Weapon testWeapon = new Weapon("testWeapon", 20);
        Monster testMonster = new Monster("testMonster2", 100, 0);
        testWeapon.use(testMonster);
        assertTrue(testMonster.getHealth() < 100);
    }

}