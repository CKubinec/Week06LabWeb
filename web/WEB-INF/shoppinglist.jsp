<%--
  Created by IntelliJ IDEA.
  User: Craig
  Date: 2020-10-21
  Time: 8:18 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shopping List</title>
</head>
<body>
    <h1>Shopping List</h1>
    <p>Hello ${username}</p>
    <p><a href="?action=logout">Logout</a></p>

    <form action="ShoppingList" method="POST">
        <h2>Add Item</h2>
        <input type="text" name="item">
        <input type="submit" value="Add Item">
        <input type="hidden" name="action" value="add">
    </form>

    <form action="ShoppingList" method="POST">
        <ul>
            <c:forEach var="item" items="${items}">
                <li><input type="radio" name="item" value="${item}">${item}</li>
            </c:forEach>
        </ul>
            <input type="submit" value="delete">
            <input type="hidden" name="action" value="delete">
    </form>
</body>
</html>
