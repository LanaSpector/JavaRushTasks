package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readLine = reader.readLine();
        Path path = Paths.get(readLine);
        if (Files.isDirectory(path)) {
            MyFileVisitor visitor = new MyFileVisitor();
            Files.walkFileTree(path, visitor);
            System.out.println("Всего папок - " + visitor.directoriesCount);
            System.out.println("Всего файлов - " + visitor.filesCount);
            System.out.println("Общий размер - " + visitor.totalSize);

        } else {
            System.out.println(path.toString() + " - не папка");
        }
    }

    public static class MyFileVisitor extends SimpleFileVisitor<Path> {
        int filesCount = 0;
        int directoriesCount = -1;
        long totalSize = 0;

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            if (attrs.isDirectory()) {
                directoriesCount += 1;
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (attrs.isRegularFile()) {
                filesCount += 1;
                totalSize += attrs.size();
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
