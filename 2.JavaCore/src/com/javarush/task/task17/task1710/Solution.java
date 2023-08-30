package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if(args == null || args.length == 0) {
            throw  new RuntimeException();
        }
        SimpleDateFormat input = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat output = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Person person = null;
        if (args[0].equals("-c")) {
            if (args[2].equalsIgnoreCase("м")) {
                Date date = input.parse(args[3]);
                person = Person.createMale(args[1], date);
            } else if (args[2].equalsIgnoreCase("ж")) {
                Date date = input.parse(args[3]);
                person = Person.createFemale(args[1], date);
            }
            allPeople.add(person);
            System.out.println(allPeople.lastIndexOf(person));
        } else if (args[0].equals("-r")) {
            int id = Integer.parseInt(args[1]);
            if (id >= 0 && id < allPeople.size()) {
                person = allPeople.get(id);
                String sex = null;
                if (person.getSex() == Sex.MALE) {
                    sex = "м";
                } else if (person.getSex() == Sex.FEMALE) {
                    sex = "ж";
                }
                String date = output.format(person.getBirthDate());
                System.out.println(person.getName() + " " + sex + " " + date);
            }
        } else if (args[0].equals("-u")) {
            int id = Integer.parseInt(args[1]);
            if (id >= 0 && id < allPeople.size()) {
                person = allPeople.get(id);
                person.setName(args[2]);
                if(args[3].equalsIgnoreCase("м")) {
                    person.setSex(Sex.MALE);
                }
                else if(args[3].equalsIgnoreCase("ж")) {
                    person.setSex(Sex.FEMALE);
                }
                person.setBirthDate(input.parse(args[4]));
            }
        } else if (args[0].equals("-d")) {
            int id = Integer.parseInt(args[1]);
            if (id >= 0 && id < allPeople.size()) {
                person = allPeople.get(id);
                person.setName(null);
                person.setSex(null);
                person.setBirthDate(null);
            }
        }
    }
}
