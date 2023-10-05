package com.example.finewineapi.models;

import java.util.List;

public class WineRecommendationReq {
    List<String> countries;
    List<String> wineColors;
    String variety;
    String winery;
    String province;
    Long price;
    Long points;

    public WineRecommendationReq() {
    }

    public WineRecommendationReq(List<String> countries, List<String> wineColors, String variety, String winery, String province, Long price, Long points) {
        this.countries = countries;
        this.wineColors = wineColors;
        this.variety = variety;
        this.winery = winery;
        this.province = province;
        this.price = price;
        this.points = points;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<String> getWineColors() {
        return wineColors;
    }

    public void setWineColors(List<String> wineColors) {
        this.wineColors = wineColors;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}