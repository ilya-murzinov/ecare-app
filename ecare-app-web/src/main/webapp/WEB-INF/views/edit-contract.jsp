<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/styles.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
    <script>
        $(function () {
            updateOptions();
            $("#contract").submit(function () {
                var data = {
                    id: ${contract.id},
                    blocked: $("#blocked").prop('checked'),
                    tariff: {
                        id: $("#tariff").val()
                    },
                    options: []
                };

                $("#options").find("option").each(function () {
                    data.options.push({
                        id: $(this).val()
                    });
                });
                $.ajax({
                    url: $("#contract").attr("action"),
                    dataType: "json",
                    data: JSON.stringify(data),
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    type: "POST",
                    success: function (response) {
                        alert("OK");
                        history.go(-1);
                    },
                    error: function (xhr, status, error) {
                        alert("response: " + xhr.responseText + "\nerror: " + error);
                    }
                });
                return false;
            });
            $("#removeOption").click(function () {
                $('#options').find('option:selected').remove();
            });
            $("#addOption").click(function () {
                $('#allOptions-div').css("display", "block");
                $(this).find('#add').click(function () {
                    $('#allOptions-div').css("display", "none");
                });
            });
            $("#add").click(function () {
                $("#options").append($("#allOptions").find("option:selected"));
            });
        });
        function updateOptions() {
            var tariffId = $("#tariff").val();
            if (tariffId) {
                $.ajax({
                    url: "${pageContext.servletContext.contextPath}/tariff/options?id=" + tariffId,
                    type: "GET",
                    success: function (response) {
                        $("#allOptions").html(response);
                    },
                    error: function (xhr, status, error) {
                        alert("response: " + xhr.responseText + "\nerror: " + error);
                    }
                });
            }
        }
    </script>
</head>
<body>
<p><c:import url="header.jsp"/></p>
<c:choose>
    <c:when test="${!(contract.blocked && contract.blockedByEmployee) || currentUser.admin}">
        <form:form action="edit" id="contract" method="POST" modelAttribute="contract">
            <table>
                <tr>
                    <td>Contract:</td>
                    <td>${contract.number}</td>
                </tr>
                <tr>
                    <td><form:checkbox id="blocked" path="blocked" label="Blocked"/></td>
                </tr>
                <tr>
                    <td>Tariff</td>
                    <td>
                        <form:select path="tariff" id="tariff" items="${tariffs}" itemValue="id" itemLabel="name"
                                     onchange="updateOptions();"/>
                    </td>
                </tr>
            </table>
            <p>Options:</p>
            <label>
                <select id="options" size="5">
                    <c:forEach var="option" items="${contract.options}">
                        <option value="${option.id}">${option.name}</option>
                    </c:forEach>
                </select>
            </label>

            <div id="optionOperations">
                <a id="addOption" href="javascript:void(0);">Add option</a>
                <a id="removeOption" href="javascript:void(0);">Remove option</a>
            </div>
            <div id="allOptions-div" class="allOptions">
                <label>
                    <select id="allOptions" size="5">

                    </select>
                </label>
                <a id="add" href="javascript:void(0);">Add</a>
            </div>
            <button type="submit">Save</button>
        </form:form>
    </c:when>
    <c:otherwise>
        <b>Contract is blocked</b>
    </c:otherwise>
</c:choose>
<button type="button" onclick="history.go(-1);">Cancel</button>
</body>
</html>