package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Stream<Path> walk = null;
        return Files.walk(Paths.get(root)).filter(Files::isRegularFile)
                .map(Path::toAbsolutePath).map(Path::toString).collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Solution.getFileTree("C:\\Users\\С\\Desktop\\Notes from Sibelius"));

    }
}
