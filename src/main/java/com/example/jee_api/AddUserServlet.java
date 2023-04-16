package com.example.jee_api;

import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.DB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Map;

@WebServlet(name = "AddUserServlet", value = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DB db = new DB();
        try {
            db.addUser("idss","emm","nomm");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("*********");
        // Get the JSON data from the request body
        String requestData = request.getReader().readLine();

        // Parse the JSON data into a Map
        Map<String, Object> requestMap = new Gson().fromJson(requestData, Map.class);

        // Get the value of the 'name' parameter
        String user_id = (String) requestMap.get("user_id");
        String email = (String) requestMap.get("email");
        String name = (String) requestMap.get("name");

        DB db = new DB();
        try {
            db.addUser(user_id,email,name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Received data: " + email);
    }
}
