package com.alternanceradar.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "languages")
public class Language {

    @Id
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    public Language() {
    }

    public Language(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
