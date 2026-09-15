package com.alternanceradar.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_language")
public class UserLanguage {

    @EmbeddedId
    private UserLanguageId id;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @MapsId("languageId")
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(name = "level")
    private Short level;

    public UserLanguage() {}

    public UserLanguage(User user, Language language, Short level) {
        this.id = new UserLanguageId(user.getId(), language.getId());
        this.user = user;
        this.language = language;
        this.level = level;
    }

    public UserLanguageId getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Language getLanguage() {
        return language;
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

    public void setLanguage(Language language) {
        this.language = language;
    }
}
