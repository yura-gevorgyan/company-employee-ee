<%@ page import="java.util.List" %>
<%@ page import="am.itspace.companyemployeeee.model.Employee" %><%--
  Created by IntelliJ IDEA.
  User: Yura
  Date: 1/13/2024
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Employee> employees = (List<Employee>) request.getAttribute("employees");%>
<html>
<style>
    table, th, td {
        border-collapse: collapse;
        border: 1px solid black;
        width: 30%
    }
</style>
<head>
    <title>Employee</title>
</head>
<body>
<div>
    <table>
        <tr>
            <th>NAME</th>
            <th>EMAIL</th>
            <th>COMPANY</th>
            <th>DELETE</th>
            <th>UPDATE</th>
        </tr>
        <%for (Employee employee : employees) { %>
            <tr>
                <td><%=employee.getName()%></td>
                <td><%=employee.getEmail()%></td>
                <td><%=employee.getCompany().getName()%></td>
                <td><a href="deleteEmployee?id=<%=employee.getId()%>">DELETE</a></td>
                <td><a href="updateEmployee?id=<%=employee.getId()%>">UPDATE</a></td>
            </tr>
        <%}%>
    </table>
</div>
<a href="addEmployee"><h3>ADD EMPLOYEE</h3></a>
</body>
</html>
