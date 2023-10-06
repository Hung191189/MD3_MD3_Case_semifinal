package com.example.case_md3.service.comment;

import com.example.case_md3.model.Comment;
import com.example.case_md3.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentServiceImpl implements CommentService{
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
    public List<Comment> findAll() {
        List<Comment> commentList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from comment");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idComment = rs.getInt("idComment");
                String content = rs.getString("content");
                int idUser = rs.getInt("idUser");
                int idPosts = rs.getInt("idPosts");
                int status = rs.getInt("status");
                commentList.add(new Comment(idComment, content, idUser, idPosts, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentList;
    }

    @Override
    public void create(Comment comment) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into comment(content, idUser, idPosts, status) values (?, ?, ?, ?)")) {
            preparedStatement.setString(1, comment.getContent());
            preparedStatement.setInt(2, comment.getIdUser());
            preparedStatement.setInt(3, comment.getIdPosts());
            preparedStatement.setInt(4, comment.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }

    }

    @Override
    public boolean update(Comment comment) throws SQLException {
        boolean rowUpdate;
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("update comment set content= ? where idComment = ?");
            statement.setString(1, comment.getContent());
            statement.setInt(2, comment.getIdComment());
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
            PreparedStatement preparedStatement = connection.prepareStatement("update comment set status=0 where idComment = ?;");
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
            PreparedStatement preparedStatement = connection.prepareStatement("update comment set status=1 where idComment = ?;");
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDelete;

    }
    @Override
    public List<Comment> findByName(String name) {
        return null;
    }

    @Override
    public Comment findById(int id) {
        Comment comment = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from comment where idComment =?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String content = rs.getString("content");
                int idUser = rs.getInt("idUser");
                int idPosts = rs.getInt("idPosts");
                int status = rs.getInt("status");
                comment = new Comment (id, content, idUser, idPosts, status);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return comment;

    }
}
