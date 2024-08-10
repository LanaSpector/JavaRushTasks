package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File resultFileName = new File(args[0]);
        if (!resultFileName.exists()) {
            resultFileName.createNewFile();
        }
        List<String> fileNames = new ArrayList<>(Arrays.asList(args).subList(1, args.length));
        fileNames.sort(Comparator.naturalOrder());
        List<FileInputStream> fis = new ArrayList<>();
        for (String fileName : fileNames) {
            fis.add(new FileInputStream(fileName));
        }
        Enumeration<FileInputStream> enumeration = Collections.enumeration(fis);

        try (SequenceInputStream sequenceInputStream = new SequenceInputStream(enumeration);
             ZipInputStream zis = new ZipInputStream(sequenceInputStream);
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(resultFileName, true))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
//                byte[] buffer = new byte[1024];
//                for (int length; (length = zis.read(buffer, 0, buffer.length)) > -1; ) {
//                    out.write(buffer, 0, length);
//                }
                out.write(zis.readAllBytes());
            }
        }
    }
}
