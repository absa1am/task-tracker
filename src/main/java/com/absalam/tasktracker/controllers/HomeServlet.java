package com.absalam.tasktracker.controllers;

import com.absalam.tasktracker.dao.ToDoDAO;
import com.absalam.tasktracker.models.Task;
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
            // As I have not implemented error logger, so I'm not showing the exception message directly
            System.out.println("Something went wrong and resolved in internal server.");
        }
    }

}
