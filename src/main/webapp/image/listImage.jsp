<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/6/2023
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/ImageServlet?action=createImage">Create new Image</a>
<%--<a href="/ImageServlet?action=createImage">Create new customer</a>--%>
<c:forEach items="${image}" var="image">
    <c:if test="${image.status == 1}">
        <p>${image.idImage},
            <a href="/ImageServlet?action=viewImage&id=${image.idImage}">${image.url}</a>, ${image.titleImage}, ${image.idPosts}, ${image.status}
            <a href="/ImageServlet?action=deleteImage&id=${image.idImage}">Delete</a>,
            <a href="/ImageServlet?action=updateImage&id=${image.idImage}">Edit</a>
        </p>
    </c:if>
</c:forEach>
<h1>blocked</h1>
<c:forEach items="${image}" var="image">
    <c:if test="${image.status == 0}">
        <p>${image.idImage},
            <a href="/ImageServlet?action=viewImage&id=${image.idImage}">${image.url}</a>, ${image.titleImage}, ${image.idPosts}, ${image.status}
            <a href="/ImageServlet?action=restoreImage&id=${image.idImage}">Restore</a>
        </p>
    </c:if>
</c:forEach>
</body>
</html>
