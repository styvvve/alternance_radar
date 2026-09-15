package com.alternanceradar.entity;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "offer_skill")
public class OfferSkill {

    @EmbeddedId
    private OfferSkillId id;

    @MapsId("offerId")
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @MapsId("skillId")
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @Column(name = "required_level")
    private Short requiredLevel;

    @Column(name = "importance")
    private Short importance;

    public OfferSkill() {}

    public OfferSkill(Offer offer, Skill skill, Short requiredLevel, Short importance) {
        this.id = new OfferSkillId(offer.getId(), skill.getId());
        this.offer = offer;
        this.skill = skill;
        this.requiredLevel = requiredLevel;
        this.importance = importance;
    }

    public OfferSkillId getId() {
        return id;
    }
    public Offer getOffer() {
        return offer;
    }

    public Skill getSkill() {
        return skill;
    }

    public Short getRequiredLevel() {
        return requiredLevel;
    }

    public Short getImportance() {
        return importance;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setRequiredLevel(Short requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public void setImportance(Short importance) {
        this.importance = importance;
    }
}
