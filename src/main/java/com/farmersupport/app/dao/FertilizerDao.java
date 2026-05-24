package com.farmersupport.app.dao;

import com.farmersupport.app.model.FertilizerSuggestion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FertilizerDao {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/farmersupport";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "madhukutty";

    public List<FertilizerSuggestion> getSuggestions(String crop, String soilType, double landSize) {
        List<FertilizerSuggestion> suggestions = new ArrayList<>();

        String sql = "SELECT * FROM fertilizer_suggestions WHERE crop = ? AND soil_type = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, crop);
            ps.setString(2, soilType);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    FertilizerSuggestion fs = new FertilizerSuggestion();
                    fs.setId(rs.getInt("id"));
                    fs.setCrop(rs.getString("crop"));
                    fs.setSoilType(rs.getString("soil_type"));
                    fs.setLandSize(landSize); // input from user
                    fs.setFertilizerName(rs.getString("fertilizer_name"));
                    fs.setAmountRequired(rs.getDouble("amount_required")); // assumed column name
                    suggestions.add(fs);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return suggestions;
    }

    public boolean addSuggestion(FertilizerSuggestion suggestion) {
        String sql = "INSERT INTO fertilizer_suggestions (soil_type, crop, land_size, fertilizer_name, amount_required) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, suggestion.getSoilType());
            ps.setString(2, suggestion.getCrop());
            ps.setDouble(3, suggestion.getLandSize());
            ps.setString(4, suggestion.getFertilizerName());
            ps.setDouble(5, suggestion.getAmountRequired());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<FertilizerSuggestion> getAllSuggestions() {
        List<FertilizerSuggestion> list = new ArrayList<>();
        String sql = "SELECT * FROM fertilizer_suggestions";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                FertilizerSuggestion fs = new FertilizerSuggestion();
                fs.setId(rs.getInt("id"));
                fs.setSoilType(rs.getString("soil_type"));
                fs.setCrop(rs.getString("crop"));
                fs.setLandSize(rs.getDouble("land_size"));
                fs.setFertilizerName(rs.getString("fertilizer_name"));
                fs.setAmountRequired(rs.getDouble("amount_required"));
                list.add(fs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
