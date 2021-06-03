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
    <a class="btn btn-primary" href="/customer" role="button">Back to list Customer</a>
    <div class="container">
        <c:if test="${message!=null}">
            <p>${message}</p>
        </c:if>
        <form method="post">
            <div class="form-group">
                <label for="formGroupExampleInput">Customer Id:</label>
                <input disabled type="text" value="${customer.customerId}" name="id" class="form-control"
                       id="formGroupExampleInput"
                >
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Customer Type Id:</label>
                <input type="text" value="${customer.getCustomerTypeId()}" name="type" class="form-control"
                       id="formGroupExampleInput2"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Customer Name:</label>
                <input type="text" class="form-control" name="name" value="${customer.customerName}"
                       id="formGroupExampleInput3"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Customer Birthday:</label>
                <input type="text" class="form-control" name="birthday" value="${customer.customerBirthday}"
                       id="formGroupExampleInput4"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Customer Gender:</label>
                <input type="text" class="form-control" name="gender" value="${customer.customerGender}"
                       id="formGroupExampleInput5"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Customer Id Card</label>
                <input type="text" class="form-control" name="card" value="${customer.customerIdCard}"
                       id="formGroupExampleInput6"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Customer Phone</label>
                <input type="text" class="form-control" name="phone" value="${customer.customerPhone}"
                       id="formGroupExampleInput7"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Customer Email</label>
                <input type="text" class="form-control" name="email" value="${customer.customerEmail}"
                       id="formGroupExampleInput8"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Customer Address</label>
                <input type="text" class="form-control" name="address" value="${customer.customerAddress}"
                       id="formGroupExampleInput9"
                       placeholder="Another input placeholder">
            </div>
            <div class="d-fex justify-content-center">
                <input class="btn btn-primary" type="submit" value="Update">
            </div>
        </form>
    </div>
</div>
</body>
</html>
