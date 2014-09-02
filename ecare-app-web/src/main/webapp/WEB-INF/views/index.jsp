<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <p><c:import url="header.jsp"/></p>
    Hello!
    <p><a href="${pageContext.servletContext.contextPath}/clientoffice">For clients</a></p>
    <p><a href="${pageContext.servletContext.contextPath}/backoffice">For employees</a></p>
</body>
</html>
