package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileReader.readLine())))) {

            List<Integer> list = new ArrayList<>();
            while (reader.ready()) {
                String str = reader.readLine();
                int s = Integer.parseInt(str);
                if (s % 2 == 0) {
                    list.add(s);
                }
            }
            Collections.sort(list);
            list.forEach(element -> System.out.println(element));
        }
    }
}
