package com.example.finewineapi.wine;

import jakarta.persistence.*;

@Entity(name = "wine_entity")
@Table(name = "wines")
public class WineEntity {

    @Id
    @SequenceGenerator(
            name = "wine_sequence",
            sequenceName = "wine_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "wine_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "variety", updatable = false)
    private String variety;

    @Column(name = "wine_color", updatable = false)
    private String wineColor;

    @Column(name = "winery", updatable = false)
    private String winery;

    @Column(name = "country", updatable = false)
    private String country;

    @Column(name = "points", updatable = false)
    private Long points;

    @Column(name = "description", updatable = false, length = 10000)
    private String description;

    @Column(name = "price", updatable = false)
    private String price;

    @Column(name = "province", updatable = false)
    private String province;

    @Column(name = "wine_name", updatable = false)
    private String wineName;

    @Column(name = "wine_name_v2", updatable = false)
    private String wineNameV2;

    @Column(name = "region_1", updatable = false)
    private String region1;

    @Column(name = "region_2", updatable = false)
    private String region2;

    public WineEntity() {}

    public WineEntity(String variety, String wineColor, String winery, String country, Long points, String description, String price, String province, String wineName, String wineNameV2, String region1, String region2) {
        this.variety = variety;
        this.wineColor = wineColor;
        this.winery = winery;
        this.country = country;
        this.points = points;
        this.description = description;
        this.price = price;
        this.province = province;
        this.wineName = wineName;
        this.wineNameV2 = wineNameV2;
        this.region1 = region1;
        this.region2 = region2;
    }

    public Long getId() {
        return id;
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

    public String getWineName() {
        return wineName;
    }

    public void setWineName(String wineName) {
        this.wineName = wineName;
    }

    public String getWineNameV2() {
        return wineNameV2;
    }

    public void setWineNameV2(String wineNameV2) {
        this.wineNameV2 = wineNameV2;
    }

    public String getRegion1() {
        return region1;
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
