<%--
  Created by IntelliJ IDEA.
  User: Le Khanh
  Date: 10/4/2023
  Time: 5:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${user}" var="user">
    <p>${user.idUser}, ${user.name}, ${user.age}, ${user.email}, ${user.address}, ${user.password}, ${user.status}</p>
</c:forEach>
</body>
</html>
