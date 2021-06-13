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

@WebServlet(name = "UpdateUserServlet", value = "/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getRequestDispatcher("updateUser.jsp").forward(request,response);
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String date = request.getParameter("birthDate");
        int id = Integer.parseInt(request.getParameter("id"));
        try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(date);
        java.sql.Date birthdate = new java.sql.Date(date1.getTime());

        User user = new User(id,username,password,email,gender,birthdate);
            //System.out.println(user.toString());
        UserDao userDao = new UserDao();

            userDao.updateUser(con,user);
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("accountDetails").forward(request,response);
    }
}
