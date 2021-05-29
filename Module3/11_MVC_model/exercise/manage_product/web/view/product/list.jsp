<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Products</h1>
<p>
    <a href="/products?action=create">
        Create new Product
    </a>
</p>
<table border="1">
    <tr>
        <th>Name Product</th>
        <th>Amount</th>
        <th>Product Description</th>
        <th>Producer</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td><a href="/products?action=view$id=${product.getId()}">${product.getName()}</a></td>
        <td>${product.getAmount()}</td>
        <td>${product.getProductDescription()}</td>
        <td>${product.getProducer()}</td>
        <td><a href="/products?action=edit&id=${product.getId()}">edit</a></td>
        <td><a href="/products?action=delete&id=${product.getId()}">Delete</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
