package com.javarush.task.pro.task12.task1224;

/* 
Подключение к системе
*/

import java.util.Arrays;

public class Solution {
    public final static Planet LULG;

    static {
        LULG = new Planet("Лулг");
        LULG.stations = new Planet.OrbitalStation[]{new Planet.OrbitalStation("Большое Орбитальное Кольцо")};
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(getConnection(LULG)));
    }

    public static int[] getConnection(Planet planet) {
        for (int i = 0; i < planet.stations.length; i++) {
            Planet.OrbitalStation orbitalStation = planet.stations[i];
            for (int j = 0; j < orbitalStation.controlSystem.getInterfacesNumber(); j++) {
                if(orbitalStation.controlSystem.connect(j) == Boolean.TRUE) {
                    return new int[] {i, j};
                }

            }
        }

        return null;
    }
}
