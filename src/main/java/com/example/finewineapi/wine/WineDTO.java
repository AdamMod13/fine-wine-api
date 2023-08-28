package com.example.finewineapi.wine;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WineDTO {
    private Long id;
    private String variety;
    private String wineColor;
    private String winery;
    private String country;
    private Long points;
    private String description;
    private String price;
    private String province;
    private String wineName1;
    private String wineName2;
    private String region1;
    private String region2;

    public WineDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getWineColor() {
        return wineColor;
    }

    public void setWineColor(String wineColor) {
        this.wineColor = wineColor;
    }

    public String getWinery() {
        return winery;
    }

    public void setWinery(String winery) {
        this.winery = winery;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getWineName2() {
        return wineName2;
    }

    public void setWineName2(String wineName2) {
        this.wineName2 = wineName2;
    }

    public String getRegion1() {
        return region1;
    }

    public String getWineName1() {
        return wineName1;
    }

    public void setWineName1(String wineName1) {
        this.wineName1 = wineName1;
    }

    public void setRegion1(String region1) {
        this.region1 = region1;
    }

    public String getRegion2() {
        return region2;
    }

    public void setRegion2(String region2) {
        this.region2 = region2;
    }
}
