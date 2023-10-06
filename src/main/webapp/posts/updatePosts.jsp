<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/6/2023
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <h3>Update User</h3>
    <c:if test="${posts != null}">
        <input type="hidden" name="idUser" value="<c:out value='${posts.idPosts}' />"/>
    </c:if>
    <input type="text" name="titlePosts" value="<c:out value='${posts.titlePosts}'/>"/>
    <input type="text" name="content" value="<c:out value='${posts.content}'/>"/>
    <input type="number" name="abc" value="<c:out value='${posts.idUser}'/>"/>
    <input type="hidden" name="idCategory" value="<c:out value='${posts.idCategory}'/>"/>
    <input type="hidden" name="status" value="1">
    <input type="submit" value="Save">
</form>
</body>
</html>
