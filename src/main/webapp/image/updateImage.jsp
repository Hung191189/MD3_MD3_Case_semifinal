<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/7/2023
  Time: 2:34 AM
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
    <h3>Update Image</h3>
    <c:if test="${image != null}">
        <input type="hidden" name="idImage" value="<c:out value='${image.idImage}' />"/>
    </c:if>
    <input type="text" name="url" value="<c:out value='${image.url}'/>"/>
    <input type="text" name="titleImage" value="<c:out value='${image.titleImage}'/>"/>
    <input type="number" name="idPosts" value="<c:out value='${image.idPosts}'/>"/>
    <input type="hidden" name="status" value="1">
    <input type="submit" value="Save">
</form>
</body>
</html>
