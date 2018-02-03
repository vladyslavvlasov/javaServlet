package com.slava;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Vladyslav Vlasov on 28.01.2018.
 */
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init method is called in " + this.getClass().getName());
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter method is called in " + this.getClass().getName());
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String ip = req.getRemoteAddr();

        if (userName.equals("slava") && password.equals("pass")) {
            System.out.println("User logged in " + ip + " at " + new Date().toString());
            filterChain.doFilter(req, res);
        } else {
            PrintWriter out = res.getWriter();
            out.println("<h1> You are not authorized, baby! </h1>");
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy method is called in " + this.getClass().getName());
    }
}
