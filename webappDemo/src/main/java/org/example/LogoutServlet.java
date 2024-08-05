package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie loginCookie = new Cookie("user", null);
        loginCookie.setMaxAge(0); // 删除Cookie
        response.addCookie(loginCookie);
        response.sendRedirect("login.html");
        System.out.println("XX");
    }
}