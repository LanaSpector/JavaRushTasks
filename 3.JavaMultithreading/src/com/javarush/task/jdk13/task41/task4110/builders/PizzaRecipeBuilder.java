package com.javarush.task.jdk13.task41.task4110.builders;

import com.javarush.task.jdk13.task41.task4110.pizzas.Pizza;
import com.javarush.task.jdk13.task41.task4110.pizzas.PizzaType;
import com.javarush.task.jdk13.task41.task4110.pizzas.Recipe;

public class PizzaRecipeBuilder implements Builder {
    private PizzaType type;
    private String dough;
    private String sauce;
    private String topping;

    public PizzaRecipeBuilder(PizzaType type, String dough, String sauce, String topping) {
        this.type = type;
        this.dough = dough;
        this.sauce = sauce;
        this.topping = topping;
    }

    public PizzaRecipeBuilder() {}

    @Override
    public void setType(PizzaType type) {
        this.type = type;
    }

    @Override
    public void setDough(String dough) {
        this.dough = dough;
    }

    @Override
    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    @Override
    public void setTopping(String topping) {
        this.topping = topping;
    }

    public Recipe getResult() {
        return new Recipe(type, dough, sauce, topping);
    }
}
