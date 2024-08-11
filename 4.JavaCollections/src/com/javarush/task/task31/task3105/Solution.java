package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, ByteArrayOutputStream> map = new HashMap<>();
        String zipFile = args[1];
        try (ZipInputStream inputStream = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry;
            while ((entry = inputStream.getNextEntry()) != null) {
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                for (int length; (length = inputStream.read(buffer)) > 0;) {
                    byteArray.write(buffer, 0, length);
                }
                map.put(entry.getName(), byteArray);
            }
        }
        File fileName = new File(args[0]);
        try (ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(zipFile))) {
            outputStream.putNextEntry(new ZipEntry("new/" + fileName.getName()));
            Files.copy(fileName.toPath(), outputStream);
            for (Map.Entry<String, ByteArrayOutputStream> mapEntry : map.entrySet()) {
                if (!mapEntry.getKey().equals("new/" + fileName.getName())) {
                    ZipEntry entry = new ZipEntry(mapEntry.getKey());
                    outputStream.putNextEntry(entry);
                    outputStream.write(mapEntry.getValue().toByteArray());
                    outputStream.closeEntry();
                }
            }
        }
    }
}
