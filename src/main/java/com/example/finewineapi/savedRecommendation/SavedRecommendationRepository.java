package com.example.finewineapi.savedRecommendation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedRecommendationRepository extends JpaRepository<SavedRecommendationEntity, Long> {

    List<SavedRecommendationEntity> findAllByUserId(String userId);
}
