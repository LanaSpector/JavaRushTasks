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

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage(String.format("Пожалуйста, выберете блюдо из списка: [ %s ] или введите 'exit' для формирования заказа",
                Dish.allDishesToString()));

        List<Dish> dishes = new ArrayList<>();
        while (true) {
            String dishName = readString();
            if (dishName.equals("exit")) break;
            try {
                dishes.add(Dish.valueOf(dishName));
                writeMessage(dishName + " успешно добавлено в заказ");
            } catch (IllegalArgumentException e) {
                writeMessage(dishName + " не найдено в списке меню");
            }
        }
        return dishes;
    }
}
