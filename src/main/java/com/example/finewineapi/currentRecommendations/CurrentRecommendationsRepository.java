package com.example.finewineapi.currentRecommendations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentRecommendationsRepository extends JpaRepository<CurrentRecommendationsEntity, Long> {

}
