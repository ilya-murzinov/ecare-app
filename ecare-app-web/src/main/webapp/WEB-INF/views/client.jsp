<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client office</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
    <script>
        $(document).ready(function () {
            update();
            $("#edit").click(function () {
                window.location.replace("${pageContext.request.contextPath}/contract/edit?id=" + $("#contract-select").val());
            });
            $("#add").click(function() {
                window.location.replace("${pageContext.request.contextPath}/contract/add?id=${param.id}");
            });
            $("#delete").click(function () {
                data = $("#contract-select").val();
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
            })
        });
        $("#deleteClient").click(function() {
            alert();
            $.ajax({
                url: "${pageContext.request.contextPath}/client/delete",
                dataType: "json",
                data: ${param.id},
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                type: "POST",
                success: function (response) {
                    alert(response);
                    history.go(-1);
                },
                error: function (xhr, status, error) {
                    alert(xhr.responseText);
                }
            });
        });
        function update() {
            if (${empty(client.contracts)}) {
                $("#contract-select-div").css("display", "none");
            } else {
                $("#contract-select-div").css("display", "block");
            }
            var id = $("#contract-select").val();
            if (id == null) {
                return;
            }
            $.ajax({
                url: "${pageContext.servletContext.contextPath}/contract",
                data: "id=" + id,
                type: "GET",
                success: function (response) {
                    $("#contract").html(response);
                }
            })
        }
    </script>
</head>
<body>
<p><c:import url="header.jsp"/></p>

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
<c:if test="${currentUser.email == 'admin@mail.com'}">
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

    <c:if test="${currentUser.email == 'admin@mail.com'}">
        <a id="add" href="javascript:void(0);">Add contract</a>
    </c:if>
    <a id="edit" href="javascript:void(0);">Edit contract</a>
    <a id="delete" href="javascript:void(0);">Delete contract</a>
</div>
</c:if>

</body>
</html>
