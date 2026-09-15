package com.alternanceradar.entity;

import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.UUID;

@Embeddable
public class UserLanguageId {

    private UUID userId;
    private UUID languageId;

    public UserLanguageId() {}

    public UserLanguageId(UUID userId, UUID languageId) {
        this.userId = userId;
        this.languageId = languageId;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getLanguageId() {
        return languageId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setLanguageId(UUID languageId) {
        this.languageId = languageId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof UserLanguageId other)) return false;

        return Objects.equals(userId, other.userId) && Objects.equals(languageId, other.languageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, languageId);
    }
}
