package com.absalam.tasktracker.controllers;

import com.absalam.tasktracker.dao.ToDoDAO;
import com.absalam.tasktracker.models.Status;
import com.absalam.tasktracker.models.Task;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Date;

public class EditToDoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/edit-todo.jsp");
            ToDoDAO toDoDAO = new ToDoDAO();

            Task task = toDoDAO.get(id);

            if (task != null) {
                request.setAttribute("task", task);
                request.setAttribute("status", Status.values());

                requestDispatcher.forward(request, response);
            } else response.sendError(404, "The task not found");
        } catch (Exception e) {
            System.out.println("Something went wrong in server and resolved.");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            // Validation
            if (!request.getParameter("name").isBlank() && !request.getParameter("startDate").isBlank() && !request.getParameter("endDate").isBlank()) {
                // Collecting data from form
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                Date startDate = Date.valueOf(request.getParameter("startDate"));
                Date endDate = Date.valueOf(request.getParameter("endDate"));
                Status status = Status.valueOf(request.getParameter("taskStatus"));

                ToDoDAO toDoDAO = new ToDoDAO();

                toDoDAO.update(name, description, startDate, endDate, status, id);

                // Alert message for successful operation
                request.getSession().setAttribute("success", "Task updated successfully.");

                response.sendRedirect("/");
            } else { // else is needed here otherwise the code will have bug
                // Alert for unsuccessful operation
                request.getSession().setAttribute("danger", "Please, fill the form appropriately.");

                response.sendRedirect("/edit-todo?id=" + Integer.parseInt(request.getParameter("id")));
            }
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Something went wrong in server and resolved.");
        }
    }

}
