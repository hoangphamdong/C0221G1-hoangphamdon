<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting Product</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
    <a href="/products">Back to products list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td>${product.getName()}</td>
            </tr>
            <tr>
                <td>Amount:</td>
                <td>${product.getAmount()}</td>
            </tr>
            <tr>
                <td>Product Description:</td>
                <td>${product.getProductDesciption()}</td>
            </tr>
            <tr>
                <td>Producer:</td>
                <td>${product.getProducer()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete customer"></td>
                <td><a href="/customers">Back to products list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
