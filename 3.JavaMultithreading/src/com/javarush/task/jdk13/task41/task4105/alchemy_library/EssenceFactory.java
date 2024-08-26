package com.javarush.task.jdk13.task41.task4105.alchemy_library;

import static com.javarush.task.jdk13.task41.task4105.alchemy_library.Type.MANA;
import static com.javarush.task.jdk13.task41.task4105.alchemy_library.Type.STAMINA;
import static com.javarush.task.jdk13.task41.task4105.alchemy_library.Type.MANA;
import static com.javarush.task.jdk13.task41.task4105.alchemy_library.Type.STAMINA;

public class EssenceFactory {
    public static Essence extract(Potion file) {
        Type type = file.getType();
        if (type == MANA) {
            System.out.println("EssenceFactory: extracting mana essence...");
            return new ManaEssenceConverter();
        } else if (type == STAMINA) {
            System.out.println("EssenceFactory: extracting stamina essence...");
            return new StaminaEssenceConverter();
        } else {
            System.out.println("EssenceFactory: extracting healing essence...");
            return new HealingEssenceConverter();
        }
    }
}