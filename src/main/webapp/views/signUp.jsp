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
            <td>Username: <input type="text" name="username"> <c:if test="${usernameEmpty!=null}">
                <c:if test="${usernameEmpty}">
                    <p style="color: red"><b>Field is empty!</b></p>
                </c:if>
            </c:if></td>
        </tr>
        <tr>
            <td>Password: <input type="password" name="password"> <c:if test="${passwordEmpty!=null}">
                <c:if test="${passwordEmpty}">
                    <p style="color: red"><b>Field is empty!</b></p>
                </c:if>
            </c:if></td>
        </tr>
        <tr>
            <td>Full name: <input type="text" name="fio"> <c:if test="${fioEmpty!=null}">
                <c:if test="${fioEmpty}">
                    <p style="color: red"><b>Field is empty!</b></p>
                </c:if>
            </c:if></td>

            <td>Birthday: <input type="date" name="birthday"> <c:if test="${birthdayEmpty!=null}">
                <c:if test="${birthdayEmpty}">
                    <p style="color: red"><b>Field is empty!</b></p>
                </c:if>
            </c:if></td>
        </tr>
        <tr>
            <td><input type="submit" name="Submit"></td>
        </tr>
    </table>
    <c:if test="${userExists && userExists!=null}">
        <p style="color: orangered"><b>User is already exists!</b></p>
    </c:if>
    <c:if test="${userCreated && userCreated!=null}">
        <p style="color: green"><b>User created!</b></p>
    </c:if>
    <jsp:include page="returnToMain.html"></jsp:include>
</form>
</body>
</html>
