package com.example.finewineapi.savedRecommendation;

import com.example.finewineapi.recommendation.RecommendationDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavedRecommendationDTO {
    private Long id;
    private String userId;
    private RecommendationDTO recommendation;

    public SavedRecommendationDTO() {
    }

    public SavedRecommendationDTO(Long id, String userId, RecommendationDTO recommendation) {
        this.id = id;
        this.userId = userId;
        this.recommendation = recommendation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public RecommendationDTO getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(RecommendationDTO recommendation) {
        this.recommendation = recommendation;
    }
}
