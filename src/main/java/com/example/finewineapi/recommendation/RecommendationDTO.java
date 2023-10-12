package com.example.finewineapi.recommendation;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecommendationDTO {
    List<String> wineries;
    List<String> varieties;

    public RecommendationDTO() {
    }

    public RecommendationDTO(List<String> wineries, List<String> varieties) {
        this.wineries = wineries;
        this.varieties = varieties;
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
}
