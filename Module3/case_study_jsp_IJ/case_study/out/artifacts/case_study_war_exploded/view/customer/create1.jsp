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
<div class="container m-5">
    <div>
        <form action="/customer" >
            <input class="btn btn-outline-success" type="submit" value="<=Back To list Customer"/>
        </form>
    </div>
    <h1 class="text-center">ADD New Customer</h1>
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm col-md-offset-4">
            <legend>
                <a href="http://hocwebgiare.com/"><i class="glyphicon glyphicon-globe"></i></a>
                Customer New!
            </legend>
            <form action="/customer?action=create" method="post" class="form" role="form">
                <label>Customer Name</label>
                <input class="form-control" name="name" placeholder="Customer Name" type="text">
                <label>Customer birthday</label>
<%--                <div>--%>
<%--                    <input type="date">--%>
<%--                </div>--%>
                <div class="row">
                    <div class="col-xs-4 col-md-4">
                        <input class="form-control" name="day" placeholder="Day" required="" autofocus="" type="text">
                    </div>

                    <div class="col-xs-4 col-md-4">
                        <input class="form-control" name="month" placeholder="Month" required="" type="text">
                    </div>

                    <div class="col-xs-4 col-md-4">
                        <input class="form-control" name="year" placeholder="Year" required="" type="text">
                    </div>
                </div>
                <label>Customer gender</label>
                <br>
                <label class="radio-inline">
                    <input name="sex" id="inlineCheckbox1" value="male" type="radio">
                    Nam
                </label>
                <label class="radio-inline">
                    <input name="sex" id="inlineCheckbox2" value="female" type="radio">
                    Nữ
                </label>
                <br>
                <label>Customer ID Card</label>
                <input class="form-control" name="idCard" placeholder="ID Card" type="text">

                <label>Customer Phone</label>
                <input class="form-control" name="phone" placeholder="Phone" type="text">

                <label>Customer Email</label>
                <input class="form-control" name="email" placeholder="Email" type="text">

                <label>Customer Address</label>
                <input class="form-control" name="address" placeholder="Address" type="text">

                <label>Customer Type</label>
                <br>
                <select name="typeCustomer">
                </select>
                <label class="radio-inline">
                    <input name="type" id="inlineCheckbox3" value="diamond" type="radio">
                    Diamond
                </label>
                <label class="radio-inline">
                    <input name="type" id="inlineCheckbox4" value="platinium" type="radio">
                    Platinium
                </label>
                <label class="radio-inline">
                    <input name="type" id="inlineCheckbox5" value="gold" type="radio">
                    Gold
                </label>
                <br>
                <label class="radio-inline">
                    <input name="type" id="inlineCheckbox6" value="silver" type="radio">
                    Silver
                </label>
                <label class="radio-inline">
                    <input name="type" id="inlineCheckbox7" value="member" type="radio">
                    Member
                </label>
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
