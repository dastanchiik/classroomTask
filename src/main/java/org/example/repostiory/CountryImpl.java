package org.example.repostiory;

import org.example.configuration.Util;
import org.example.models.City;
import org.example.models.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryImpl implements CountryRepo {
    private static Connection connection;

    public CountryImpl() throws SQLException {
        connection = new Util().getCon();
    }

    @Override
    public void createTable() throws SQLException {
        String function = """
                create table if not exists country(
                id serial primary key,
                name varchar(255),
                population int
                );
                """;
        Statement statement = connection.createStatement();
        statement.execute(function);
        statement.close();
        System.out.println("created!");
    }

    @Override
    public void save(Country country) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into country (name,population) values (?,?)");
        ps.setString(1, country.getName());
        ps.setLong(2, country.getPopulation());
        ps.execute();
        ps.close();
        System.out.println("saved!");
    }

    @Override
    public List getAll() throws SQLException {
        List<Country> countries = new ArrayList<>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from country ");
        while (rs.next()) {
            Country c = new Country();
            c.setId(rs.getLong("id"));
            c.setName(rs.getString("name"));
            c.setPopulation(rs.getLong("population"));
            countries.add(c);
        }
        return countries;
    }

    @Override
    public Country getById(Long id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from country where id =" + id + ";");
        ResultSet rs = ps.executeQuery();
        while (!rs.next()) {
            System.out.println("wrong!!!");
        }
        Country c = new Country();
        c.setId(rs.getLong("id"));
        c.setName(rs.getString("name"));
        c.setPopulation(rs.getLong("population"));
        return c;
    }
}
