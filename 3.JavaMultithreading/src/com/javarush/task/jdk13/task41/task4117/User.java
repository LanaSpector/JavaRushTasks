package com.javarush.task.jdk13.task41.task4117;

public class User {

    private int id;
    private String name;
    private Mediator mediator;

    public User(Mediator mediator, int id, String name) {
        this.name = name;
        this.id = id;
        this.mediator = mediator;
    }

    public int getId() {
        return id;
    }

    public void send(String msg, int userId) {
        System.out.println(name + " :: исходящее сообщение : " + msg);
        mediator.sendMessage(msg, userId);
        this.receive(msg);
    }

    public void receive(String msg) {
        System.out.println(name + " :: входящее сообщение : " + msg);
    }
}