<%--
  Created by IntelliJ IDEA.
  User: Nguyen Quang Phu
  Date: 2025/11/12
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>

</head>
<body>
<h2>Register</h2>
<%--@elvariable id="userRegisterDTO" type=""--%>
<form:form action="/auth/register" method="post" modelAttribute="userRegisterDTO" enctype="multipart/form-data">
    <form:input path="username" placeholder="Username"/>
    <form:errors path="username" cssClass="error"/>
    <form:input path="password" placeholder="Password"/>
    <form:errors path="password" cssClass="error"/>
    <form:input path="email" placeholder="Email"/>
    <form:errors path="email" cssClass="error"/>
    <label for="avatar">Avatar</label>
    <form:input path="avatar" type="file"/>
    <form:errors path="avatar" cssClass="error"/>
    <button type="submit">Register</button>
</form:form>
</body>
</html>
