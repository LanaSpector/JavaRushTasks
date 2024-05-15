package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishList = new ArrayList<>();
        writeMessage("Пожалуйста, выберите блюдо и введите название.");
        writeMessage(Dish.allDishesToString());
        while (true) {
            String string = readString();
            if (string.equals("exit")) {
                return dishList;
            }
            try {
                dishList.add(Dish.valueOf(string));
            } catch (IllegalArgumentException e) {
                writeMessage("Такого блюда нет в меню");
            }
        }
    }
}
