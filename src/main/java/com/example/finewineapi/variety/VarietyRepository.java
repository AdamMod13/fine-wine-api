package com.example.finewineapi.variety;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VarietyRepository extends JpaRepository<VarietyEntity, Long> {
    @Query(value = "SELECT * FROM varieties ORDER BY RANDOM() LIMIT :size", nativeQuery = true)
    List<VarietyEntity> findRandomUniqueVarieties(@Param("size") Long size);

    List<VarietyEntity> findTop25ByVarietyContaining(String varietyFilter);
}
