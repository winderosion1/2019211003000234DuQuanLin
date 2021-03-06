<%@ page import="com.example.DuQuanLin2019211003000234.lab1.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.DuQuanLin2019211003000234.lab1.Dog" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 9:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assignemnt1</title>
</head>
<body>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<h1> c:forEach loog to print 1 to 10</h1>

    <ul>
        <c:forEach var="i" begin="1" end="10">
        <li>$${i}</li>
        </c:forEach>
    </ul>
    <%-- todo 1 : run assignement1.jsp  --%>
    <%-- todo 2 : use c:forEach to print list 1,3,5,7,9   --%>
<c:forEach var="j"   begin="1"    end="9"    step="2">

    <li>$${j}</li>

</c:forEach>
   <%-- todo 3 : use c:forEach to print 2,4,6,8,10   --%>
<c:forEach var="k"   begin="2"    end="10"    step="2">

    <li>$${k}</li>

</c:forEach>


<% String[] words ={"one","two","three","four","five","six","seven","eight","nine","ten"};
   request.setAttribute("words", words);
%>
    <%-- todo 4 : use c:forEach to print all elements of array --%>
<c:forEach var="word" items="${request.words}">
    <td>
        <c:out value="${words}" />
    </td>
</c:forEach>
    <%-- todo 5 : use c:forEach to print "one","three","five","seven","nine"  of array --%>
<c:forEach var="word" items="${request.words}" step="2">
    <td>
        <c:out value="${words}" />
    </td>
</c:forEach>
<%
List<Person> personList=new ArrayList<Person>();
personList.add(new Person("Tom",new Dog("Tommy")));
personList.add(new Person("Sam",new Dog("Sammy")));
// todo 6 : add a new person into PersonList - person name and dog name
    personList.add(new Person("niuniu",new Dog("diudiu")));
request.setAttribute("AllPerson",personList);
%>
<%--//todo 7: use c:forEach to print person name :   and persons' dog name : --%>
<c:forEach var="url" items="${AllPerson}" >
    ${url}
</c:forEach>
<%
    String str="one:two:three-four-five";
%>
<%--todo 8 : use c:forToken to print all words --%>
<c:forTokens items="one:two:three-four-five" delims="-" var="word">
<c:out value="${word}"/><p>
    </c:forTokens>
</body>
</html>
