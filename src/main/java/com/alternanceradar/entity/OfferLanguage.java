package com.alternanceradar.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "offer_language")
public class OfferLanguage {

    @EmbeddedId
    private OfferLanguageId id;

    @MapsId("offerId")
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @MapsId("languageId")
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(name = "level")
    private Short level;

    public OfferLanguage() {}

    public OfferLanguage(Offer offer, Language language, Short level) {
        this.id = new OfferLanguageId(offer.getId(), language.getId());
        this.offer = offer;
        this.language = language;
        this.level = level;
    }

    public OfferLanguageId getId() {
        return id;
    }

    public Offer getOffer() {
        return offer;
    }

    public Language getLanguage() {
        return language;
    }

    public Short getLevel() {
        return level;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setLevel(Short level) {
        this.level = level;
    }
}
