package com.dsinnovators.tasktracker.controllers;

import com.dsinnovators.tasktracker.dao.StatusDAO;
import com.dsinnovators.tasktracker.models.Status;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class ToDoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/todo.jsp");

        try {
            StatusDAO statusDAO = new StatusDAO();
            List<Status> statusList = statusDAO.getAll();

            request.setAttribute("status", statusList);

            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
