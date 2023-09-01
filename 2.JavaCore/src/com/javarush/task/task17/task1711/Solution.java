package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat input = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat output = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person person = null;
        Person person2 = null;
        if (args[0].equals("-c")) {
            if (args[2].equalsIgnoreCase("м")) {
                Date date = input.parse(args[3]);
                person = Person.createMale(args[1], date);
            } else if (args[2].equals("ж")) {
                Date date = input.parse(args[3]);
                person = Person.createFemale(args[1], date);
            }
            if (args[5].equals("м")) {
                Date date2 = input.parse(args[6]);
                person2 = Person.createMale(args[4], date2);
            } else if (args[5].equals("ж")) {
                Date date2 = input.parse(args[6]);
                person2 = Person.createFemale(args[4], date2);
            }
            allPeople.add(person);
            allPeople.add(person2);
            System.out.println(allPeople.lastIndexOf(person));
            System.out.println(allPeople.lastIndexOf(person2));
        } else if (args[0].equals("-u")) {


        }
    }
}
