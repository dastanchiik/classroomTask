package org.example.repository;

import org.example.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepo {

    void createTable() throws SQLException;

    void save(User user) throws SQLException;

    User getById(Long id) throws SQLException;

    List getAll() throws SQLException;

    void deleteById(Long id) throws SQLException;

    void deleteAll() throws SQLException;
}
