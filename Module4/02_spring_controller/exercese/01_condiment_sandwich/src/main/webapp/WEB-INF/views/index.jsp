
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form action="/save" method="get">

    <td><input type="checkbox" name="condiment" value="Lettuce">Lettuce</td>
    <td><input type="checkbox" name="condiment" value="tomato">Tomato</td>
    <td><input type="checkbox" name="condiment" value="Mustard">Mustard</td>
    <td><input type="checkbox" name="condiment" value="Sprouts" >sprouts</td>
    <hr>
    <td><input type="submit" value="save"></td>
</form>
</body>
</html>
