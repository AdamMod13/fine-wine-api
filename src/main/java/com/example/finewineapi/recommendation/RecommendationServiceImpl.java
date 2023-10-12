package com.example.finewineapi.recommendation;

import com.example.finewineapi.variety.VarietyDTO;
import com.example.finewineapi.variety.VarietyRepository;
import com.example.finewineapi.winery.WineryDTO;
import com.example.finewineapi.winery.WineryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Autowired
    private ModelMapper modelMapper;

    private final VarietyRepository varietyRepository;

    private final WineryRepository wineryRepository;

    public RecommendationServiceImpl(VarietyRepository varietyRepository, WineryRepository wineryRepository) {
        this.varietyRepository = varietyRepository;
        this.wineryRepository = wineryRepository;
    }

    @Override
    public RecommendationDTO getFilters() {
        List<String> varieties = this.varietyRepository.findRandomUniqueVarieties()
                .stream()
                .map(varietyEntity -> modelMapper.map(varietyEntity, VarietyDTO.class))
                .map(VarietyDTO::getVariety)
                .collect(Collectors.toList());

        List<String> wineries = this.wineryRepository.findRandomUniqueWineries()
                .stream()
                .map(wineryEntity -> modelMapper.map(wineryEntity, WineryDTO.class))
                .map(WineryDTO::getWinery)
                .collect(Collectors.toList());

        return new RecommendationDTO(wineries, varieties);
    }
}
