<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2018/5/1
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/userlogining" method="post">
    <h1>hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh</h1>
    <table>
        <tr>
            <td><form:label path="username">Username</form:label></td>
            <td><form:input path="username" /></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:input path="password" /></td>
        </tr>
        <tr>
            <td><<input type="submit" value="Login">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
