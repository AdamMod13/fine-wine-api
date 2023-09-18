package com.example.finewineapi.models;

public class WineRecommendationReq {
    String country;
    String wineColor;
    String variety;
    String winery;
    Long price;
    Long points;

    public WineRecommendationReq() {
    }

    public WineRecommendationReq(String country, String wineColor, String variety, String winery, Long price, Long points) {
        this.country = country;
        this.wineColor = wineColor;
        this.variety = variety;
        this.winery = winery;
        this.price = price;
        this.points = points;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWineColor() {
        return wineColor;
    }

    public void setWineColor(String wineColor) {
        this.wineColor = wineColor;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getWinery() {
        return winery;
    }

    public void setWinery(String winery) {
        this.winery = winery;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public void replaceNullValuesWithDash() {
        if (country == null) {
            country = "-";
        }
        if (wineColor == null) {
            wineColor = "-";
        }
        if (variety == null) {
            variety = "-";
        }
        if (winery == null) {
            winery = "-";
        }
        if (price == null) {
            price = -1L; // You can choose a different default value for Long
        }
        if (points == null) {
            points = -1L; // You can choose a different default value for Long
        }
    }
}