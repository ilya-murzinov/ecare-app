<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h2>Change your password</h2>
    <form:form method="POST" action="change-password" modelAttribute="passwordBean">
        <fieldset>
            <form:label path="currentPassword">Current password</form:label>
            <form:input path="currentPassword" />

            <form:label path="newPassword">New password</form:label>
            <form:password path="newPassword" />

            <form:label path="newPasswordRetyped">Re-type new password</form:label>
            <form:password path="newPasswordRetyped" />
        </fieldset>
        <p><button type="submit">Submit</button></p>
    </form:form>
</body>
</html>
