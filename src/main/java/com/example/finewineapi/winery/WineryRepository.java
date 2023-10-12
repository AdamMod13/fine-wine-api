package com.example.finewineapi.winery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineryRepository extends JpaRepository<WineryEntity, Long> {
    @Query(value = "SELECT * FROM wineries ORDER BY RANDOM() LIMIT 5", nativeQuery = true)
    List<WineryEntity> findRandomUniqueWineries();
}
