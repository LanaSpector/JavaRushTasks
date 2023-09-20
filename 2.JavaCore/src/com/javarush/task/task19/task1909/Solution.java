package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(str1));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(str2))) {
            while (fileReader.ready()) {
                String s = fileReader.readLine().replaceAll("\\.", "!");
                fileWriter.write(s);
            }
        }
        reader.close();
    }

}
