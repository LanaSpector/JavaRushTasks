package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number;
    private static final Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);

            int time = order.getTotalCookingTime() * 60;
            AdvertisementManager manager = new AdvertisementManager(time);
            manager.processVideos();

            ConsoleHelper.writeMessage(order.toString());

            setChanged();

            if (!order.isEmpty()) {
                notifyObservers(order);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        return order;
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }
}
