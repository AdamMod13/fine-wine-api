package com.example.finewineapi.savedWines;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedWineRepository extends JpaRepository<SavedWineEntity, Long> {

    Page<SavedWineEntity> findAllByUserIdOrderById(Pageable pageable,@Param("userId") String userId);
}
