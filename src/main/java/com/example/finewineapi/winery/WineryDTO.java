package com.example.finewineapi.winery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WineryDTO {
    private Long id;
    private String winery;

    public WineryDTO() {
    }

    public WineryDTO(Long id, String winery) {
        this.id = id;
        this.winery = winery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWinery() {
        return winery;
    }

    public void setWinery(String winery) {
        this.winery = winery;
    }
}
