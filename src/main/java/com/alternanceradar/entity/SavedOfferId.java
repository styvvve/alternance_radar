package com.alternanceradar.entity;

import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.UUID;

@Embeddable
public class SavedOfferId {

    private UUID userId;
    private UUID offerId;

    public SavedOfferId() {}

    public SavedOfferId(UUID userId, UUID offerId) {
        this.userId = userId;
        this.offerId = offerId;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getOfferId() {
        return offerId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setOfferId(UUID offerId) {
        this.offerId = offerId;
    }

    //equals and hashcode
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof SavedOfferId other)) return false;

        return Objects.equals(offerId, other.offerId) && Objects.equals(userId, other.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerId, userId);
    }
}
