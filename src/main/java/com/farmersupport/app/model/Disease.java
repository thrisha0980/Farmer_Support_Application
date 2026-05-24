package com.farmersupport.app.model;

public class Disease {
    private int id;
    private String plantName; // 🔄 renamed from `name`
    private String symptoms;
    private String diseaseName; // 🔄 added
    private String solution;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPlantName() { return plantName; }
    public void setPlantName(String plantName) { this.plantName = plantName; }

    public String getDiseaseName() { return diseaseName; }
    public void setDiseaseName(String diseaseName) { this.diseaseName = diseaseName; }

    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    public String getSolution() { return solution; }
    public void setSolution(String solution) { this.solution = solution; }
}
