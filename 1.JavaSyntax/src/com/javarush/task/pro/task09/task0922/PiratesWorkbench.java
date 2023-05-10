package com.javarush.task.pro.task09.task0922;

/* 
Закосить под пиратов
*/

import java.util.Arrays;

public class PiratesWorkbench {

    public static String[] piratesDB = new String[]{
            "Drax",
            "Yondu Udonta",
            "Maz Kanata",
            "キャプテン・ハーロック",
            "Star-Lord",
            "Christopher Summers",
            "Крысс",
            "Весельчак У",
            "Nebula",
            "Rocket",
            "Han Solo",
            "boba Fett"
    };

    public static void main(String[] args) {
        System.out.println(Arrays.toString(piratesDB));

        corruptDB();
        addTwoNames();

        System.out.println(Arrays.toString(piratesDB));
    }

    public static void corruptDB() {
        int count = 0;
        for (int i = 0; i < piratesDB.length; i++) {
            if (piratesDB[i].contains("b") && count < 2) {
                piratesDB[i] = piratesDB[i].replaceAll("b", "\b");
                count++;
            }
        }
    }

    public static void addTwoNames() {
        String[] tmp = new String[piratesDB.length + 2];
        System.arraycopy(piratesDB, 0,tmp, 0, piratesDB.length);
        tmp[piratesDB.length + 1] = "Одноглазый Диего";
        tmp[piratesDB.length] = "Рыжий Амиго";
        piratesDB = tmp;
    }
}
