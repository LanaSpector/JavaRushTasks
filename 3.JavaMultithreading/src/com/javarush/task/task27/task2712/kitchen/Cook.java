package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    private String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable observer, Object arg) {
        // observable - объект, который отправил нам значение,
        // arg - само значение, в нашем случае это объект order
        Order order = (Order) arg;
        ConsoleHelper.writeMessage("Start cooking - " + order);
        CookedOrderEventDataRow event = new CookedOrderEventDataRow(
                observer.toString(),
                name,
                order.getTotalCookingTime() * 60,
                order.getDishes()
        );

        StatisticManager.getInstance().register(event);

        setChanged();
        notifyObservers(order);
    }

    @Override
    public String toString() {
        return name;
    }
}
