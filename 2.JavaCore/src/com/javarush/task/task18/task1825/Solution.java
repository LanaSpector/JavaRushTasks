package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, String> map = new TreeMap<>();
        while (true) {
            String readLine = reader.readLine();
            if (readLine.equals("end")) {
                break;
            }
            String substring = readLine.substring(readLine.lastIndexOf("t") + 1);
            int index = Integer.parseInt(substring);
            if (!map.containsKey(index)) {
                map.put(index, readLine);
            }
        }
        for (String fullName : map.values()) {
            String shortName = fullName.substring(0, fullName.lastIndexOf("."));
            try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fullName));
                 BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(shortName, true))) {
                while (inputStream.available()>0) {
                    outputStream.write(inputStream.read());
                }
            }
        }
    }
}
