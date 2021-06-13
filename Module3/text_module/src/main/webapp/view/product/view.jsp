<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
</head>
<body>
<div class="mt-5">
    <form action="/employee">
        <input class="btn btn-outline-success ml-3" type="submit" value="Back to list Customers"/>
    </form>
    <div style="margin-left: 150px">
        <h1>View Employee</h1>
        <p>${employee.getEmployeeName()}</p>
    </div>
    <table class="table table-striped" >
        <tr>
            <td>Employee Id: </td>
            <td>${employee.getEmployeeId()}</td>
        </tr>
        <tr>
            <td>Employee Name: </td>
            <td>${employee.getEmployeeName()}</td>
        </tr>
        <tr>
            <td>Employee Birthday: </td>
            <td>${employee.getEmployeeBirthday()}</td>
        </tr>
<%--        <tr>--%>
<%--            <td>Customer Gender : </td>--%>
<%--            <c:if test="${customer.getCustomerGender()==1}">--%>
<%--                <td><c:out value="Male"/></td>--%>
<%--            </c:if>--%>
<%--            <c:if test="${customer.getCustomerGender()==0}">--%>
<%--                <td><c:out value="Female"/></td>--%>
<%--            </c:if>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Customer Id Card :</td>--%>
<%--            <td>${customer.getCustomerIdCard()}</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Customer Phone : </td>--%>
<%--            <td>${customer.getCustomerPhone()}</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Customer Email :</td>--%>
<%--            <td>${customer.getCustomerEmail()}</td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Customer Address: </td>--%>
<%--            <td>${customer.getCustomerAddress()}</td>--%>
<%--        </tr>--%>
    </table>
</div>
</body>
</html>
