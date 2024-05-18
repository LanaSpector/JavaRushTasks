package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        PersonScannerAdapter adapter = new PersonScannerAdapter(new Scanner(new File("D:\\TheProjects\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1904\\file")));
        Person person = adapter.read();
        System.out.println(person);
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] strings = fileScanner.nextLine().split(" ");
            String year = strings[strings.length - 1];
            String month = strings[strings.length - 2];
            String day = strings[strings.length - 3];
            Date date = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day)).getTime();
            return new Person(strings[1], strings[2], strings[0], date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
