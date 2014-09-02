<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script>
        $(function() {
            if (${user.email == "nobody"}) {
                $("#links").css("display", "none");
            }
        });
    </script>
</head>
You are logged in as <b>${user.email}</b>
<div id="links">
    <a href="/ecare-app/logout">Logout</a>
    <a href="/ecare-app/change-password">Change password</a>
</div>
</html>
