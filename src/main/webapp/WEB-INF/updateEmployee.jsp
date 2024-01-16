<%@ page import="am.itspace.companyemployeeee.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="am.itspace.companyemployeeee.model.Company" %><%--
  Created by IntelliJ IDEA.
  User: Yura
  Date: 1/13/2024
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Employee employee = (Employee) request.getAttribute("employee"); %>
<% List<Company> companies = (List<Company>) request.getAttribute("companies"); %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form method="post" action="/updateEmployee">
    <input type="hidden" name="employeeId" value="<%=employee.getId()%>">
    NEW NAME:<input type="text" name="name" value="<%=employee.getName()%>">
    <br>
    <br>
    NEW EMAIL: <input type="email" name="email" value="<%=employee.getEmail()%>">
    <br>
    <br>
    NEW COMPANY:
    <select name="companyId">
        </option>
        <% for (Company company : companies) {%>
        <option value="<%=company.getId()%>"><%=company.getName()%>
        </option>
        <%}%>
    </select>
    <br>
    <br>
    <input type="submit" value="UPDATE">

</form>
</body>
</html>
