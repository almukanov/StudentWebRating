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
<input type="button" value="Main page" onclick="window.location.href='/'">
<form:form  action="/calculate-rating" method="get" >
    <table>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Grade</th>
            <th>Answer activity</th>
            <th>Self activity</th>
            <th>Question activity</th>

        </tr>



            <tr>
                <td>${profileOfStudent.firstName}</td>
                <td>${profileOfStudent.lastName}</td>
                <td>${profileOfStudent.grade.gradeNumber}</td>

              <input type="hidden" name="s_id" value="${profileOfStudent.id}" />
              <input type="hidden" name="g_id" value="${profileOfStudent.grade.id}" />
                <td><input type="number" name="answerActivity" /></td>
                <td><input type="number" name="selfActivity" /></td>
                <td><input type="number" name="questionfActivity" /></td>
                <td><input type="submit" value="add new rating"></td>
            </tr>


    </table>
</form:form>
<br>
<input type="button" onclick="history.back();" value="Back"/>
</body>
</html>
