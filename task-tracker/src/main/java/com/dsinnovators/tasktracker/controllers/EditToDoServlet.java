package com.dsinnovators.tasktracker.controllers;

import com.dsinnovators.tasktracker.dao.ToDoDAO;
import com.dsinnovators.tasktracker.models.Status;
import com.dsinnovators.tasktracker.models.Task;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

}
