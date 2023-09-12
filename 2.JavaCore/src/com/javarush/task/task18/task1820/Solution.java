package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.List;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string1 = reader.readLine();
        String string2 = reader.readLine();
        try (BufferedReader stream1 = new BufferedReader(new FileReader(string1));
             BufferedWriter stream2 = new BufferedWriter(new FileWriter(string2))) {
            while (stream1.ready()) {
                String[] line = stream1.readLine().split(" ");
                for (String s : line) {
                    long round = Math.round(Double.parseDouble(s));
                    stream2.write(String.valueOf(round) + " ");
                }
            }

        }
    }

}
