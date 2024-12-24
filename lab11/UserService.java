package org.knit.lab11;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserInteface userInteface;

    public UserService(UserInteface userInteface) {
        this.userInteface = userInteface;
    }

    public void registerUser(String name, String email) throws SQLException {
        if (userInteface.emailExists(email)) {
            throw new IllegalArgumentException("Email уже существует.");
        }
        long size = userInteface.findAll().size();
        User user = new User((int) size + 1, name, email);
        userInteface.create(user);
    }

    public void listAllUsers() throws SQLException {
        List<User> users = userInteface.findAll();
        for (int i = 0; i < (long) users.size(); i++) {
            System.out.println("ID: " + users.get(i).getId() + " Name: " + users.get(i).getName() + " Email: " + users.get(i).getEmail());
        }
        userInteface.findAll();
    }

    public void deleteUser(int id) throws SQLException {
        if (userInteface.findById(id) == null) {
            throw new IllegalArgumentException("Пользователь не найден.");
        }
        userInteface.delete(id);
    }

    public void updateUser(int id, String newName, String newEmail) throws SQLException {
        User existingUser = userInteface.findById(id);
        if (existingUser == null) {
            throw new IllegalArgumentException("Пользователь не найден.");
        }

        if (!existingUser.getEmail().equals(newEmail) && userInteface.emailExists(newEmail)) {
            throw new IllegalArgumentException("Email уже существует.");
        }

        existingUser.setName(newName);
        existingUser.setEmail(newEmail);
        userInteface.update(existingUser);
    }
}

