package com.alternanceradar.entity;

import com.alternanceradar.enums.SkillType;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "skill_type")
    private SkillType skillType;

    public Skill() {
    }

    public Skill(String name, SkillType skillType) {
        this.name = name;
        this.skillType = skillType;
    }

    //getters and setters

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public SkillType getSkillType() {
        return this.skillType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkillType(SkillType type) {
        this.skillType = type;
    }

}
