package com.example.finewineapi.winery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineryRepository extends JpaRepository<WineryEntity, Long> {
    @Query(value = "SELECT * FROM wineries ORDER BY RANDOM() LIMIT :size", nativeQuery = true)
    List<WineryEntity> findRandomUniqueWineries(@Param("size") Long size);
}
