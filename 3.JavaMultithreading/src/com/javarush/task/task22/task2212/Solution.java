package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) {
            return false;
        }
        return telNumber.matches("\\+\\d{12}") || telNumber.matches("\\+\\d{2}\\(\\d{3}\\)\\d{7}") ||
                telNumber.matches("\\(\\d{3}\\)\\d{7}") || telNumber.matches("\\d\\(\\d{3}\\)\\d{6}");
    }

    public static void main(String[] args) {
        checkTelNumber("+380501234567");
        checkTelNumber("+38(050)1234567");
        checkTelNumber("(050)1234567");
        checkTelNumber("0(501)234567 ");
    }
}
