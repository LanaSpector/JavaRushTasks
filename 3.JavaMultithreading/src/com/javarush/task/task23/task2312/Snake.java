package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    int getY() {
        return sections.get(0).getY();
    }

    public Snake(int x, int y) {
        sections = new ArrayList<SnakeSection>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;

    }

    public void move() {
        if (!isAlive) {
            return;
        }
        if (direction == SnakeDirection.UP) {
            move(0, -1);
        } else if (direction == SnakeDirection.RIGHT) {
            move(1, 0);
        } else if (direction == SnakeDirection.DOWN) {
            move(0, 1);
        } else if (direction == SnakeDirection.LEFT) {
            move(-1, 0);
        }
    }

    /**
     * Метод перемещает змею в соседнюю клетку.
     * Координаты клетки заданы относительно текущей головы с помощью переменных (dx, dy).
     */
    void move(int dx, int dy) {
        SnakeSection head = sections.get(0);
        head = new SnakeSection(head.getX() + dx, head.getY() + dy);

        checkBorders(head);
        if (!isAlive) return;

        checkBody(head);
        if (!isAlive) return;

        Mouse mouse = Room.game.getMouse();
        if (head.getX() == mouse.getX() && head.getY() == mouse.getY())
        {
            sections.add(0, head);
            Room.game.eatMouse();
        } else
        {
            sections.add(0, head);
            sections.remove(sections.size() - 1);
        }
    }

    public void checkBorders(SnakeSection head) {
        if (head.getX() < 0 || head.getY() < 0 ||
                head.getX() >= Room.game.getWidth() ||
                head.getY() >= Room.game.getHeight()
        ) isAlive = false;
    }

    public void checkBody(SnakeSection head) {
        if (sections.contains(head)) {
            isAlive = false;
        }
    }

}
