<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 2018/4/30
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>User select</h1>
<table>
    <tr>
        <th>username</th>
        <th>password</th>
    </tr>
<c:forEach items="${requestScope.listusers}" var="users">
    <tr>
        <td>${users.username}</td>
        <td>${users.password}</td>
    </tr>
</c:forEach>

</table>
</body>
</html>
