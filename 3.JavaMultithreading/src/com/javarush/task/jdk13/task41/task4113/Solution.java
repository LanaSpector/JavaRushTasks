package com.javarush.task.jdk13.task41.task4113;

import org.apache.commons.collections4.iterators.ArrayIterator;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

/* 
Тотальная итерация
*/

public class Solution {

    public static void main(String[] args) {
        getIterators().stream()
                .map(i -> i.getClass().getCanonicalName())
//                .sorted()
                .forEach(System.out::println);
    }

    public static List<Iterator<?>> getIterators() {
        List<Iterator<?>> list = new ArrayList<>();
        list.add(new ArrayList<>(List.of()).iterator());
        list.add(new LinkedList<>(List.of()).iterator());
        list.add(new Vector<>(List.of()).iterator());

        list.add(new PriorityQueue<>(List.of()).iterator());
        list.add(new ArrayDeque<>(List.of()).iterator());

        list.add(new TreeSet<>(List.of()).iterator());
        list.add(new HashSet<>(List.of()).iterator());
        list.add(new LinkedHashSet<>(List.of()).iterator());

        list.add(new HashMap<>(Map.of()).keySet().iterator());
        list.add(new HashMap<>(Map.of()).values().iterator());
        list.add(new LinkedHashMap<>(Map.of()).keySet().iterator());
        list.add(new LinkedHashMap<>(Map.of()).values().iterator());
        list.add(new TreeMap<>(Map.of()).keySet().iterator());
        list.add(new TreeMap<>(Map.of()).values().iterator());
        return list;
    }
}
