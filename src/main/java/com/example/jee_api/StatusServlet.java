package com.example.jee_api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.DB;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "StatusServlet", value = "/StatusServlet")
public class StatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the value of the 'name' parameter
        String user_id = request.getParameter("user_id");

        DB db = new DB();
        try {
            String status = db.getUserStatus(user_id);
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("userStatus",status);
            response.setContentType("application/json");
            response.getWriter().write(jsonResponse.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
