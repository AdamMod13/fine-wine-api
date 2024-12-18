package com.example.finewineapi.wine;

import com.example.finewineapi.recommendation.RecommendationEntity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "name", updatable = false)
    private String name;

    @Column(name = "year", updatable = false)
    private Long year;

    @Column(name = "winery", updatable = false)
    private String winery;

    @Column(name = "country", updatable = false)
    private String country;

    @Column(name = "wine_color", updatable = false)
    private String wineColor;

    @Column(name = "region", updatable = false, length = 10000)
    private String region;

    @Column(name = "variety", updatable = false)
    private String variety;

    @Column(name = "rating", updatable = false)
    private Double rating;

    @Column(name = "price", updatable = false)
    private Double price;

    @Column(name = "style", updatable = false)
    private String style;

    @ManyToMany(mappedBy = "wines")
    private Set<RecommendationEntity> recommendations = new HashSet<>();

    public WineEntity() {}

    public WineEntity(Long id, String name, Long year, String winery, String country, String wineColor, String region, String variety, Double rating, Double price, String style) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.winery = winery;
        this.country = country;
        this.wineColor = wineColor;
        this.region = region;
        this.variety = variety;
        this.rating = rating;
        this.price = price;
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getWinery() {
        return winery;
    }

    public void setWinery(String winery) {
        this.winery = winery;
    }

    public String getWineColor() {
        return wineColor;
    }

    public void setWineColor(String wineColor) {
        this.wineColor = wineColor;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
