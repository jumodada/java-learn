package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String username = null;
        HttpSession se = request.getSession();
        se.invalidate();
        System.out.println("homeStart");
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("user".equals(cookie.getName())) {
                    username = cookie.getValue();
                }
            }
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (username != null) {
            out.println("<h1>Welcome, " + username + "!</h1>");
            out.println("<a href='logout'>Logout</a>");
        } else {
            response.sendRedirect("login.html");
        }
    }
}