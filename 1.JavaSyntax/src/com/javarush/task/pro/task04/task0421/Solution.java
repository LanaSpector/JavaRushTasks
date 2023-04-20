package com.javarush.task.pro.task04.task0421;

/* 
Охлаждение ядра планеты
*/

public class Solution {
    public static void main(String[] args) {
        int num = 1;
        int sum =0;
        while(num<=100) {
            if(num%2==0) {
                sum+=num;
            }
            num++;
        }
        System.out.print(sum);
    }
}