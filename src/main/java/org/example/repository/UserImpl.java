package org.example.repository;

import org.example.configuration.Util;
import org.example.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements UserRepo {
    private final Connection connection;

    public UserImpl() throws SQLException {
        connection = new Util().getConnection();
    }

    @Override
    public void createTable() throws SQLException {
        String function = """
                create table if not exists users(
                id serial primary key,
                name varchar ,
                age integer
                );
                """;
        Statement st = connection.createStatement();
        st.execute(function);
        st.close();
        System.out.println("created");
    }

    @Override
    public void save(User user) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into users (name,age) values (?,?)");
        ps.setString(1, user.getName());
        ps.setInt(2, user.getAge());
        ps.execute();
        System.out.println("saved!");
        ps.close();
    }

    @Override
    public User getById(Long id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from users where id =" + id + ";");
        ResultSet rs = ps.executeQuery();
        while (!rs.next()) {
            System.out.println("wrong!");
        }
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setAge(rs.getInt("age"));
        return user;
    }

    @Override
    public List getAll() throws SQLException {
        List<User> list = new ArrayList<>();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from users");
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            list.add(user);
        }
        return list;
    }

    @Override
    public void deleteById(Long id) throws SQLException {
     PreparedStatement ps = connection.prepareStatement("delete from users where id ="+id+";");
     ps.executeUpdate();
        System.out.println("deleted it's id: "+id);
    }

    @Override
    public void deleteAll() throws SQLException {
    Statement st = connection.createStatement();
    st.executeUpdate("truncate table users");
        System.out.println("deleted all !!!");
    }
}
