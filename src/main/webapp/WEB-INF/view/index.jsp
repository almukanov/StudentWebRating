<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Main page</title>
</head>
<body>
<select onchange="window.location.href=this.options[this.selectedIndex].value">
    <option selected>Chose a grade</option>
    <d:forEach var="grades" items="${grade}">
        <option VALUE="get-All-By-Grade/${grades.id}">${grades.gradeNumber}</option>
    </d:forEach>
</select>
<table>
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Grade</th>
        <th>Rating</th>
    </tr>

    <c:forEach var="students" items="${allStudents}">

        <tr>
        <td>${students.student.firstName}</td>
        <td>${students.student.lastName}</td>
        <td>${students.student.grade.gradeNumber}</td>
        <td>${students.rating}</td>


        </tr>

    </c:forEach>

</table>
<br>
<br>
<input type="button" value="Add a new student" onclick="window.location.href='/add-new-student'">
<br>
<br>







<br>
<br>




</body>
</html>
