package com.javarush.task.pro.task15.task1506;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Files.readAllLines(Path.of(scanner.nextLine()));
        for (String string : list) {
            char[] chars = string.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '.' || chars[i] == ',' || chars[i] == ' ') {
                    continue;
                }
                System.out.print(chars[i]);
            }
            System.out.println();
        }
    }
}

