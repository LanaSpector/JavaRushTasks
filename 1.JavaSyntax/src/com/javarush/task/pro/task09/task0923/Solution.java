package com.javarush.task.pro.task09.task0923;

/* 
Ранг доступа — Пиратский Капитан
*/

import static com.javarush.task.pro.task09.task0923.CaptainBridge.checkAccess;

public class Solution {
    public static void main(String[] args) {
        String[] crew = {"Раб", "Гость", "Боец", "Ветеран", "Картографист", "Капитан", "Стив"};
        for(int i=0; i<crew.length; i++) {
            if(CaptainBridge.debugAccess(crew[i])) {
                checkAccess(crew[i]);
                break;
            }
        }
        
    }
}
