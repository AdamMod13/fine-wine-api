package com.example.finewineapi.wine;

import com.example.finewineapi.models.WineRecommendationReq;

import java.io.IOException;
import java.util.List;

public interface WineService {

    List<WineDTO> getWines();

    List<WineDTO> getBestRandomWines();

    List<WineDTO> getRecommendations(WineRecommendationReq wineRecommendationReq) throws IOException, InterruptedException;

    void saveCurrentRecommendations(List<WineDTO> currentRecommendations);

    List<WineDTO> getCurrentRecommendations();
}
