package org.example.repostiory;

import org.example.configuration.Util;
import org.example.models.Country;
import org.example.models.President;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PresidentImpl implements PresidentRepo{
    private static Connection connection;

    public PresidentImpl() throws SQLException {
        connection = new Util().getCon();
    }

    @Override
    public void createTable() throws SQLException {
            String function = """
                create table if not exists president(
                id serial primary key,
                name varchar(255),
                age int
                );
                """;
            Statement statement = connection.createStatement();
            statement.execute(function);
            statement.close();
            System.out.println("created!");
    }

    @Override
    public void save(President president) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into president (name,age) values (?,?)");
        ps.setString(1, president.getName());
        ps.setLong(2,president.getAge());
        ps.execute();
        ps.close();
        System.out.println("saved!");
    }

    @Override
    public List getAll() throws SQLException {
        List<President>presidents = new ArrayList<>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from president ");
        while (rs.next()){
            President c = new President();
            c.setId(rs.getLong("id"));
            c.setName(rs.getString("name"));
            c.setAge(rs.getInt("age"));
            presidents.add(c);
        }
        return presidents;
    }

    @Override
    public President getById(Long id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from president where id =" + id + ";");
        ResultSet rs = ps.executeQuery();
        while (!rs.next()){
            System.out.println("wrong!!!");
        }
        President c = new President();
        c.setId(rs.getLong("id"));
        c.setName(rs.getString("name"));
        c.setAge(rs.getInt("age"));
        return c;
    }
}
