package com.absalam.tasktracker.controllers;

import com.absalam.tasktracker.dao.ToDoDAO;
import com.absalam.tasktracker.models.Task;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewToDoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/view-todo.jsp");
            Task task = (new ToDoDAO()).get(id);

            if (task != null) {
                request.setAttribute("task", task);

                requestDispatcher.forward(request, response);
            } else {
                response.sendError(404, "Sorry, the task is not found.");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong in the internal server and resolved.");
        }
    }

}
