package com.dsinnovators.tasktracker.controllers;

import com.dsinnovators.tasktracker.dao.ToDoDAO;
import com.dsinnovators.tasktracker.models.Status;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Date;
import java.util.List;

public class ToDoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/todo.jsp");

        try {
            Status[] status = Status.values();

            request.setAttribute("status", status);

            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        Status status = Status.valueOf(request.getParameter("taskStatus"));

        try {
            ToDoDAO todoDAO = new ToDoDAO();

            todoDAO.insert(name, description, startDate, endDate, status);

            response.sendRedirect("/");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
