package com.example.finewineapi.winery;

import jakarta.persistence.*;

@Entity(name = "winery_entity")
@Table(name = "wineries")
public class WineryEntity {

    @Id
    @SequenceGenerator(
            name = "winery_sequence",
            sequenceName = "winery_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "winery_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "winery", updatable = false)
    private String winery;

    public WineryEntity() {
    }

    public WineryEntity(Long id, String variety) {
        this.id = id;
        this.winery = variety;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWinery() {
        return winery;
    }

    public void setWinery(String variety) {
        this.winery = variety;
    }
}
