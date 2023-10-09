<%--
  Created by IntelliJ IDEA.
  User: Le Khanh
  Date: 10/9/2023
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="box">
    <span class="borderLine"></span>
    <form action="/login" method="post">
        <h2>Sign In</h2>
        <div class="inputBox">
            <input type="text" name="username" required = "required">
            <span>Username</span>
            <i></i>
        </div>
        <div class="inputBox">
            <input type="password" name="password" required = "required">
            <span>Password</span>
            <i></i>
        </div>
        <div class="links">
            <a href="#">Forgot password</a>
            <a href="#">Signup</a>
        </div>
        <input type="submit" value="login">
    </form>
</div>
</body>
</html>
