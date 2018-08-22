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

<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : 'eng'}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />
<html  lang="${language}">
<head>
    <title> Index </title>
</head>
<body>
<form action="registration.jsp">
    <select id="language" name="language" onchange="submit()">
        <option value="eng" ${language == 'eng' ? 'selected' : ''}>English</option>
        <option value="rus" ${language == 'rus' ? 'selected' : ''}>Russian</option>
    </select>
</form>
<br>
<form action="${pageContext.request.contextPath}/servlet" method="post">
       <p>${pageContext.request.requestURL}</p>

    <input type="hidden" name="command" value="register">
    <input type="hidden" name="page" value="registration.jsp">
    

    <p>First name </p>
    <c:if test="${not empty requestScope.firstNameError}">
        <p><c:out value="${requestScope.firstNameError}"/> Error output</p>
    </c:if>
    <p><input type="text" name="firstName" value="${param.firstName}" size="30%"/></p>

    <p>Last name</p>
    <c:if test="${not empty requestScope.lastNameError}">
        <p><c:out value="${requestScope.lastNameError}"/> Error output</p>
    </c:if>
    <p><input type="text" name="lastName" value="${param.lastName}"size="30%"/></p>
    
    <p>Middle Name</p>
    <c:if test="${not empty requestScope.middleNameError}">
        <p><c:out value="${requestScope.middleNameError}"/> Error output</p>
    </c:if>
    <p><input type="text" name="middleName" value="${param.middleName}" size="30%"/></p>
    
    <p>Login </p>
    <c:if test="${not empty requestScope.loginError}">
        <p><c:out value="${requestScope.loginError}"/> Error output</p>
    </c:if>
    <p><input type="text" name="login" value="${param.login}" size="30%"/></p>

    <p><input type="submit" value="Register"/></p>
</form>


</body>
</html>
