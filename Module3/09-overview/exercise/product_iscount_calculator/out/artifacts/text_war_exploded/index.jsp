<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/26/2021
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      .product-discount {
        width: 350px;
        height: 370px;
        border: 1px solid #ccc;
      }
      .product-discount textarea, .product-discount input {
        margin: 5px;
        padding: 5px;
      }
    </style>
  </head>
  <body>
  <div class="product-discount">
    <h1>Product Discount Calculator</h1>
    <form action="/discount" method="post">
      <textarea name="description" placeholder="description"></textarea>
      <input type="number" size="30" name="price" placeholder="price"/>
      <input type="number" size="30" name="discount" placeholder="discount"/>
      <input type="submit" name="calculate" value="Calculate Discount"/>
    </form>
  </div>
  </body>
</html>
