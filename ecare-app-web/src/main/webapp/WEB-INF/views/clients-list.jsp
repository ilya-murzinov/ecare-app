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
<p><c:import url="header.jsp"/></p>
<table border="1" class="clients">
    <tr>
        <td>Last name</td>
        <td>Name</td>
        <td>Passport</td>
        <td>Date of birth</td>
        <td>Address</td>
        <td>E-mail</td>
    </tr>
    <c:forEach var="client" items="${clientList}">
        <tr>
            <td><b><a href="${pageContext.servletContext.contextPath}/client?id=${client.id}">${client.lastname}</a></b></td>
            <td>${client.name}</td>
            <td>${client.passport}</td>
            <td>${client.dateOfBirth}</td>
            <td>${client.address}</td>
            <c:choose>
                <c:when test="${client.user.email != null}">
                    <td>${client.user.email}</td>
                </c:when>
                <c:when test="${client.user.email == null}">
                    <td><a href="${pageContext.servletContext.contextPath}/user/add?id=${client.id}">Register</a></td>
                </c:when>
            </c:choose>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="${pageContext.servletContext.contextPath}/client/add">Add client</a>
</body>
</html>
