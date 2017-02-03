package io.muic.ooc.zork.utils;

import io.muic.ooc.zork.characters.Character;

import java.util.Random;

public class DamageHandler {
    private DamageHandler() {}

    public static int getRandomDamage(Character character, int baseDamage) {
        Random random = new Random();
        float modifier = baseDamage/4.0f;
        float randFloat = random.nextFloat();
        float randModifier = (random.nextBoolean()) ? randFloat * modifier : -1*(randFloat * modifier);
        int randDamage = baseDamage + (int) randModifier;
        character.changeHealth((-1)*randDamage);
        return randDamage;
    }
}
