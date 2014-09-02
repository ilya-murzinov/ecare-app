<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script>
        $(function () {
            $("#contract").submit(function () {
                var data = '{ "tariff": { "id":' + $("#tariff").val() + '}, "options": [';
                var opts = [];
                $("#options").find("option").each(function() {
                   opts.push('{"id":' + $(this).val() + "}");
                });
                data += opts.join(',') +  '] }';
                $.ajax({
                    url: $("#contract").attr("action"),
                    dataType: "json",
                    data: data,
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    type: "POST",
                    success: function(response) {
                        alert('OK');
                    },
                    error : function(xhr, status, error) {
                        alert(xhr.responseText);
                    }
                });
                return false;
            })
        });
    </script>
</head>
<body>
<p><c:import url="header.jsp"/></p>
<table>
    <tr>
        <td>Contract:</td>
        <td>${contract.number}</td>
    </tr>
</table>
<form:form id="contract" method="POST" modelAttribute="contract">
    <table>
        <tr>
            <td>Tariff</td>
            <td>
                <form:select path="tariff" id="tariff" items="${tariffs}" itemValue="id" itemLabel="name"/>
            </td>
        </tr>
    </table>
    <p>Options:</p>
    <label>
        <select id="options" multiple>
            <c:forEach var="option" items="${contract.options}">
                <option value="${option.id}">${option.name}</option>
            </c:forEach>
        </select>
    </label>
    <button type="submit">Ok</button>
</form:form>
</body>
</html>