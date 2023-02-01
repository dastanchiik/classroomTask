package org.example.repostiory;

import org.example.models.President;

import java.sql.SQLException;
import java.util.List;

public interface PresidentRepo {
    void createTable() throws SQLException;

    void save(President president) throws SQLException;

    List getAll() throws SQLException;

    President getById(Long id) throws SQLException;
}
