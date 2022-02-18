<%@ page import="by.it.academy.Mk_JD2_88_22.homework.hw1.service.UserService" %>
<%@ page import="by.it.academy.Mk_JD2_88_22.homework.hw1.dto.User" %>
<%@ page import="by.it.academy.Mk_JD2_88_22.homework.hw1.service.api.IMessageService" %>
<%@ page import="by.it.academy.Mk_JD2_88_22.homework.hw1.service.MessageService" %>
<%@ page import="by.it.academy.Mk_JD2_88_22.homework.hw1.service.api.IUserService" %><%--
  Created by IntelliJ IDEA.
  User: Inotak
  Date: 2/17/2022
  Time: 5:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    User user = (User) session.getAttribute("user");
    IMessageService messageService = MessageService.getInstance();
    UserService userService = UserService.getInstance();
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
        dude
    </c:otherwise>
</c:choose>
</h1>
<table>
    <tr>
        <td><a href="signIn.jsp"><input type="button" value="Login"></a></td>
    </tr>
    <tr>
        <td><a href="signUp.jsp"><input type="button" value="Register"></a></td>
    </tr>
    <tr>
        <td><a href="message.jsp"><input type="button" value="Print message"></a></td>
    </tr>
    <tr>
        <td><a href="chats.jsp"><input type="button" value="Chats"></a></td>
    </tr>
</table>
<br>
<p style="color: purple" aria-setsize="20">Messages on server: <%=messageService.getMessagesCount()%>
</p><br>
<p style="color: aqua">Created account count: <%= userService.getUserCount()%>
</p>
</body>
</html>
