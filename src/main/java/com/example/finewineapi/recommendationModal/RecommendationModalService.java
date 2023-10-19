package com.example.finewineapi.recommendationModal;

import com.example.finewineapi.models.FilterWineryOrVarietyReq;

public interface RecommendationModalService {

    RecommendationModalDTO getFilters();

    RecommendationModalDTO getSpecificFilters(FilterWineryOrVarietyReq specificFiltersReq);
}
