package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetAndNumbers = alphabet.toLowerCase() + alphabet + "0123456789";
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(alphabetAndNumbers.length());
            char charAt = alphabetAndNumbers.charAt(index);
            builder.append(charAt);
        }
        String string = builder.toString();
        if (!string.matches(".+\\d.+") ||
                !string.matches(".+[A-Z].+") ||
                !string.matches(".+[a-z].+")) {
            return getPassword();
        }
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            outputStream.write(string.getBytes());
            return outputStream;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
