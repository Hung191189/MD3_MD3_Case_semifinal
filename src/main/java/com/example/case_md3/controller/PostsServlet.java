package com.example.case_md3.controller;

import com.example.case_md3.model.Posts;
import com.example.case_md3.model.User;
import com.example.case_md3.service.posts.PostsService;
import com.example.case_md3.service.posts.PostsServiceImpl;
import com.example.case_md3.service.user.UserService;
import com.example.case_md3.service.user.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "postsServlet", value = "/PostsServlet")
public class PostsServlet extends HttpServlet {
    PostsService postsService = new PostsServiceImpl();
    PostsServiceImpl postsService1 = new PostsServiceImpl();
    UserService userService = new UserServiceImpl();
    Date date = new Date();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createPosts":
                    showCreatPosts(request, response);
                    break;
                case "deletePosts":
                    deletePosts(request, response);
                    break;
                case "restorePosts":
                    restorePosts(request, response);
                    break;
                case "updatePosts":
                    showUpdatePost(request, response);
                    break;
                default:
                    showListPosts(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    private void showUpdatePost(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Posts posts = postsService.findById(id);
        RequestDispatcher dispatcher;
        if(posts == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("posts", posts);
            dispatcher = request.getRequestDispatcher("posts/updatePosts.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void restorePosts(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        postsService1.restore(id);
        List<Posts> postsList;
        postsList = postsService.findAll();
        List<User> userList = findAllUser(postsList);
        request.setAttribute("postsList", postsList);
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("posts/listPosts.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deletePosts(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        postsService.delete(id);
        List<Posts> postsList;
        postsList = postsService.findAll();
        List<User> userList = findAllUser(postsList);
        request.setAttribute("postsList", postsList);
        request.setAttribute("userList", userList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("posts/listPosts.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreatPosts(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("posts/createPosts.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void showListPosts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Posts> postsList = postsService.findAll();
        List<User> userList = findAllUser(postsList);
        request.setAttribute("postsList", postsList);
        request.setAttribute("userList", userList);
//        request.getRequestDispatcher("posts/listPosts.jsp").forward(request, response);
        request.getRequestDispatcher("user/homePage.jsp").forward(request, response);
    }

    private List<User> findAllUser(List<Posts> postsList) {
        List<User> list = new ArrayList<>();
        for (Posts posts : postsList) {
            User user = userService.findById(posts.getIdUser());
            list.add(user);
        }
        return list;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null) {
            action = "";
        }
        try {
            switch (action) {
                case "createPosts":
                        savePosts(request, response);
                    break;
                case "updatePosts":
                    updatePost(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("titlePosts");
        String content = request.getParameter("content");
        int status = Integer.parseInt(request.getParameter("status"));
        int idUser = Integer.parseInt(request.getParameter("abc"));
        int idCategory = Integer.parseInt(request.getParameter("idCategory"));
        Posts posts = new Posts(id, title, content, status, idUser, idCategory);
        postsService.update(posts);
        showListPosts(request, response);
    }

    private void savePosts(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String titlePosts = request.getParameter("titlePosts");
        String content = request.getParameter("content");
        int status = Integer.parseInt(request.getParameter("status"));
        String dateForm = request.getParameter("datePosts");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date datePosts = null;
        try {
            datePosts = dateFormat.parse(dateForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        int idCategory = Integer.parseInt(request.getParameter("idCategory"));
        postsService.create(new Posts(titlePosts, content, status, idUser, idCategory));
        response.sendRedirect("/PostsServlet");
    }
}