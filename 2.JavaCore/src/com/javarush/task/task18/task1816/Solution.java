package com.javarush.task.task18.task1816;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        try (FileReader reader = new FileReader(args[0])) {
            while (reader.ready()) {
                int read = reader.read();
                if(read>= 65 && read<=122 && Character.isAlphabetic(read)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
