package com.example.finewineapi.variety;

import jakarta.persistence.*;

@Entity(name = "variety_entity")
@Table(name = "varieties")
public class VarietyEntity {

    @Id
    @SequenceGenerator(
            name = "variety_sequence",
            sequenceName = "variety_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "variety_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "variety", updatable = false)
    private String variety;

    public VarietyEntity() {
    }

    public VarietyEntity(Long id, String variety) {
        this.id = id;
        this.variety = variety;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }
}
