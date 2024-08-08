package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File sourceDirectory = new File(args[0]);
        File resultFile = new File(args[1]);
        File allFilesContent = new File(resultFile.getParent() + "/allFilesContent.txt");
        if (FileUtils.isExist(allFilesContent)) {
            FileUtils.deleteFile(allFilesContent);
        }
        FileUtils.renameFile(resultFile, allFilesContent);
        List<File> list = new ArrayList<>();
        fillListWithFiles(sourceDirectory, list);
        try (FileOutputStream out = new FileOutputStream(allFilesContent, true)) {
            for (File file : list) {
                if (file.length() <= 50) {
                    byte[] bytes = Files.readAllBytes(file.toPath());
                    out.write(bytes);
                    out.write(System.lineSeparator().getBytes());
                }
            }
        }
    }

    private static void fillListWithFiles(File directory, List<File> list) {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }
        for (File smth : files) {
            if (smth.isDirectory()) {
                fillListWithFiles(smth, list);
            } else {
                list.add(smth);
            }
        }
    }
}
