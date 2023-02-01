package org.example.repostiory;

import org.example.configuration.Util;
import org.example.models.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityImpl implements CityRepo {
    private static Connection connection;

    public CityImpl() throws SQLException {
        connection = new Util().getCon();
    }

    @Override
    public void createTable() throws SQLException {
        String function = """
                create table if not exists city(
                id serial primary key,
                name varchar(255)
                )
                """;
        Statement statement = connection.createStatement();
        statement.execute(function);
        statement.close();
        System.out.println("created!");
    }

    @Override
    public void save(City city) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into city (name) values (?)");
        ps.setString(1, city.getName());
        ps.execute();
        ps.close();
        System.out.println("saved!");
    }

    @Override
    public List getAll() throws SQLException {
        List<City> cities = new ArrayList<>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from city ");
        while (rs.next()) {
            City c = new City();
            c.setId(rs.getLong("id"));
            c.setName(rs.getString("name"));
            cities.add(c);
        }
        return cities;
    }

    @Override
    public City getById(Long id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from city where id =" + id + ";");
        ResultSet rs = ps.executeQuery();
        while (!rs.next()) {
            System.out.println("wrong!!!");
        }
        City c = new City();
        c.setId(rs.getLong("id"));
        c.setName(rs.getString("name"));
        return c;
    }

}
