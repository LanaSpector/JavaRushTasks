package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    public static void main(String[] args) {
        System.out.println(labels);
    }
    static {
        labels.put(1.3, "Toy");
        labels.put(2.3, "Wax");
        labels.put(3.3, "Hugo");
        labels.put(4.3, "Rap");
        labels.put(5.3, "Nan");
    }
}
