package com.example.finewineapi.savedWines;

import com.example.finewineapi.wine.WineEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedWineRepository extends JpaRepository<SavedWineEntity, Long> {

    Page<SavedWineEntity> findAllByUserIdOrderById(Pageable pageable,@Param("userId") String userId);

    List<SavedWineEntity> findAllByUserIdOrderById(String userId);

    Boolean existsByWineAndUserId(WineEntity wine, String userId);

    void deleteByWineAndUserId(WineEntity wine, String userId);
}
