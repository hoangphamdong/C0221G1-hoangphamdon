<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Condiment Sandwich</h1>
<c:forEach items="${condiment}" var="eat">
<h3>${eat}</h3>
</c:forEach>
</body>
</html>
