package com.example.finewineapi.variety;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VarietyDTO {
    private Long id;
    private String variety;

    public VarietyDTO() {
    }

    public VarietyDTO(Long id, String variety) {
        this.id = id;
        this.variety = variety;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }
}
