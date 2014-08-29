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
            <table>
                <tr>
                    <td><form:label path="currentPassword">Current password</form:label></td>
                    <td><form:password path="currentPassword" /></td>
                    <td><form:errors path="currentPassword"/></td>
                </tr>
                <tr>
                    <td><form:label path="newPassword">New password</form:label></td>
                    <td><form:password path="newPassword" /></td>
                    <td><form:errors path="newPassword"/></td>
                </tr>
                <tr>
                    <td><form:label path="newPasswordRetyped">Re-type new password</form:label></td>
                    <td><form:password path="newPasswordRetyped" /></td>
                    <td><form:errors path="newPasswordRetyped"/></td>
                </tr>
            </table>
        </fieldset>
        <p><button type="submit">Submit</button></p>
    </form:form>
</body>
</html>
