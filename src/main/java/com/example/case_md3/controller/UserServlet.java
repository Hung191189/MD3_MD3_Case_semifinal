package com.example.case_md3.controller;

import com.example.case_md3.model.User;
import com.example.case_md3.service.user.UserService;
import com.example.case_md3.service.user.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "userServlet", urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    UserServiceImpl userService1 = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        try {
        switch (action){
            case "deleteUser":
                    deleteUser(request, response);
                break;
            case "restoreUser":
                restoreUser(request, response);
                break;
            case "updateUser":
                showUpdateUser(request, response);
                break;
            case "createUser":
                showCreateUser(request, response);
                break;
            case "viewUser":
                showUser(request, response);
                break;
//            case "findByName":
//                showFindByName(request, response);
//                break;
            default:
                showListUser(request, response);
                break;
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        request.getRequestDispatcher("user/listUser.jsp").forward(request, response);

    }

//    private void showFindByName(HttpServletRequest request, HttpServletResponse response) {
//        String name = request.getParameter("name");
//        List<User> userList = userService.findByName(name);
//        RequestDispatcher dispatcher;
//        if(userList == null){
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        }else {
//            request.setAttribute("user", userList);
//            dispatcher = request.getRequestDispatcher("user/listUser.jsp");
//        }
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    private void restoreUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService1.restore(id);
        List<User> userList = new ArrayList<>();
        userList = userService.findAll();
        request.setAttribute("user", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/listUser.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.findById(id);
        RequestDispatcher dispatcher;
        if(user == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("user/viewUser.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateUser(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/createUser.jsp");
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
        User user = userService.findById(id);
        RequestDispatcher dispatcher;
        if(user == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("user/updateUser.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.delete(id);
        List<User> userList;
        userList = userService.findAll();
        request.setAttribute("user", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/listUser.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userService.findAll();
        request.setAttribute("user", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/listUser.jsp");
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
            case "createUser":
                saveUser(request, response);
                break;
            case "updateUser":
                updateUser(request, response);
                break;
            case "findByName":
                findByName(request, response);
                break;
            default:

        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) {
        String a = request.getParameter("nameSearch");
        List<User> userList = userService.findByName(a);
        request.setAttribute("userByName", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/viewFindBN.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        int status = Integer.parseInt(request.getParameter("status"));
        User user = new User(id, name, age, email, address, password, status);
        userService.update(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/updateUser.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String password = req.getParameter("password");
        int status = Integer.parseInt(req.getParameter("status"));
        userService.create(new User(name, age, email, address, password, status));
        resp.sendRedirect("/UserServlet");
    }

}