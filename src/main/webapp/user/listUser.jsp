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
<a href="/UserServlet?action=createUser">Create new customer</a>
<c:forEach items="${user}" var="user">
    <c:if test="${user.status == 1}">
        <p>${user.idUser},
            <a href="/UserServlet?action=viewUser&id=${user.idUser}">${user.name}</a>, ${user.age}, ${user.email}, ${user.address}, ${user.password}, ${user.status}
            <a href="/UserServlet?action=deleteUser&id=${user.idUser}">Delete</a>,
            <a href="/UserServlet?action=updateUser&id=${user.idUser}">Edit</a>
        </p>
    </c:if>
</c:forEach>
<h1>blocked</h1>
<c:forEach items="${user}" var="user">
    <c:if test="${user.status == 0}">
        <p>${user.idUser},
            <a href="/UserServlet?action=viewUser&id=${user.idUser}">${user.name}</a>, ${user.age}, ${user.email}, ${user.address}, ${user.password}, ${user.status}
            <a href="/UserServlet?action=restoreUser&id=${user.idUser}">Restore</a>,

        </p>
    </c:if>
</c:forEach>
<h1>find by name</h1>
<form method="post">
    <input type="text" name="name">
    <a href="/UserServlet?action=findByName"><input type="submit"></a>
</form>

</body>
</html>
