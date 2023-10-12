package com.example.finewineapi.currentRecommendations;

import com.example.finewineapi.wine.WineEntity;

import jakarta.persistence.*;

@Entity(name = "current_recommendations")
@Table(name = "current_recommendations")
public class CurrentRecommendationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // Define the relationship as ManyToOne
    @JoinColumn(name = "wine_id", referencedColumnName = "id") // Join the recommendation to a wine
    private WineEntity wine;


    public CurrentRecommendationsEntity() {}

    public CurrentRecommendationsEntity(WineEntity wine) {
        this.wine = wine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WineEntity getWine() {
        return wine;
    }

    public void setWine(WineEntity wine) {
        this.wine = wine;
    }
}

