<%--
  Created by IntelliJ IDEA.
  User: Le Khanh
  Date: 10/6/2023
  Time: 10:06 AM
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
    <h3>Update Category</h3>
    <c:if test="${category != null}">
        <input type="hidden" name="idCategory" value="<c:out value='${category.idCategory}' />"/>
    </c:if>
    <input type="text" name="name" value="<c:out value='${category.name}'/>"/>
    <input type="hidden" name="status" value="1">
    <input type="submit" value="Save">
</form>
</body>
</html>
