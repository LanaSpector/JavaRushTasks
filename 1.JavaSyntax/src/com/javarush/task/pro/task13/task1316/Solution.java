package com.javarush.task.pro.task13.task1316;

public class Solution {

    public static void main(String[] args) {
        JavarushQuest[] jrQ = JavarushQuest.values();
        for (JavarushQuest javarushQuest : jrQ) {
            System.out.println(javarushQuest.ordinal());
        }



    }
}
