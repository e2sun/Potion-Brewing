package com.potionbrew.backend.model;

import java.time.LocalDateTime;

public class Ingredient {
    private Long id;
    private String title;
    private boolean completed;
    private boolean addedToPotion;
    private LocalDateTime createdAt;

    public Ingredient() {
        this.createdAt = LocalDateTime.now();
        this.completed = false;
        this.addedToPotion = false;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted(){
        return completed;
    }

    public boolean isAddedToPotion(){
        return addedToPotion;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    public void setAddedToPotion(boolean addedToPotion){
        this.addedToPotion = addedToPotion;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
}