<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            padding-top: 0px;
        }

        .form-control {
            margin-bottom: 10px;
        }

        .login-screen-bg {
            background-color: #EFEFEF;
        }
    </style>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="text-center">ADD New Contract</h1>
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm col-md-offset-4">
            <legend>
                <a href="http://hocwebgiare.com/"><i class="glyphicon glyphicon-globe"></i></a>
                Contract New!
            </legend>
            <form action="/contract?action=create" method="post" class="form" role="form">
                <label>Contract Start Date</label>
                <div class="row">
                    <div class="col-xs-4 col-md-4">
                        <input class="form-control" name="startDay" placeholder="Day" required="" autofocus="" type="text">
                    </div>

                    <div class="col-xs-4 col-md-4">
                        <input class="form-control" name="startMonth" placeholder="Month" required="" type="text">
                    </div>

                    <div class="col-xs-4 col-md-4">
                        <input class="form-control" name="startYear" placeholder="Year" required="" type="text">
                    </div>
                </div>
                <label>Contract End Date</label>
                <div class="row">
                    <div class="col-xs-4 col-md-4">
                        <input class="form-control" name="endDay" placeholder="Day" required="" autofocus="" type="text">
                    </div>

                    <div class="col-xs-4 col-md-4">
                        <input class="form-control" name="endMonth" placeholder="Month" required="" type="text">
                    </div>

                    <div class="col-xs-4 col-md-4">
                        <input class="form-control" name="endYear" placeholder="Year" required="" type="text">
                    </div>
                </div>
                <label>Contract Deposit</label>
                <input class="form-control" name="deposit" placeholder="Deposit" type="text">

                <label>Contract Total Money</label>
                <input class="form-control" name="total" placeholder="Total Money" type="text">

                <label>Employee ID</label>
                <input class="form-control" name="employeeId" placeholder="Employee ID" type="text">

                <label>Customer ID</label>
                <input class="form-control" name="customerId" placeholder="Customer ID" type="text">

                <label>Service ID</label>
                <input class="form-control" name="serviceId" placeholder="Service" type="text">
                <br>
                <br>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Add New</button>
            </form>
        </div>
    </div>
</div>
<div class="jumbotron text-center mt-3" style="margin-bottom:0">
    <p>@Hoàng Phạm Đông</p>
</div>
</body>
</html>
