<%--
  Created by IntelliJ IDEA.
  User: Le Khanh
  Date: 10/5/2023
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
123
<c:forEach items="${userByName}" var="user">
    ${user.name}
</c:forEach>
</body>
</html>
