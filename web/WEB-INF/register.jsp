<%--
  Created by IntelliJ IDEA.
  User: Craig
  Date: 2020-10-21
  Time: 8:18 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h1>Shopping List</h1>
    <form action="ShoppingList" method="POST">
        <label>
            <input type="text" name="username">
        </label>
        <input type="hidden" name="action" value="Register"><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
