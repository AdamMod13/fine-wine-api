package com.example.finewineapi.variety;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VarietyRepository extends JpaRepository<VarietyEntity, Long> {
    @Query(value = "SELECT * FROM varieties ORDER BY RANDOM() LIMIT 5", nativeQuery = true)
    List<VarietyEntity> findRandomUniqueVarieties();
}
