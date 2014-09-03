<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/styles.css"/>
    <title></title>
</head>
<body>
    <p><c:import url="../header.jsp"/></p>
    <table border="1" class="clients">
        <c:forEach var="client" items="${clientList}">
            <tr>
                <td><b><a href="${pageContext.servletContext.contextPath}/client?id=${client.id}">${client.lastname}</a></b></td>
                <td>${client.name}</td>
                <td>${client.passport}</td>
                <td>${client.dateOfBirth}</td>
                <td>${client.address}</td>
                <td>${client.user.email}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
