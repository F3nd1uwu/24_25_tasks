package org.knit.lab11_2;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class FileProcessor {
    private static final long MAX_SIZE = 10 * 1024 * 1024; // 10 MB

    public void processFiles(String path) {
        File file = new File(path);

        // Проверяем, является ли путь папкой или файлом
        if (file.exists()) {
            if (file.isDirectory()) {
                // Обрабатываем все файлы в папке
                for (File f : file.listFiles()) {
                    saveIfValid(f);
                }
            } else {
                // Обрабатываем файл, если он не превышает лимит
                saveIfValid(file);
            }
        } else {
            System.out.println("Invalid path.");
        }
    }

    private void saveIfValid(File file) {
        if (file.isFile() && file.length() < MAX_SIZE) {
            try {
                new FileDAO().saveFile(file);
                System.out.println("Saved: " + file.getName());
            } catch (SQLException | IOException e) {
                System.err.println("Error saving file: " + e.getMessage());
            }

        }
    }
}


