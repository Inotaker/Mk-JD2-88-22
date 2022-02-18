<%--
  Created by IntelliJ IDEA.
  User: Inotak
  Date: 2/16/2022
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/views/signUp" method="post">
    <table>
        <tr>
            <td>Username: <input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password: <input type="password" name="password"></td>
        </tr>
        <tr>
            <td>Full name: <input type="text" name="fio"></td>
            <td>Birthday: <input type="date" name="birthday"></td>
        </tr>
        <tr>
            <td><input type="submit" name="Submit"></td>
        </tr>
    </table>
    <c:if test="${userExists}">
        <p style="color: green">User created!</p>
    </c:if>
    <jsp:include page="returnToMain.html"></jsp:include>
</form>
</body>
</html>
