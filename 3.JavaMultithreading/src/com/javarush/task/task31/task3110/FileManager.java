package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private List<Path> fileList;
    private Path rootPath;

    public FileManager(Path rootPath) throws IOException {
        this.fileList = new ArrayList<>();
        this.rootPath = rootPath;
        collectFileList(rootPath);
    }

    public List<Path> getFileList() {
        return fileList;
    }

    private void collectFileList(Path path) throws IOException {
        if (Files.isRegularFile(path)) {
            Path relativePath = rootPath.relativize(path);
            fileList.add(relativePath);
        }
        if (Files.isDirectory(path)) {
            try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
                for (Path path1 : files) {
                    collectFileList(path1);
                }
            }
        }
    }
}
