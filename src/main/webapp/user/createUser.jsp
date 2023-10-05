<%--
  Created by IntelliJ IDEA.
  User: Le Khanh
  Date: 10/5/2023
  Time: 8:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="UserServlet">Back to home</a></h3>
<form method="post">
    <input type="text" name="name" placeholder="Input name">
    <input type="number" name="age" placeholder="Input age">
    <input type="text" name="email" placeholder="Input email">
    <input type="text" name="address" placeholder="Input address">
    <input type="password" name="password" placeholder="Input password">
    <input type="hidden" name="status" value="1">
    <input type="submit" value="Create">
</form>
</body>
</html>
