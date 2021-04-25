package com.example.DuQuanLin2019211003000234.controller;

import com.example.DuQuanLin2019211003000234.dao.UserDao;
import com.example.DuQuanLin2019211003000234.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try {
            birthDate = df.parse((String)request.getParameter("r_date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int id = Integer.parseInt(request.getParameter("id"));

        User user = new User(id,username,password,email,gender,birthDate);

        UserDao userDao = new UserDao();
        try {
            userDao.updateUser(con,user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("updateUser.jsp").forward(request,response);
    }
}
