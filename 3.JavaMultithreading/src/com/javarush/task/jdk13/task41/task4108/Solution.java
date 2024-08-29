package com.javarush.task.jdk13.task41.task4108;

import com.javarush.task.jdk13.task41.task4108.factories.*;

/* 
Фабрики кадров
*/

public class Solution {

    public static void main(String[] args) {
        Team javaTeam = new Team(new JavaCourse());
        javaTeam.hireSeniors(1);
        javaTeam.hireMiddles(3);
        javaTeam.hireJuniors(8);
        javaTeam.produceCode();
    }
}
