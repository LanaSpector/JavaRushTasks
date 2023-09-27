package com.javarush.task.task19.task1925;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer string = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             FileWriter writer = new FileWriter(args[1])) {
            while (reader.ready()) {
                String[] strings = reader.readLine().split(" ");
                for (String line : strings) {
                    if (line.length() > 6) {
                        string.append(line).append(" ");
                    }
                }
            }
            String str = string.toString().trim().replaceAll(" ", ",");
            writer.write(str);
        }

    }
}
