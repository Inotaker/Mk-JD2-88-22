<%@ page import="by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    User user = (User) session.getAttribute("user");
%>
<!doctype html>
<html>
<head>
    <title>Main page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1 class="">Welcome, <c:choose>
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
            <td><a href="signIn.jsp"><input class="btn-primary" type="button" value="Login"></a></td>
        </tr>
        <tr>
            <td><a href="signUp.jsp"><input class="btn-primary" type="button" value="Register"></a></td>
        </tr>
        <tr>
        </tr>
    </c:if>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/views/message" method="get">
                <input class="btn-secondary" type="submit" value="Print message">
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/views/chats" method="get">
                <input class="btn-secondary" type="submit" value="Chats">
            </form>
        </td>
    </tr>
</table>
<br>
<c:if test="${user!=null}">
    <form action="${pageContext.request.contextPath}/views/logout" method="get">
        <input class="btn-dark" type="submit"  value="Logout">
    </form>
</c:if>
</body>
</html>
