package com.javarush.task.jdk13.task41.task4107.developers;


public class KotlinDeveloper extends JavaDeveloper implements Developer{
    @Override
    public void study() {
        System.out.println("Изучает особенности котлина...");
        writeCode();
    }
}
