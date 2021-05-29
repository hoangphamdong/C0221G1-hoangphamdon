<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${product.getName()}</td>
    </tr>
    <tr>
        <td>Amount: </td>
        <td>${product.getAmount()}</td>
    </tr>
    <tr>
        <td>Product Description: </td>
        <td>${product.getProductDescription()}</td>
    </tr>
    <tr>
        <td>Producer: </td>
        <td>${product.getProducer()}</td>
    </tr>
</table>
</body>
</html>
