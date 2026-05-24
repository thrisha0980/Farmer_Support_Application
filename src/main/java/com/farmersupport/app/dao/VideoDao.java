package com.farmersupport.app.dao;

import com.farmersupport.app.model.Video;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideoDao {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/farmersupport";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "madhukutty";

    private static final String INSERT_VIDEO_SQL =
            "INSERT INTO videos (title, language, description, file_path, uploaded_by, upload_date) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_ALL_VIDEOS_SQL =
            "SELECT * FROM videos ORDER BY upload_date DESC";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addVideo(Video video) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_VIDEO_SQL)) {

            ps.setString(1, video.getTitle());
            ps.setString(2, video.getLanguage());
            ps.setString(3, video.getDescription());
            ps.setString(4, video.getFilePath());
            ps.setString(5, video.getUploadedBy());
            ps.setDate(6, new java.sql.Date(video.getUploadDate().getTime()));

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Video> getAllVideos() {
        List<Video> videos = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL_VIDEOS_SQL)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Video video = new Video();
                video.setId(rs.getInt("id"));
                video.setTitle(rs.getString("title"));
                video.setLanguage(rs.getString("language"));
                video.setDescription(rs.getString("description"));
                video.setFilePath(rs.getString("file_path"));
                video.setUploadedBy(rs.getString("uploaded_by"));
                video.setUploadDate(rs.getDate("upload_date"));

                videos.add(video);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return videos;
    }
}
