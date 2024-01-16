<%@ page import="java.util.List" %>
<%@ page import="am.itspace.companyemployeeee.model.Company" %><%--
  Created by IntelliJ IDEA.
  User: Yura
  Date: 1/13/2024
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Company> companies = (List<Company>) request.getAttribute("companies"); %>
<html>
<head>
    <title>ADD EMPLOYEE</title>
</head>
<body>
<form method="post" action="/addEmployee" enctype="multipart/form-data">
    NAME: <input type="text" name="name">
    <br>
    <br>
    E-MAIL: <input type="email" name="email">
    <br>
    <br>
    COMPANY:
    <select name="companyId">
        <%for (Company company : companies) {%>
        <option value="<%=company.getId()%>"><%=company.getName()%>
        </option>
        <%}%>
    </select><br>
    <input type="file" name="picture">
    <input type="submit" value="ADD">
</form>
</body>
</html>
