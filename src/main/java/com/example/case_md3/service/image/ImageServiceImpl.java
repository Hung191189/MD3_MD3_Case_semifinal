package com.example.case_md3.service.image;

import com.example.case_md3.model.Image;
import com.example.case_md3.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImageServiceImpl implements ImageService{
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
    public List<Image> findAll() {
        List<Image> imageList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from image");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idImage");
                String url = rs.getString("url");
                String titleImage = rs.getString("titleImage");
                int idPosts = rs.getInt("idPosts");
                int status = rs.getInt("status");
                imageList.add(new Image(id, url, titleImage, idPosts, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    public void create(Image image) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into image(url, titleImage, idPosts, status) values (?, ?, ?, ?)");) {
            preparedStatement.setString(1, image.getUrl());
            preparedStatement.setString(2, image.getTitleImage());
            preparedStatement.setInt(3, image.getIdPosts());
            preparedStatement.setInt(4, image.getStatus());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(Image image) throws SQLException {
        boolean rowUpdate;
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("update image set url= ?, titleImage =?, idPosts=?, status=? where idImage = ?");

            statement.setString(1, image.getUrl());
            statement.setString(2, image.getTitleImage());
            statement.setInt(3, image.getIdPosts());
            statement.setInt(4, image.getStatus());
            statement.setInt(5, image.getIdImage());
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
            PreparedStatement preparedStatement = connection.prepareStatement("update image set status=0 where idImage = ?;");
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
            PreparedStatement preparedStatement = connection.prepareStatement("update image set status=1 where idImage = ?;");
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDelete;

    }

    @Override
    public List<Image> findByName(String name) {
        return null;
    }

    @Override
    public Image findById(int id) {
        Image image = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from image where idImage =?");
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String url = rs.getString("url");
                String title = rs.getString("titleImage");
                int idPosts = rs.getInt("idPosts");
                int status = rs.getInt("status");
                image = new Image(id, url, title, idPosts, status);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return image;
    }
}
