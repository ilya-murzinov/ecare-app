<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/styles.css"/>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
    <script>
        $(function () {
            if (${param.passwordChanged == "true"}) {
                $('#password-changed-message').css('display', 'block');
            }
        });
    </script>
</head>
<body>
<c:import url="header.jsp"/>

<div id="password-changed-message">
    <p>Password successfully changed!</p>
</div>

<p><a href="${pageContext.servletContext.contextPath}/login">Login</a></p>
</body>
</html>
