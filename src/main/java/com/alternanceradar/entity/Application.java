package com.alternanceradar.entity;

import com.alternanceradar.enums.ApplicationStatus;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "application")
public class Application {

    @EmbeddedId
    private ApplicationId id;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @MapsId("offerId")
    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ApplicationStatus status;

    @Column(name = "applied_at")
    private Instant appliedAt;

    public Application() {}

    public Application(User user, Offer offer, ApplicationStatus status) {
        this.id = new ApplicationId(user.getId(), offer.getId());
        this.user = user;
        this.offer = offer;
        this.status = status;
    }

    public ApplicationId getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public Offer getOffer() {
        return offer;
    }
    public ApplicationStatus getStatus() {
        return status;
    }

    public Instant getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(Instant appliedAt) {
        this.appliedAt = appliedAt;
    }
    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
