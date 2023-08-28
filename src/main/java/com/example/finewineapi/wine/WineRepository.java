package com.example.finewineapi.wine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineRepository extends JpaRepository<WineEntity, Long> {

    @Query("SELECT w.id FROM wine_entity w WHERE w.wineColor = :wineColor AND w.points > :pointLimit")
    List<Long> findIdsByWineColorAndPointsGreaterThan(
            @Param("wineColor") String wineColor,
            @Param("pointLimit") Long pointLimit
    );}
