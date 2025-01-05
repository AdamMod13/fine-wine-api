package com.example.finewineapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecommendationJson {
    @JsonProperty("id")
    private double id;

    @JsonProperty("variety")
    private String variety;

    @JsonProperty("wineColor")
    private String wineColor;

    @JsonProperty("price")
    private double price;

    @JsonProperty("rating")
    private double rating;

    @JsonProperty("country")
    private String country;

    @JsonProperty("winery")
    private String winery;

    @JsonProperty("region")
    private String region;

    @JsonProperty("wineName")
    private String wineName;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
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

    public String getWineName() {
        return wineName;
    }

    public void setWineName(String wineName) {
        this.wineName = wineName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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
