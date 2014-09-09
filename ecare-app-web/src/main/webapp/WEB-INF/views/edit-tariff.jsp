<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/styles.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
    <script>
        $(function () {
            $("#tariff").submit(function () {
                var data = {
                    id: ${param.id},
                    name: $("#name").val(),
                    price: $("#price").val(),
                    options: []
                };
                $("#options").find("option").each(function () {
                    data.options.push({
                        id: $(this).val()
                    });
                });
                $.ajax({
                    url: "${pageContext.servletContext.contextPath}/tariff/edit",
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
            $("#removeRequiredOption").click(function () {
                $('#options').find('option:selected').remove();
            });
            $("#addRequiredOption").click(function () {
                $('#allOptions-div').css("display", "block");
            });
            $("#add").click(function () {
                $("#options").append($("#allOptions").find("option:selected"));
                $('#allOptions-div').css("display", "none");
            });
        });
    </script>
</head>
<body>
<form id="tariff">
    <table>
        <tr>
            <td>Name:</td>
            <td>
                <label>
                    <input id="name" type="text" value="${tariff.name}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Price:</td>
            <td>
                <label>
                    <input id="price" type="text" value="${tariff.price}"/>
                </label>
            </td>
        </tr>
    </table>
    <p>Options:</p>
    <label>
        <select id="options" size="5">
            <c:forEach var="option" items="${tariff.options}">
                <option value="${option.id}">${option}</option>
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
                <c:forEach var="option" items="${options}">
                    <option value="${option.id}">${option}</option>
                </c:forEach>
            </select>
        </label>
        <a id="add" href="javascript:void(0);">Add</a>
    </div>
    <button type="button" onclick="history.go(-1);">Cancel</button>
    <button type="submit">Save</button>
</form>
</body>
</html>