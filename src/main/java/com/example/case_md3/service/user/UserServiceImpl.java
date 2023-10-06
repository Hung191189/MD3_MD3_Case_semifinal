package com.example.case_md3.service.user;

import com.example.case_md3.model.User;
import com.example.case_md3.service.user.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    protected Connection getConnection() {
        Connection connection = null;
        try {
            java.lang.Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/casemd3?useSSL=false", "root", "123456");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idUser");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String password = rs.getString("password");
                int status = rs.getInt("status");
                userList.add(new User(id, name, age, email, address, password, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void create(User user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into user(name, age, email, address, password, status) values (?, ?, ?, ?, ?, ?)");) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setInt(6, user.getStatus());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }

    }

    @Override
    public boolean update(User user) throws SQLException {
        boolean rowUpdate;
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("update user set name= ?, age =?, email=?, address=?, password=?, status=? where idUser = ?");

            statement.setString(1, user.getName());
            statement.setInt(2, user.getAge());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getPassword());
            statement.setInt(7, user.getIdUser());
            statement.setInt(6, user.getStatus());

            rowUpdate = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdate;
    }


    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDelete;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update user set status=0 where idUser = ?;");
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDelete;

    }

    public boolean restore(int id) throws SQLException {
        boolean rowDelete;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update user set status=1 where idUser = ?;");
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDelete;

    }

    @Override
    public List<User> findByName(String a) {
        List<User> userList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user ");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                String name = rs.getString("name");
                if (name.contains(a)){
                    int age = rs.getInt("age");
                    String email = rs.getString("email");
                    String address = rs.getString("address");
                    String password = rs.getString("password");
                    int status = rs.getInt("status");
                    userList.add(new User(name, age, email, address, password, status));
                }

            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }



    @Override
    public User findById(int id) {
        User user = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where idUser =?");
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int status = rs.getInt("status");
                user = new User(id, name, age, email, address, status);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return user;

    }
}
