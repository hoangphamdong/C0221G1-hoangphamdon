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
        <form action="/employee">
            <input class="btn btn-outline-success" type="submit" value="<=Back To list Customer"/>
        </form>
    </div>
    <h1 class="text-center">ADD New Employee</h1>
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm col-md-offset-4">
            <legend>
                <a href="http://hocwebgiare.com/"><i class="glyphicon glyphicon-globe"></i></a>
                Employee New!
            </legend>
            <form action="/employee?action=create" method="post" class="form" role="form">
                <label>Employee Name</label>
                <input class="form-control" name="name" placeholder="Employee Name" type="text">
                <label>Employee birthday</label>
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
                <label>Employee ID Card</label>
                <input class="form-control" name="idCard" placeholder="ID Card" type="text">

                <label>Employee Salary</label>
                <input class="form-control" name="salary" placeholder="salary" type="text">

                <label>Employee Phone</label>
                <input class="form-control" name="phone" placeholder="phone" type="text">

                <label>Employee Email</label>
                <input class="form-control" name="email" placeholder="Email" type="text">

                <label>Employee Address</label>
                <input class="form-control" name="address" placeholder="Address" type="text">

                <label>Position</label>
                <br>
                <label class="radio-inline">
                    <input name="position" id="inlineCheckbox3" value="leTan" type="radio">
                    Lễ tân
                </label>
                <label class="radio-inline">
                    <input name="position" id="inlineCheckbox4" value="phucVu" type="radio">
                    Phục Vụ
                </label>
                <label class="radio-inline">
                    <input name="position" id="inlineCheckbox5" value="chuyenVien" type="radio">
                    Chuyên Viên
                </label>
                <br>
                <label class="radio-inline">
                    <input name="position" id="inlineCheckbox6" value="giamSat" type="radio">
                    Giám Sát
                </label>
                <label class="radio-inline">
                    <input name="position" id="inlineCheckbox7" value="quanLy" type="radio">
                    Quản Lý
                </label>
                <label class="radio-inline">
                    <input name="position" id="inlineCheckbox8" value="giamDoc" type="radio">
                    Giám Đốc
                </label>
                <br>
                <label>Education Degree</label>
                <br>
                <label class="radio-inline">
                    <input name="education" id="inlineCheckbox9" value="trungCap" type="radio">
                    Trung Cấp
                </label>
                <label class="radio-inline">
                    <input name="education" id="inlineCheckbox10" value="caoDang" type="radio">
                    Cao Đẵng
                </label>
                <br>
                <label class="radio-inline">
                    <input name="education" id="inlineCheckbox11" value="daiHoc" type="radio">
                    Đại Học
                </label>
                <label class="radio-inline">
                    <input name="education" id="inlineCheckbox12" value="sauDaiHoc" type="radio">
                    Sau Đại Học
                </label>
                <br>
                <label>Division</label>
                <br>
                <label class="radio-inline">
                    <input name="division" id="inlineCheckbox13" value="marketing" type="radio">
                    Sale-Marketing
                </label>
                <label class="radio-inline">
                    <input name="division" id="inlineCheckbox14" value="hanhChinh" type="radio">
                    Hành Chính
                </label>
                <br>
                <label class="radio-inline">
                    <input name="division" id="inlineCheckbox15" value="phucVu" type="radio">
                    Phục Vụ
                </label>
                <label class="radio-inline">
                    <input name="division" id="inlineCheckbox16" value="quanLy" type="radio">
                    Quản Lý
                </label>
                <br>
                <label>User Name</label>
                <input class="form-control" name="user" placeholder="User Name" type="text">
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
