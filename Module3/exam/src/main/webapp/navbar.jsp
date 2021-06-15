
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark my-3 ">
        <div class="collapse navbar-collapse justify-content-center" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/employee">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customer">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/service">Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/contract">Contract</a>
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
