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
        <H1>ADD NEW CUSTOMER</H1>
    </div>

    <form method="post" action="/customer?action=create">
        <div class="container mt-5" style="width: 600px">
            <div class="form-group">
                <div class="form-row">
                    <div class="form-group">
                        <label>Customer Name</label>
                        <input type="text" class="form-control" placeholder="Customer Name" name="name">
                    </div>
                    <div class="form-group ml-3">
                        <label>Customer Birthday</label>
                        <input type="text" class="form-control" placeholder="Customer Birthday" name="birthday">
                    </div>
                    <div class="form-group">
                        <label>Customer Gender</label>
                        <input type="text" class="form-control" placeholder="Gender : 1 Name 0 Nữ"
                               name="gender">
                    </div>
                    <div class="form-group ml-3">
                        <label>Customer ID Card</label>
                        <input type="text" class="form-control" placeholder="ID Card" name="idCard">
                    </div>
                    <div class="form-group">
                        <label>Customer Phone</label>
                        <input type="text" class="form-control" placeholder="Phone" name="phone">
                    </div>
                    <div class="form-group ml-3">
                        <label>Customer Email</label>
                        <input type="text" class="form-control" placeholder="Email " name="email">
                    </div>
                    <div class="form-group">
                        <label>Customer Address</label>
                        <input type="text" class="form-control" placeholder="Address" name="address">
                    </div>
                    <div class="form-group ml-3">
                        <label>Customer type</label>
                        <input type="text" class="form-control" placeholder="Address" name="type">
                    </div>
                                <div class="form-group ml-3">
<%--                                    <label>Customer Type</label>--%>
<%--                                    <select class="form-control ">--%>
<%--                                        <option value="" selected>Diamond</option>--%>
<%--                                        <option value="">Platinium</option>--%>
<%--                                        <option value="">Gold</option>--%>
<%--                                        <option value="">Silver</option>--%>
<%--                                        <option value="">Member</option>--%>
<%--                                    </select>--%>

                </div>
                <div class="form-group">
                    <button class="btn btn-success" type="submit">ADD</button>
                </div>
            </div>

        </div>
    </form>

</div>
</div>
</body>
</html>
