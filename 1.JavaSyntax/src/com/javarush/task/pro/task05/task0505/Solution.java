package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        if (n > 0) {
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.nextInt();
            }
            if (n % 2 != 0) {
                for (int j = 0; j < array.length; j++) {
                    System.out.println(array[j]);
                }
            } else if (n % 2 == 0) {
                for (int k = array.length-1; k >= 0; k--) {
                    System.out.println(array[k]);
                }
            }


        }
    }
}