package com.example.finewineapi.models;

public class FilterWineryOrVarietyReq {
    public String value;
    public String type;

    public FilterWineryOrVarietyReq() {
    }

    public FilterWineryOrVarietyReq(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
