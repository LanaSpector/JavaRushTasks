package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String name = line.replaceAll("\\d", "").trim();
                String birth = line.replaceAll("[^\\d\\s]", "").trim();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
                Date birthDate = dateFormat.parse(birth);
                PEOPLE.add(new Person(name, birthDate));
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
