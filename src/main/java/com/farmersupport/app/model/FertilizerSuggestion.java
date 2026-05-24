package com.farmersupport.app.model;

public class FertilizerSuggestion {
    private int id;
    private String soilType;
    private String crop;
    private double landSize;
    private String fertilizerName;
    private double amountRequired;

    // Constructors
    public FertilizerSuggestion() {}

    public FertilizerSuggestion(int id, String soilType, String crop, double landSize, String fertilizerName, double amountRequired) {
        this.id = id;
        this.soilType = soilType;
        this.crop = crop;
        this.landSize = landSize;
        this.fertilizerName = fertilizerName;
        this.amountRequired = amountRequired;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public double getLandSize() {
        return landSize;
    }

    public void setLandSize(double landSize) {
        this.landSize = landSize;
    }

    public String getFertilizerName() {
        return fertilizerName;
    }

    public void setFertilizerName(String fertilizerName) {
        this.fertilizerName = fertilizerName;
    }

    public double getAmountRequired() {
        return amountRequired;
    }

    public void setAmountRequired(double amountRequired) {
        this.amountRequired = amountRequired;
    }
}
