package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] byteCount = new int[256];
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream stream = new FileInputStream(reader.readLine());) {
            while (stream.available() > 0) {
                byteCount[stream.read()]++;
            }
        }
        int maxCount = byteCount[0];
        for (int i = 0; i < byteCount.length; i++) {
            if (byteCount[i] > maxCount) {
                maxCount = byteCount[i];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < byteCount.length; i++) {
            if (byteCount[i] == maxCount) {
                list.add(i);
            }
        }
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
