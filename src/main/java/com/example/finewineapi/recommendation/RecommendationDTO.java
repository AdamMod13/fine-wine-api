package com.example.finewineapi.recommendation;

import com.example.finewineapi.wine.WineDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecommendationDTO {
    private Long id;
    private List<WineDTO> wines;

    public RecommendationDTO() {
    }

    public RecommendationDTO(Long id, List<WineDTO> wines) {
        this.id = id;
        this.wines = wines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<WineDTO> getWines() {
        return wines;
    }

    public void setWines(List<WineDTO> wines) {
        this.wines = wines;
    }
}
