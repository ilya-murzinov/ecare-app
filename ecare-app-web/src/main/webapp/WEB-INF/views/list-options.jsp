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
        <td>Name</td>
        <td>Price</td>
        <td>Subscription fee</td>
    </tr>
    <c:forEach var="option" items="${optionsList}">
        <tr>
            <td><b><a
                    href="${pageContext.servletContext.contextPath}/option/edit?id=${option.id}">${option.name}</a></b>
            </td>
            <td>${option.price}</td>
            <td>${option.subscriptionFee}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="${pageContext.servletContext.contextPath}/option/add">Add option</a>
</body>
</html>
