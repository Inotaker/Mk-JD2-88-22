<%@ page import="by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    User user = (User) session.getAttribute("user");
%>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<h1 style="color: brown;">Welcome, <c:choose>
    <c:when test="${user!=null}">
        <%= user.getUsername()%>
    </c:when>
    <c:otherwise>
        <a href="signUp.jsp">stranger</a>
    </c:otherwise>
</c:choose>!
</h1>
<table>
    <c:if test="${user==null}">
        <tr>
            <td><a href="signIn.jsp"><input type="button" value="Login"></a></td>
        </tr>
        <tr>
            <td><a href="signUp.jsp"><input type="button" value="Register"></a></td>
        </tr>
        <tr>
        </tr>
    </c:if>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/views/message" method="get">
                <input type="submit" value="Print message">
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/views/chats" method="get">
                <input type="submit" value="Chats">
            </form>
        </td>
    </tr>
</table>
<br>
<c:if test="${user!=null}">
    <form action="${pageContext.request.contextPath}/views/logout" method="get">
        <input type="submit" style="background-color: burlywood" value="Logout">
    </form>
</c:if>
</body>
</html>
