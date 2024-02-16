package com.javarush.task.task23.task2312;

import java.util.Objects;

public class SnakeSection {
    private int x;
    private int y;

    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        SnakeSection that = (SnakeSection) object;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


}
