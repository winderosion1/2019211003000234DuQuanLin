package com.example.DuQuanLin2019211003000234;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthdate = request.getParameter("birthdate");

        PrintWriter printWriter = response.getWriter();

        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<meta charset='UTF-8'>");
        printWriter.println("<title>显示所有</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("username:"+username);
        printWriter.println("<br/>password:"+password);
        printWriter.println("<br/>email:"+email);
        printWriter.println("<br/>gender:"+gender);
        printWriter.println("<br/>birthdate:"+birthdate);
        printWriter.println("<br/></body>");
        printWriter.println("</html>");
    }
}
