package com.javarush.task.pro.task05.task0527;
import java.util.Arrays;
/* 
Подготовка Кибердракона
*/

public class Solution {
    public static int[][] array = new int[5][];

    public static void main(String[] args) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new int [2*i+1]; // создание одномерного массива
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = i+j; // заполнение одномерного массива числами
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
