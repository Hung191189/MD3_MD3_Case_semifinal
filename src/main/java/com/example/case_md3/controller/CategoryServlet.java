package com.example.case_md3.controller;

import com.example.case_md3.model.Category;
import com.example.case_md3.model.User;
import com.example.case_md3.service.Category.CategoryService;
import com.example.case_md3.service.Category.CategoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "categoryServlet", value = "/CategoryServlet")
public class CategoryServlet extends HttpServlet {
    CategoryService categoryService = new CategoryServiceImpl();
    CategoryServiceImpl categoryService1 = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createCategory":
                    showCreateCategory(request, response);
                    break;
                case "updateCategory":
                    showUpdateCategory(request, response);
                    break;
                case "deleteCategory":
                    deleteCategory(request, response);
                    break;
                case "restoreCategory":
                    restoreCategory(request, response);
                    break;
                default:
                    showListCategory(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void restoreCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("idCategory"));
        categoryService1.restore(id);
        List<Category> categoryList = new ArrayList<>();
        categoryList = categoryService.findAll();
        request.setAttribute("category", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/listCategory.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        categoryService.delete(id);
        List<Category> categoryList;
        categoryList = categoryService.findAll();
        request.setAttribute("category", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/listCategory.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showUpdateCategory(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.findById(id);
        RequestDispatcher dispatcher;
        if(category == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("category", category);
            dispatcher = request.getRequestDispatcher("category/updateCategory.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showListCategory(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = categoryService.findAll();
        request.setAttribute("category", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/listCategory.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateCategory(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/createCategory.jsp");
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
            case "createCategory":
                saveCategory(request, response);
                break;
            case "updateCategory":
                updateCategory(request, response);
                break;
            case "findByNameCategory":
                findByNameCategory(request, response);
                break;
                }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void findByNameCategory(HttpServletRequest request, HttpServletResponse response) {
        String a = request.getParameter("nameSearch");
        List<Category> categoryList = categoryService.findByName(a);
        request.setAttribute("categoryByName", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/findCategoryByName.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("idCategory"));
        String name = request.getParameter("name");
        int status = Integer.parseInt(request.getParameter("status"));
        Category category = new Category(id, name, status);
        categoryService.update(category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/updateCategory.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        int status = Integer.parseInt(request.getParameter("status"));
        categoryService.create(new Category(name, status));
        response.sendRedirect("/CategoryServlet");
    }
    }
