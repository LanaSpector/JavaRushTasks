package com.javarush.task.task27.task2712.statistic.event;

//интерфейс-маркер По нему мы определяем, является ли переданный объект событием или нет.
public interface EventDataRow {
    public EventType getType();
}
