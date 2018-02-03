package com.slava;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Vladyslav Vlasov on 28.01.2018.
 */
public class AutoPageRefresh extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setIntHeader("Refresh", 3);

        Date currentDate = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyy 'at' hh:mm:ss a");
        String currentDateAndTime = ft.format(currentDate);

        PrintWriter out = resp.getWriter();
        out.println("page last refreshed at " + currentDateAndTime);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }
}
