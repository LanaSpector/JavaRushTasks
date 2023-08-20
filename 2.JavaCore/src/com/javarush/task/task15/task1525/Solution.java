package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try (BufferedReader reader = new BufferedReader(new FileReader(Statics.FILE_NAME))) {
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
        } catch (IOException e) {

        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
