<%@ page import="java.util.List" %>
<%@ page import="am.itspace.companyemployeeee.model.Company" %><%--
  Created by IntelliJ IDEA.
  User: Yura
  Date: 1/13/2024
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%List<Company> companies = (List<Company>) request.getAttribute("companies");%>
<html>
<style>
    table, td, th {
        border-collapse: collapse;
        border: 1px solid black;
        width: 30%;
    }
</style>
<head>
    <title>Company</title>
</head>
<body>
<h2>All Companies</h2>
<div>
    <table>
        <tr>
            <th>NAME</th>
            <th>ADDRESS</th>
            <th>DELETE</th>
        </tr>
        <%for (Company company : companies) { %>
        <tr>
            <td><%=company.getName()%>
            </td>
            <td><%=company.getAddress()%>
            </td>
            <td><a href="/deleteCompany?id=<%=company.getId()%>">DELETE</a></td>
        </tr>
        <%}%>
    </table>
</div>
<a href="/addCompany"><h3>ADD COMPANY</h3></a>
<a href="/home">BACK</a>
</body>
</html>
