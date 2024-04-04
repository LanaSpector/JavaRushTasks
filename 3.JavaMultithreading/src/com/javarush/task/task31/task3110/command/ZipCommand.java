package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command {
    public ZipFileManager getZipFileManager() throws Exception {
        ConsoleHelper.writeMessage("Пожалуйста, введите полный путь файла архива");
        String archiveFilePath = ConsoleHelper.readString();
        Path pathToArchiveFile = Paths.get(archiveFilePath);
        return new ZipFileManager(pathToArchiveFile);
    }


}
