<%--
  Created by IntelliJ IDEA.
  User: Danila
  Date: 13.08.2018
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
<html  lang="${language}">
<head>
    <title> Index </title>
</head>
<body>
<form action="index.jsp">
    <select id="language" name="language" onchange="submit()">
        <option value="eng" ${language == 'eng' ? 'selected' : ''}>English</option>
        <option value="rus" ${language == 'rus' ? 'selected' : ''}>Russian</option>
    </select>
</form>
<br>
<form action="/servlet" method="post">
    <input type="hidden" name="command" value="register">
    <p>Last name</p>
    <p><input type="text" name="lastName" size="30%"/></p>
    <p>First </p>
    <p><input type="text" name="firstName" size="30%"/></p>
    <p>Middle Name</p>
    <p><input type="text" name="middleName" size="30%"/></p>
    <p>Login </p>
    <p><input type="text" name="login" size="30%"/></p>

    <p><input type="submit" value="Register"/></p>
</form>
</body>
</html>
