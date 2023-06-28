package com.javarush.task.pro.task16.task1607;

import java.time.LocalDate;

/* 
Освоение нового API
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
    }

    static LocalDate nowExample() {
        return LocalDate.now();
    }

    static LocalDate ofExample() {
        return LocalDate.of(2020, 9, 12);
    }

    static LocalDate ofYearDayExample() {
        LocalDate date1 = LocalDate.of(2020,9,12);
        int tmp = date1.getDayOfYear();
        return LocalDate.ofYearDay(2020, tmp);
    }

    static LocalDate ofEpochDayExample() {
        
        return LocalDate.ofEpochDay(LocalDate.of(2020,9,12).toEpochDay());
    }
}
