package com.farmersupport.app.model;

public class SoilInfo {
    private int id;
    private String soilType;
    private double phLevel;
    private String nutrientLevel;
    private String recommendedCrops;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getSoilType() { return soilType; }
    public void setSoilType(String soilType) { this.soilType = soilType; }

    public double getPhLevel() { return phLevel; }
    public void setPhLevel(double phLevel) { this.phLevel = phLevel; }

    public String getNutrientLevel() { return nutrientLevel; }
    public void setNutrientLevel(String nutrientLevel) { this.nutrientLevel = nutrientLevel; }

    public String getRecommendedCrops() { return recommendedCrops; }
    public void setRecommendedCrops(String recommendedCrops) { this.recommendedCrops = recommendedCrops; }
}
