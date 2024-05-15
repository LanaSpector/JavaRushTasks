package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    FISH,
    STEAK,
    SOUP,
    JUICE,
    WATER;

    public static String allDishesToString() {
        String string = "";
        for (Dish dish : Dish.values()) {
            string = string + dish.name() + ", ";
        }
        return string.trim().substring(0, string.length()-2);
    }
}
