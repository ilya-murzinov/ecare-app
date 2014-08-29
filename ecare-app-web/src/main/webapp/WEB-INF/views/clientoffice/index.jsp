<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="com.github.ilyamurzinov.ecareapp.common.domain.Client" %>
<%@ page import="com.github.ilyamurzinov.ecareapp.common.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Client client = (Client) request.getAttribute("clientBean");%>
<% User user = (User) request.getAttribute("userBean");%>
<html>
<head>
    <title></title>
</head>
<body>
    <p><c:import url="../header.jsp"/></p>

    This is client office.

    <table>
        <tr>
            <td>Name:</td>
            <td><%=client.getName()%></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><%=client.getLastname()%></td>
        </tr>
        <tr>
            <td>Passport:</td>
            <td><%=client.getPassport()%></td>
        </tr>
        <tr>
            <td>Date of birth:</td>
            <td><%=client.getDateOfBirth()%></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><%=client.getAddress()%></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><%=user.getEmail()%></td>
        </tr>
    </table>
</body>
</html>
