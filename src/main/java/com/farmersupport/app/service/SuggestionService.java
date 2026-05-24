package com.farmersupport.app.service;

import com.farmersupport.app.model.FertilizerSuggestion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SuggestionService {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/farmersupport";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "madhukutty";

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC Driver
        return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
    }

    public List<FertilizerSuggestion> getSuggestions(String soilType, String crop, double userLandSize) {
        List<FertilizerSuggestion> suggestions = new ArrayList<>();

        String sql = "SELECT * FROM fertilizer_suggestions WHERE soil_type = ? AND crop = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, soilType);
            stmt.setString(2, crop);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FertilizerSuggestion suggestion = new FertilizerSuggestion();
                suggestion.setId(rs.getInt("id"));
                suggestion.setSoilType(rs.getString("soil_type"));
                suggestion.setCrop(rs.getString("crop"));
                suggestion.setFertilizerName(rs.getString("fertilizer_name"));

                double dbLandSize = rs.getDouble("land_size");
                double baseAmount = rs.getDouble("amount_required");

                // Calculate required amount for user input land size
                double adjustedAmount = (dbLandSize > 0) ? (baseAmount * userLandSize / dbLandSize) : 0.0;

                suggestion.setLandSize(userLandSize);
                suggestion.setAmountRequired(adjustedAmount);

                suggestions.add(suggestion);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return suggestions;
    }
}
