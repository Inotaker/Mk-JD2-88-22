<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8" %>
<%! private int accessCount = 0; %>
<html>
<head>
    <title>Генерация рандомных чисел</title>
</head>
<body>
<%= Math.random() %>
<%--выражения JSP--%>
<h1>Текущее время: <%= new java.util.Date() %>
    <%--обьявление JSP--%>
    <h2>
        Количество обращений к странице с момента загрузки сервера: <%= ++accessCount %>
    </h2>
    <%--скриплеты JSP--%>
    <h3>
        <%
            String queryData = request.getQueryString();
            out.println("Данные запроса " + queryData);
            out.println(request.getRemoteHost());
            out.println(request.getParameter("title"));
        %>
    </h3>
</h1>
</body>
</html>
