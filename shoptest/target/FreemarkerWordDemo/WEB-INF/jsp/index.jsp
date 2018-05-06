<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="../statics/css/div.css"/>
    <style>
        div {
            width: 500px;height: 600px;
            border: 8px solid gainsboro;
            padding: 10px;
            margin: 30px;
            float: left;
        }
    </style>
</head>



<body>
<h2 style="text-align: center">Hello World! Welcome Shoplist</h2>
<c:forEach items="${requestScope.shoplists}" var="shoplists">
<div>
    <p>${shoplists.shopname}</p>
    <p>${shoplists.prce}</p>
    <img src="/image/${shoplists.img}" width="400" height="300"/>
    <p>12131</p>
</div>
</c:forEach>

</body>
</html>
