-- CREATION TABLE USERS

CREATE TABLE users
(
    id           UUID,
    name         TEXT NOT NULL,
    last_name    TEXT NOT NULL,
    email        TEXT NOT NULL,
    target_field TEXT,
    CONSTRAINT pk_users PRIMARY KEY (id),
    CONSTRAINT uq_users_email UNIQUE (email)
);


-- CREATION TABLE LANGUAGES

CREATE TABLE languages
(
    id   UUID,
    name TEXT NOT NULL,
    CONSTRAINT pk_languages PRIMARY KEY (id),
    CONSTRAINT uq_languages_name UNIQUE (name)
);


-- CREATION TABLE COMPANY

CREATE TABLE company
(
    id          UUID,
    name        TEXT NOT NULL,
    description TEXT,
    website     TEXT,
    location    TEXT,
    CONSTRAINT pk_company PRIMARY KEY (id)
);


-- CREATION TABLE SKILL

CREATE TABLE skill
(
    id         UUID,
    name       TEXT NOT NULL,
    skill_type TEXT NOT NULL,
    CONSTRAINT pk_skill PRIMARY KEY (id),
    CONSTRAINT uq_skill_name UNIQUE (name),
    CONSTRAINT ck_skill_type CHECK (skill_type IN ('hard_skill', 'soft_skill'))
);


-- CREATION TABLE OFFER

CREATE TABLE offer
(
    id          UUID,
    company_id  UUID NOT NULL,
    title       TEXT NOT NULL,
    location    TEXT,
    description TEXT,
    CONSTRAINT pk_offer PRIMARY KEY (id),
    CONSTRAINT fk_offer_company FOREIGN KEY (company_id) REFERENCES company (id)
);


-- CREATION TABLE OFFER_SKILL

CREATE TABLE offer_skill
(
    offer_id       UUID     NOT NULL,
    skill_id       UUID     NOT NULL,
    required_level SMALLINT NOT NULL,
    importance     SMALLINT NOT NULL,
    CONSTRAINT pk_offer_skill PRIMARY KEY (offer_id, skill_id),
    CONSTRAINT fk_offer_skill_offer FOREIGN KEY (offer_id) REFERENCES offer (id),
    CONSTRAINT fk_offer_skill_skill FOREIGN KEY (skill_id) REFERENCES skill (id),
    CONSTRAINT ck_offer_skill_required_level CHECK (required_level BETWEEN 1 AND 3),
    CONSTRAINT ck_offer_skill_importance CHECK (importance BETWEEN 1 AND 5)
);


-- CREATION TABLE OFFER_LANGUAGE

CREATE TABLE offer_language
(
    offer_id    UUID     NOT NULL,
    language_id UUID     NOT NULL,
    level       SMALLINT NOT NULL,
    CONSTRAINT pk_offer_language PRIMARY KEY (offer_id, language_id),
    CONSTRAINT fk_offer_language_offer FOREIGN KEY (offer_id) REFERENCES offer (id),
    CONSTRAINT fk_offer_language_language FOREIGN KEY (language_id) REFERENCES languages (id),
    CONSTRAINT ck_offer_language_level CHECK (level BETWEEN 1 AND 6)
);


-- CREATION TABLE USER_SKILL

CREATE TABLE user_skill
(
    user_id  UUID     NOT NULL,
    skill_id UUID     NOT NULL,
    level    SMALLINT NOT NULL,
    CONSTRAINT pk_user_skill PRIMARY KEY (user_id, skill_id),
    CONSTRAINT fk_user_skill_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_user_skill_skill FOREIGN KEY (skill_id) REFERENCES skill (id),
    CONSTRAINT ck_user_skill_level CHECK (level BETWEEN 1 AND 3)
);


-- CREATION TABLE USER_LANGUAGE

CREATE TABLE user_language
(
    user_id     UUID     NOT NULL,
    language_id UUID     NOT NULL,
    level       SMALLINT NOT NULL,
    CONSTRAINT pk_user_language PRIMARY KEY (user_id, language_id),
    CONSTRAINT fk_user_language_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_user_language_language FOREIGN KEY (language_id) REFERENCES languages (id),
    CONSTRAINT ck_user_language_level CHECK (level BETWEEN 1 AND 6)
);


-- CREATION TABLE SAVED_OFFER

CREATE TABLE saved_offer
(
    user_id  UUID NOT NULL,
    offer_id UUID NOT NULL,
    CONSTRAINT pk_saved_offer PRIMARY KEY (user_id, offer_id),
    CONSTRAINT fk_saved_offer_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_saved_offer_offer FOREIGN KEY (offer_id) REFERENCES offer (id)
);


-- CREATION TABLE APPLICATION

CREATE TABLE application
(
    user_id    UUID        NOT NULL,
    offer_id   UUID        NOT NULL,
    status     TEXT        NOT NULL,
    applied_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_application PRIMARY KEY (user_id, offer_id),
    CONSTRAINT fk_application_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_application_offer FOREIGN KEY (offer_id) REFERENCES offer (id),
    CONSTRAINT ck_application_status CHECK (
        status IN ('applied', 'interview', 'accepted', 'rejected', 'withdrawn')
        )
);