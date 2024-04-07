package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Распаковывание архива");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите путь для распаковки");
            Path path = Paths.get(ConsoleHelper.readString());
            zipFileManager.extractAll(path);

            ConsoleHelper.writeMessage("Архив распакован");

        } catch (WrongZipFileException e) {
            ConsoleHelper.writeMessage("Архива не существует");
        }

    }
}
