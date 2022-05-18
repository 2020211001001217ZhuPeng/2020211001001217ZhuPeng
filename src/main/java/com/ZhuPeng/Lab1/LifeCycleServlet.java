package com.ZhuPeng.Lab1;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "LifeCycleServlet", value = "/lifecycle")
public class LifeCycleServlet extends HttpServlet {
    public LifeCycleServlet(){
        System.out.println("I Am from default constructor");

    }
    int count=0;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("init");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("service");
        count = count + 1;
        PrintWriter writer=response.getWriter();
        writer.println("Since Loading,this servlet has been accessed "+count+" times");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy");
    }
}
