<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="web/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
<div class="form-group m-5">
    <form action="/customer">
        <button class="btn btn-success" type="submit">Back Home</button>
    </form>
</div>
<div class="container my-5 bg-primary text-white" style="width: 600px ">
    <div>
        <H1>ADD NEW EMPLOYEE</H1>
    </div>

    <form method="post" action="/employee?action=create">
        <div class="container mt-5" style="width: 600px">
            <div class="form-group">
                <div class="form-row">
                    <div class="form-group">
                        <label>Employee Id</label>
                        <input type="text" class="form-control" placeholder="Employee Id" name="id">
                    </div>
                    <div class="form-group ml-3">
                        <label>Employee Name</label>
                        <input type="text" class="form-control" placeholder="Employee Name" name="name">
                    </div>
                    <div class="form-group">
                        <label>Employee Birthday</label>
                        <input type="text" class="form-control" placeholder="Employee Birthday"
                               name="birthday">
                    </div>
                    <div class="form-group ml-3">
                        <label>Employee ID Card</label>
                        <input type="text" class="form-control" placeholder="ID Card" name="idCard">
                    </div>
                    <div class="form-group">
                        <label>Salary</label>
                        <input type="text" class="form-control" placeholder="salary" name="salary">
                    </div>
                    <div class="form-group ml-3">
                        <label>Employee Phone</label>
                        <input type="text" class="form-control" placeholder="Phone " name="phone">
                    </div>
                    <div class="form-group">
                        <label>Employee Email</label>
                        <input type="text" class="form-control" placeholder="Email" name="email">
                    </div>
                    <div class="form-group ml-3">
                        <label>Employee Address</label>
                        <input type="text" class="form-control" placeholder="Address" name="address">
                    </div>
                    <div class="form-group">
                        <label>Position</label>
                        <input type="text" class="form-control" placeholder="Position" name="position">
                    </div>
                    <div class="form-group ml-3">
                        <label>Education Degree</label>
                        <input type="text" class="form-control" placeholder="degree" name="degree">
                    </div>
                    <div class="form-group">
                        <label>Division Id</label>
                        <input type="text" class="form-control" placeholder="Division" name="division">
                    </div>
                    <div class="form-group ml-3">
                        <label>User Name</label>
                        <input type="text" class="form-control" placeholder="User Name" name="user">
                    </div>
                    <%--            <div class="form-group ml-3">--%>
                    <%--                <label>Customer Type</label>--%>
                    <%--                <select class="form-control ">--%>
                    <%--                    <option value="" selected>Diamond</option>--%>
                    <%--                    <option value="">Platinium</option>--%>
                    <%--                    <option value="">Gold</option>--%>
                    <%--                    <option value="">Silver</option>--%>
                    <%--                    <option value="">Member</option>--%>
                    <%--                </select>--%>

                </div>
                <div class="form-group my-3">
                    <button class="btn btn-success" type="submit">ADD</button>
                </div>
            </div>

        </div>
    </form>

</div>
</div>
</body>
</html>
