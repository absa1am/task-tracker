package com.dsinnovators.tasktracker.controllers;

import com.dsinnovators.tasktracker.dao.ToDoDAO;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DeleteToDoServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ToDoDAO toDoDAO = new ToDoDAO();

            if (toDoDAO.get(id) != null) {
                toDoDAO.delete(id);

                request.getSession().setAttribute("success", "Task deleted successfully.");
            } else {
                HttpSession session = request.getSession();

                session.setAttribute("danger", "Sorry, unable to delete the task.");
            }

            response.sendRedirect("/");
        } catch (Exception e) {
            System.out.println("Something went wrong and resolved in the server.");
        }
    }

}
