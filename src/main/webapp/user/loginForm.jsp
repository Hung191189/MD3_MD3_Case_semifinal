<%--
  Created by IntelliJ IDEA.
  User: Le Khanh
  Date: 10/7/2023
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login User</h1>

<form method="post">
    <fieldset>
        <legend>Login Form</legend>
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="text" name="password" id="password"></td>
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
