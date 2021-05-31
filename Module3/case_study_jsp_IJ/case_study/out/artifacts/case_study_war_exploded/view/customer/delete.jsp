<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Customer</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<h1>Delete customer</h1>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Customer information</legend>
        <table class="table table-dark table-striped">
            <tr>
                <td>Name:</td>
                <td>${customer.getCustomerName()}</td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>${customer.getCustomerEmail()}</td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>${customer.getCustomerAddress()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete customer"></td>
                <td><a href="/customer?action">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
