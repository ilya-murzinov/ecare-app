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
            $("#option").submit(function () {
                var data = {
                    id: ${param.id},
                    name: $("#name").val(),
                    price: $("#price").val(),
                    subscriptionFee: $("#subscriptionFee").val(),
                    requiredOptions: [],
                    incompatibleOptions: []
                };
                $("#requiredOptions").find("option").each(function () {
                    data.requiredOptions.push({ id: $(this).val() });
                });
                $("#incompatibleOptions").find("option").each(function () {
                    data.incompatibleOptions.push({ id: $(this).val()});
                });
                $.ajax({
                    url: "${pageContext.servletContext.contextPath}/option/edit",
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
                $("#allRequiredOptions-select").append($("#requiredOptions").find("option:selected"));
                $('#requiredOptions').find('option:selected').remove();
            });
            $("#addRequiredOption").click(function () {
                $('#allRequiredOptions-div').css("display", "block");
            });
            $("#addRequired").click(function () {
                $("#requiredOptions").append($("#allRequiredOptions-select").find("option:selected"));
                $('#allRequiredOptions-select').find('option:selected').remove();
            });

            $("#removeIncompatibleOption").click(function () {
                $("#allIncompatibleOptions-select").append($("#incompatibleOptions").find("option:selected"));
                $('#incompatibleOptions').find('option:selected').remove();
            });
            $("#addIncompatibleOption").click(function () {
                $('#allIncompatibleOptions-div').css("display", "block");
            });
            $("#addIncompatible").click(function () {
                $("#incompatibleOptions").append($("#allIncompatibleOptions-select").find("option:selected"));
                $('#allIncompatibleOptions-select').find('option:selected').remove();
            });

            $("#deleteOption").click(function () {
                $.ajax({
                    url: "${pageContext.request.contextPath}/option/delete",
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
        });
    </script>
</head>
<body>
<form id="option">
    <table>
        <tr>
            <td>Name:</td>
            <td>
                <label>
                    <input id="name" type="text" value="${option.name}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Price:</td>
            <td>
                <label>
                    <input id="price" type="text" value="${option.price}"/>
                </label>
            </td>
        </tr>
        <tr>
            <td>Subscription fee:</td>
            <td>
                <label>
                    <input id="subscriptionFee" type="text" value="${option.subscriptionFee}"/>
                </label>
            </td>
        </tr>
    </table>
    <table>
        <tr>
            <td>
                <p>Required options:</p>
                <label>
                    <select id="requiredOptions" size="5">
                        <c:forEach var="option" items="${option.requiredOptions}">
                            <option value="${option.id}">${option}</option>
                        </c:forEach>
                    </select>
                </label>
            </td>
            <td>
                <p>Incompatible options:</p>
                <label>
                    <select id="incompatibleOptions" size="5">
                        <c:forEach var="option" items="${option.incompatibleOptions}">
                            <option value="${option.id}">${option}</option>
                        </c:forEach>
                    </select>
                </label>
            </td>
        </tr>
        <tr>
            <td>
                <div id="requiredOptionOperations">
                    <a id="addRequiredOption" href="javascript:void(0);">Add required option</a>
                    <a id="removeRequiredOption" href="javascript:void(0);">Remove required option</a>
                </div>
            </td>
            <td>
                <div id="optionOperations">
                    <a id="addIncompatibleOption" href="javascript:void(0);">Add incompatible option</a>
                    <a id="removeIncompatibleOption" href="javascript:void(0);">Remove incompatible option</a>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div id="allRequiredOptions-div" class="allOptions">
                    <label>
                        <select id="allRequiredOptions-select" size="5">
                            <c:forEach var="option" items="${optionsList}">
                                <option value="${option.id}">${option}</option>
                            </c:forEach>
                        </select>
                    </label>
                    <a id="addRequired" href="javascript:void(0);">Add</a>
                </div>
            </td>
            <td>
                <div id="allIncompatibleOptions-div" class="allOptions">
                    <label>
                        <select id="allIncompatibleOptions-select" size="5">
                            <c:forEach var="option" items="${optionsList}">
                                <option value="${option.id}">${option}</option>
                            </c:forEach>
                        </select>
                    </label>
                    <a id="addIncompatible" href="javascript:void(0);">Add</a>
                </div>
            </td>
        </tr>
    </table>
    <button type="button" onclick="history.go(-1);">Cancel</button>
    <button type="submit">Save</button>
</form>
<a id="deleteOption" href="javascript:void(0);">Delete option</a>
</body>
</html>