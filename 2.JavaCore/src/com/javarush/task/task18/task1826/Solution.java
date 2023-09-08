package com.javarush.task.task18.task1826;

import java.io.*;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int key = 1;
        if (args[0].equals("-e")) {
            try (FileReader reader = new FileReader(args[1]);
                 FileWriter writer = new FileWriter(args[2])) {
                while (reader.ready()) {
                    int encrypted = reader.read() + key;
                    writer.write(encrypted);
                }
            }
        } else if (args[0].equals("-d")) {
            try (FileReader reader = new FileReader(args[1]);
                 FileWriter writer = new FileWriter(args[2])) {
                while (reader.ready()) {
                    int decrypted = reader.read() - key;
                    writer.write(decrypted);
                }
            }
        }
    }
}
