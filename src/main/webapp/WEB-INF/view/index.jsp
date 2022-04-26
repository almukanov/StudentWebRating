<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jrus
  Date: 4/24/2022
  Time: 10:15 PM
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
    </tr>

    <c:forEach var="students" items="${allStudents}">

        <tr>
        <td>${students.firstName}</td>
        <td>${students.lastName}</td>
        <td>${students.grade.gradeNumber}</td>


        </tr>

    </c:forEach>

</table>
<br>
<br>
<input type="button" value="Add a new student" onclick="window.location.href='/add-new-student'">
<br>
<br>
<input type="button" value="Get all ratings" onclick="window.location.href='/get-all-ratings'">
</body>
</html>
