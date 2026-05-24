package com.farmersupport.app.dao;

import com.farmersupport.app.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private String jdbcURL = "jdbc:mysql://localhost:3306/farmersupport";
    private String jdbcUsername = "root";
    private String jdbcPassword = "madhukutty";

    private static final String INSERT_PRODUCT_SQL = 
        "INSERT INTO products (name, category, description, price, available_quantity, seller_username) VALUES (?, ?, ?, ?, ?, ?)";
    
    private static final String SELECT_ALL_PRODUCTS = 
        "SELECT * FROM products";

    private static final String SELECT_PRODUCT_BY_ID = 
        "SELECT * FROM products WHERE id = ?";

    private static final String DELETE_PRODUCT_SQL = 
        "DELETE FROM products WHERE id = ?";

    private static final String UPDATE_PRODUCT_SQL = 
        "UPDATE products SET name = ?, category = ?, description = ?, price = ?, available_quantity = ?, seller_username = ? WHERE id = ?";

    public ProductDao() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // mysql-connector
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertProduct(Product product) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            
            ps.setString(1, product.getName());
            ps.setString(2, product.getCategory());
            ps.setString(3, product.getDescription());
            ps.setDouble(4, product.getPrice());
            ps.setInt(5, product.getAvailableQuantity());
            ps.setString(6, product.getSellerUsername());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> selectAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PRODUCTS)) {
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setAvailableQuantity(rs.getInt("available_quantity"));
                product.setSellerUsername(rs.getString("seller_username"));
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product selectProduct(int id) {
        Product product = null;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                product = new Product();
                product.setId(id);
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                product.setAvailableQuantity(rs.getInt("available_quantity"));
                product.setSellerUsername(rs.getString("seller_username"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public boolean deleteProduct(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_PRODUCT_SQL)) {

            ps.setInt(1, id);
            rowDeleted = ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean updateProduct(Product product) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {

            ps.setString(1, product.getName());
            ps.setString(2, product.getCategory());
            ps.setString(3, product.getDescription());
            ps.setDouble(4, product.getPrice());
            ps.setInt(5, product.getAvailableQuantity());
            ps.setString(6, product.getSellerUsername());
            ps.setInt(7, product.getId());

            rowUpdated = ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}
