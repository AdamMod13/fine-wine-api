package com.example.finewineapi.recommendationModal;

import com.example.finewineapi.models.FilterWineryOrVarietyReq;
import com.example.finewineapi.variety.VarietyDTO;
import com.example.finewineapi.variety.VarietyRepository;
import com.example.finewineapi.winery.WineryDTO;
import com.example.finewineapi.winery.WineryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationModalServiceImpl implements RecommendationModalService {

    @Autowired
    private ModelMapper modelMapper;

    private final VarietyRepository varietyRepository;

    private final WineryRepository wineryRepository;

    public RecommendationModalServiceImpl(VarietyRepository varietyRepository, WineryRepository wineryRepository) {
        this.varietyRepository = varietyRepository;
        this.wineryRepository = wineryRepository;
    }

    @Override
    public RecommendationModalDTO getFilters() {
        List<String> varieties = this.varietyRepository.findRandomUniqueVarieties(15L)
                .stream()
                .map(varietyEntity -> modelMapper.map(varietyEntity, VarietyDTO.class))
                .map(VarietyDTO::getVariety)
                .collect(Collectors.toList());

        List<String> wineries = this.wineryRepository.findRandomUniqueWineries(15L)
                .stream()
                .map(wineryEntity -> modelMapper.map(wineryEntity, WineryDTO.class))
                .map(WineryDTO::getWinery)
                .collect(Collectors.toList());

        return new RecommendationModalDTO(wineries, varieties, "NONE");
    }

    @Override
    public RecommendationModalDTO getSpecificFilters(FilterWineryOrVarietyReq specificFiltersReq) {
        switch (specificFiltersReq.getType()) {
            case "VARIETY" -> {
                List<String> varietyResults = new ArrayList<>(this.varietyRepository.findTop25ByVarietyContaining(specificFiltersReq.getValue())
                        .stream()
                        .map(varietyEntity -> modelMapper.map(varietyEntity, VarietyDTO.class))
                        .map(VarietyDTO::getVariety)
                        .toList());
                return new RecommendationModalDTO(null, varietyResults, "VARIETY");
            }
            case "WINERY" -> {
                List<String> wineryResults = new ArrayList<>(this.wineryRepository.findTop25ByWineryContaining(specificFiltersReq.getValue())
                        .stream()
                        .map(wineryEntity -> modelMapper.map(wineryEntity, WineryDTO.class))
                        .map(WineryDTO::getWinery)
                        .toList());
                return new RecommendationModalDTO(wineryResults, null, "WINERY");
            }
            default -> {
                return null;
            }
        }
    }
}
