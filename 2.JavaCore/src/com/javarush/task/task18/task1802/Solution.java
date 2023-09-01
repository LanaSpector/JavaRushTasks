package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream stream = new FileInputStream(reader.readLine());) {
            int mix = 255;
            while (stream.available() > 0) {
                int i = stream.read();
                if (i < mix) {
                    mix = i;
                }
            }
            System.out.println(mix);
        }
    }
}
