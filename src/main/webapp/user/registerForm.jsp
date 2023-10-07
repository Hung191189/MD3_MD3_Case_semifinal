<%--
  Created by IntelliJ IDEA.
  User: Le Khanh
  Date: 10/7/2023
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Register User</h1>

<form method="post">
    <fieldset>
        <legend>Customer Form</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name""></td>
            </tr>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="userName" id="userName"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="text" name="password" id="password"></td>
            </tr>
            <tr>
                <td>RePassword:</td>
                <td><input type="text" name="rePassword" id="rePassword"></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Submit">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
