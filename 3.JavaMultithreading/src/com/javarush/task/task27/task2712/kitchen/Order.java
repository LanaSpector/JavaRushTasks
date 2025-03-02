package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;


public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet; // при создании заказа указывается номер планшета
        dishes = ConsoleHelper.getAllDishesForOrder(); // получаем список выбранных блюд
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public int getTotalCookingTime() {
        return dishes.stream()
                .mapToInt(Dish::getDuration)
                .sum();
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    @Override
    public String toString() {
        return dishes.isEmpty() ? "" :
                String.format("Your order: %s of %s, cooking time %smin",
                        dishes, tablet.toString(), getTotalCookingTime());
    }
}
