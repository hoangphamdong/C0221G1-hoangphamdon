<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1>Edit User</h1>
    <a class="btn btn-primary" href="/employee" role="button">Back to list Customer</a>
    <div class="container">
        <c:if test="${message!=null}">
            <p>${message}</p>
        </c:if>
        <form method="post">
            <div class="form-group">
                <label for="formGroupExampleInput">Product Id:</label>
                <input disabled type="text" value="${product.getProductId()}" name="id" class="form-control"
                       id="formGroupExampleInput"
                >
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Product Name:</label>
                <input type="text" value="${product.getProductName()}" name="name" class="form-control"
                       id="formGroupExampleInput2"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Price:</label>
                <input type="text" class="form-control" name="birthday" value="${product.getProductPrice()}"
                       id="formGroupExampleInput3"
                       placeholder="Another input placeholder">
            </div>

            <div class="form-group">
                <label for="formGroupExampleInput2">Quantity:</label>
                <input type="text" class="form-control" name="gender" value="${product.getProductQuantity()}"
                       id="formGroupExampleInput5"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Color</label>
                <input type="text" class="form-control" name="card" value="${product.getProductColor()}"
                       id="formGroupExampleInput6"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Description</label>
                <input type="text" class="form-control" name="phone" value="${product.getProductDescription()}"
                       id="formGroupExampleInput7"
                       placeholder="Another input placeholder">
            </div>
<%--            <div class="form-group">--%>
<%--                <label for="formGroupExampleInput2">Customer Email</label>--%>
<%--                <input type="text" class="form-control" name="email" value="${customer.customerEmail}"--%>
<%--                       id="formGroupExampleInput8"--%>
<%--                       placeholder="Another input placeholder">--%>
<%--            </div>--%>
<%--            <div class="form-group">--%>
<%--                <label for="formGroupExampleInput2">Customer Address</label>--%>
<%--                <input type="text" class="form-control" name="address" value="${customer.customerAddress}"--%>
<%--                       id="formGroupExampleInput9"--%>
<%--                       placeholder="Another input placeholder">--%>
<%--            </div>--%>
            <div class="d-fex justify-content-center">
                <input class="btn btn-primary" type="submit" value="Update">
            </div>
        </form>
    </div>
</div>
</body>
</html>
