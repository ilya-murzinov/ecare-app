<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/styles.css"/>
</head>
<div class="header">
    <table>
        <tr>
            <td>You are logged in as <b>${currentUser.email}</b></td>
            <td><a href="${pageContext.servletContext.contextPath}">Home</a></td>
            <td>
                <c:if test="${currentUser.email != 'nobody'}">
                <div id="links">
                    <a href="${pageContext.servletContext.contextPath}/logout">Logout</a>
                    <a href="${pageContext.servletContext.contextPath}/change-password">Change password</a>
                </div>
                </c:if>
            </td>
        </tr>
    </table>
</div>
</html>
