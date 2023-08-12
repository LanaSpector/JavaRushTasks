package com.javarush.task.task15.task1518;

/* 
Статики и котики
*/

public class Solution {
    public static Cat cat;
    
    static{
            Solution.cat = new Cat();
            cat.name = "Burbon";
            System.out.print(cat.name);
        }
    
   public static class Cat {
        public String name;
    }

    public static void main(String[] args) {

    }
}
