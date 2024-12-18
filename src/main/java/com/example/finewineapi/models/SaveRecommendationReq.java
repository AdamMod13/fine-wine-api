package com.example.finewineapi.models;

import java.util.List;

public class SaveRecommendationReq {

    String userId;
    List<Long> wineIds;

    public SaveRecommendationReq() {
    }

    public SaveRecommendationReq(String userId, List<Long> wineIds) {
        this.userId = userId;
        this.wineIds = wineIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Long> getWineIds() {
        return wineIds;
    }

    public void setWineIds(List<Long> wineIds) {
        this.wineIds = wineIds;
    }
}
