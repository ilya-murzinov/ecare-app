<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/styles.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script>
        $(function() {
            $("#user").submit(function() {
                var data = {
                    user: {
                        email: $("#email").val(),
                        password: $("#password").val()
                    }
                };
                $.ajax({
                    url: "${pageContext.servletContext.contextPath}/user/add?id=${param.id}",
                    dataType: "json",
                    data: JSON.stringify(data),
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    method: "POST",
                    success: function(response) {
                        alert(response);
                    },
                    error: function (xhr, status, error) {
                        alert("response: " + xhr.responseText + "\nerror: " + error);
                    }
                });
                return false;
            });
        })
    </script>
</head>
<body>
<p><c:import url="header.jsp"/></p>

<form:form id="user" method="POST" modelAttribute="user">
    <fieldset>
        <table>
            <tr>
                <td>E-mail:</td>
                <td><form:input id="email" path="email"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:password id="password" path="password"/></td>
            </tr>
        </table>
        <button type="button" onclick="history.go(-1);">Cancel</button>
        <button type="submit">Save</button>
    </fieldset>
</form:form>
</body>
</html>
