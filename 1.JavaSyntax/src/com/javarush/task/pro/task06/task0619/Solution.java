package com.javarush.task.pro.task06.task0619;

/* 
Замок чернобайта
*/

public class Solution {
    public static String[] deadMen = {"мертвец_1", "мертвец_2", "мертвец_3", "мертвец_4", "мертвец_5",
                                      "мертвец_6", "мертвец_7", "мертвец_8", "мертвец_9", "мертвец_10"};

    public static void main(String[] args) {
       for(int i = 0; i<deadMen.length;i++) {
       System.out.println(destroyDeadMan(deadMen[i]));
       }
    }

    public static String destroyDeadMan(String deadMen) {
        return deadMen+" был уничтожен";
    }
}
