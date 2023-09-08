package com.javarush.task.task18.task1817;

import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        try (FileReader reader = new FileReader(args[0])) {
            int countAll = 0;
            int countSpace = 0;
            while (reader.ready()) {
                String symbol = String.valueOf(reader.read());
                if(symbol.equals(" ")) {
                    countSpace++;
                }
                countAll++;
            }
            double sum = (double) (countAll/countSpace)*100;
            System.out.printf("%.2f", sum);
        }
    }
}
