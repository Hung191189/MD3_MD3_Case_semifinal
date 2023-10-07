<%--
  Created by IntelliJ IDEA.
  User: Le Khanh
  Date: 10/5/2023
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
<h3>Update User</h3>
<c:if test="${user != null}">
    <input type="hidden" name="idUser" value="<c:out value='${user.idUser}' />"/>
</c:if>
    <input type="text" name="name" value="<c:out value='${user.name}'/>"/>
    <input type="number" name="age" value="<c:out value='${user.age}'/>"/>
    <input type="text" name="email" value="<c:out value='${user.email}'/>"/>
    <input type="text" name="address" value="<c:out value='${user.address}'/>"/>
    <input type="password" name="password" value="<c:out value='${user.password}'/>"/>
    <input type="hidden" name="status" value="1">
    <input type="submit" value="Save">
</form>
<a href="UserServlet">Back to list</a>
</body>
</html>