package com.farmersupport.app.dao;

import com.farmersupport.app.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/farmersupport";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "madhukutty";

    private static final String INSERT_USER_SQL = "INSERT INTO users (name, username, password, email, contact, address, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_USER_BY_USERNAME_PASSWORD = "SELECT * FROM users WHERE username = ? AND password = ?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public boolean validate(String username, String password) {
        boolean status = false;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_USERNAME_PASSWORD)) {
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            status = rs.next(); // true if user exists
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void registerUser(User user) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getContact());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getRole());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL_USERS)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("contact"),
                        rs.getString("address"),
                        rs.getString("role")
                );
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
