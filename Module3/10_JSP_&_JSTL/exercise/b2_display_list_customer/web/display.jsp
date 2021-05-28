<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/27/2021
  Time: 5:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<html>
<head>
    <title>Title</title>
    <style>
        img {
            height: 100px;
            width: 100px;
        }
    </style>
</head>
<body>
<div>
    <h1>Student List</h1>
    <table class="table table-dark">
        <tr>
            <th>Name</th>
            <th>Birth date</th>
            <th>Address</th>
            <th>Img</th>
        </tr>
        <c:forEach items="${customer}" var="customer">
            <tr>
                <td><c:out value="${customer.nameCustomer}"></c:out></td>
                <td><c:out value="${customer.birthDateCustomer}"></c:out></td>
                <td><c:out value="${customer.addressCustomer}"></c:out></td>
                <td><img src="${customer.imgCustomer}"></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
