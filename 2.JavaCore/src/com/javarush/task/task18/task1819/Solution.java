package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (FileInputStream streamInput1 = new FileInputStream(str1);
             FileInputStream streamInput2 = new FileInputStream(str2)) {
            while (streamInput2.available() > 0) {
                byteArrayOutputStream.write(streamInput2.read());
            }
            while (streamInput1.available() > 0) {
                byteArrayOutputStream.write(streamInput1.read());
            }
        }
        try (FileOutputStream stream = new FileOutputStream(str1)) {
            byteArrayOutputStream.writeTo(stream);
        }
    }
}
