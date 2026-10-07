# AlternanceRadar

Backend application for managing work-study opportunities, candidate profiles, skills and applications.

The project is developed as a personal software engineering project using Java and Spring Boot. The main objective is to build a structured backend that can later be used to match candidates with relevant work-study opportunities based on their skills, languages and target field.

The project is currently focused on the database and persistence layer. The REST API and business logic will be developed progressively.

## Objectives

AlternanceRadar aims to provide the following features:

- Manage candidate profiles
- Manage companies and work-study offers
- Associate skills and language requirements with offers
- Define skill levels and importance for each offer
- Store candidate skills and language levels
- Save offers
- Track applications
- Calculate compatibility between a candidate and an offer
- Eventually provide more advanced recommendation features

## Architecture

The project follows a layered architecture:

```text
Controller
    |
    v
Service
    |
    v
Repository
    |
    v
JPA / Hibernate
    |
    v
PostgreSQL
```

The current project structure is:

```text
src/
└── main/
    ├── java/
    │   └── com/alternanceradar/
    │       ├── entity/
    │       ├── enums/
    │       ├── repository/
    │       ├── service/
    │       └── controller/
    │
    └── resources/
        ├── application.properties
        └── db/
            └── migration/
```

The repository, service and controller layers will be implemented as the application progresses.

## Data Model

The current database contains the following main entities:

```text
User
Company
Offer
Skill
Language
```

Relationship entities are used when additional information is required:

```text
OfferSkill
OfferLanguage
UserSkill
UserLanguage
SavedOffer
Application
```

For example, an offer does not simply contain a list of required skills. The relationship between an offer and a skill also stores the required level and the importance of that skill.

```text
Offer
  |
  +-- OfferSkill
          |
          +-- Skill
          +-- requiredLevel
          +-- importance
```

This allows the future matching system to distinguish between mandatory skills and secondary requirements.

## Skill Levels

Skills use a three-level scale:

| Level | Description |
|---|---|
| 1 | Beginner |
| 2 | Intermediate |
| 3 | Advanced |

Languages use the CEFR scale:

| Level | CEFR |
|---|---|
| 1 | A1 |
| 2 | A2 |
| 3 | B1 |
| 4 | B2 |
| 5 | C1 |
| 6 | C2 |

## Matching

One of the main objectives of the project is to calculate a compatibility score between a candidate and an offer.

The initial approach will use the importance of each required skill as a weight:

```text
Match Score =
Σ(skill compatibility × skill importance)
------------------------------------------
          Σ(skill importance)
```

The first implementation will remain deterministic and explainable. More advanced recommendation techniques may be considered later.

## Database

PostgreSQL is used as the relational database.

The current schema contains:

```text
users
languages
company
skill
offer

offer_skill
offer_language
user_skill
user_language
saved_offer
application
```

Database schema changes are managed with Flyway.

Current migrations:

```text
src/main/resources/db/migration/

V1__init.sql
V2__update_skill_type.sql
V3__update_status_on_application_table.sql
```

Flyway is responsible for modifying the database schema.

Hibernate is configured to validate the existing schema:

```properties
spring.jpa.hibernate.ddl-auto=validate
```

This prevents Hibernate from modifying the database structure automatically.


## Development

The PostgreSQL database runs in a Docker container on a separate Linux machine.

The Spring Boot application connects to the PostgreSQL instance through the local network.

Database credentials are provided through environment variables and are not stored in the repository.

Example:

```properties
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

## Project Status

The following parts have currently been implemented:

- Spring Boot project setup
- PostgreSQL database
- Docker database environment
- Flyway migrations
- Initial relational database schema
- JPA entity model
- Composite primary keys for relationship entities
- Entity relationships with `@ManyToOne`
- Enum persistence
- UUID identifiers
- Database constraints
- Hibernate schema validation
- Externalized database credentials
- User repository (`UserRepository`), with email lookup
- User service (`UserService`) with full CRUD and duplicate email handling
- Custom exceptions (`ResourceNotFoundException`, `EmailAlreadyExistsException`)

Current development:

- REST API (`UserController` and others)
- DTOs
- Validation
- Global exception handling
- Authentication and authorization
- Repository and service layers for the remaining entities (`Company`, `Offer`, `Skill`, `Language`, etc.)

Planned development:

- Candidate and offer management API
- Application management
- Offer search and filtering
- Skill-based matching
- Language matching
- Offer ranking
- Automated offer ingestion
- Recommendation features

## Project Structure

```text
com.alternanceradar
├── entity
│   ├── User
│   ├── Company
│   ├── Skill
│   ├── Language
│   ├── Offer
│   ├── OfferSkill
│   ├── OfferLanguage
│   ├── UserSkill
│   ├── UserLanguage
│   ├── SavedOffer
│   └── Application
│
├── enums
│   ├── SkillType
│   └── ApplicationStatus
│
├── repository
├── service
├── controller
└── exception
```

## Author

Steve NGUELE