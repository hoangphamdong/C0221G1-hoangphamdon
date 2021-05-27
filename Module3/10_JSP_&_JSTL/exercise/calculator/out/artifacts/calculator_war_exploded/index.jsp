<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 5/27/2021
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/calculator" method="post">
    <label>First operand:</label>
    <input type="text" name="first" placeholder="First operand"><br>
    <label>Operator:</label>
    <select name="op">
        <option value="Addition">Addition</option>
        <option value="Subtraction">Subtraction</option>
        <option value="Multiplication">Multiplication</option>
        <option value="Division">Division</option>
    </select><br>
    <label>Second operand</label>
    <input type="text" name="second" placeholder="Second operand"><br>
    <input type="submit" value="Calculate" id="calculate"/>
    <h1><c:out value="${result}"></c:out></h1>
    <h1><c:out value="${massage}"></c:out></h1>
</form>

</body>
</html>
