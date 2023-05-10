package com.javarush.task.pro.task09.task0920;

/* 
Абордаж
*/

import java.util.Arrays;

public class NimrodAi {

    public static String[] diningRoom = {
            "button for emergency meeting",
            "table", "table", "table", "table", "table",
            "bench", "bench", "bench", "bench", "bench", "bench", "bench", "bench", "bench", "bench",
            "bench", "bench", "bench", "bench", "bench", "bench", "bench", "bench", "bench", "bench"};
    public static String[] o2 = {"plant", "plant"};
    public static String[] medRoom = {"bed", "bed", "bed", "bed", "SCAN-MO-TRON-2000", "liquid analyser"};
    public static String[] armoury = {"cannon launcher", "chair"};
    public static String[] securityRoom = {"rack", "rack", "table"};
    public static String[] reactor = {"reactor"};
    public static String[] telecom = {"computer", "computer", "computer", "table", "chair"};
    public static String[] warehouse = {
            "container", "container", "container",
            "box", "box", "box", "box", "box", "box",
            "barrel", "barrel", "barrel", "barrel"};
    public static String[] controlRoom = {"interactive ship map", "chair", "chair", "chair"};
    public static String[] powerRoom = {"power lamp", "power lamp", "power lamp", "power lamp", "power lamp", "power lamp", "power lamp"};

    public static void main(String[] args) {
        String[] nameRoom = {"diningRoom", "o2", "medRoom", "armoury", "securityRoom", "reactor", "telecom", "warehouse", "controlRoom", "powerRoom"};
        for (String room : nameRoom) {
            if (checkPirates(room)) {
                openFloodgates(room);
            }

        }

    }

    public static boolean checkPirates(String roomName) {
        String[] room = getRoomByName(roomName);
        if (room == null) {
            return false;
        }

        String[] scanResult = RoomScanner.scanRoom(roomName);
        System.out.printf("В %s обнаружено: %s\n", roomName, Arrays.toString(scanResult));

        if(room.length< scanResult.length) {
            return  true;
        }
        Arrays.sort(room);
        for (String item : scanResult) {
            if (Arrays.binarySearch(room, item) < 0) {
                return true;
            }
        }
        return false;
    }

    public static void openFloodgates(String roomName) {
        System.out.printf("ВНИМАНИЕ, открытие шлюзов в %s\n\n", roomName);
        Arrays.fill(getRoomByName(roomName), null);
    }

    public static String[] getRoomByName(String roomName) {
        if("diningRoom".equals(roomName)) {
            return diningRoom;
        }
        else if("o2".equals(roomName)) {
            return o2;
        } else if ("medRoom".equals(roomName)) {
            return medRoom;
        } else if ("armoury".equals(roomName)) {
            return armoury;
        } else if ("securityRoom".equals(roomName)) {
        return securityRoom;
        } else if ("reactor".equals(roomName)) {
            return reactor;
        } else if ("telecom".equals(roomName)) {
            return telecom;
        } else if ("warehouse".equals(roomName)) {
            return warehouse;
        } else if ("controlRoom".equals(roomName)) {
            return controlRoom;
        } else if ("powerRoom".equals(roomName)) {
            return powerRoom;
        }
        return null;
    }
}
