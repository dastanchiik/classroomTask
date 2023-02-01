package org.example.repostiory;

import org.example.models.City;
import org.example.models.Country;

import java.sql.SQLException;
import java.util.List;

public interface CountryRepo {
    void createTable() throws SQLException;

    void save(Country country) throws SQLException;

    List getAll() throws SQLException;

    Country getById(Long id) throws SQLException;
}
