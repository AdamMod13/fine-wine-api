package com.example.finewineapi.recommendationModal;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecommendationModalDTO {
    private List<String> wineries;
    private List<String> varieties;
    private String type;

    public RecommendationModalDTO() {
    }

    public RecommendationModalDTO(List<String> wineries, List<String> varieties, String type) {
        this.wineries = wineries;
        this.varieties = varieties;
        this.type = type;
    }

    public List<String> getWineries() {
        return wineries;
    }

    public void setWineries(List<String> wineries) {
        this.wineries = wineries;
    }

    public List<String> getVarieties() {
        return varieties;
    }

    public void setVarieties(List<String> varieties) {
        this.varieties = varieties;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
