<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jrus
  Date: 4/25/2022
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student info</title>
</head>
<body>



<form:form action = "saveStudent" modelAttribute="student" method="post">
    First name <form:input path="firstName" />
    <br><br>
    Last name <form:input path="lastName" />
    <br><br>
     <form:select path="grade.id">
         <c:forEach var="grades" items="${grade}">
             <form:option  value="${grades.id}"> ${grades.gradeNumber}</form:option>
         </c:forEach>

     </form:select>

    <br><br>
    <input type="submit" value="ADD ">
</form:form>
</body>
</html>
