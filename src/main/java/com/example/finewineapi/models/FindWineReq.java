package com.example.finewineapi.models;

import java.util.List;

public class FindWineReq {
    List<String> countries;
    List<String> wineColors;
    List<String> varieties;
    List<String> wineries;
    List<String> provinces;
    Long price;
    Long points;

    public FindWineReq() {
    }

    public FindWineReq(List<String> countries, List<String> wineColors, List<String> varieties, List<String> wineries, List<String> provinces, Long price, Long points) {
        this.countries = countries;
        this.wineColors = wineColors;
        this.varieties = varieties;
        this.wineries = wineries;
        this.provinces = provinces;
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

    public List<String> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<String> provinces) {
        this.provinces = provinces;
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
}
