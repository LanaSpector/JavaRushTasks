package com.javarush.task.jdk13.task41.task4107;

import com.javarush.task.jdk13.task41.task4107.factory.DotNetCourse;
import com.javarush.task.jdk13.task41.task4107.factory.JavaCourse;
import com.javarush.task.jdk13.task41.task4107.factory.KotlinCourse;
import com.javarush.task.jdk13.task41.task4107.factory.ProgrammingCourse;

/*
Кузница кадров
*/

public class Solution {

    private static ProgrammingCourse course;

    public static void main(String[] args) {
        choose("web");
        startLearningProcess();
    }

    static void choose(String direction) {
        if (direction.equals("web")) {
            course = new DotNetCourse();
        } else if (direction.equals("android")) {
            course = new KotlinCourse();
        } else {
            course = new JavaCourse();
        }
    }

    static void startLearningProcess() {
        course.educateStudent();
    }
}
