package com.example.jee_api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Tactic;
import models.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "DataServlet", value = "/DataServlet")
public class DataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println("Receiiiiived name : " + name);
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String json = gson.toJson(name);
        response.setContentType("application/json");
        out.println(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("*********");
        // Get the JSON data from the request body
        String requestData = request.getReader().readLine();

        // Parse the JSON data into a Map
        Map<String, Object> requestMap = new Gson().fromJson(requestData, Map.class);

        // Get the value of the 'name' parameter
        String userInput = (String) requestMap.get("userInput");
        System.out.println("Received data: " + userInput);

        // Traitement
        User user = new User(userInput);
        user.getFinalTactic();
        String finalFormation = Tactic.getFinalFormation();
        ArrayList<String> instructions = Tactic.all_instructions;


        // Return a JSON response
        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("finalFormation",finalFormation);
        JsonArray instructionsArray = new JsonArray();
        for (String instruction : instructions) {
            instructionsArray.add(instruction);
        }
        jsonResponse.add("instructions", instructionsArray);

        response.setContentType("application/json");
        response.getWriter().write(jsonResponse.toString());

        // Renitialize Tactic
        Tactic.resetParameters();
    }
}