package com.javarush.task.jdk13.task41.task4116.visitor;

import com.javarush.task.jdk13.task41.task4116.animals.Cat;
import com.javarush.task.jdk13.task41.task4116.animals.Cow;
import com.javarush.task.jdk13.task41.task4116.animals.Dog;

public class JsonExportVisitor implements Visitor {
    @Override
    public String visitCat(Cat cat) {
        return "{name : " + cat.getName() + ", "
                + "mice : " + cat.miceCaught() + ", "
                + "kilogramsOfFur : " + cat.furEaten() + "}";
    }

    @Override
    public String visitCow(Cow cow) {
        return "{name : " + cow.getName() + ", "
                + "milk : " + cow.milkedLiters() + ", "
                + "stars : " + cow.getStars() + "}";
    }

    @Override
    public String visitDog(Dog dog) {
        return "{name : " + dog.getName()+", "
                + "bones : " + dog.bonesGnawed()
                + "}";
    }
}
