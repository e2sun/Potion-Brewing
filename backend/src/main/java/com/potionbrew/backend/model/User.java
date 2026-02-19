package com.potionbrew.backend.model;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String displayName;

    public User(){}
    public Long getId() {
        return id;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String displayName() {
        return displayName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

}
