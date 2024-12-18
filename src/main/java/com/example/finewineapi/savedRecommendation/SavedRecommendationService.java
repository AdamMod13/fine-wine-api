package com.example.finewineapi.savedRecommendation;

import com.example.finewineapi.recommendation.RecommendationDTO;

import java.util.List;
import java.util.Set;

public interface SavedRecommendationService {

    void saveRecommendation(Set<Long> wineIds, String userId);

    List<RecommendationDTO> getUserRecommendations(String userId);
}
