package com.alternanceradar.entity;

import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.UUID;

@Embeddable
public class OfferLanguageId {

    private UUID offerId;
    private UUID languageId;

    public OfferLanguageId() {}

    public OfferLanguageId(UUID offerId, UUID languageId) {
        this.offerId = offerId;
        this.languageId = languageId;
    }

    public UUID getOfferId() {
        return offerId;
    }

    public UUID getLanguageId() {
        return languageId;
    }

    public void setOfferId(UUID offerId) {
        this.offerId = offerId;
    }

    public void setLanguageId(UUID languageId) {
        this.languageId = languageId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof OfferLanguageId other)) return false;

        return Objects.equals(offerId, other.offerId) && Objects.equals(languageId, other.languageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerId, languageId);
    }
}
