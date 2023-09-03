package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] arrayCount = new int[256];
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream stream = new FileInputStream(reader.readLine())) {
            while (stream.available() > 0) {
                arrayCount[stream.read()]++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arrayCount.length; i++) {
            if (arrayCount[i] > 0 && arrayCount[i] < min) {
                min = arrayCount[i];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arrayCount.length; i++) {
            if (arrayCount[i] == min) {
                list.add(i);
            }
        }
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
