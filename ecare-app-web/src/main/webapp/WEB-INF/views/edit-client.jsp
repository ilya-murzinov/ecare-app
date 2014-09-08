<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/styles.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
</head>
<body>
<p><c:import url="header.jsp"/></p>

<form:form id="client" method="POST" modelAttribute="client">
    <fieldset>
        <table>
            <tr>
                <td>Name:</td>
                <td><form:input path="name"/></td>
                <td><form:errors path="name" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><form:input path="lastname"/></td>
                <td><form:errors path="lastname" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Passport:</td>
                <td><form:input path="passport"/></td>
                <td><form:errors path="passport" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Date of birth:</td>
                <td><form:input path="dateOfBirth"/></td>
                <td><form:errors path="dateOfBirth" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><form:input path="address"/></td>
                <td><form:errors path="address" cssClass="error"/></td>
            </tr>
        </table>
        <button type="button" onclick="history.go(-1);">Cancel</button>
        <button type="submit">Save</button>
    </fieldset>
</form:form>
</body>
</html>
