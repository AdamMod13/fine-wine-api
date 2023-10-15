package com.example.finewineapi.savedWines;

import com.example.finewineapi.wine.WineEntity;
import jakarta.persistence.*;

@Entity(name = "saved_wines_entity")
@Table(name = "saved_wines")
public class SavedWineEntity {

    @Id
    @SequenceGenerator(
            name = "saved_wine_sequence",
            sequenceName = "saved_wine_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "saved_wine_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "user_id", updatable = false)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wine_id", referencedColumnName = "id")
    private WineEntity wine;

    public SavedWineEntity() {
    }

    public SavedWineEntity(Long id, String userId, WineEntity wine) {
        this.id = id;
        this.userId = userId;
        this.wine = wine;
    }

    public SavedWineEntity(String userId, WineEntity wine) {
        this.userId = userId;
        this.wine = wine;
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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public WineEntity getWine() {
        return wine;
    }

    public void setWine(WineEntity wine) {
        this.wine = wine;
    }
}
