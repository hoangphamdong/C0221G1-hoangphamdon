<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="web/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="web/dataTables/DataTables/css/dataTables.bootstrap4.min.css"/>
</head>
<body>
<table border="1" cellpadding="5" id="tableStudent" class="table table-striped table-bordered" style="width: 100%">
    <thead>
    <caption><h2>List of Users</h2></caption>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
    </tr>
    </thead>
    <tr>
        <td><c:out value="${user.id}"/></td>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.country}"/></td>
    </tr>
</table>
<script src="web/jquery/jquery-3.6.0.min.map"></script>
<script src="web/dataTables/js/jquery.dataTables.min.js"></script>
<script src="web/dataTables/DataTables-1.10.24/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    })
</script>
</body>
</html>
