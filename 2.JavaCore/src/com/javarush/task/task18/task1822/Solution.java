package com.javarush.task.task18.task1822;

import java.io.*;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(string))) {
            while (bufferedReader.ready()) {
                String readLine = bufferedReader.readLine();
                String[] strings = readLine.split(" ");
                if(strings[0].equals(args[0])) {
                    System.out.println(readLine);
                }
            }
        }
    }
}
