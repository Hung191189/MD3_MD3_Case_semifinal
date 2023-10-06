<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/6/2023
  Time: 9:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="PostsServlet">Back to home</a></h3>
<form method="post">
    <input type="text" name="titlePosts" placeholder="Input title">
    <input type="text" name="content" placeholder="Input content">
    <input type="hidden" name="status" value="1">
    <input type="number" name="idUser" placeholder="Input id User">
    <input type="number" name="idCategory" placeholder="Input id Category">
    <input type="submit" value="Create">
</form>
</body>
</html>
