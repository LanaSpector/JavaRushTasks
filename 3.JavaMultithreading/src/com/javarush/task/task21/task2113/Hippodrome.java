package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<>();
        Horse whiteHorse = new Horse("White", 3, 0);
        Horse blueHorse = new Horse("Blue", 3, 0);
        Horse redHorse = new Horse("Red", 3, 0);

        horses.add(whiteHorse);
        horses.add(blueHorse);
        horses.add(redHorse);

        game = new Hippodrome(horses);


    }
}
