package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        int index = url.lastIndexOf("?");
        String newString = url.substring(index + 1);
        String[] strings = newString.split("&");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].contains("=")) {
                int indexNew = strings[i].indexOf("=");
                String subString = strings[i].substring(0, indexNew);
                System.out.print(subString + " ");
            } else {
                System.out.print(strings[i] + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].contains("obj")) {
                int indexNew2 = strings[i].indexOf("=") + 1;
                String substring = strings[i].substring(indexNew2);
                try {
                    double parseDouble = Double.parseDouble(substring);
                    alert(parseDouble);
                } catch (NumberFormatException e) {
                    alert(substring);
                }
            }
        }
    }


    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
