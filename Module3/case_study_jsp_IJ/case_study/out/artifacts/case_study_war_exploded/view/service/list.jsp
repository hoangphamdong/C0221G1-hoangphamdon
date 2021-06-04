<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="web/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
<div class="container mt-5">
    <div class="jumbotron text-center">
        <H1>List Service</H1>
    </div>

    <nav class="navbar navbar-expand-sm bg-dark navbar-dark my-3">
        <div class="collapse navbar-collapse justify-content-center" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customer">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link table table-hover" href="/service">Service</a>


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

<%--    <div class="d-flex">--%>
<%--        <form action="/">--%>
<%--            <input class="btn btn-outline-success ml-3" type="submit" value="Back Home"/>--%>
<%--        </form>--%>
<%--        <form action="/customer" style="margin-left: 150px;" class="d-flex">--%>
<%--            <input name="action" value="search" hidden>--%>
<%--            <input class="form-control me-2 d-flex" type="text" name="search" placeholder="Search" style="width: 200px">--%>
<%--            <button class="btn btn-success ml-3">Search</button>--%>
<%--        </form>--%>
<%--        <form action="/customer" >--%>
<%--            <input type="hidden" name="action" value="create">--%>
<%--            <input class="btn btn-outline-success" type="submit" value="ADD New Service"--%>
<%--                   style="margin-left: 350px"/>--%>
<%--        </form>--%>
<%--    </div>--%>

    <form action="/service" style="margin-left: 550px">
        <input type="hidden" name="action" value="create">
        <input class="btn btn-outline-success" type="submit" value="Create New Customer"
               style="margin-left: 350px"/>
    </form>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Service ID</th>
            <th scope="col">Service Name</th>
            <th scope="col">Service Description </th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="service" items="${services}">
            <tr>
                <td><c:out value="${service.getServiceId()}"/></td>
                <td><c:out value="${service.getServiceName()}"/></td>
                <td><c:out value="${service.getDescriptionOtherConvenience()}"/></td>
                <td>
                    <a class="btn btn-primary" href="/customer?action=edit&id=${service.getServiceId()}"
                       role="button">Edit</a>
                </td>
                <td>
                    <button type="button" class="btn btn-danger"
                            onclick="sendDataToModal('${service.getServiceId()}','${service.getServiceName()}')"
                            data-toggle="modal" data-target="#exampleModalLong">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle"
     aria-hidden="true">
    <form action="/customer?action=delete" method="post">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input hidden type="text" name="id" id="idStudent">
                    <p>You want delete customer name <span id="nameStudent"></span> ?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">OK</button>
                </div>
            </div>
        </div>
    </form>
</div>
<script>
    function sendDataToModal(id, name) {
        document.getElementById("idStudent").value = id;
        document.getElementById("nameStudent").innerText = name
    }
</script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
</body>
</html>
