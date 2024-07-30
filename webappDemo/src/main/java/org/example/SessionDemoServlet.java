package org.example;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionDemoServlet implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("start");
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("end");
    }
}
