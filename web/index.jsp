<%--
  Created by IntelliJ IDEA.
  User: Danila
  Date: 08.08.2018
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language :'eng' }" scope="session" />
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
<a href="registration.jsp"> Register </a>
<a href="login.jsp"> LogIn </a>
</body>
</html>
