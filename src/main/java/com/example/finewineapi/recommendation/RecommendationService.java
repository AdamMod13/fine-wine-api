package com.example.finewineapi.recommendation;

import com.example.finewineapi.models.FilterWineryOrVarietyReq;

public interface RecommendationService {

    RecommendationDTO getFilters();

    RecommendationDTO getSpecificFilters(FilterWineryOrVarietyReq specificFiltersReq);
}
