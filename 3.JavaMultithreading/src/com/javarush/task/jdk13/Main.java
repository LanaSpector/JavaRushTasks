package com.javarush.task.jdk13;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String pathString = "D:\\TheProjects\\IdeaProjects\\JavaRushTasks\\3.JavaMultithreading\\src\\com\\javarush\\task\\jdk13\\task41";
        Path path = Path.of(pathString);
        renameFile(path);
        fixContent(path);

    }

    private static void renameFile(Path path) throws IOException {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            for (Path pathEntry : directoryStream) {
                if (Files.isDirectory(pathEntry)) {
                    renameFile(pathEntry);
                } else if (Files.isRegularFile(pathEntry)) {
                    String string = pathEntry.getFileName().toString();
                    if (string.endsWith(".jrtc")) {
                        String replaced = string.replace(".jrtc", ".md");
                        Path parent = pathEntry.getParent();
                        Path newPath = parent.resolve(replaced);
                        Files.move(pathEntry, newPath);
                    }
                }
            }
        }
    }

    private static void fixContent(Path path) throws IOException {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            for (Path pathEntry : directoryStream) {
                if (Files.isDirectory(pathEntry)) {
                    fixContent(pathEntry);
                } else if (Files.isRegularFile(pathEntry)) {
                    String content = Files.readString(pathEntry);
                    if(content.startsWith("taskKey=\"")) {
                        int index = content.indexOf("\"\\n\\n");
                        String substringContent = content.substring(index + 5);
                        Files.writeString(pathEntry, "\n### " + substringContent);
                    }
                }
            }
        }
    }
}
