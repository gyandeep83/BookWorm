<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="AddToCartServlet" method="post">
    <table>
        <tr>
            <th>Select</th>
            <th>Name</th>
            <th>ISBN</th>
            <th>Author</th>
            <th>Price</th>
            <th>Quantity</th>
        </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td><input type="checkbox" name="bookId" value="${book.id}"></td>
                <td>${book.name}</td>
                <td>${book.isbn}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <td><input type="number" name="quantity"></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Add to Cart">
</form>
</body>
</html>