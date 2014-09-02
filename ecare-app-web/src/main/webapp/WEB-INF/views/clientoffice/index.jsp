<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client office</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script>
        $(document).ready(function() {
            update();
            $("#edit").click(function() {
                window.location.replace("/ecare-app/contract/edit?id=" + $("#contract-select").val());
            });
            $("#delete").click(function() {
                data = $("#contract-select").val();
                $.ajax({
                    url: "/ecare-app/contract/delete",
                    dataType: "json",
                    data: data,
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    type: "POST",
                    success: function(response) {
                        alert(response);
                        location.reload(true);
                    },
                    error : function(xhr, status, error) {
                        alert(xhr.responseText);
                    }
                });
            })
        });
        function update() {
            if (${empty(client.contracts)}) {
                $("#contract-select-div").css("display", "none");
            } else {
                $("#contract-select-div").css("display", "block");
            }
            var id = $("#contract-select").val();
            $.ajax({
                url: "${pageContext.servletContext.contextPath}/contract",
                data: "id=" + id,
                type: "GET",
                success : function(response) {
                    $("#contract").html(response);
                }
            })
        };
    </script>
</head>
<body>
<p><c:import url="../header.jsp"/></p>

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
        <td>${user.email}</td>
    </tr>
</table>
<a href="${pageContext.servletContext.contextPath}/clientoffice/edit">Edit you data</a>

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
</body>
</html>
