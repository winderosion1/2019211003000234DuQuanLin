package com.example.DuQuanLin2019211003000234.lab2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "YourNameFilter")
public class YourNameFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("YourNameFilter doFilter()--request before chain");
        chain.doFilter(request,response);
        System.out.println("YourNameFilter --> destory()--response after chain");
    }
}
