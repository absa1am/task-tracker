package com.absalam.tasktracker.controllers;

import com.absalam.tasktracker.dao.StrengthDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;

@WebServlet(name = "strength", urlPatterns = "/strength")
public class StrengthServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/strength.jsp");

            StrengthDAO strengthDAO = new StrengthDAO();

            HashMap<String, Integer> strength = strengthDAO.get();

            request.setAttribute("strength", strength);

            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            System.out.println("Something went wrong in the server and resolved.");
        }
    }

}
