package com.javarush.task.jdk13.task41.task4119.shop;

import com.javarush.task.jdk13.task41.task4119.customer.Customer;
import com.javarush.task.jdk13.task41.task4119.strategy.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items = new ArrayList<>();
    private PaymentStrategy strategy;

    public ShoppingCart(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public PaymentStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public int calculateTotal() {
        int sum = 0;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public void pay() {
        int amount = calculateTotal();
        strategy.pay(amount);
//        switch (type) {
//            case CASH:
//                // много важного кода
//                System.out.printf("Оплачено товаров на $%d наличными.\n", amount);
//                break;
//            case PAYPAL:
//
//                break;
//            case CREDIT_CARD:
//
//                break;
//        }
    }
}
