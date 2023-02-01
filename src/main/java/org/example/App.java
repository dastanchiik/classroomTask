package org.example;

import org.example.models.President;
import org.example.repostiory.PresidentImpl;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        President pr = new President("Neil", 54);
        President pr1 = new President("Nolly", 65);
        President pr2 = new President("Cale", 45);
        President pr3 = new President("Bink", 54);
        President pr4 = new President("Nicol", 44);
        PresidentImpl pi = new PresidentImpl();
        System.out.println(pi.getById(5L));
    }
}
