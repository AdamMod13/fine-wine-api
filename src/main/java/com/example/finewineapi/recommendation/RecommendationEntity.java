package com.example.finewineapi.recommendation;

import com.example.finewineapi.wine.WineEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "recommendation")
@Table(name = "recommendation")
public class RecommendationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "recommendation_wine",
            joinColumns = @JoinColumn(name = "recommendation_id"),
            inverseJoinColumns = @JoinColumn(name = "wine_id"))
    private List<WineEntity> wines;


    public RecommendationEntity() {}

    public RecommendationEntity(Long id, List<WineEntity> wines) {
        this.id = id;
        this.wines = wines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<WineEntity> getWines() {
        return wines;
    }

    public void setWines(List<WineEntity> wines) {
        this.wines = wines;
    }
}

