package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        while (fileReader.ready()) {
            String[] split = fileReader.readLine().split("\\W");
            for (String string : split) {
                if(string.equals("world")) {
                    count++;
                }
            }
        }
        System.out.println(count);
        fileReader.close();
        reader.close();
    }
}
