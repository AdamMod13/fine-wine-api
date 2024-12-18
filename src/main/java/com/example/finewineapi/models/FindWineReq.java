package com.example.finewineapi.models;

import java.util.List;

public class FindWineReq {
    List<String> countries;
    List<String> wineColors;
    List<String> varieties;
    List<String> wineries;
    List<String> regions;
    Long price;
    Long rating;

    public FindWineReq() {
    }

    public FindWineReq(List<String> countries, List<String> wineColors, List<String> varieties, List<String> wineries, List<String> regions, Long price, Long rating) {
        this.countries = countries;
        this.wineColors = wineColors;
        this.varieties = varieties;
        this.wineries = wineries;
        this.regions = regions;
        this.price = price;
        this.rating = rating;
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

    public List<String> getVarieties() {
        return varieties;
    }

    public void setVarieties(List<String> varieties) {
        this.varieties = varieties;
    }

    public List<String> getWineries() {
        return wineries;
    }

    public void setWineries(List<String> wineries) {
        this.wineries = wineries;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
