package com.dsinnovators.tasktracker.controllers;

import com.dsinnovators.tasktracker.dao.StatusDAO;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class StatusServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String status = request.getParameter("status");

        try {
            StatusDAO statusDAO = new StatusDAO();

            statusDAO.insert(status);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("/todo");
    }

}
