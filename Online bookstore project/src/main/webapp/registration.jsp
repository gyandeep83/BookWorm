<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="RegisterServlet" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username">
    <label for="password">Password:</label>
    <input type="password" id="password" name="password">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email">
    <input type="submit" value="Register">
</form>
</body>
</html>