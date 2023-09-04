package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] byteStream = new int[256];
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream stream = new FileInputStream(reader.readLine())) {
            Set<Integer> set = new TreeSet<>();
            while (stream.available() > 0) {
                    set.add(stream.read());
            }
            for (Integer integer : set) {
                System.out.print(integer + " ");
            }
        }
    }
}
