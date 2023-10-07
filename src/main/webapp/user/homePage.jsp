<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>JSP - Hello World</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="PostsServlet">Post</a>--%>
<%--<a href="UserServlet">User</a>--%>
<%--<a href="CategoryServlet">Category</a>--%>
<%--<a href="CommentServlet">Comment</a>--%>
<%--<p>${name}</p>--%>
<%--</body>--%>
<%--</html>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/homePage.css">
</head>
<body>
<div class="header">
    <a href="UserServlet?action=login" class="login"> <span >Login</span></a>
    <a href="UserServlet?action=createUser" class="login"> <span >Register</span></a>
</div>
<div class="menu">
    <ul>
        <li><a href="#">Long</a>
            <ul>
                <li><a href="#">Information</a></li>
                <li><a href="#">Posts</a></li>
                <li><a href="#">Picture</a></li>
                <li><a href="#">Video</a></li>
                <li><a href="#">Friends</a></li>
            </ul>
        </li>
        <li><a href="#">Sem 2 </a>
            <ul>
                <li><a href="#">Cloud Computing</a></li>
                <li><a href="#">APJ - I</a></li>
                <li><a href="#">APJ - II</a></li>
                <li><a href="#">APJ - III</a></li>
                <li><a href="#">eProject</a></li>
            </ul>
        </li>
        <li><a href="#">Sem 3</a>
            <ul>
                <li><a href="#">Cloud Computing</a></li>
                <li><a href="#">APJ - I</a></li>
                <li><a href="#">APJ - II</a></li>
                <li><a href="#">APJ - III</a></li>
                <li><a href="#">eProject</a></li>
            </ul>
        </li>
        <li><a href="#">Sem 3</a>
            <ul>
                <li><a href="#">Cloud Computing</a></li>
                <li><a href="#">APJ - I</a></li>
                <li><a href="#">APJ - II</a></li>
                <li><a href="#">APJ - III</a></li>
                <li><a href="#">eProject</a></li>
            </ul>
        </li>
        <li><a href="#">Sem 3</a>
            <ul>
                <li><a href="#">Cloud Computing</a></li>
                <li><a href="#">APJ - I</a></li>
                <li><a href="#">APJ - II</a></li>
                <li><a href="#">APJ - III</a></li>
                <li><a href="#">eProject</a></li>
            </ul>
        </li>
        <li><a href="#">Sem 3</a>
            <ul>
                <li><a href="#">Cloud Computing</a></li>
                <li><a href="#">APJ - I</a></li>
                <li><a href="#">APJ - II</a></li>
                <li><a href="#">APJ - III</a></li>
                <li><a href="#">eProject</a></li>
            </ul>
        </li>
        <li><a href="#">Sem 3</a>
            <ul>
                <li><a href="#">Cloud Computing</a></li>
                <li><a href="#">APJ - I</a></li>
                <li><a href="#">APJ - II</a></li>
                <li><a href="#">APJ - III</a></li>
                <li><a href="#">eProject</a></li>
            </ul>
        </li>
        <li><a href="#">Sem 3</a>
            <ul>
                <li><a href="#">Cloud Computing</a></li>
                <li><a href="#">APJ - I</a></li>
                <li><a href="#">APJ - II</a></li>
                <li><a href="#">APJ - III</a></li>
                <li><a href="#">eProject</a></li>
            </ul>
        </li>
        <li><a href="#">Sem 3</a>
            <ul>
                <li><a href="#">Cloud Computing</a></li>
                <li><a href="#">APJ - I</a></li>
                <li><a href="#">APJ - II</a></li>
                <li><a href="#">APJ - III</a></li>
                <li><a href="#">eProject</a></li>
            </ul>
        </li>
        <li><a href="#">Sem 3</a>
            <ul>
                <li><a href="#">Cloud Computing</a></li>
                <li><a href="#">APJ - I</a></li>
                <li><a href="#">APJ - II</a></li>
                <li><a href="#">APJ - III</a></li>
                <li><a href="#">eProject</a></li>
            </ul>
        </li>
        <li><a href="#">Sem 3</a>
            <ul>
                <li><a href="#">Cloud Computing</a></li>
                <li><a href="#">APJ - I</a></li>
                <li><a href="#">APJ - II</a></li>
                <li><a href="#">APJ - III</a></li>
                <li><a href="#">eProject</a></li>
            </ul>
        </li>
        <li><a href="#">Sem 3</a>
            <ul>
                <li><a href="#">Cloud Computing</a></li>
                <li><a href="#">APJ - I</a></li>
                <li><a href="#">APJ - II</a></li>
                <li><a href="#">APJ - III</a></li>
                <li><a href="#">eProject</a></li>
            </ul>
        </li>
    </ul>
</div>
<div id="carouselExampleIndicators1" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="5"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="6"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="7"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="8"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="9"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="10"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="11"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbuYbYN3BRJiVjesWIckR_DKBivVXmtiuoyC3I7lg8iET1ngWLA-qBOh-LfXvS4082sMw&usqp=CAU" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="src/main/webapp/img/Screenshot 2023-10-07 121119.png" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="C:\Users\Le Khanh\IdeaProjects\MD3_Case_semifinal\img\Screenshot 2023-10-07 121119.png" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="img/Screenshot 2023-10-07 121119.png" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="img/z4761337000538_5d599efff33beb013bc0de20f5e24ac9.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="img/z4761337000538_5d599efff33beb013bc0de20f5e24ac9.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="img/z4761337000538_5d599efff33beb013bc0de20f5e24ac9.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="img/z4761337000538_5d599efff33beb013bc0de20f5e24ac9.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="img/z4761337000538_5d599efff33beb013bc0de20f5e24ac9.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="img/z4761337000538_5d599efff33beb013bc0de20f5e24ac9.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="img/z4761337000538_5d599efff33beb013bc0de20f5e24ac9.jpg" class="d-block w-100" alt="...">
        </div>
        <div class="carousel-item">
            <img src="img/z4761337000538_5d599efff33beb013bc0de20f5e24ac9.jpg" class="d-block w-100" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-target="#carouselExampleIndicators" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-target="#carouselExampleIndicators" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </button>
</div>
<div class="row">
    <div class="col-2">left</div>
    <div class="col-8">
        <div class="row">
            <c:forEach items="${postsList}" var="posts">
                <div class="col-xl-3 col-lg-4 mt-3">
                    <div class="card">
                        <a href="" style="text-decoration: none"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbuYbYN3BRJiVjesWIckR_DKBivVXmtiuoyC3I7lg8iET1ngWLA-qBOh-LfXvS4082sMw&usqp=CAU" class="card-img-top" alt="..."></a>
                        <div class="card-body">
                            <a href="" style="text-decoration: none">  <h4>${posts.content}</h4></a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <a href="PostsServlet">dfghj</a>
    <div class="col-2">right</div>
</div>
</div>
</body>
</html>