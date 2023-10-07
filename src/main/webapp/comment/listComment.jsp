<%--
  Created by IntelliJ IDEA.
  User: Le Khanh
  Date: 10/6/2023
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/CommentServlet?action=createComment">Create new comment</a>
<c:forEach items="${commentList}" var="comment">
    <c:if test="${comment.status == 1}">
        <p>${comment.idComment},
            <a href="/CommentServlet?action=viewComment&id=${comment.idComment}">${comment.content}</a>, ${comment.dateComment}, ${comment.idUser}, ${comment.idPosts}, ${comment.status}
            <a href="/CommentServlet?action=deleteComment&id=${comment.idComment}">Delete</a>,
            <a href="/CommentServlet?action=updateComment&id=${comment.idComment}">Edit</a>
        </p>
    </c:if>
</c:forEach>
<h1>blocked</h1>
<c:forEach items="${commentList}" var="commnet">
    <c:if test="${commnet.status == 0}">
        <p>${commnet.idComment},
            <a href="/CommentServlet?action=viewComment&id=${commnet.idComment}">${commnet.content}</a>, ${comment.dateComment}, ${comment.idUser}, ${comment.idPosts}, ${comment.status}
            <a href="/CommentServlet?action=restoreComment&id=${commnet.idComment}">Restore</a>,

        </p>
    </c:if>
</c:forEach>
</body>
</html>
