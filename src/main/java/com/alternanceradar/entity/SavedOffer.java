package com.alternanceradar.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "saved_offer")
public class SavedOffer {

    @EmbeddedId
    private SavedOfferId id;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @MapsId("offerId")
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    public SavedOffer() {}

    public SavedOffer(User user, Offer offer) {
        this.id = new SavedOfferId(user.getId(), offer.getId());
        this.user = user;
        this.offer = offer;
    }

    public SavedOfferId getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public Offer getOffer() {
        return offer;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
