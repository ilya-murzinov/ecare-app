<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/styles.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.10.2.js"></script>
    <script>
        $(function() {
            $("#option").submit(function() {
                var data = {
                    id: ${param.id},
                    name: $("#name").val(),
                    price: $("#price").val(),
                    subscriptionFee: $("#subscriptionFee").val()
                };
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
    <button type="button" onclick="history.go(-1);">Cancel</button>
    <button type="submit">Save</button>
</form>
<a id="deleteOption" href="javascript:void(0);">Delete option</a>
</body>
</html>