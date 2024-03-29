package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            int max = Integer.MIN_VALUE;
            while (reader.ready()) {
                String readLine = reader.readLine();
                int id = Integer.parseInt(readLine.substring(0, 8).trim());
                if (id > max) {
                    max = id;
                }
            }
            if (args.length != 0) {
                if (args[0].equals("-c")) {
                    String index = checkLength(String.valueOf(max + 1), 8);
                    String productName = checkLength(args[1], 30);
                    String price = checkLength(args[2], 8);
                    String quantity = checkLength(args[3], 4);
                    writer.newLine();
                    writer.write(index + productName + price + quantity);
                }
            }
        }
    }

    private static String checkLength(String string, int limit) {
        if (string.length() > limit) {
            return string.substring(0, limit);
        } else {
//            return string + " ".repeat(limit - string.length());
            StringBuilder builder = new StringBuilder(string);
            while (builder.length() != limit) {
                builder.append(" ");
            }
            return builder.toString();
        }
    }
}
