<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/6/2023
  Time: 8:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
123
<a href="PostsServlet?action=createPosts">Creat new posts</a>
<c:forEach  var="i" begin="0" end="${postsList.size()-1}">
    <c:if test="${postsList.get(i).status == 1}">
        <p>${postsList.get(i).idPosts}, ${postsList.get(i).titlePosts}, ${postsList.get(i).content}, ${postsList.get(i).status}, ${postsList.get(i).datePosts}, ${userList.get(i).name}}</p>
        <a href="/PostsServlet?action=deletePosts&id=${postsList.get(i).idPosts}">Delete</a>,
        <a href="/PostsServlet?action=updatePosts&id=${postsList.get(i).idPosts}">Edit</a>
    </c:if>
</c:forEach>

<h2>Blocked</h2>
<c:forEach  var="i" begin="0" end="${postsList.size()-1}">
<c:if test="${postsList.get(i).status == 0}">
    <p>${postsList.get(i).idPosts}, ${postsList.get(i).titlePosts}, ${postsList.get(i).content}, ${postsList.get(i).status}, ${postsList.get(i).datePosts}, ${userList.get(i).name}}</p>
    <a href="/PostsServlet?action=restorePosts&id=${postsList.get(i).idPosts}">Restore</a>
</c:if>
</c:forEach>
</body>
</html>
