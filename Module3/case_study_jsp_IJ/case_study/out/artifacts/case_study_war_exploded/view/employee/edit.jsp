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
    <a class="btn btn-primary" href="/employee" role="button">Back to list Employee</a>
    <div class="container">
        <c:if test="${message!=null}">
            <p>${message}</p>
        </c:if>
        <form method="post" action="/employee?action=edit">
            <div class="form-group">
                <label for="formGroupExampleInput">Employee ID</label>
                <input readonly type="text" value="${employee.getEmployee()}" name="id" class="form-control"
                       id="formGroupExampleInput">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Employee Name</label>
                <input type="text" value="${employee.getEmployeeName()}" name="name" class="form-control"
                       id="formGroupExampleInput17"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Employee Birthday</label>
                <input type="text" value="${employee.getEmployeeBirthday()}" name="birthday" class="form-control"
                       id="formGroupExampleInput2"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Employee Id Card</label>
                <input type="text" class="form-control" name="idCard" value="${employee.getEmployeeIdCard()}"
                       id="formGroupExampleInput3"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Employee Salary</label>
                <input type="text" class="form-control" name="salary" value="${employee.getEmployeeSalary()}"
                       id="formGroupExampleInput4"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Employe Phone</label>
                <input type="text" class="form-control" name="phone" value="${employee.getEmployeePhone()}"
                       id="formGroupExampleInput5"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Employee Email</label>
                <input type="text" class="form-control" name="email" value="${employee.getEmployeeEmail()}"
                       id="formGroupExampleInput6"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Employee Address</label>
                <input type="text" class="form-control" name="address" value="${employee.getEmployeeAddress()}"
                       id="formGroupExampleInput7"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Employee Position</label>
                <input type="text" class="form-control" name="position" value="${employee.getPosition()}"
                       id="formGroupExampleInput8"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Education Degree</label>
                <input type="text" class="form-control" name="degree" value="${employee.getEducationDegree()}"
                       id="formGroupExampleInput9"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">Division</label>
                <input type="text" class="form-control" name="division" value="${employee.getDivisionId()}"
                       id="formGroupExampleInput10"
                       placeholder="Another input placeholder">
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput2">User Name</label>
                <input type="text" class="form-control" name="user" value="${employee.getUserName()}"
                       id="formGroupExampleInput11"
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
