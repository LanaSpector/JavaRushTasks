package com.javarush.task.jdk13.task43.task4306;

/* 
В поиске ботана
*/

import org.apache.commons.lang3.ObjectUtils;

import org.apache.commons.lang3.ObjectUtils;

public class Solution {

    public static void main(String[] args) {
        Student studentOne = new Student("Joe", 10, 8, 7, 7, 5, 6, 9);
        Student studentTwo = new Student("Jane", 8, 9, 5, 6, 7, 7, 8);

        String result = compareStudentGrades(studentOne, studentTwo);
        System.out.println(result);
    }

    public static String compareStudentGrades(Student studentOne, Student studentTwo) {
        if (studentOne == null || studentTwo == null) {
            return "Make sure there are no null objects";
        }
        int mathScore = ObjectUtils.compare(studentOne.getMathScore(), studentTwo.getMathScore());
        int physicsScore = ObjectUtils.compare(studentOne.getPhysicsScore(), studentTwo.getPhysicsScore());
        int chemistryScore = ObjectUtils.compare(studentOne.getChemistryScore(), studentTwo.getChemistryScore());
        int biologyScore = ObjectUtils.compare(studentOne.getBiologyScore(), studentTwo.getBiologyScore());
        int geographyScore = ObjectUtils.compare(studentOne.getGeographyScore(), studentTwo.getGeographyScore());
        int historyScore = ObjectUtils.compare(studentOne.getHistoryScore(), studentTwo.getHistoryScore());
        int englishScore = ObjectUtils.compare(studentOne.getEnglishScore(), studentTwo.getEnglishScore());

        int totalCount = mathScore + physicsScore + chemistryScore + biologyScore + geographyScore + historyScore + englishScore;
        return totalCount > 0 ? studentOne.getName() + " has a higher grades score" : totalCount < 0 ? studentTwo.getName() + " has a higher grades score" : "Student grades scores are equal";
    }
}


