package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Solution solution = (Solution) super.clone();
        Map<String, User> clonedMap = new LinkedHashMap<>();
        for (String keyUser : users.keySet()) {
            User user = users.get(keyUser);
            clonedMap.put(keyUser, (User) user.clone());
        }
        solution.users = clonedMap;
        return solution;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }


    }

    protected Map<String, User> users = new LinkedHashMap<>();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return (User) super.clone();
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            User user = (User) object;
            return age == user.age && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }
    }
}
