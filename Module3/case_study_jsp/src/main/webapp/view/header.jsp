<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/4/2021
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div style="margin-bottom:20px">
        <img src="view/img/backgrou.jpeg" height="350" width="1100"/>
    </div>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark my-3">
        <div class="collapse navbar-collapse justify-content-center" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customer">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/service">Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contract</a>
                </li>
            </ul>
            <form class="d-flex " style="margin-left: 400px">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success ml-3" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>
</body>
</html>
