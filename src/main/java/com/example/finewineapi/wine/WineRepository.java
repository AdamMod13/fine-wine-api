package com.example.finewineapi.wine;

import com.example.finewineapi.models.FindWineReq;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    );

    @Query(nativeQuery = true, value = "SELECT * FROM wines as w WHERE " +
            "w.wine_color IS NOT NULL " +
            "AND w.variety IS NOT NULL " +
            "AND w.province IS NOT NULL " +
            "AND w.winery IS NOT NULL " +
            "AND w.country IS NOT NULL " +
            "AND w.points IS NOT NULL " +
            "AND w.description IS NOT NULL " +
//            "AND (:colors IS NULL OR w.wine_color IN :colors) " +
//            "AND (:varieties IS NULL OR w.variety IN :varieties) " +
//            "AND (:countries IS NULL OR w.country IN :countries) " +
//            "AND (:provinces IS NULL OR w.province IN :provinces) " +
//            "AND (:wineries IS NULL OR w.winery IN :wineries) " +
            "ORDER BY w.id")
    Page<WineEntity> findWinesWithNoNullColumns(Pageable pageable,
                                                @Param("colors") List<String> colors,
                                                @Param("varieties") List<String> varieties,
                                                @Param("countries") List<String> countries,
                                                @Param("provinces") List<String> provinces,
                                                @Param("wineries") List<String> wineries);
}
