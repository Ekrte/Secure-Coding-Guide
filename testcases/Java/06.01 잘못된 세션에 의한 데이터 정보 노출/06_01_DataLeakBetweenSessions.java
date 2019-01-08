package com.fasoo.syn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DataLeakBetweenSessions extends HttpServlet {
    private static final long serialVersionUID = 1256367567161939187L;
    private String name1;
    private static String name2;
    private final String name3 = "name3";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        name1=req.getParameter("name"); /* BUG */
    }

    private class InnerClass {
        private String field;
    }

    private class InnerHttpClass extends DataLeakBetweenSessions {
        private String field;
    }
}
