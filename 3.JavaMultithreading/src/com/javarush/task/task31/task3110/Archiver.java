package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите полный путь к архиву с клавиатуры");
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(fileName));
        System.out.println("Введите путь к файлу для архивации");
        String archive = console.readLine();
        zipFileManager.createZip(Paths.get(archive));
        ExitCommand exitCommand = new ExitCommand();
        exitCommand.execute();
    }
}
