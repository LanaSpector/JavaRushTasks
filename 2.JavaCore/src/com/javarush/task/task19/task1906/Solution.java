package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        int count = 1;

        FileReader fileReader = new FileReader(str1);
        FileWriter fileWriter = new FileWriter(str2);
        while (fileReader.ready()) {
            int read = fileReader.read();
            if (count % 2 == 0) {
                fileWriter.write(read);
            }
            count++;
        }
        fileReader.close();
        fileWriter.close();
        reader.close();
    }
}
