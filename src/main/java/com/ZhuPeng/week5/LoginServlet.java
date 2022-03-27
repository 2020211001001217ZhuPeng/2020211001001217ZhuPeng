package com.ZhuPeng.week5;

import com.sun.org.apache.bcel.internal.generic.Select;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context=getServletContext();
        String driver= context.getInitParameter("driver");
        String url= context.getInitParameter("url");
        String username= context.getInitParameter("username");
        String password= context.getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection in RegisterServlet-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sql = "select * from usertable where username=? and password=?";
        PreparedStatement r = null;
        try {
            r = con.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            r.setString(1, username);
            r.setString(2, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = r.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter writer=response.getWriter();
            if (rs.next()){
                writer.println("Login Success!!!");
                writer.println("Welcome,"+username);

            }else{
                writer.println("Username of Password Error!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
