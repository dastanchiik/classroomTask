package org.example.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static Connection con;

    public Util() throws SQLException {
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                ",sql.111217S");
    }

    public Connection getCon() {
        return con;
    }
}
