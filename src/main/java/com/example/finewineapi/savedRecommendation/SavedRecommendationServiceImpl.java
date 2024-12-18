package com.example.finewineapi.savedRecommendation;

import com.example.finewineapi.recommendation.RecommendationDTO;
import com.example.finewineapi.recommendation.RecommendationEntity;
import com.example.finewineapi.recommendation.RecommendationRepository;
import com.example.finewineapi.wine.WineRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SavedRecommendationServiceImpl implements SavedRecommendationService {

    @Autowired
    private ModelMapper modelMapper;

    private final RecommendationRepository recommendationRepository;

    private final WineRepository wineRepository;

    private final SavedRecommendationRepository savedRecommendationRepository;

    public SavedRecommendationServiceImpl(RecommendationRepository recommendationRepository, WineRepository wineRepository, SavedRecommendationRepository savedRecommendationRepository) {
        this.recommendationRepository = recommendationRepository;
        this.wineRepository = wineRepository;
        this.savedRecommendationRepository = savedRecommendationRepository;
    }

    @Override
    public void saveRecommendation(Set<Long> wineIds, String userId) {
        RecommendationEntity recommendation = new RecommendationEntity();
        recommendation.setWines(wineRepository.findAllById(wineIds));

        recommendationRepository.save(modelMapper.map(recommendation, RecommendationEntity.class));

        SavedRecommendationEntity savedRecommendation = new SavedRecommendationEntity();
        savedRecommendation.setUserId(userId);
        savedRecommendation.setRecommendations(modelMapper.map(recommendation, RecommendationEntity.class));
        savedRecommendationRepository.save(savedRecommendation);
    }

    @Override
    public List<RecommendationDTO> getUserRecommendations(String userId) {
        List<SavedRecommendationEntity> savedRecommendationEntities = savedRecommendationRepository.findAllByUserId(userId);

        return savedRecommendationEntities
                .stream()
                .map(SavedRecommendationEntity::getRecommendations)
                .map(recommendation -> modelMapper.map(recommendation, RecommendationDTO.class))
                .toList();
    }
}
