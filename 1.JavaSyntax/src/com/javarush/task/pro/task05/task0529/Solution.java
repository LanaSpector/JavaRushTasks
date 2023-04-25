package com.javarush.task.pro.task05.task0529;

import java.util.Arrays;

/* 
Галаксианские роботанки (1)
*/

public class Solution {
    public static String robotank = "☖";
    public static String empty = "_";
    public static String hit = "🎯";
    public static int width = 30;
    public static int height = 10;
    public static int[][] bombs = new int[height][width];
    public static String[][] field = new String[height][width];


    public static void main(String[] args) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (j == 0) {
                    field[i][j] = robotank;
                    System.out.print(field[i][j]);
                } else {
                    field[i][j] = empty;
                    System.out.print(field[i][j]);
                }
            }
            System.out.println();
        }
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs[i].length; j++) {
                if (j < 10) {
                    bombs[i][j] = 1;
                    System.out.print(bombs[i][j]);
                } else {
                    bombs[i][j] = 0;
                    System.out.print(bombs[i][j]);
                }
            }
            System.out.println();
        }
    }
}
