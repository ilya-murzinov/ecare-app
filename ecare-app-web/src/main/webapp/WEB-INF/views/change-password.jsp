<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/styles.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
    <script>
        $(document).ready(function () {
            $('#passwordBean').submit(
                    function (event) {
                        var currentPassword = $('#currentPassword').val();
                        var newPassword = $('#newPassword').val();
                        var newPasswordRetyped = $('#newPasswordRetyped').val();
                        var data = {
                            currentPassword: currentPassword,
                            newPassword: newPassword,
                            newPasswordRetyped: newPasswordRetyped
                        };
                        $.ajax({
                            url: $("#sampleForm").attr("action"),
                            data: JSON.stringify(data),
                            type: "POST",

                            success: function (response) {
                                window.location.replace("${pageContext.servletContext.contextPath}?passwordChanged=true");
                            },
                            error: function (xhr, status, error) {
                                alert(xhr.responseText);
                            }
                        });
                        return false;
                    });
        });
    </script>
</head>
<body>
<h2>Change your password</h2>
<form:form method="POST" id="passwordBean" modelAttribute="passwordBean">
    <fieldset>
        <table>
            <tr>
                <td><form:label path="currentPassword">Current password</form:label></td>
                <td><form:password path="currentPassword"/></td>
                <td><form:errors path="currentPassword" cssClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="newPassword">New password</form:label></td>
                <td><form:password path="newPassword"/></td>
                <td><form:errors path="newPassword" cssClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="newPasswordRetyped">Re-type new password</form:label></td>
                <td><form:password path="newPasswordRetyped"/></td>
                <td><form:errors path="newPasswordRetyped" cssClass="error"/></td>
            </tr>
            <tr>
                <td colspan="3"><form:errors path="valid" cssClass="error"/></td>
            </tr>
        </table>
    </fieldset>
    <p>
        <button type="submit">Submit</button>
    </p>
</form:form>
</body>
</html>
