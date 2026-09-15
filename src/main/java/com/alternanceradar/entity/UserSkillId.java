package com.alternanceradar.entity;

import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.UUID;

@Embeddable
public class UserSkillId {

    private UUID userId;
    private UUID skillId;

    public UserSkillId() {}

    public UserSkillId(UUID userId, UUID skillId) {
        this.userId = userId;
        this.skillId = skillId;
    }

    public UUID getUserId() {
        return userId;
    }
    public UUID getSkillId() {
        return skillId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public void setSkillId(UUID skillId) {
        this.skillId = skillId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof UserSkillId other)) return false;

        return Objects.equals(userId, other.userId) && Objects.equals(skillId, other.skillId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, skillId);
    }
}
