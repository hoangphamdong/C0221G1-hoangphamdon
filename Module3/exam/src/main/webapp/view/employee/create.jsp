<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <style>
        .form-detail {
            padding-top: 50px;
            display: flex;
            align-items: flex-end;
        }

        .form-detail .control-custom {
            font-size: 14px;
            color: #868686;
            width: 97%;
        }

        .form-detail .group {
            position: relative;
        }

        .form-detail input {
            display: block;
            padding: 14px 0;
            border: none;
            border-bottom: 1px solid #d8d8d8;
            margin-top: 26px;
        }

        .form-detail textarea {
            display: block;
            border: none;
            border-bottom: 1px solid #d8d8d8;
        }

        .form-detail label {
            font-size: 14px;
            color: #868686;
            position: absolute;
            pointer-events: none;
            left: 0;
            top: 16px;
            transition: 0.2s ease all;
            -moz-transition: 0.2s ease all;
            -webkit-transition: 0.2s ease all;
        }

        input:focus,
        textarea:focus {
            outline: none;
        }

        .form-detail .bar {
            position: relative;
            display: block;
            width: 97%;
        }

        .bar::before,
        .bar::after {
            content:'';
            height: 2px;
            width: 0;
            bottom: 1px;
            position: absolute;
            background: #2cb680;
            transition: 0.2s ease all;
            -moz-transition: 0.2s ease all;
            -webkit-transition: 0.2s ease all;
        }

        .bar::before {
            left:50%;
        }

        .bar::after {
            right:50%;
        }

        .form-detail input:focus ~ .bar::before,
        .form-detail input:focus ~ .bar::after,
        .form-detail textarea:focus ~ .bar::before,
        .form-detail textarea:focus ~ .bar::after {
            width:50%;
        }
        .form-button {
            margin-top: 20px;
        }
        .form-detail input:focus ~ label,
        .form-detail input:valid ~ label,
        .form-detail textarea:focus ~ label,
        .form-detail textarea:valid ~ label {
            top: -16px;
            color: #2cb680;
        }

    </style>
</head>
<body>
<form action="/employee?action=create"method="post">
    <div class="container">
        <p class="text-primary">${massage}</p>
        <div class="form-detail">
            <div class="form-info col-md-6 col-xs-12">
                <div class="group">

                    <label>Employee Name:</label>
                    <br>
                    <input class="control-custom" type="text" required="required" name="name" value="${employeeInfo.getEmployeeName()}" />
                    <span class="bar"></span>
                    <p style="color: red">${msgName}</p>
                </div>
                <div class="group">
                    <label>Birthday:</label>
                    <br>
                    <input class="control-custom" type="date" required="required" name="birthday" value="${employeeInfo.getEmployeeBirthday()}"/>
                    <span class="bar"></span>

                </div>
                <div class="group">
                    <label>Employee ID Card:</label>
                    <br>
                    <input class="control-custom" type="text" required="required" name="card"/>
                    <span class="bar"></span>
                </div>
                <div class="group">
                    <label>Salary:</label>
                    <br>
                    <input class="control-custom" type="text" required="required" name="salary"/>
                    <span class="bar"></span>

                </div>
                <div class="group">
                    <label>Phone:</label>
                    <br>
                    <input class="control-custom" type="text" required="required" name="phone"/>
                    <span class="bar"></span>
                </div>

            </div>
            <div class="form-message col-md-6 col-xs-12">
                <div class="group">
                    <label>Email:</label>
                    <br>
                    <input class="control-custom" type="text" required="required" name="email"/>
                    <span class="bar"></span>
                    <p style="color: red">${msgEmail}</p>
                </div>
                <div class="group">
                    <label>Address:</label>
                    <br>
                    <input class="control-custom" type="text" required="required" name="address"/>
                    <span class="bar"></span>

                </div>
                <div class="group">
                    <label>Position:</label>
                    <br>
                    <br>

                    <select name="position">
                        <c:forEach var="position" items="${positions}">
                            <option  value="${position.getPositionId()}">${position.getPositionName()}</option>
                        </c:forEach>
                    </select>

                </div>
                <div class="group">
                    <label>Education Degree:</label>
                    <br>
                    <br>
                    <select name="education">
                        <c:forEach var="education" items="${educations}">
                            <option  value="${education.getEducationDegreeId()}">${education.getEducationDegreeName()}</option>
                        </c:forEach>
                    </select>

                </div>
                <div class="group">
                    <label>Division:</label>
                    <br>
                    <br>
                    <select name="division">
                        <c:forEach var="division" items="${divisions}">
                            <option  value="${division.getDivisionId()}">${division.getDivisionName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="group">
                    <label>UserName:</label>
                    <br>
                    <input class="control-custom" type="text" required="required" name="username"/>
                    <span class="bar"></span>
                </div>
            </div>
        </div>
        <div class="form-button text-center">
            <button class="btn btn-info" type="submit">ADD</button>
        </div>
    </div>
</form>
</body>
</html>
