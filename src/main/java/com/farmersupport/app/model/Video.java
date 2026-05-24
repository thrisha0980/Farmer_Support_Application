package com.farmersupport.app.model;

import java.util.Date;

public class Video {
    private int id;
    private String title;
    private String language;
    private String description;
    private String filePath;
    private String uploadedBy;
    private Date uploadDate;

    // Constructors
    public Video() {}

    public Video(int id, String title, String language, String description, String filePath, String uploadedBy, Date uploadDate) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.description = description;
        this.filePath = filePath;
        this.uploadedBy = uploadedBy;
        this.uploadDate = uploadDate;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
}
