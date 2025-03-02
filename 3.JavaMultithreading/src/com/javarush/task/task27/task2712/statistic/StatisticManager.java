package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// регистрация событий в хранилище
public class StatisticManager {
    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        if (instance == null) {
            instance = new StatisticManager();
        }
        return instance;
    }

    // регистрируем событие в хранилище.
    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    // Хранилище связано 1 к 1 с менеджером
    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>(); // хранение данных внутри себя в виде мапы/словаря

        private StatisticStorage() {
            for (EventType type : EventType.values()) {
                this.storage.put(type, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }
    }
}
