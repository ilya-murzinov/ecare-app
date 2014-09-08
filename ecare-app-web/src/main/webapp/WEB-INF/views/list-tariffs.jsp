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
<c:import url="header.jsp"/>
<div class="main">
    <table border="1" class="clients">
        <tr>
            <td>Name</td>
            <td>Price</td>
            <td>Options</td>
        </tr>
        <c:forEach var="tariff" items="${tariffsList}">
            <tr>
                <td><b><a
                        href="${pageContext.servletContext.contextPath}/tariff?id=${tariff.id}">${tariff.name}</a></b>
                </td>
                <td>${tariff.price}</td>
                <td>
                    <c:forEach var="option" items="${tariff.options}">
                        ${option}<br/>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="${pageContext.servletContext.contextPath}/tariff/add">Add tariff</a>
</div>
</body>
</html>
