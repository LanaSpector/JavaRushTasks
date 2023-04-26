package com.javarush.task.pro.task05.task0519;

import java.util.Arrays;

/* 
Есть ли кто?
*/

public class Solution {

    public static int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    public static int element = 50;

    public static void main(String[] args) {
        int [] array2 = Arrays.copyOf(array, array.length);
        Arrays.sort(array2);
        int c = Arrays.binarySearch(array2, element);
        System.out.print(c>=0? true:false);

    }
}
