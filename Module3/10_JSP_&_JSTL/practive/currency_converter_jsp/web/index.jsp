<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<form method="post" action="/converter">
    <h2>Currency Converter</h2>
    <label>Rate</label><br>
    <input type="text" name="rate" placeholder="RATE"value="22000" ><br>
    <label>USD</label><br>
    <input type="text" name="usd" placeholder="USD"><br>
    <input type="submit" id="submit" value="Converter">
</form>
</body>
</html>
