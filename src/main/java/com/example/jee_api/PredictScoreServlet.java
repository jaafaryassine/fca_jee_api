package com.example.jee_api;

import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import predicting.PredictingScore;
import predicting.PredictingScoreEPL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet(name = "PredictScoreServlet", value = "/PredictScoreServlet")
public class PredictScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String teamA = request.getParameter("teamA");
        String teamB = request.getParameter("teamB");
        try {
            PredictingScore predictingScore = new PredictingScoreEPL();
            Thread predictingThread = new Thread(() -> {
                try {
                    StringBuffer responseBuffer = predictingScore.predictScore(teamA, teamB);
                    synchronized(response) {
                        response.setContentType("application/json");
                        response.getWriter().write(responseBuffer.toString());
                        response.notifyAll();
                    }
                } catch (Exception e) {
                    synchronized(response) {
                        JsonObject jsonResponse = new JsonObject();
                        jsonResponse.addProperty("error", e.getMessage().toString());
                        response.setContentType("application/json");
                        try {
                            response.getWriter().write(jsonResponse.toString());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        response.notifyAll();
                    }
                }
            });
            predictingThread.start();
            synchronized(response) {
                response.wait();
            }
        } catch (Exception e) {
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("error", e.getMessage().toString());
            response.setContentType("application/json");
            response.getWriter().write(jsonResponse.toString());
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
