package com.farmersupport.app.dao;

import com.farmersupport.app.model.WeatherInfo;
import com.farmersupport.app.config.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherDao {

    public List<WeatherInfo> getWeatherByLocation(String location) {
        List<WeatherInfo> weatherList = new ArrayList<>();
        String sql = "SELECT * FROM weather_info WHERE location = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, location);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                WeatherInfo info = new WeatherInfo();
                info.setId(rs.getInt("id"));
                info.setLocation(rs.getString("location"));
                info.setDate(rs.getDate("date"));
                info.setTemperature(rs.getDouble("temperature"));
                info.setHumidity(rs.getDouble("humidity"));
                info.setCondition(rs.getString("condition"));

                weatherList.add(info);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return weatherList;
    }

    public boolean addWeatherInfo(WeatherInfo info) {
        String sql = "INSERT INTO weather_info (location, date, temperature, humidity, `condition`) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, info.getLocation());
            stmt.setDate(2, new java.sql.Date(info.getDate().getTime()));
            stmt.setDouble(3, info.getTemperature());
            stmt.setDouble(4, info.getHumidity());
            stmt.setString(5, info.getCondition());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
