package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        String str3 = reader.readLine();
        try (FileOutputStream stream1 = new FileOutputStream(str1);
             FileInputStream stream2 = new FileInputStream(str2);
             FileInputStream stream3 = new FileInputStream(str3)) {
            while (stream2.available() > 0) {
                stream1.write(stream2.read());
            }
            while (stream3.available() > 0) {
                stream1.write(stream3.read());
            }

        }


    }
}
