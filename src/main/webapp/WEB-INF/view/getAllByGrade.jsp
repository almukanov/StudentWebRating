<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jrus
  Date: 4/26/2022
  Time: 2:44 PM
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

    <c:forEach var="student" items="${students}">

        <tr>
            <td>${student.student.firstName}</td>
            <td>${student.student.lastName}</td>
            <td>${student.student.grade.gradeNumber}</td>
            <td>${student.rating}</td>


        </tr>

    </c:forEach>

</table>
</body>
</html>
