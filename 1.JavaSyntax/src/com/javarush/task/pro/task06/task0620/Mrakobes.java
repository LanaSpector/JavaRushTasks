package com.javarush.task.pro.task06.task0620;

public class Mrakobes {
    private static boolean isAlive = true;
    
    public static void setIsAlive(boolean isAlive3) {
        isAlive = isAlive3;
    }

    public static void printState() {
        System.out.println("Амиго" + (isAlive ? " НЕ " : " ") + "победил Мракобеса Безумного");
    }
}
