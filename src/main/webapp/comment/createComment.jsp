<%--
  Created by IntelliJ IDEA.
  User: Le Khanh
  Date: 10/6/2023
  Time: 4:48 PM
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
    <input type="text" name="content" placeholder="Input content">
    <input type="hidden" name="idUser" value="<c:out value='${user.idUser}' />"/>
    <input type="hidden" name="idUser" value="<c:out value='${posts.idPosts}' />"/>
    <input type="hidden" name="status" value="1">
    <input type="submit" value="Create">
</form>
</body>
</html>
