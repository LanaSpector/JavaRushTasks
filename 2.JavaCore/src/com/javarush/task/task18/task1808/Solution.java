package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        String str3 = reader.readLine();
        try (FileInputStream stream1 = new FileInputStream(str1);
             FileOutputStream stream2 = new FileOutputStream(str2);
             FileOutputStream stream3 = new FileOutputStream(str3)) {
            int count = 0;
            int available = (stream1.available() + 1) / 2;
            while (stream1.available() > 0) {
                if (count < available) {
                    stream2.write(stream1.read());
                    count++;
                } else {
                    stream3.write(stream1.read());
                }
            }
        }

    }
}
