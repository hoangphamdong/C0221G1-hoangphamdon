<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="web/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
<div class="mt-5">
    <form action="/employee">
        <input class="btn btn-outline-success ml-3" type="submit" value="Back to list Employees"/>
    </form>
    <div style="margin-left: 150px">
        <h1>View Employee</h1>
        <p>${employee.getEmployeeName()}</p>
    </div>
    <table class="table table-striped" >
        <tr>
            <td>Employee Id: </td>
            <td>${employee.getEmployee()}</td>
        </tr>
        <tr>
            <td>Employee Name: </td>
            <td>${employee.getEmployeeName()}</td>
        </tr>
        <tr>
            <td>Employee Birthday: </td>
            <td>${employee.getEmployeeBirthday()}</td>
        </tr>
        <tr>
            <td>Employee ID Card: </td>
            <td>${employee.getEmployeeIdCard()}</td>
        </tr>
        <tr>
            <td>Employee Salary: </td>
            <td>${employee.getEmployeeSalary()}</td>
        </tr>
        <tr>
            <td>Employee Phone :</td>
            <td>${employee.getEmployeePhone()}</td>
        </tr>
        <tr>
            <td>Employee Email : </td>
            <td>${employee.getEmployeeEmail()}</td>
        </tr>
        <tr>
            <td>Employee Address :</td>
            <td>${employee.getEmployeeAddress()}</td>
        </tr>
        <tr>
            <td>Position : </td>
            <td>${employee.getPosition()}</td>
        </tr>
        <tr>
            <td>Education Degree: </td>
            <td>${employee.getEducationDegree()}</td>
        </tr>
        <tr>
            <td>Division ID: </td>
            <td>${employee.getDivisionId()}</td>
        </tr>
    </table>
</div>
<div class="jumbotron text-center mt-3" style="margin-bottom:0">
    <p>@Hoàng Phạm Đông</p>
</div>
</body>
</html>
