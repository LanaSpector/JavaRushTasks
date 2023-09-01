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
            } else if (args[2].equalsIgnoreCase("ж")) {
                Date date = input.parse(args[3]);
                person = Person.createFemale(args[1], date);
            }
            if (args[5].equalsIgnoreCase("м")) {
                Date date2 = input.parse(args[6]);
                person2 = Person.createMale(args[4], date2);
            } else if (args[5].equalsIgnoreCase("ж")) {
                Date date2 = input.parse(args[6]);
                person2 = Person.createFemale(args[4], date2);
            }
            allPeople.add(person);
            allPeople.add(person2);
            System.out.println(allPeople.lastIndexOf(person));
            System.out.println(allPeople.lastIndexOf(person2));
        } else if (args[0].equals("-u")) {
            int id = Integer.parseInt(args[1]);
            if (id >= 0 && id < allPeople.size()) {
                person = allPeople.get(id);
                person.setName(args[2]);
                if (args[3].equalsIgnoreCase("м")) {
                    person.setSex(Sex.MALE);
                } else if (args[3].equalsIgnoreCase("ж")) {
                    person.setSex(Sex.FEMALE);
                }
                person.setBirthDate(input.parse(args[4]));
            }
            int id2 = Integer.parseInt(args[5]);
            if (id2 >= 0 && id2 < allPeople.size()) {
                person2 = allPeople.get(id2);
                person2.setName(args[6]);
                if (args[7].equalsIgnoreCase("м")) {
                    person2.setSex(Sex.MALE);
                } else if (args[7].equalsIgnoreCase("ж")) {
                    person2.setSex(Sex.FEMALE);
                }
                person2.setBirthDate(input.parse(args[8]));
            }
        } else if (args[0].equals("-d")) {
            for (int i = 1; i < allPeople.size(); i+=4) {
                int id = Integer.parseInt(args[1]);
                if(id>=0 && id< allPeople.size()) {
                    person = allPeople.get(id);
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDate(null);
                }

            }
//            System.out.println(person);
        } else if (args[0].equals("-i")) {
            int id = Integer.parseInt(args[1]);
            if(id >= 0 && id < allPeople.size()) {
                person = allPeople.get(id);
                String sex = null;
                if(person.getSex() == Sex.MALE) {
                    sex = "м";
                } else if (person.getSex() == Sex.FEMALE) {
                    sex = "ж";
                }
                String date = output.format(person.getBirthDate());
                System.out.println(person.getName()+" "+sex+" "+date);
            }
        }
    }
}
