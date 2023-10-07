package com.example.case_md3.controller;

import com.example.case_md3.model.Image;
import com.example.case_md3.model.User;
import com.example.case_md3.service.image.ImageService;
import com.example.case_md3.service.image.ImageServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "imageServlet", value = "/ImageServlet")
public class ImageServlet extends HttpServlet {
    ImageService imageService = new ImageServiceImpl();
    ImageServiceImpl imageService1 = new ImageServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
        switch (action) {
            case "deleteImage":
                deleteImage(request, response);
                break;
            case "restoreImage":
                restoreImage(request, response);
                break;
            case "createImage":
                showCreateImage(request, response);
                break;
            case "updateImage":
                showUpdateImage(request, response);
                break;
            default:
                showListImage(request, response);
                break;
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void showUpdateImage(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Image image = imageService.findById(id);
        RequestDispatcher dispatcher;
        if(image == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("image", image);
            dispatcher = request.getRequestDispatcher("image/updateImage.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateImage(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("image/createImage.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void restoreImage(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        imageService1.restore(id);
        List<Image> imageList = new ArrayList<>();
        imageList = imageService.findAll();
        request.setAttribute("image", imageList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("image/listImage.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteImage(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        imageService.delete(id);
        List<Image> imageList;
        imageList = imageService.findAll();
        request.setAttribute("image", imageList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("image/listImage.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showListImage(HttpServletRequest request, HttpServletResponse response) {
        List<Image> imageList = imageService.findAll();
        request.setAttribute("image", imageList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("image/listImage.jsp");
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
        if (action==null) {
            action = "";
        }
        try {
            switch (action) {
                case "createImage":
                    saveImage(request, response);
                    break;
                case "updateImage":
                    updateImage(request, response);
                    break;
                default:
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateImage(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String url = request.getParameter("url");
        String titleImage = request.getParameter("titleImage");
        int idPosts = Integer.parseInt(request.getParameter("idPosts"));
        int status = Integer.parseInt(request.getParameter("status"));
        Image image = new Image(id, url, titleImage, idPosts, status);
        imageService.update(image);
        showListImage(request, response);
    }

    private void saveImage(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String url = request.getParameter("url");
        String title = request.getParameter("titleImage");
        int idPosts = Integer.parseInt(request.getParameter("idPosts"));
        int status = Integer.parseInt(request.getParameter("status"));
        imageService.create(new Image(url, title, idPosts, status));
        response.sendRedirect("/ImageServlet");
    }
}