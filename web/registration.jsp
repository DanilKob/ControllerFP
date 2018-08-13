<%--
  Created by IntelliJ IDEA.
  User: Danila
  Date: 13.08.2018
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/servlet" method="post">
    <input type="hidden" name="<command>" value="register">
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
