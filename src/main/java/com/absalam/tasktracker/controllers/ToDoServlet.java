package com.absalam.tasktracker.controllers;

import com.absalam.tasktracker.dao.ToDoDAO;
import com.absalam.tasktracker.models.Status;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Date;

public class ToDoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/todo.jsp");

        try {
            // Getting the all status values for showing as option
            Status[] status = Status.values();

            request.setAttribute("status", status);

            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            System.out.println("Something went wrong and resolved in internal server.");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/todo.jsp");

            // Checking validity of data
            if (!request.getParameter("name").isBlank() && !request.getParameter("startDate").isBlank() && !request.getParameter("endDate").isBlank()) {
                // Collecting parameter from form-body
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                Date startDate = Date.valueOf(request.getParameter("startDate"));
                Date endDate = Date.valueOf(request.getParameter("endDate"));
                Status status = Status.valueOf(request.getParameter("taskStatus"));

                // Inserting data into database
                ToDoDAO todoDAO = new ToDoDAO();

                todoDAO.insert(name, description, startDate, endDate, status);

                // Alert message for successful task creation
                request.getSession().setAttribute("success", "Task created successfully.");

                response.sendRedirect("/");
            } else {
                // Alert message for unsuccessful operation
                request.getSession().setAttribute("danger", "Please, fill the form appropriately.");

                response.sendRedirect("/todo");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong and resolved in internal server.");
        }
    }

}
