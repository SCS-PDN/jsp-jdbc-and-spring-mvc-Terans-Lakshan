<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registration Successful</title>
</head>
<body>
<h2>Course Registration Successful!</h2>
<p>Congratulations, ${loggedInStudent.name}! You have successfully registered for the course.</p>

<a href="/courses">Back to Courses</a> |
<a href="/logout">Logout</a>
</body>
</html>
