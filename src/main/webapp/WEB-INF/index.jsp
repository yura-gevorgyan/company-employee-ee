<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello World</title>
</head>
<% if (session.getAttribute("msg") != null) { %>
<span style="color: red"><%=session.getAttribute("msg")%></span>
<%}%>
<body>
<form method="post" action="/login">
    E-MAIL: <input type="email" name="email"><br>
    PASSWORD: <input type="password" name="password"><br>
    <input type="submit" name="login"><br>
</form>
<a href="/register">REGISTER</a>
</body>
</html>
