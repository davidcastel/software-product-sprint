package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Handles requests sent to the /hello URL. Try running a server and navigating
 * to /hello!
 */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<String> messages = new ArrayList<>();
        messages.add("I run marathons");
        messages.add("The fastest I have ran is a 5 minute mile with 49 seconds");
        messages.add("I enjoy lasagna");
        response.setContentType("application/json;");

        String json = new Gson().toJson(messages);
        response.getWriter().println(json);
    }
}