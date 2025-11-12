<%--
  Created by IntelliJ IDEA.
  User: Nguyen Quang Phu
  Date: 2025/11/12
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="login-container">
    <h2>Login</h2>
    <c:if test="${not empty message}"


    <script>
        alert("${mesage}");
    </script>
    <%--@elvariable id="userLogin" type=""--%>
    <form:form action="/auth/login" modelAttribute="userLogin" method="post">
        <form:input path="username" placeholder="Username"/>
        <form:errors path="username" cssClass="error"/>

        <form:input path="password" type="password" placeholder="Password"/>
        <form:errors path="password" cssClass="error"/>

        <button type="submit">Login</button>
    </form:form>
<div class="footer">
    <p>© 2025 Your Company</p>
</div>

</div>

</body>
</html>
