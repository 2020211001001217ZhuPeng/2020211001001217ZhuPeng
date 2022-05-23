package com.ZhuPeng.controller;

import com.ZhuPeng.dao.UserDao;
import com.ZhuPeng.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con= (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");
        User user=new User();
        user.setId(Integer.parseInt(id));
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setBirthday(birthDate);
        UserDao userDao=new UserDao();
        try {
            userDao.updateUser(con,user);
            userDao.findById(con, Integer.valueOf(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session=request.getSession();
        System.out.println("session id-->"+session.getId());
        session.setMaxInactiveInterval(10);
        session.setAttribute("user",user);

        //request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
        request.getRequestDispatcher("accountDetails").forward(request,response);


    }
}
