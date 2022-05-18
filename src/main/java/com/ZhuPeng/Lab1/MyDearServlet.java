package com.ZhuPeng.Lab1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyDearServlet", value = "/Lab1/myDear")
public class MyDearServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String class1=request.getParameter("class");
        String id=request.getParameter("id");
        PrintWriter w=response.getWriter();
        w.println("Name:"+name);
        w.println("Class:"+class1);
        w.println("ID:"+id);

    }
}
