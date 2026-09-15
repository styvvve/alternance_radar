package com.alternanceradar.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_skill")
public class UserSkill {

    @EmbeddedId
    private UserSkillId id;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @MapsId("skillId")
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(name = "level")
    private Short level;

    public UserSkill() {}

    public UserSkill(User user, Skill skill, Short level) {
        this.id = new UserSkillId(user.getId(), skill.getId());
        this.user = user;
        this.skill = skill;
        this.level = level;
    }

    public UserSkillId getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Skill getSkill() {
        return skill;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
