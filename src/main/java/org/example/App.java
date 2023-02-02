package org.example;

import org.example.model.User;
import org.example.repository.UserImpl;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        User user = new User("Dastan",15);
        User user12 = new User("Kubat",9);
        User user2 = new User("Kurmangazy",15);
        UserImpl user1 = new UserImpl();
        user1.deleteById(5L);
    }
}