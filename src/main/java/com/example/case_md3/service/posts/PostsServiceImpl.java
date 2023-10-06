package com.example.case_md3.service.posts;

import com.example.case_md3.model.Posts;
import com.example.case_md3.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostsServiceImpl implements PostsService{
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
    public List<Posts> findAll() {
        List<Posts> postsList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from posts");){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idPosts = rs.getInt("idPosts");
                String titlePosts = rs.getString("titlePosts");
                String content = rs.getString("content");
                int status = rs.getInt("status");
                Date datePosts = rs.getDate("datePosts");
                int idUser = rs.getInt("idUser");
                int idCategory = rs.getInt("idCategory");
                postsList.add(new Posts(idPosts, titlePosts, content, status, datePosts, idUser, idCategory));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postsList;
    }

    @Override
    public void create(Posts posts) throws SQLException {
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into posts(titlePosts, content, status, idUser, idCategory) values (?, ?, ?, ?, ?)");) {
            preparedStatement.setString(1, posts.getTitlePosts());
            preparedStatement.setString(2, posts.getContent());
            preparedStatement.setInt(3, posts.getStatus());
            preparedStatement.setInt(4, posts.getIdUser());
            preparedStatement.setInt(5, posts.getIdCategory());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(Posts posts) throws SQLException {
        boolean rowUpdate;
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("update posts set titlePosts= ?, content =?, status=?, idUser=?, idCategory=? where idPosts = ?");

            statement.setString(1, posts.getTitlePosts());
            statement.setString(2, posts.getContent());
            statement.setInt(3, posts.getStatus());
            statement.setInt(4, posts.getIdUser());
            statement.setInt(5, posts.getIdCategory());
            statement.setInt(6, posts.getIdPosts());
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
            PreparedStatement preparedStatement = connection.prepareStatement("update posts set status=0 where idPosts = ?;");
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
            PreparedStatement preparedStatement = connection.prepareStatement("update posts set status=1 where idPosts = ?;");
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDelete;

    }

    @Override
    public List<Posts> findByName(String name) {
        return null;
    }

    @Override
    public Posts findById(int id) {
        Posts posts = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from posts where idPosts =?");
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String title = rs.getString("titlePosts");
                String content = rs.getString("content");
                int status = rs.getInt("status");
                int idUser = rs.getInt("idUser");
                int idCategory = rs.getInt("idCategory");
                posts = new Posts(title, content, status, idUser, idCategory);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return posts;

    }
}

