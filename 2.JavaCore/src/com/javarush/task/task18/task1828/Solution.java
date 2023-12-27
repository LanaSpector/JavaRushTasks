package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();

        Map<String, String> map = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String string = reader.readLine();
                String id = string.substring(0, 8).trim();
                String str = string.substring(8);
                if (!map.containsKey(id))
                    map.put(id, str);
            }
        }
        if (args.length != 0) {
            if (args[0].equals("-u")) {
                String id = args[1].trim();
                if (map.containsKey(id)) {
                    String productName = checkLength(args[2], 30);
                    String price = checkLength(args[3], 8);
                    String quantity = checkLength(args[4], 4);
                    map.put(id, productName + price + quantity);
                }

            }
        }

    }

    private static String checkLength(String string, int limit) {
        if (string.length() > limit) {
            return string.substring(0, limit);
        } else {
            StringBuilder builder = new StringBuilder(string);
            while (builder.length() != limit) {
                builder.append(" ");
            }
            return builder.toString();
        }
    }
}
