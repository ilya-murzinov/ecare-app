<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<table>
    <tr>
        <td>Status:</td>
        <td>
            <b>
                <c:choose>
                    <c:when test="${contract.blocked && contract.blockedByEmployee}">
                        Blocked by employee
                    </c:when>
                    <c:when test="${contract.blocked && !contract.blockedByEmployee}">
                        Blocked
                    </c:when>
                    <c:otherwise>
                        Active
                    </c:otherwise>
                </c:choose>
            </b>
        </td>
    </tr>
    <tr>
        <td>Tariff:</td>
        <td><b>${contract.tariff}</b></td>
    </tr>
</table>
<p>Options:</p>
<label>
    <select size="5">
        <c:forEach var="option" items="${contract.options}">
            <option value="${option.id}">${option}</option>
        </c:forEach>
    </select>
</label>

</html>