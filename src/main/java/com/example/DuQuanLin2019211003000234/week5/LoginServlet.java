package com.example.DuQuanLin2019211003000234.week5;

import com.example.DuQuanLin2019211003000234.dao.UserDao;
import com.example.DuQuanLin2019211003000234.model.User;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        /*String driver = getServletConfig().getServletContext().getInitParameter("driver");
        String url = getServletConfig().getServletContext().getInitParameter("url");
        String username = getServletConfig().getServletContext().getInitParameter("username");
        String password = getServletConfig().getServletContext().getInitParameter("password");

        try{
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("init()" + connection);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(con, username, password);
            if (user != null) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Username or Password Error!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
/*
        String driver = getServletConfig().getServletContext().getInitParameter("driver");
        String url = getServletConfig().getServletContext().getInitParameter("url");
        String user = getServletConfig().getServletContext().getInitParameter("username");
        String pd = getServletConfig().getServletContext().getInitParameter("password");

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,user,pd);
            String sql = "select * from usertable";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                String user1 = rs.getString(1);
                String pd1 = rs.getString(2);
                if(user1.equals(username) && pd1.equals(password)){
                    PrintWriter printWriter =response.getWriter();
                    request.setAttribute("username",rs.getString(1));
                    request.setAttribute("password",rs.getString(2));
                    request.setAttribute("email",rs.getString(3));
                    request.setAttribute("gender",rs.getString(4));
                    request.setAttribute("birthdate",rs.getString(5));

                    request.getRequestDispatcher("userList.jsp").forward(request,response);

                }else{
                    PrintWriter printWriter =response.getWriter();
                    request.setAttribute("message","Username Or Password Error!!");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }*/
