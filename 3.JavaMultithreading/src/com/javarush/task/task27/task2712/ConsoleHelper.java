package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static final BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return CONSOLE.readLine();
    }
    // метод формирования списка блюд в заказе
    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage(String.format("Please choose a dish from the list: [ %s ] or type 'exit' to complete the order",
                Dish.allDishesToString()));

        List<Dish> dishes = new ArrayList<>();
        while (true) {
            String dishName = readString();
            if ("exit".equals(dishName)) break;
            try {
                dishes.add(Dish.valueOf(dishName));
                writeMessage(dishName + " has been successfully added to your order");
            } catch (IllegalArgumentException e) {
                writeMessage(dishName + " hasn't been detected");
            }
        }
        return dishes;
    }
}
