package com.dsinnovators.tasktracker.controllers;

import com.dsinnovators.tasktracker.dao.StatusDAO;
import com.dsinnovators.tasktracker.models.Status;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/home.jsp");

            StatusDAO statusDAO = new StatusDAO();
            List<Status> status = statusDAO.getAll();

            request.setAttribute("status", status);

            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
