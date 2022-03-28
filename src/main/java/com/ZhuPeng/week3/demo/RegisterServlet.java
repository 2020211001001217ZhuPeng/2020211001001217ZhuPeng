package com.ZhuPeng.week3.demo;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
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

        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");

/*        PrintWriter writer = response.getWriter();
        writer.println("<br>id :"+id);
        writer.println("<br>username :" + username);
        writer.println("<br>password :" + password);
        writer.println("<br>email :" + email);
        writer.println("<br>gender :" + gender);
        writer.println("<br>birthDate :" + birthDate);
        writer.close();*/
        String sql = "insert into usertable values(?,?,?,?,?,?)";
        PreparedStatement r = null;
        try {
            r = con.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            r.setString(1, id);
            r.setString(2, username);
            r.setString(3, password);
            r.setString(4, email);
            r.setString(5, gender);
            r.setString(6, birthDate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            r.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql2 = "select * from usertable";
        PreparedStatement r2 = null;
        try {
            r2 = con.prepareStatement(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        try {
            rs = r2.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String id1 = null;
            String username1 = null;
            String password1 = null;
            String email1 = null;
            String gender1 = null;
            String birthDate1 = null;
            try {
                id1 = rs.getString("id");
                username1 = rs.getString("username");
                password1 = rs.getString("password");
                email1 = rs.getString("email");
                gender1 = rs.getString("gender");
                birthDate1 = rs.getString("birthday");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            PrintWriter writer = response.getWriter();
            writer.println(id1 +" "+ username1 +" "+ password1 +" " + email1 +" "+ gender1 +" "+ birthDate1);


        }

    }
}
