package com.javarush.task.jdk13.task41.task4110.builders;

import com.javarush.task.jdk13.task41.task4110.pizzas.PizzaType;

public interface Builder {
    public void setType(PizzaType type);
    public void setDough(String dough);
    public void setSauce(String sauce);
    public void setTopping(String topping);
}
