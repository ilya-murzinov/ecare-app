<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/styles.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
    <script>
        $(function () {
            $("#deleteTariff").click(function () {
                $.ajax({
                    url: "${pageContext.request.contextPath}/tariff/delete",
                    data: "id=" + ${param.id},
                    type: "POST",
                    success: function (response) {
                        alert("OK");
                        history.go(-1);
                    },
                    error: function (xhr, status, error) {
                        alert(xhr.responseText);
                    }
                });
            })
        })
    </script>
</head>
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
<c:if test="${currentUser.admin}">
    <div>
        <a href="${pageContext.servletContext.contextPath}/tariff/edit?id=${tariff.id}">Edit tariff</a>
        <a id="deleteTariff" href="javascript:void(0);">Delete tariff</a>
    </div>
</c:if>
</body>
</html>