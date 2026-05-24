package com.farmersupport.app.dao;

import com.farmersupport.app.config.DBUtil;
import com.farmersupport.app.model.Disease;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiseaseDao {

    public Disease getDiseaseBySymptoms(String symptoms) {
        Disease disease = null;
        String sql = "SELECT * FROM diseases WHERE symptoms LIKE ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + symptoms + "%");

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                disease = new Disease();
                disease.setId(rs.getInt("id"));
                disease.setPlantName(rs.getString("plant_name"));
                disease.setDiseaseName(rs.getString("disease_name"));
                disease.setSymptoms(rs.getString("symptoms"));
                disease.setSolution(rs.getString("solution"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return disease;
    }

    public List<Disease> getAllDiseases() {
        List<Disease> diseaseList = new ArrayList<>();
        String sql = "SELECT * FROM diseases";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Disease disease = new Disease();
                disease.setId(rs.getInt("id"));
                disease.setPlantName(rs.getString("plant_name"));
                disease.setDiseaseName(rs.getString("disease_name"));
                disease.setSymptoms(rs.getString("symptoms"));
                disease.setSolution(rs.getString("solution"));
                diseaseList.add(disease);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return diseaseList;
    }

    public boolean addDisease(Disease disease) {
        String sql = "INSERT INTO diseases (plant_name, disease_name, symptoms, solution) VALUES (?, ?, ?, ?)";
        boolean success = false;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, disease.getPlantName());
            stmt.setString(2, disease.getDiseaseName());
            stmt.setString(3, disease.getSymptoms());
            stmt.setString(4, disease.getSolution());

            int rows = stmt.executeUpdate();
            success = rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }
}
