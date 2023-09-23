package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String[] strings = reader.readLine().split(" ");
                map.merge(strings[0], Double.parseDouble(strings[1]), Double::sum);
            }
        }
        double max = Double.MIN_VALUE;
        for (Double value : map.values()) {
            if (value > max) {
                max = value;
            }
        }
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue().equals(max)) {
                String key = entry.getKey();
                System.out.println(key);
            }
        }
    }

    public static void main2(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<>();
        Files.readAllLines(Paths.get(args[0])).stream().map(str -> str.split(" "))
                .forEach(strings -> map.merge(strings[0], Double.parseDouble(strings[1]), Double::sum));

        map.entrySet().stream()
                .filter(entry -> Objects.equals(entry.getValue(), map.values().stream().max(Comparator.naturalOrder()).get()))
                .forEach(entry -> System.out.println(entry.getKey()));
    }

    public static void main1(String[] args) throws IOException {
        TreeMap<String, Double> map = Files.readAllLines(Paths.get(args[0])).stream()
                .collect(Collectors.toMap(str -> str.split("\\s")[0],
                        str -> Double.parseDouble(str.split("\\s")[1]),
                        Double::sum, TreeMap::new));
        map.entrySet().stream()
                .filter(entry -> Objects.equals(entry.getValue(), map.values().stream().max(Comparator.naturalOrder()).get()))
                .forEach(entry -> System.out.println(entry.getKey()));
    }
}