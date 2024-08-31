package com.javarush.task.jdk13.task41.task4117;

public interface Mediator {
    public void sendMessage(String msg, int userId);

    public void register(User user);
}
