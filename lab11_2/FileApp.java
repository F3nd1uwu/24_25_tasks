package org.knit.lab11_2;

import java.util.Scanner;

public class FileApp {

    public static void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу или папке: ");
        String path = scanner.nextLine();

        FileProcessor processor = new FileProcessor();
        processor.processFiles(path);
    }
}
