package com.slava;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Vladyslav Vlasov on 27.01.2018.
 */
public class LargeServletPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out;
        if (GzipUtility.isGzipSupported(req) && !GzipUtility.isGzipDisabled(req)) {
            out = GzipUtility.getGzipWriter(resp);
        } else {
            out = resp.getWriter();
        }


        String dummyLine = "This is a test string that tdoesn'ty make much sense";
        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Large servlet demo </title>");
        out.println("</head");
        out.println("<body>");
        out.println("<h1>Showing dummy line: </h1>");
        for (int i = 0; i < 10000; i++) {
            out.println(dummyLine);
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
