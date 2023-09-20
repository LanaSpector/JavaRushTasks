package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(str1));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(str2))) {
            while (fileReader.ready()) {
                String[] readLine = fileReader.readLine().split(" ");
                for (String s : readLine) {
                    if(s.matches("\\d*")) {
                        fileWriter.write(s+" ");
                    }
                }
            }
        }
        reader.close();
    }
}
