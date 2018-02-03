package com.slava;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by Vladyslav Vlasov on 27.01.2018.
 */

public class ShowRequestHeaders extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Showing Request headers </title>");
        out.println("</head");
        out.println("<body>");
        out.println("<h1>Request headers </h1>");

        out.println("<p> <b> Request Method : </b>" + req.getMethod());
        out.println("<p><b> Request url: </b>" + req.getRequestURI());
        out.println("<p><b> Request Protocol: </b>" + req.getProtocol());

        Enumeration<String> headerNames = req.getHeaderNames();

        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            out.println("<p>" + headerName + " " + req.getHeader(headerName) + "</p>");
        }

        out.println("</body>");
        out.println("</html>");
        out.close();

    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
