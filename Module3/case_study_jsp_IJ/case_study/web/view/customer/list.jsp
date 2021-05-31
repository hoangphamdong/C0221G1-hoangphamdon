<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="d-flex m-3">
    <div>
        <a href="/"><---Back Home</a>
    </div>
    <div class="mx-3">
        <a href="/customer?action=create">Create New Customer</a>
    </div>
    <div class="ml-3">
        <form class="form-inline my-2 my-lg-0 mr-5 "method="/customer?action=search">
            <input class="form-control mr-sm-2" type="search" name="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</div>

<div>
    <table class="table table-striped">
        <tr>
            <th>Customer Name</th>
            <th>Customer Birthday</th>
            <th>Customer Gander</th>
            <th>Customer ID Card</th>
            <th>Customer Phone</th>
            <th>Customer Email</th>
            <th>Customer Type ID</th>
            <th>Customer Address</th>
        </tr>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td><a href="/customer?action=view=${customer.getCustomerId()}"></a>${customer.getCustomerName()}</td>
                <td>${customer.getCustomerBirthday()}</td>
                <td>${customer.getCustomerGander()}</td>
                <td>${customer.getCustomerIdCard()}</td>
                <td>${customer.getCustomerPhone()}</td>
                <td>${customer.getCustomerEmail()}</td>
                <td>${customer.getCustomerTypeId()}</td>
                <td>${customer.getCustomerAddress()}</td>
                <td>
                    <a href="/customer?action=edit&id=${customer.getCustomerId()}">Edit</a>
                    <a href="/customer?action=delete&customerId=${customer.getCustomerId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
