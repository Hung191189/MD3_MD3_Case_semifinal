<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/7/2023
  Time: 2:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="ImageServlet">Back to home</a></h3>
<form method="post">
    <input type="text" name="url" placeholder="Input url">
    <input type="text" name="titleImage" placeholder="Input title">
    <input type="number" name="idPosts" placeholder="Input idPosts">
    <input type="hidden" name="status" value="1">
    <input type="submit" value="Create">
</form>
</body>
</html>
