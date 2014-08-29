<%@ page import="com.github.ilyamurzinov.ecareapp.common.domain.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%User user = (User) request.getAttribute("userBean");%>
<html>
You are logged in as <b><%=user.getEmail()%></b>
<a href="/ecare-app/logout">Logout</a>
</html>
