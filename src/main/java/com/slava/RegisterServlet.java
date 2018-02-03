package com.slava;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Vladyslav Vlasov on 15.01.2018.
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("userName");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String[] hobbies = req.getParameterValues("hobbies");
        String country = req.getParameter("country");
        String[] languages = req.getParameterValues("languages");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<div>");
        printWriter.println("<p> User name: " + username + "</p");
        printWriter.println("<p> User pass : " + password + "</p");
        printWriter.println("<p> Country: " + country + "</p");
        printWriter.println("<p> Hobbies: </p");
        printWriter.println("<ul>");
        for (int i =0; i< hobbies.length;i++ ) {
            printWriter.println("<li>" + hobbies[i]+ "</li>");
        }
        printWriter.println("</ul>");

        printWriter.println("<p> Languages: </p");
        printWriter.println("<ul>");
        for (int i =0; i< languages.length;i++ ) {
            printWriter.println("<li>" + languages[i]+ "</li>");
        }
        printWriter.println("</ul>");
    }
    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("userName");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String[] hobbies = req.getParameterValues("hobbies");
        String country = req.getParameter("country");
        String[] languages = req.getParameterValues("languages");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<h3>Processing is done for Post request: </h3>");
        printWriter.println("<div>");
        printWriter.println("<p> User name: " + username + "</p");
        printWriter.println("<p> User pass : " + password + "</p");
        printWriter.println("<p> Country: " + country + "</p");
        printWriter.println("<p> Hobbies: </p");
        printWriter.println("<ul>");
        for (int i =0; i< hobbies.length;i++ ) {
            printWriter.println("<li>" + hobbies[i]+ "</li>");
        }
        printWriter.println("</ul>");

        printWriter.println("<p> Languages: </p");
        printWriter.println("<ul>");
        for (int i =0; i< languages.length;i++ ) {
            printWriter.println("<li>" + languages[i]+ "</li>");
        }
        printWriter.println("</ul>");
    }
}
