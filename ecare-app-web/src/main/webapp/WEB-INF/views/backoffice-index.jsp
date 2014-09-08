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
<a href="${pageContext.servletContext.contextPath}/client/all">Clients</a><br/>
<a href="${pageContext.servletContext.contextPath}/tariff/all">Tariffs</a><br/>
<a href="${pageContext.servletContext.contextPath}/option/all">Options</a><br/>
</body>
</html>
