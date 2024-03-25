package com.javarush.task.task24.task2413;

public class Stand extends BaseObject {
    private double speed;
    private double direction;

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }

    public Stand(double x, double y, double radius) {
        super(x, y, radius);
    }

    @Override
    void draw(Canvas canvas) {

    }

    @Override
    void move() {
        double dx = speed * direction;
        x = x + dx;
    }

    void moveLeft() {
        direction = -1;
    }

    void moveRight() {
        direction = 1;
    }
}
