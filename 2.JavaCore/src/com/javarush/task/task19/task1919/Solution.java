package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> salary = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");
                salary.merge(line[0], Double.parseDouble(line[1]), Double::sum);
            }
            salary.forEach((k,v)-> System.out.println(k+" "+v));
        }

    }
}
