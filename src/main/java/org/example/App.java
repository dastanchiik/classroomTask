package org.example;

import org.example.models.President;
import org.example.repostiory.PresidentImpl;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        PresidentImpl pi = new PresidentImpl();
        System.out.println(pi.getById(5L));
    }
}
