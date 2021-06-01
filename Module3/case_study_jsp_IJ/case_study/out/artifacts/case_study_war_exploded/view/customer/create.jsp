<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<body>
<h1>Create new customer</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/customer?action">Back to customer list</a>
</p>
<form method="post" class="mb-3">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Customer Id: </td>
                <td><input type="text" name="customerId" id="id"></td>
            </tr>
            <tr>
                <td>Customer Name: </td>
                <td><input type="text" name="customerName" id="name"></td>
            </tr>
            <tr>
                <td>Customer birthDay: </td>
                <td><input type="text" name="customerBirthDay" id="birthday"></td>
            </tr>
            <tr>
                <td>Customer Gander: </td>
                <td><input type="text" name="customerGander" id="gander"></td>
            </tr>
            <tr>
                <td>Customer Id card: </td>
                <td><input type="text" name="customerIdCard" id="idCard"></td>
            </tr>
            <tr>
                <td>Customer Phone: </td>
                <td><input type="text" name="customerPhone" id="phone"></td>
            </tr>
            <tr>
                <td>Customer Email: </td>
                <td><input type="text" name="customerEmail" id="email"></td>
            </tr>
            <tr>
                <td>Customer Type Id: </td>
                <td><input type="text" name="customerTypeId" id="typeId"></td>
            </tr>
            <tr>
                <td>Customer Address: </td>
                <td><input type="text" name="customerAddress" id="address"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
