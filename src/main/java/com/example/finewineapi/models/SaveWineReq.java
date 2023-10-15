package com.example.finewineapi.models;

import com.example.finewineapi.wine.WineEntity;

public class SaveWineReq {
    public WineEntity wine;
    public String userId;

    public SaveWineReq() {
    }

    public SaveWineReq(WineEntity wine, String userId) {
        this.wine = wine;
        this.userId = userId;
    }

    public WineEntity getWine() {
        return wine;
    }

    public void setWine(WineEntity wine) {
        this.wine = wine;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
