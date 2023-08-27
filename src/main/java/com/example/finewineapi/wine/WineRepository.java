package com.example.finewineapi.wine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineRepository extends JpaRepository<WineEntity, Long> {

    List<WineEntity> findAllByWineColorOrderByPoints(String wineColor);

    Long countByWineColorAndPointsGreaterThan(String wineColor, Long priceLimit);
}
