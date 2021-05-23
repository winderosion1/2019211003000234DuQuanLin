package com.example.DuQuanLin2019211003000234.controller;

import com.example.DuQuanLin2019211003000234.dao.ProductDao;
import com.example.DuQuanLin2019211003000234.model.Category;
import com.example.DuQuanLin2019211003000234.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductDetailsServlet", value = "/productDetails")
public class ProductDetailsServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categoryList = Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if(request.getParameter("id")!=null){
            int productId = Integer.parseInt(request.getParameter("id"));
            ProductDao productDao = new ProductDao();
            try {
                Product product = productDao.findById(productId,con);
                request.setAttribute("p",product);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        request.getRequestDispatcher("/WEB-INF/views/admin/productDetails.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
