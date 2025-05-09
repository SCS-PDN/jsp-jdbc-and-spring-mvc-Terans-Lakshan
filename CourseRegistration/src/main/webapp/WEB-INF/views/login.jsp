<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Login</title></head>
<body>
<h2>Student Login</h2>
<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>
<form action="/login" method="post">
    Email: <input type="text" name="email"><br>
    Password: <input type="password" name="password"><br>
    <button type="submit">Login</button>
</form>
</body>
</html>
