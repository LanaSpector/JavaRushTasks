package com.javarush.task.jdk13.task35.task3507;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* 
Collections & Generics
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        return new HashSet<>(Arrays.asList(elements));
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException();
        }
        return IntStream.range(0, keys.size()).boxed().collect(Collectors.toMap(keys::get, values::get, (a, b) -> b, HashMap::new));
    }
}

