<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script>
        $(document).ready(function() {
            update();
            $("#edit").click(function() {
                window.location.replace("/ecare-app/contract/edit?id=" + $("#contract-select").val());
            })
        });
        function update() {
            var id = $("#contract-select").val();
            $.ajax({
                url: "contract",
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
<a href="/ecare-app/clientoffice/edit">Edit you data</a>

<p>
    <label>
        <select id="contract-select" onchange="update()">
            <c:forEach var="item" items="${client.contracts}">
                <option value="${item.id}">${item.number}</option>
            </c:forEach>
        </select>
    </label>
</p>

<div id="contract">

</div>

<a id="edit" href="javascript:void(0);">Edit contract</a>
</body>
</html>
