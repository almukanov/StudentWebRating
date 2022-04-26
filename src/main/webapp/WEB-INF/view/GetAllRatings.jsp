<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jrus
  Date: 4/25/2022
  Time: 1:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Grade</th>
        <th>Rating</th>
    </tr>

    <c:forEach var="rating" items="${ratings}">

        <tr>
            <td>${rating.student.firstName}</td>
            <td>${rating.student.lastName}</td>
            <td>${rating.student.grade.gradeNumber}</td>
            <td>${rating.rating}</td>

        </tr>

    </c:forEach>
    <input type="button" value="Main page" onclick="window.location.href='/'">
</table>
</body>
</html>
