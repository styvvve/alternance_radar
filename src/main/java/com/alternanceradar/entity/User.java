package com.alternanceradar.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

/**
 * User entity class
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "target_field")
    private String targetField;

    public User() {
    }

    public User(String name, String lastName, String email, String targetField) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.targetField = targetField;
    }

    //getters and setters

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getTargetField() {
        return targetField;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTargetField(String targetField) {
        this.targetField = targetField;
    }

}
