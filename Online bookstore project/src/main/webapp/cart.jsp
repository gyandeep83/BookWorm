<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bookstore.models.Cart" %>
<%@ page import="com.bookstore.models.Book" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
</head>
<body>
<h2>Your Shopping Cart</h2>

<form action="BillServlet" method="post">
    <table border="1">
        <tr>
            <th>Book ID</th>
            <th>Book Name</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart != null && cart.getBooks().size() > 0) {
                List<Book> booksInCart = cart.getBooks();
                for (Book book : booksInCart) {
        %>
        <tr>
            <td><%= book.getId() %></td>
            <td><%= book.getName() %></td>
            <td><%= book.getQuantity() %></td>
            <td><%= book.getPrice() * book.getQuantity() %></td>
        </tr>
        <% 
                }
            } else { 
        %>
        <tr>
            <td colspan="4">Your cart is empty</td>
        </tr>
        <% } %>
    </table>
    <br>
    <input type="submit" value="Back" formaction="bookSearch.jsp">
    <input type="submit" value="Bill">
</form>
</body>
</html>
