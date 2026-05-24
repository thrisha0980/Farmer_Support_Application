package com.farmersupport.app.dao;

import com.farmersupport.app.config.DBUtil;
import com.farmersupport.app.model.SoilInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SoilInfoDao {

    // Add new soil info entry
    public boolean addSoilInfo(SoilInfo soil) {
        String sql = "INSERT INTO soil_info (soil_type, ph_level, nutrient_level, recommended_crops) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, soil.getSoilType());
            stmt.setDouble(2, soil.getPhLevel());
            stmt.setString(3, soil.getNutrientLevel());
            stmt.setString(4, soil.getRecommendedCrops());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get all soil info records
    public List<SoilInfo> getAllSoilInfo() {
        List<SoilInfo> soilList = new ArrayList<>();
        String sql = "SELECT * FROM soil_info";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                SoilInfo soil = new SoilInfo();
                soil.setId(rs.getInt("id"));
                soil.setSoilType(rs.getString("soil_type"));
                soil.setPhLevel(rs.getDouble("ph_level"));
                soil.setNutrientLevel(rs.getString("nutrient_level"));
                soil.setRecommendedCrops(rs.getString("recommended_crops"));
                soilList.add(soil);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soilList;
    }

    // Get soil info by soil type
    public SoilInfo getSoilInfoByType(String soilType) {
        String sql = "SELECT * FROM soil_info WHERE soil_type = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, soilType);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                SoilInfo soil = new SoilInfo();
                soil.setId(rs.getInt("id"));
                soil.setSoilType(rs.getString("soil_type"));
                soil.setPhLevel(rs.getDouble("ph_level"));
                soil.setNutrientLevel(rs.getString("nutrient_level"));
                soil.setRecommendedCrops(rs.getString("recommended_crops"));
                return soil;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
