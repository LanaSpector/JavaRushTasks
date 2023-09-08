package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String readStr = reader.readLine();
            try (FileInputStream stream = new FileInputStream(readStr)) {
            }
            catch(FileNotFoundException e) {
                System.out.println(readStr);
                break;
            }
        }

    }
}
