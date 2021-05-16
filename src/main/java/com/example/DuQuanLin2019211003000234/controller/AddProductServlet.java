package com.example.DuQuanLin2019211003000234.controller;

import com.example.DuQuanLin2019211003000234.dao.ProductDao;
import com.example.DuQuanLin2019211003000234.model.Category;
import com.example.DuQuanLin2019211003000234.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddProductServlet", value = "/admin/addProduct")
public class AddProductServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Category> categoryList = Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
            request.getRequestDispatcher("/WEB-INF/views/admin/addProduct.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        double price = request.getParameter("price") != null ? Double.parseDouble(request.getParameter("price")):0.0;
        int categoryId = request.getParameter("categoryId")!=null?Integer.parseInt("categoryId"):8;
        String productDescription = request.getParameter("productDescription");

        InputStream inputStream = null;
        Part fileParts = request.getPart("picture");
        if(fileParts!=null){
            inputStream = fileParts.getInputStream();
        }

        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setCategoryId(categoryId);
        product.setProductDescription(productDescription);
        product.setPicture(inputStream);

        ProductDao productDao = new ProductDao();
        try {
            int n = productDao.save(product,con);
            if(1>0){
                response.sendRedirect("productList");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
