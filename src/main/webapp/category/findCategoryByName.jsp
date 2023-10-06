<%--
  Created by IntelliJ IDEA.
  User: Le Khanh
  Date: 10/6/2023
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${categoryByName}" var="cate">
    <p>${cate.name}</p>
</c:forEach>
</body>
</html>
