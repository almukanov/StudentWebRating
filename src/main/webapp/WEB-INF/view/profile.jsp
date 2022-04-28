<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jrus
  Date: 28.04.2022
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form  action="/calculate-rating" method="get" >
    <table>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Grade</th>

        </tr>



            <tr>
                <td>${profileOfStudent.firstName}</td>
                <td>${profileOfStudent.lastName}</td>
                <td>${profileOfStudent.grade.gradeNumber}</td>

                <td><input type="hidden" name="s_id" value="${profileOfStudent.id}"></td>
                <td><input type="number" name="a" /></td>
                <td><input type="number" name="b" /></td>
                <td><input type="number" name="c" /></td>
                <td><input type="submit" value="add new rating"></td>
            </tr>


    </table>
</form:form>
</body>
</html>
