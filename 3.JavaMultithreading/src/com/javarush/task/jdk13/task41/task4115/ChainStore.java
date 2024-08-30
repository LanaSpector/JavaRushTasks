package com.javarush.task.jdk13.task41.task4115;

import com.javarush.task.jdk13.task41.task4115.listeners.NotificationType;
import com.javarush.task.jdk13.task41.task4115.publisher.NotificationManager;

public class ChainStore {

    public NotificationManager notifications;

    private final String name;

    public ChainStore(String name) {
        this.notifications = new NotificationManager(NotificationType.EVENT
                ,NotificationType.PROMO
                ,NotificationType.PERSONAL_OFFER
                ,NotificationType.SALE);
        this.name = name;
    }

    public void launchPersonalOffer() {
        System.out.println(name + " запускает соблазнительные персональные скидки!");
        notifications.notify(NotificationType.PERSONAL_OFFER, name);
    }

    public void launchSale() {

        System.out.println(name + " запускает горячую распродажу!");
        notifications.notify(NotificationType.SALE, name);
    }

    public void launchPromo() {
        System.out.println("В " + name + " стартует супер промо акция!");
        notifications.notify(NotificationType.PROMO, name);
    }

    public void launchEvent() {
        System.out.println("В " + name + " состоится грандиозное мероприятие!");
        notifications.notify(NotificationType.EVENT, name);
    }
}
