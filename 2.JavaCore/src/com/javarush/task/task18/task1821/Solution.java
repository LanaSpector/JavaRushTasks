package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try(FileInputStream stream = new FileInputStream(args[0])) {
            Map<Character, Integer> map = new TreeMap<>();
            while (stream.available() > 0) {
                char read = (char) stream.read();
                if (!map.containsKey(read)) {
                    map.put(read, 1);
                } else {
                    map.put(read, map.get(read) + 1);
                }
            }
            for (Map.Entry<Character, Integer> pair : map.entrySet()) {
                System.out.println(pair.getKey() + " " + pair.getValue());
            }
        }
    }
}
