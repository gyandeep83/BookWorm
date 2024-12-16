package com.bookstore.dao;

import com.bookstore.models.User;
import com.bookstore.utils.DBConnection;

import java.sql.*;

public class UserDAO {

    // Method to validate login credentials
    public static boolean validateUser(String username, String password) {
        boolean isValid = false;
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                isValid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }

    // Method to register a new user
    public static boolean registerUser(User user) {
        boolean isRegistered = false;
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO Users (name, username, password, email) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword()); // Ideally store hashed passwords
            ps.setString(4, user.getEmail());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                isRegistered = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isRegistered;
    }
}
