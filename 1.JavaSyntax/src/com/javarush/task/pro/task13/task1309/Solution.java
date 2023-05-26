package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Сергей Иванов", 3.56);
        grades.put("Анна Бланк", 4.87);
        grades.put("Стас Воробьев", 2.56);
        grades.put("Майкл Кейн", 5.00);
        grades.put("Аквафина", 4.31);
    }
}
