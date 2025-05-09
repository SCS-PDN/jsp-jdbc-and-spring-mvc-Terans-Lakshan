<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Available Courses</title></head>
<body>
<h2>Courses</h2>
<c:if test="${empty loggedInStudent}">
    <p>You must log in first! <a href="/login">Login</a></p>
</c:if>
<c:if test="${not empty loggedInStudent}">
    <p>Welcome, ${loggedInStudent.name}!</p>
    <c:forEach var="course" items="${courses}">
        <p>${course.name} - Instructor: ${course.instructor}</p>
        <form action="/register/${course.courseId}" method="post">
            <button type="submit">Register</button>
        </form>
    </c:forEach>
</c:if>
</body>
</html>
