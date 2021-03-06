<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client office</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
    <script>
        $(function () {
            update();
            $("#edit").click(function () {
                window.location.assign("${pageContext.request.contextPath}/contract/edit?id=" + $("#contract-select").val());
            });
            $("#delete").click(function () {
                var data = $("#contract-select").val();
                $.ajax({
                    url: "${pageContext.request.contextPath}/contract/delete",
                    dataType: "json",
                    data: data,
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    type: "POST",
                    success: function (response) {
                        location.reload(true);
                    },
                    error: function (xhr, status, error) {
                        alert(xhr.responseText);
                    }
                });
            });
            $("#deleteClient").click(function () {
                $.ajax({
                    url: "${pageContext.request.contextPath}/client/delete",
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
            });
            $("#blockClient").click(function () {
                $.ajax({
                    url: "${pageContext.request.contextPath}/user/update",
                    data: JSON.stringify({
                        id: ${client.user.id},
                        enabled: false
                    }),
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    type: "POST",
                    success: function (response) {
                        alert("OK");
                        location.reload();
                    },
                    error: function (xhr, status, error) {
                        alert(xhr.responseText);
                    }
                });
            });
            $("#unblockClient").click(function () {
                $.ajax({
                    url: "${pageContext.request.contextPath}/user/update",
                    data: JSON.stringify({
                        id: ${client.user.id},
                        enabled: true
                    }),
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    type: "POST",
                    success: function (response) {
                        alert("OK");
                        location.reload();
                    },
                    error: function (xhr, status, error) {
                        alert(xhr.responseText);
                    }
                });
            });
        });
        function update() {
            var id = $("#contract-select").val();
            if (id == null) {
                return;
            }
            $.ajax({
                url: "${pageContext.servletContext.contextPath}/contract?id=" + id,
                type: "GET",
                success: function (response) {
                    $("#contract").html(response);
                }
            })
        }
    </script>
</head>
<body>
<c:import url="header.jsp"/>

<table>
    <tr>
        <td>Name:</td>
        <td>${client.name}</td>
    </tr>
    <tr>
        <td>Last name:</td>
        <td>${client.lastname}</td>
    </tr>
    <tr>
        <td>Passport:</td>
        <td>${client.passport}</td>
    </tr>
    <tr>
        <td>Date of birth:</td>
        <td>${client.dateOfBirth}</td>
    </tr>
    <tr>
        <td>Address:</td>
        <td>${client.address}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${client.user.email}</td>
    </tr>
</table>
<a href="${pageContext.servletContext.contextPath}/client/edit?id=${param.id}">Edit personal data</a>
<c:if test="${currentUser.admin}">
    <c:if test="${client.user != null && client.user.enabled}">
        <a id="blockClient" href="javascript:void(0);">Block client</a>
    </c:if>
    <c:if test="${client.user != null && !client.user.enabled}">
        <a id="unblockClient" href="javascript:void(0);">Unblock client</a>
    </c:if>
    <a id="deleteClient" href="javascript:void(0);">Delete client</a>
</c:if>

<c:if test="${!empty(client.contracts)}">
    <div id="contract-select-div">
        <table>
            <tr>
                <td>Contract:</td>
                <td>
                    <label>
                        <select id="contract-select" onchange="update()">
                            <c:forEach var="item" items="${client.contracts}">
                                <option value="${item.id}">${item.number}</option>
                            </c:forEach>
                        </select>
                    </label>
                </td>
            </tr>
        </table>

        <div class="contract" id="contract">

        </div>

        <a id="edit" href="javascript:void(0);">Edit contract</a>
        <a id="delete" href="javascript:void(0);">Delete contract</a>
    </div>
</c:if>
<c:if test="${currentUser.admin}">
    <a id="add" href="${pageContext.request.contextPath}/contract/add?id=${param.id}">Add contract</a>
</c:if>

</body>
</html>
