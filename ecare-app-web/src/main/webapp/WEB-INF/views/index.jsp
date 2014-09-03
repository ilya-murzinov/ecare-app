<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="ecare-app-web/src/main/webapp/WEB-INF/css/styles.css"/>
    <link rel="stylesheet" type="text/css" href="ecare-app-web/src/main/webapp/WEB-INF/css/styles.css"/>
    <title></title>
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script>
        $(function () {
            if (${param.passwordChanged == "true"}) {
                $('#password-changed-message').css('display', 'block');
            }
        });
    </script>
</head>
<body>
<p><c:import url="header.jsp"/></p>

<div id="password-changed-message">
    <p>Password successfully changed!</p>
</div>

<p><a href="${pageContext.servletContext.contextPath}/clientoffice">For clients</a></p>

<p><a href="${pageContext.servletContext.contextPath}/backoffice">For employees</a></p>
</body>
</html>
