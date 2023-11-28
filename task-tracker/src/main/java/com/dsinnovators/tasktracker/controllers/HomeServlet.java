package com.dsinnovators.tasktracker.controllers;

import com.dsinnovators.tasktracker.dao.ToDoDAO;
import com.dsinnovators.tasktracker.models.Task;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/home.jsp");

            List<Task> tasks = (new ToDoDAO()).getAll();

            request.setAttribute("tasks", tasks);

            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
