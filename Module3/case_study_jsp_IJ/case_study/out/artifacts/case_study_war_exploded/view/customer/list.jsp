<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
    <link rel="stylesheet" href="web/bootstrap/css/bootstrap.min.css"/>

</head>
<body>


<div class="container-fluid mt-5">
    <div class="jumbotron text-center">
        <H1>List Customer</H1>
    </div>
    <div class="d-flex">
        <form action="/">
            <input class="btn btn-outline-success ml-3" type="submit" value="Back Home"/>
        </form>
<%--        <form class="d-flex" action="/customer?action=search" method="get">--%>
<%--            <input name="search" class="form-control me-2" type="search" placeholder="Search" aria-label="Search" style="width: 150px">--%>
<%--            <button class="btn btn-outline-success" type="submit">Search</button>--%>
<%--        </form>--%>
        <form action="/customer" style="margin-left: 200px" class="d-flex">
            <input  name="action" value="search" hidden>
            <input class="form-control me-2 d-flex"  type="text" name="search" placeholder="Input Search">
            <button class="btn btn-success ml-3">Search</button>
        </form>
<%--        <form method="get" action="/customer&action=" class="d-flex " style="margin-left: 200px">--%>
<%--            <input class="form-control me-2 d-flex" type="search" placeholder="Search"--%>
<%--                   name="a"  style="width: 300px">--%>
<%--            <input class="btn btn-outline-success ml-3" type="submit" value="Search"/>--%>
<%--        </form>--%>
        <form action="/customer" style="margin-left: 100px">
            <input type="hidden" name="action" value="create">
            <input class="btn btn-outline-success" type="submit" value="Create New Customer"
                   style="margin-left: 350px"/>
        </form>
    </div>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Type</th>
            <th scope="col">Name</th>
            <th scope="col">Birthday</th>
            <th scope="col">Gender</th>
            <th scope="col">ID Card</th>
            <th scope="col">Phone</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
            <th scope="col">View</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td><c:out value="${customer.getCustomerId()}"/></td>
                <td><c:out value="${customer.getCustomerTypeName()}"/></td>
                <td><c:out value="${customer.getCustomerName()}"/></td>
                <td><c:out value="${customer.getCustomerBirthday()}"/></td>

                <c:if test="${customer.getCustomerGender()==1}">
                    <td><c:out value="Male"/></td>
                </c:if>
                <c:if test="${customer.getCustomerGender()==0}">
                    <td><c:out value="Female"/></td>
                </c:if>

                <td><c:out value="${customer.getCustomerIdCard()}"/></td>
                <td><c:out value="${customer.getCustomerPhone()}"/></td>
                <td><c:out value="${customer.getCustomerEmail()}"/></td>
                <td><c:out value="${customer.getCustomerAddress()}"/></td>
                <td>
                    <button type="button" class="btn btn-danger"
                            onclick="viewDataToModal('${customer.getCustomerId()}','${customer.getCustomerTypeName()}',
                                    '${customer.getCustomerName()}','${customer.getCustomerBirthday()}',
                                    '${customer.getCustomerGender()}','${customer.getCustomerIdCard()}',
                                    '${customer.getCustomerPhone()}','${customer.getCustomerEmail()}',
                                    '${customer.getCustomerAddress()}')"
                            data-toggle="modal" data-target="#exampleModalLong">
                        View
                    </button>
                </td>

                <td>
                    <a class="btn btn-primary" href="/customer?action=edit&id=${customer.getCustomerId()}"
                       role="button">Edit</a>
                </td>
                <td>
                    <button type="button" class="btn btn-danger"
                            onclick="sendDataToModal('${customer.getCustomerId()}','${customer.getCustomerName()}')"
                            data-toggle="modal" data-target="#exampleModalLong">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!-- Modal -->
<div class="modal fade" id="exampleModalLong2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle"
     aria-hidden="true">
    <form>
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle2">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Bạn có muốn xóa sình viên tên :<span id="customerId"></span></p>
                    <p>Bạn có muốn xóa sình viên tên :<span id="customerType"></span></p>
                    <p>Bạn có muốn xóa sình viên tên :<span id="customerName"></span></p>
                    <p>Bạn có muốn xóa sình viên tên :<span id="customerBirthday"></span></p>
                    <p>Bạn có muốn xóa sình viên tên :<span id="customerGender"></span></p>
                    <p>Bạn có muốn xóa sình viên tên :<span id="customerIdCard"></span></p>
                    <p>Bạn có muốn xóa sình viên tên :<span id="customerPhone"></span></p>
                    <p>Bạn có muốn xóa sình viên tên :<span id="customerEmail"></span></p>
                    <p>Bạn có muốn xóa sình viên tên :<span id="customerAddress"></span></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">OK</button>
                </div>
            </div>
        </div>
    </form>
</div>
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle"
     aria-hidden="true">
    <form action="/customer?action=delete" method="post">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <input hidden type="text" name="id" id="idStudent">
                    <p>Bạn có muốn xóa sình viên tên :<span id="nameStudent"></span></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">OK</button>
                </div>
            </div>
        </div>
    </form>
</div>
<script>
    function sendDataToModal(id, name) {
        document.getElementById("idStudent").value = id;
        document.getElementById("nameStudent").innerText = name
    }
    function viewDataToModal(id,typeName,name,birthday,gender,idCard,phone,email,address) {
        document.getElementById("customerId").innerText = id;
        document.getElementById("customerType").innerText = typeName;
        document.getElementById("customerName").innerText = name;
        document.getElementById("customerBirthday").innerText = birthday;
        document.getElementById("customerGender").innerText = gender;
        document.getElementById("customerIdCard").innerText = idCard;
        document.getElementById("customerPhone").innerText = phone;
        document.getElementById("customerEmail").innerText = email;
        document.getElementById("customerAddress").innerText = address;
    }
</script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>
</body>
</html>
