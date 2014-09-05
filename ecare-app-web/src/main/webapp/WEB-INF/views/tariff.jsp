<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head></head>
<body>
<table>
    <tr>
        <td>Name:</td>
        <td><b>${tariff.name}</b></td>
    </tr>
    <tr>
        <td>Price:</td>
        <td><b>${tariff.price}</b></td>
    </tr>
</table>
<p>Options:</p>
<label>
    <select size="5">
        <c:forEach var="option" items="${tariff.options}">
            <option value="${option.id}">${option}</option>
        </c:forEach>
    </select>
</label>
<a href="${pageContext.servletContext.contextPath}/tariff/edit?id=${tariff.id}">Edit tariff</a>
</body>
</html>