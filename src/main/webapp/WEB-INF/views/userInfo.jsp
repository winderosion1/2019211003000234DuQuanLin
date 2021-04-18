<%@ page import="com.example.DuQuanLin2019211003000234.model.User" %>
<%@include file="header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<h1>UserInfo</h1>
<%
    User user = (User) request.getAttribute("user");
%>
<table>
    <tr><td>Username:</td><td><%=user.getUsername()%></td></tr>
    <tr><td>Password:</td><td><%=user.getPassword()%></td></tr>
    <tr><td>Email:</td><td><%=user.getEamil()%></td></tr>
    <tr><td>Gender:</td><td><%=user.getGender()%></td></tr>
    <tr><td>Birthdate:</td><td><%=user.getBirthDate()%></td></tr>
</table>
<%@include file="footer.jsp"%>