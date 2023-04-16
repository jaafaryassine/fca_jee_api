package com.example.jee_api;

import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import stats.LeagueProxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet(name = "LeagueStatsServlet", value = "/LeagueStatsServlet")
public class LeagueStatsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the URL of the API endpoint
        String user_id = request.getParameter("user_id");
        String league_name = request.getParameter("league_name");
        System.out.println("pppp " + user_id + " " + league_name);
        LeagueProxy leagueProxy = new LeagueProxy(user_id);
        try {
            StringBuffer responseBuffer = leagueProxy.getStats(league_name);
            // Set the response content type and write the response to the client
            response.setContentType("application/json");
            response.getWriter().write(responseBuffer.toString());
        } catch (Exception e) {
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("error",e.getMessage().toString());
            response.setContentType("application/json");
            response.getWriter().write(jsonResponse.toString());
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
