<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<form:form modelAttribute="showSetting" action="/setting/create-setting" method="post">
    Languages:       <form:select path="language" items="${languages}"/> <br> <br>
    page Size: Show  <form:select path="pageSize" items="${size}"/> emails per page<br> <br>
    Spams filter:    <form:checkbox path="spamsFilter"/> Enable spans filter <br> <br>
    Signature:       <form:textarea path="signature" cols="30" rows="5"/><br> <br>
    <input type="submit" value="update">
</form:form>
</body>
</html>
