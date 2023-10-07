package com.example.case_md3.controller;

import com.example.case_md3.model.Comment;
import com.example.case_md3.model.User;
import com.example.case_md3.service.comment.CommentService;
import com.example.case_md3.service.comment.CommentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CommentServlet", value = "/CommentServlet")
public class CommentServlet extends HttpServlet {
    CommentService commentService = new CommentServiceImpl();
    CommentServiceImpl commentService1 = new CommentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        try {
            switch (action){
                case "deleteComment":
                    deleteComment(request, response);
                    break;
                case "restoreComment":
                    restoreUser(request, response);
                    break;
                case "updateComment":
                    showUpdateUser(request, response);
                    break;
                case "createComment":
                    showCreateUser(request, response);
                    break;
                default:
                    showListComment(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void showListComment(HttpServletRequest request, HttpServletResponse response) {
        List<Comment> commentList = commentService.findAll();
        request.setAttribute("commentList", commentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("comment/listComment.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateUser(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("comment/createComment.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showUpdateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Comment comment = commentService.findById(id);
        RequestDispatcher dispatcher;
        if(comment == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("comment", comment);
            dispatcher = request.getRequestDispatcher("comment/updateComment.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteComment(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        commentService.delete(id);
        List<Comment> commentList;
        commentList = commentService.findAll();
        request.setAttribute("commentList", commentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("comment/listComment.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void restoreUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        commentService1.restore(id);
        List<Comment> commentList;
        commentList = commentService.findAll();
        request.setAttribute("commentList", commentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("comment/listComment.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        try {
            switch (action){
                case "createComment":
                    createComment(request, response);
                    break;
                case "updateComment":
                    updateComment(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateComment(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String content = request.getParameter("content");
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        int idPosts = Integer.parseInt(request.getParameter("idPosts"));
        int status = Integer.parseInt(request.getParameter("status"));
        Comment comment = new Comment(id, content, idUser, idPosts, status);
        commentService.update(comment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("comment/updateComment.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createComment(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String content = request.getParameter("name");
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        int idPosts = Integer.parseInt(request.getParameter("idPosts"));
        int status = Integer.parseInt(request.getParameter("status"));
        commentService.create(new Comment(content, idUser, idPosts, status));
        response.sendRedirect("/CommentServlet");
    }
}