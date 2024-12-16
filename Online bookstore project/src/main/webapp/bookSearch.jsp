<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="BookSearchServlet" method="post">
    <select name="searchType">
        <option value="name">By Name</option>
        <option value="isbn">By ISBN</option>
        <option value="author">By Author</option>
    </select>
    <input type="text" name="searchValue">
    <input type="submit" value="Search">
</form>
</body>
</html>