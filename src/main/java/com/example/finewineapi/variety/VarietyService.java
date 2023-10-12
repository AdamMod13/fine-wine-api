package com.example.finewineapi.variety;

import java.util.List;

public interface VarietyService {

    List<VarietyDTO> getVarieties();

    List<VarietyDTO> getRandomVarieties(Long size);
}
