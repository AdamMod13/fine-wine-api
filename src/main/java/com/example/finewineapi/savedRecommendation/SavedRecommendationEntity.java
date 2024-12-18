package com.example.finewineapi.savedRecommendation;

import com.example.finewineapi.recommendation.RecommendationEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity(name = "saved_recommendation")
@Table(name = "saved_recommendation")
public class SavedRecommendationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @ManyToOne
    @JoinColumn(name = "recommendation_id")
    @Cascade(CascadeType.REMOVE)
    private RecommendationEntity recommendation;

    public SavedRecommendationEntity() {}

    public SavedRecommendationEntity(Long id, String userId, RecommendationEntity recommendation) {
        this.id = id;
        this.userId = userId;
        this.recommendation = recommendation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String user_id) {
        this.userId = user_id;
    }

    public RecommendationEntity getRecommendations() {
        return recommendation;
    }

    public void setRecommendations(RecommendationEntity recommendation) {
        this.recommendation = recommendation;
    }
}

