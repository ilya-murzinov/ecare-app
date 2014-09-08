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
            <td>Subscription fee</td>
            <td>Required options</td>
            <td>Incompatible options</td>
        </tr>
        <c:forEach var="option" items="${optionsList}">
            <tr>
                <td><b><a
                        href="${pageContext.servletContext.contextPath}/option/edit?id=${option.id}">${option.name}</a></b>
                </td>
                <td>${option.price}</td>
                <td>${option.subscriptionFee}</td>
                <td>
                    <c:forEach var="requiredOption" items="${option.requiredOptions}">
                        ${requiredOption}<br/>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach var="incompatibleOption" items="${option.incompatibleOptions}">
                        ${incompatibleOption}<br/>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="${pageContext.servletContext.contextPath}/option/add">Add option</a>
</div>
</body>
</html>
