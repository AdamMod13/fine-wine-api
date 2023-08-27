package com.example.finewineapi.wine;

import java.util.List;

public interface WineService {

    List<WineDTO> getWines();

    List<WineDTO> getBestRandomWines();
}
