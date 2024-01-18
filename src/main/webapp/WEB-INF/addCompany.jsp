<%--
  Created by IntelliJ IDEA.
  User: Yura
  Date: 1/13/2024
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD COMPANY</title>
</head>
<body>
<form method="post" action="/company/add">
    NAME: <input type="text" name="name">
    <br>
    <br>
    ADDRESS: <input type="text" name="address">
    <br>
    <br>
    <input type="submit" value="ADD">
</form>
</body>
</html>
