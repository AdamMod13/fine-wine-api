package com.example.finewineapi.models;

import com.example.finewineapi.wine.WineDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public class FindWineRes {
    public Page<WineDTO> winePage;
    public List<String> randomVarieties;
    public List<String> randomWineries;


    public FindWineRes() {
    }

    public FindWineRes(Page<WineDTO> winePage, List<String> randomVarieties, List<String> randomWineries) {
        this.winePage = winePage;
        this.randomVarieties = randomVarieties;
        this.randomWineries = randomWineries;
    }

    public Page<WineDTO> getWinePage() {
        return winePage;
    }

    public void setWinePage(Page<WineDTO> winePage) {
        this.winePage = winePage;
    }

    public List<String> getRandomVarieties() {
        return randomVarieties;
    }

    public void setRandomVarieties(List<String> randomVarieties) {
        this.randomVarieties = randomVarieties;
    }

    public List<String> getRandomWineries() {
        return randomWineries;
    }

    public void setRandomWineries(List<String> randomWineries) {
        this.randomWineries = randomWineries;
    }
}
