package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(sort(new Integer[]{13, 8, 15, 5, 17})));

    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        int mediana = 0;
        if (array.length % 2 == 0) {
            mediana = (array[array.length / 2] + array[(array.length / 2) - 1]) / 2;
        } else {
            mediana = array[array.length / 2];
        }
        int finalMediana = mediana;
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(finalMediana - o1) - Math.abs(finalMediana - o2);
            }
        };
        Arrays.sort(array, comp);

        return array;
    }
}
