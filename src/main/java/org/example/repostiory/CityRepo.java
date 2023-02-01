package org.example.repostiory;

import org.example.models.City;

import java.sql.SQLException;
import java.util.List;

public interface CityRepo {
    void createTable() throws SQLException;

    void save(City city) throws SQLException;

    List getAll() throws SQLException;

    City getById(Long id) throws SQLException;
}
