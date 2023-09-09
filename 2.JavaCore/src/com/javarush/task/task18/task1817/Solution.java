package com.javarush.task.task18.task1817;

import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileReader reader = new FileReader(args[0])) {
            int countAll = 0;
            int countSpace = 0;
            while (reader.ready()) {
                String symbol = String.valueOf((char) reader.read());
//                char symbol = (char)reader.read();
//                if (Character.isSpaceChar(symbol)) {
                if(symbol.equals(" ")) {
                    countSpace++;
                }
                countAll++;
            }
            if (countAll != 0) {
                double sum = (double) countSpace / countAll * 100;
                System.out.printf("%.2f", sum);
            }
        }
    }
}
