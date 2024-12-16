package com.bookstore.dao;

import com.bookstore.models.Book;
import com.bookstore.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    // Method to search books based on criteria
    public static List<Book> searchBooks(String searchType, String searchValue) {
        List<Book> books = new ArrayList<>();
        String sql = "";

        // Construct SQL query based on search type
        switch (searchType) {
            case "name":
                sql = "SELECT * FROM Books WHERE name LIKE ?";
                break;
            case "isbn":
                sql = "SELECT * FROM Books WHERE isbn = ?";
                break;
            case "author":
                sql = "SELECT * FROM Books WHERE author LIKE ?";
                break;
        }

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + searchValue + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setIsbn(rs.getString("isbn"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(rs.getDouble("price"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
