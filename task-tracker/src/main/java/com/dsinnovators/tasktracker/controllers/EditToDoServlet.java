package com.dsinnovators.tasktracker.controllers;

import com.dsinnovators.tasktracker.dao.ToDoDAO;
import com.dsinnovators.tasktracker.models.Status;
import com.dsinnovators.tasktracker.models.Task;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Date;

public class EditToDoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/edit-todo.jsp");

        try {
            ToDoDAO toDoDAO = new ToDoDAO();

            Task task = toDoDAO.get(id);

            if (task != null) {
                request.setAttribute("task", task);
                request.setAttribute("status", Status.values());

                requestDispatcher.forward(request, response);
            }

            response.sendError(404, "The task not found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            // Validation
            if (request.getParameter("name").isBlank() || request.getParameter("startDate").isBlank() || request.getParameter("endDate").isBlank())
                request.getRequestDispatcher("views/todo.jsp").forward(request, response);

            // Collecting data from form
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            Date startDate = Date.valueOf(request.getParameter("startDate"));
            Date endDate = Date.valueOf(request.getParameter("endDate"));
            Status status = Status.valueOf(request.getParameter("taskStatus"));

            ToDoDAO toDoDAO = new ToDoDAO();

            toDoDAO.update(name, description, startDate, endDate, status, id);

            response.sendRedirect("/");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
