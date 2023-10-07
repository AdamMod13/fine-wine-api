package com.example.finewineapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecommendationJson {
    @JsonProperty("id")
    private double id;

    @JsonProperty("variety")
    private String variety;

    @JsonProperty("wineColor")
    private String wineColor;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price")
    private double price;

    @JsonProperty("points")
    private double points;

    @JsonProperty("country")
    private String country;

    @JsonProperty("winery")
    private String winery;

    @JsonProperty("province")
    private String province;

    @JsonProperty("wineName")
    private String wineName;

    @JsonProperty("region1")
    private String region1;

    @JsonProperty("distance")
    private double distance;

    public double getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWineColor() {
        return wineColor;
    }

    public void setWineColor(String wineColor) {
        this.wineColor = wineColor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWinery() {
        return winery;
    }

    public void setWinery(String winery) {
        this.winery = winery;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getWineName() {
        return wineName;
    }

    public void setWineName(String wineName) {
        this.wineName = wineName;
    }

    public String getRegion1() {
        return region1;
    }

    public void setRegion1(String region1) {
        this.region1 = region1;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
