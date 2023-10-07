<%--
  Created by IntelliJ IDEA.
  User: Le Khanh
  Date: 10/6/2023
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/CategoryServlet?action=createCategory">Create Category</a>
<c:forEach items="${category}" var="cate">
    <c:if test="${cate.status == 1}">
        <p>${cate.idCategory},
            <a href="/CategoryServlet?action=viewCategory&id=${cate.idCategory}">${cate.name}</a>, ${cate.status}
            <a href="/CategoryServlet?action=deleteCategory&id=${cate.idCategory}">Delete</a>,
            <a href="/CategoryServlet?action=updateCategory&id=${cate.idCategory}">Edit</a>
        </p>
    </c:if>
</c:forEach>
<h3>block</h3>
<c:forEach items="${category}" var="cate">
    <c:if test="${cate.status == 0}">
        <p>${cate.name}</p>
    </c:if>
</c:forEach>

<h1>find by name</h1>
<form action="CategoryServlet?action=findByNameCategory" method="post">
    <input type="text" name="nameSearch">
    <input type="submit" value="search">
</form>
</body>
</html>
