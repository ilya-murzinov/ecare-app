<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="com.github.ilyamurzinov.ecareapp.web.beans.ClientBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ClientBean clientBean = (ClientBean) request.getAttribute("clientBean");%>
<html>
<head>
    <title></title>
</head>
<body>
    This is client office.

    <table>
        <tr>
            <td>Name:</td>
            <td><%=clientBean.getName()%></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><%=clientBean.getLastname()%></td>
        </tr>
        <tr>
            <td>Passport:</td>
            <td><%=clientBean.getPassport()%></td>
        </tr>
        <tr>
            <td>Date of birth:</td>
            <td><%=clientBean.getDateOfBirth()%></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><%=clientBean.getAddress()%></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><%=clientBean.getEmail()%></td>
        </tr>
    </table>
</body>
</html>
