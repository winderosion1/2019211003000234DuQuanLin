<%--
  Created by IntelliJ IDEA.
  User: 12875
  Date: 2021/4/10
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<h1><%="welcome to my home page"%></h1>
<br/>
<form method="get" target="_blank" action="search">
    <input type="text" name="txt" size="30">
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search">
</form>
<a href = "hello-servlet">Hello Servlet-week1</a>
<br/>
<a href = "hello">Student Info Servlet-week2</a>
<br/>
<a href = "register.jsp">Register-getParameter-week3</a>
<br/>
<a href = "config">Config parameter-week4</a>
<br/>
<a href = "register.jsp">Register JDBC -week4</a>
<br/>
<a href = "index.jsp">include-week5</a>
<br/>
<a href = "login">Login-week5</a>
<br/>
</body>
</html>
<%@include file="footer.jsp"%>
