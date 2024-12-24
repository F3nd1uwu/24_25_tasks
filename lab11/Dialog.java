package org.knit.lab11;

import java.sql.SQLException;
import java.util.Scanner;

public class Dialog {
    public static void dialog(UserService userService) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Меню: ");
        System.out.println("1) Ввод пользователя");
        System.out.println("2) Изменить пользователя");
        System.out.println("3) Удалить пользователя");
        System.out.println("4) Просмотреть рользователей");
        System.out.println("5) Выход");
        boolean check = true;
        while (check) {
            System.out.println("Выберете действие: ");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case (1):
                    System.out.println("Введите имя пользователя: ");
                    String name = scanner.nextLine();
                    System.out.println("Введите email: ");
                    String email = scanner.nextLine();
                    userService.registerUser(name, email);
                    break;
                case (2):
                    System.out.println("Введите id пользователя: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите новое имя пользователя: ");
                    String newName = scanner.nextLine();
                    System.out.println("Введите новый email: ");
                    String newEmail = scanner.nextLine();
                    userService.updateUser(id, newName, newEmail);
                    break;
                case (3):
                    System.out.println("Введите id пользователя для удаления: ");
                    int idForDelete = scanner.nextInt();
                    scanner.nextLine();
                    userService.deleteUser(idForDelete);
                    break;
                case (4):
                    userService.listAllUsers();
                    break;
                case (5):
                    check = false;
                    break;
            }
        }
    }
}



