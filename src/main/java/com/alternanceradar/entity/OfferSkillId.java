package com.alternanceradar.entity;

import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.UUID;

@Embeddable
public class OfferSkillId {

    private UUID offerId;
    private UUID skillId;

    public OfferSkillId() {}

    public OfferSkillId(UUID offerId, UUID skillId) {
        this.offerId = offerId;
        this.skillId = skillId;
    }

    public UUID getOfferId() {
        return offerId;
    }
    public UUID getSkillId() {
        return skillId;
    }

    public void setOfferId(UUID offerId) {
        this.offerId = offerId;
    }
    public void setSkillId(UUID skillId) {
        this.skillId = skillId;
    }

    //equals and hashcode
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof OfferSkillId other)) return false;

        return Objects.equals(offerId, other.offerId) && Objects.equals(skillId, other.skillId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerId, skillId);
    }
}
