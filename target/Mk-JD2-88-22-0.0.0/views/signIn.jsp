<%--
  Created by IntelliJ IDEA.
  User: Inotak
  Date: 2/17/2022
  Time: 6:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignIn</title>
</head>
<body>
Login page
<form action="${pageContext.request.contextPath}/views/signIn" method="post">
    <table>
        <tr>
            <td>Username: <input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password: <input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" name="Submit"></td>
        </tr>
    </table>
</form>
<jsp:include page="returnToMain.html"></jsp:include>
</body>
</html>
