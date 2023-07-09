package com.javarush.task.pro.task17.task1715;

import java.util.ArrayList;
import java.util.List;

/* 
Вилларибо и Виллабаджо.
*/

public class Solution implements MusicalInstrument {
    static List<MusicalInstrument> orchestra = new ArrayList<>();

    public static void main(String[] args) {
        createKeyboardOrchestra();
        createStringedOrchestra();
        playOrchestra();
    }

    public static void createKeyboardOrchestra() {
        orchestra.add(new Organ());
        orchestra.add(new Piano());
        orchestra.add(new Piano());
        orchestra.add(new Piano());
    }

    public static void createStringedOrchestra() {
        orchestra.add(new Guitar());
        orchestra.add(new Violin());
        orchestra.add(new Violin());
    }

    public static void playOrchestra() {
        for (MusicalInstrument musicalInstrument : orchestra) {
            musicalInstrument.play();
        }
    }

    @Override
    public void play() {

    }
}
