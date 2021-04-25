<%--
  Created by IntelliJ IDEA.
  User: 12875
  Date: 2021/4/25
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User u = (User) session.getAttribute("user");
%>
<form method="post" action="updateUser">
    <input type="hidden" name = "id" value="<%=u.getId()%>">
    username:<input type = "text" name = "username" value="<%=u.getUsername()%>"><br/>
    password:<input type = "password" name = "password" value="<%=u.getPassword()%>"><br/>
    email:<input type = "text" name = "email" value="<%=u.getEamil()%>"><br/>

    gender:<input type = "radio" name = "gender" value="male" <%="male".equals(u.getGender())?"checked":""%>>Male
    <input type = "radio" name = "gender" value="female" <%="female".equals(u.getGender())?"checked":""%>>Female<br/>


    birthdate:<input type = "text" name = "birthDate" value="<%=u.getBirthDate()%>"><br/>
    <input type="submit" value="Save Changes">
</form>
</body>
</html>
<%@ include file="footer.jsp"%>
